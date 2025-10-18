package controllers

import graphql.Product.SchemaDefinitionProduct
import javax.inject._
import play.api.mvc._
import play.api.libs.json._
import sangria.execution._
import sangria.marshalling.circe._
import sangria.parser.QueryParser
import io.circe.{Json => CJson}
import graphql.ProductRepo

import scala.concurrent.Future
import scala.util.{Success, Failure}
import scala.concurrent.ExecutionContext

@Singleton
class GraphQLControllerProduct @Inject()(cc: ControllerComponents)(implicit ec: ExecutionContext) extends AbstractController(cc) {

  def graphql: Action[JsValue] = Action.async(parse.json) { request =>
    val query = (request.body \ "query").as[String]

    println("Query: " + query)
    
    QueryParser.parse(query) match {
      case Success(ast) =>
        Executor.execute(SchemaDefinitionProduct.schema, ast, new ProductRepo)
          .map(result => Ok(play.api.libs.json.Json.parse(result.noSpaces)))
      case Failure(error) =>
        Future.successful(BadRequest(play.api.libs.json.Json.obj("error" -> error.getMessage)))
    }
  }
}
