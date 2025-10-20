package controllers

import graphql.{OrderRepo, PictureRepo, SchemaDefinitionOrder}
import play.api.libs.json.JsValue
import play.api.mvc.{AbstractController, Action, ControllerComponents}
import sangria.execution.Executor
import sangria.parser.QueryParser
import javax.inject._
import sangria.marshalling.circe._


import scala.concurrent.Future
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext

class GraphQLControllerOrder @Inject()(cc: ControllerComponents)(implicit ec: ExecutionContext) extends AbstractController(cc) {

  def graphql: Action[JsValue] = Action.async(parse.json) { request =>
    val query = (request.body \ "query").as[String]

    println("Query: " + query)

    QueryParser.parse(query) match {
      case Success(ast) =>
        Executor.execute(SchemaDefinitionOrder.schema, ast, new OrderRepo)
          .map(result => Ok(play.api.libs.json.Json.parse(result.noSpaces)))
      case Failure(error) =>
        Future.successful(BadRequest(play.api.libs.json.Json.obj("error" -> error.getMessage)))
    }
  }
}
