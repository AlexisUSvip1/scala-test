package graphql

import sangria.schema._
import sangria.macros.derive._
import models.{Identifiable, User, Product => ModelProduct, Order => ModelOrder} // <-- Alias Product to ModelProduct
import scala.concurrent.Future

// CRÍTICO: Asegurarse de que esta línea esté presente para hacer el ProductType visible
import ProductTypes._

// Alias para el contexto de resolución

object UserTypes {

  // IdentifiableType (Asegurarse de que el contexto coincida: UserRepo)
  val IdentifiableType: InterfaceType[UserRepo, Identifiable] = InterfaceType(
    "Identifiable",
    "Entity that can be identified",
    fields[UserRepo, Identifiable](
      Field("id", StringType, resolve = _.value.id)
    )
  )

  implicit val UserType: ObjectType[UserRepo, User] =
    deriveObjectType[UserRepo, User](
      Interfaces(IdentifiableType),

      // Definición manual del campo 'product'
      AddFields(
        // Usamos ProductType, que debe ser visible
        Field("product", OptionType(ProductType),
          description = Some("The product owned by this user."),

          // ✅ CORRECCIÓN DE SINTAXIS: La lógica de fetch DEBE ir dentro de resolve = c => { ... }
          resolve = c => {

            // c.value es el objeto User actual
            // c.ctx es el UserRepoContext (o UserRepo)

            // Tipificación explícita para resolver el error anterior y ayudar al compilador.
            val result: Future[Option[ModelProduct]] = c.value.productId match {
              case Some(id) =>
                // Asumiendo que c.ctx.getProductById(id) devuelve Future[Option[models.Product]]
                c.ctx.getProductById(id)
              case None =>
                Future.successful(None)
            }
            result
          }
        )
      ),
      AddFields(
        // Usamos ProductType, que debe ser visible
        Field("order", OptionType(OrderTypes.OrderType),
          description = Some("The product owned by this user."),

          // ✅ CORRECCIÓN DE SINTAXIS: La lógica de fetch DEBE ir dentro de resolve = c => { ... }
          resolve = c => {

            // c.value es el objeto User actual
            // c.ctx es el UserRepoContext (o UserRepo)

            // Tipificación explícita para resolver el error anterior y ayudar al compilador.
            val result: Future[Option[ModelOrder]] = c.value.orderId match {
              case Some(id) =>
                // Asumiendo que c.ctx.getProductById(id) devuelve Future[Option[models.Product]]
                c.ctx.getOrderById(id)
              case None =>
                Future.successful(None)
            }
            result
          }
        )
      )
    )
}