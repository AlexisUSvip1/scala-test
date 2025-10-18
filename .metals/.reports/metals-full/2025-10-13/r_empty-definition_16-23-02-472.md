error id: file://<WORKSPACE>/app/controllers/PictureGraphqlController/PictureCroller.scala:`<none>`.
file://<WORKSPACE>/app/controllers/PictureGraphqlController/PictureCroller.scala
empty definition using pc, found symbol in pc: `<none>`.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -javax/inject/play/api.
	 -play/api/mvc/play/api.
	 -play/api/libs/json/play/api.
	 -sangria/execution/play/api.
	 -sangria/marshalling/circe/play/api.
	 -play/api.
	 -scala/Predef.play.api.
offset: 845
uri: file://<WORKSPACE>/app/controllers/PictureGraphqlController/PictureCroller.scala
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

    println("Query: " + query)
    
    QueryParser.parse(query) match {
      case Success(ast) =>
        Executor.execute(SchemaDefinition.schema, ast, new ProductRepo)
          .map(result => Ok(play.a@@pi.libs.json.Json.parse(result.noSpaces)))
      case Failure(error) =>
        Future.successful(BadRequest(play.api.libs.json.Json.obj("error" -> error.getMessage)))
    }
  }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.