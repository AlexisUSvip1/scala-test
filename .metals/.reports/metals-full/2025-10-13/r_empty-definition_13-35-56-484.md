error id: file://<WORKSPACE>/app/graphql/Product/ProductType.scala:`<none>`.
file://<WORKSPACE>/app/graphql/Product/ProductType.scala
empty definition using pc, found symbol in pc: `<none>`.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -sangria/schema/Picture#
	 -sangria/macros/derive/Picture#
	 -models/Picture#
	 -Picture#
	 -scala/Predef.Picture#
offset: 594
uri: file://<WORKSPACE>/app/graphql/Product/ProductType.scala
text:
```scala
package graphql

import sangria.schema._
import sangria.macros.derive._
import models._

// Objeto para contener todos los tipos de productos y sus dependencias
object ProductTypes {

  // 1. Interfaz GraphQL (generalmente se mantiene separada si es transversal)
  val IdentifiableType: InterfaceType[Unit, Identifiable] = InterfaceType(
    "Identifiable",
    "Entity that can be identified",
    fields[Unit, Identifiable](
      Field("id", StringType, resolve = _.value.id)
    )
  )

  // 2. Tipo Picture
  implicit val PictureType: ObjectType[Unit, Picture] =
    deriveObjectType[Unit, @@Picture](
      ObjectTypeDescription("The product picture"),
      DocumentField("url", "Picture CDN URL")
    )

  // 3. Tipo Product (implementa la interfaz y usa PictureType)
  implicit val ProductType: ObjectType[Unit, Product] =
    deriveObjectType[Unit, Product](
      Interfaces(IdentifiableType),
      IncludeMethods("picture")
    )
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.