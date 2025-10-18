package controllers

import graphql.{ProductRepo, UserRepo}
import graphql.User.SchemaDefinitionUser
import play.api.libs.json.JsValue
import play.api.mvc.{AbstractController, Action, ControllerComponents}
import sangria.execution.Executor
import sangria.parser.QueryParser

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}
import sangria.marshalling.circe._


@Singleton
class GraphQLControllerUsers @Inject()(cc: ControllerComponents)(implicit ec: ExecutionContext) extends AbstractController(cc) {

  private val productRepo = new ProductRepo()
  def graphql: Action[JsValue] = Action.async(parse.json) { request =>
    val query = (request.body \ "query").as[String]

    println("Query: " + query)

    QueryParser.parse(query) match {
      case Success(ast) =>
        val userRepo = new UserRepo(productRepo)
        Executor.execute(SchemaDefinitionUser.schema, ast,userRepo)
          .map(result => Ok(play.api.libs.json.Json.parse(result.noSpaces)))
      case Failure(error) =>
        Future.successful(BadRequest(play.api.libs.json.Json.obj("error" -> error.getMessage)))
    }
  }
}
