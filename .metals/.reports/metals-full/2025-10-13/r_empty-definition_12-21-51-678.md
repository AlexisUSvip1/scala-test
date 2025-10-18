error id: file://<WORKSPACE>/app/graphql/SchemaDefinition.scala:`<none>`.
file://<WORKSPACE>/app/graphql/SchemaDefinition.scala
empty definition using pc, found symbol in pc: `<none>`.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -sangria/schema/deriveObjectType.
	 -sangria/schema/deriveObjectType#
	 -sangria/schema/deriveObjectType().
	 -sangria/macros/derive/deriveObjectType.
	 -sangria/macros/derive/deriveObjectType#
	 -sangria/macros/derive/deriveObjectType().
	 -models/deriveObjectType.
	 -models/deriveObjectType#
	 -models/deriveObjectType().
	 -deriveObjectType.
	 -deriveObjectType#
	 -deriveObjectType().
	 -scala/Predef.deriveObjectType.
	 -scala/Predef.deriveObjectType#
	 -scala/Predef.deriveObjectType().
offset: 470
uri: file://<WORKSPACE>/app/graphql/SchemaDefinition.scala
text:
```scala
package graphql

import sangria.schema._
import sangria.macros.derive._
import models._

object SchemaDefinition {

  // Interfaz GraphQL basada en el trait Identifiable
  val IdentifiableType: InterfaceType[Unit, Identifiable] = InterfaceType(
    "Identifiable",
    "Entity that can be identified",
    fields[Unit, Identifiable](
      Field("id", StringType, resolve = _.value.id)
    )
  )

  implicit val PictureType: ObjectType[Unit, Picture] =
    deriveObjectT@@ype[Unit, Picture](
      ObjectTypeDescription("The product picture"),
      DocumentField("url", "Picture CDN URL")
    )

  implicit val ProductType: ObjectType[Unit, Product] =
    deriveObjectType[Unit, Product](
      Interfaces(IdentifiableType),
      IncludeMethods("picture")
    )

  val Id = Argument("id", StringType)

  val QueryType = ObjectType("Query", fields[ProductRepo, Unit](
    Field("product", OptionType(ProductType),
      description = Some("Returns a product by ID."),
      arguments = Id :: Nil,
      resolve = c => c.ctx.product(c arg Id)
    ),
    Field("products", ListType(ProductType),
      description = Some("Returns all available products."),
      resolve = _.ctx.products
    )
  ))

  val schema: Schema[ProductRepo, Unit] = Schema(QueryType)
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.