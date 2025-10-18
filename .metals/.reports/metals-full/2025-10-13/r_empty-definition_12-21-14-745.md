error id: file://<WORKSPACE>/app/controllers/GraphQLController.scala:`<none>`.
file://<WORKSPACE>/app/controllers/GraphQLController.scala
empty definition using pc, found symbol in pc: `<none>`.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -javax/inject/error.
	 -javax/inject/error#
	 -javax/inject/error().
	 -play/api/mvc/error.
	 -play/api/mvc/error#
	 -play/api/mvc/error().
	 -play/api/libs/json/error.
	 -play/api/libs/json/error#
	 -play/api/libs/json/error().
	 -sangria/execution/error.
	 -sangria/execution/error#
	 -sangria/execution/error().
	 -sangria/marshalling/circe/error.
	 -sangria/marshalling/circe/error#
	 -sangria/marshalling/circe/error().
	 -error.
	 -error#
	 -error().
	 -scala/Predef.error.
	 -scala/Predef.error#
	 -scala/Predef.error().
offset: 1237
uri: file://<WORKSPACE>/app/controllers/GraphQLController.scala
text:
```scala
package controllers

import javax.inject._
import play.api.mvc._
import play.api.libs.json._
import sangria.execution._
import sangria.marshalling.circe._
import sangria.parser.QueryParser
import io.circe.{Json => CJson}
import graphql.{SchemaDefinition, ProductRepo}

import scala.concurrent.Future
import scala.util.{Success, Failure}
import scala.concurrent.ExecutionContext

@Singleton
class GraphQLController @Inject()(cc: ControllerComponents)(implicit ec: ExecutionContext) extends AbstractController(cc) {

  def graphql: Action[JsValue] = Action.async(parse.json) { request =>
    val query = (request.body \ "query").as[String]
    val operation = (request.body \ "operationName").asOpt[String]
    val variables = (request.body \ "variables").toOption.flatMap {
      case JsString(vars) => Some(io.circe.parser.parse(vars).getOrElse(CJson.obj()).asObject.map(_.toMap).getOrElse(Map.empty))
      case _              => Some(Map.empty[String, CJson])
    }.getOrElse(Map.empty[String, CJson])

    QueryParser.parse(query) match {
      case Success(ast) =>
        Executor.execute(SchemaDefinition.schema, ast, new ProductRepo)
          .map(result => Ok(play.api.libs.json.Json.parse(result.noSpaces)))
      case Failure(@@error) =>
        Future.successful(BadRequest(play.api.libs.json.Json.obj("error" -> error.getMessage)))
    }
  }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.