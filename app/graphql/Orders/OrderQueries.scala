package graphql

import graphql.ProductTypes.ProductType
import sangria.schema._

object OrderQueries {
  val id = Argument("id", StringType)

  val Fields: List[Field[OrderRepo, Unit]] = List(
    Field("orders", ListType(OrderTypes.OrderType),
      description = Some("Returns all available products."),
      resolve = _.ctx.allOrders
    )
  )
}