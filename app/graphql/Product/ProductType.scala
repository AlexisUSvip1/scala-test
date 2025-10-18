package graphql

import sangria.schema._
import sangria.macros.derive._
import models._

// 1. Asegúrate de importar TODOS los tipos que usas en el deriveObjectType.
// Esto trae el 'implicit val PictureType' al alcance.
import PictureTypes._ // <-- Esta línea es vital

object ProductTypes {
  // Aquí asumo que la interfaz IdentifiableType también está definida

  // Interfaz GraphQL (Definida aquí si es el tipo base del dominio)
  val IdentifiableType: InterfaceType[ProductRepo, Identifiable] = InterfaceType(
    "Identifiable",
    "Entity that can be identified",
    fields[ProductRepo, Identifiable](
      Field("id", StringType, resolve = _.value.id)
    )
  )

  // 2. CORRECCIÓN: El contexto debe ser ProductRepo, no Unit, si vas a usarlo.
  // Pero el error se centra en la derivación automática.
  implicit val ProductType: ObjectType[ProductRepo, Product] =
    deriveObjectType[ProductRepo, Product]( // Cambiado de Unit a ProductRepo
      Interfaces(IdentifiableType),
      IncludeMethods("picture") // Ahora Sangria encuentra el tipo implícito PictureType
    )
}