error id: file://<WORKSPACE>/app/controllers/UserGraphqlController/UserController.scala:marshalling.
file://<WORKSPACE>/app/controllers/UserGraphqlController/UserController.scala
empty definition using pc, found symbol in pc: marshalling.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -sangria/marshalling/circe/sangria/marshalling.
	 -sangria/marshalling.
	 -scala/Predef.sangria.marshalling.
offset: 430
uri: file://<WORKSPACE>/app/controllers/UserGraphqlController/UserController.scala
text:
```scala
package controllers

import graphql.{OrderRepo, ProductRepo, UserRepo}
import graphql.User.SchemaDefinitionUser
import play.api.libs.json.JsValue
import play.api.mvc.{AbstractController, Action, ControllerComponents}
import sangria.execution.Executor
import sangria.parser.QueryParser

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}
import sangria.m@@arshalling.circe._


@Singleton
class GraphQLControllerUsers @Inject()(cc: ControllerComponents)(implicit ec: ExecutionContext) extends AbstractController(cc) {

  private val productRepo = new ProductRepo()
  private val orderRepo = new OrderRepo()
  def graphql: Action[JsValue] = Action.async(parse.json) { request =>
    val query = (request.body \ "query").as[String]

    println("Query: " + query)

    QueryParser.parse(query) match {
      case Success(ast) =>
        val userRepo = new UserRepo(productRepo)
        val userRepOrder = new UserRepo(orderRepo)
        Executor.execute(SchemaDefinitionUser.schema, ast, userRepo, userRepOrder)
          .map(result => Ok(play.api.libs.json.Json.parse(result.noSpaces)))
      case Failure(error) =>
        Future.successful(BadRequest(play.api.libs.json.Json.obj("error" -> error.getMessage)))
    }
  }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: marshalling.