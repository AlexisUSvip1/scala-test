error id: file://<WORKSPACE>/app/graphql/Orders/OrderTypes.scala:`<none>`.
file://<WORKSPACE>/app/graphql/Orders/OrderTypes.scala
empty definition using pc, found symbol in pc: `<none>`.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -sangria/schema/Interfaces.
	 -sangria/schema/Interfaces#
	 -sangria/schema/Interfaces().
	 -sangria/macros/derive/Interfaces.
	 -sangria/macros/derive/Interfaces#
	 -sangria/macros/derive/Interfaces().
	 -models/Interfaces.
	 -models/Interfaces#
	 -models/Interfaces().
	 -PictureTypes.Interfaces.
	 -PictureTypes.Interfaces#
	 -PictureTypes.Interfaces().
	 -Interfaces.
	 -Interfaces#
	 -Interfaces().
	 -scala/Predef.Interfaces.
	 -scala/Predef.Interfaces#
	 -scala/Predef.Interfaces().
offset: 640
uri: file://<WORKSPACE>/app/graphql/Orders/OrderTypes.scala
text:
```scala
package graphql

import sangria.schema._
import sangria.macros.derive._
import models._

// 1. Asegúrate de importar TODOS los tipos que usas en el deriveObjectType.
// Esto trae el 'implicit val PictureType' al alcance.
import PictureTypes._ // <-- Esta línea es vital

object OrderTypes {

  val IdentifiableType: InterfaceType[OrderRepo, Identifiable] = InterfaceType(
    "Identifiable",
    "Entity that can be identified",
    fields[OrderRepo, Identifiable](
      Field("id", StringType, resolve = _.value.id)
    )
  )

  implicit val OrderType: ObjectType[OrderRepo, Order] =
    deriveObjectType[OrderRepo, Order](
      Interfac@@es(IdentifiableType)
    )
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.