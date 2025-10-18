error id: file://<WORKSPACE>/app/graphql/Product/ProductQueries.scala:`<none>`.
file://<WORKSPACE>/app/graphql/Product/ProductQueries.scala
empty definition using pc, found symbol in pc: `<none>`.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -sangria/schema/sangria.
	 -ProductTypes.sangria.
	 -sangria.
	 -scala/Predef.sangria.
offset: 29
uri: file://<WORKSPACE>/app/graphql/Product/ProductQueries.scala
text:
```scala
package graphql

import sangr@@ia.schema._
import ProductTypes._ // Importar los tipos definidos en ProductTypes

object ProductQueries {

  // Reutilizar el argumento ID
  val Id = Argument("id", StringType)

  // Lista de campos de consulta relacionados con productos
  val Fields: List[Field[ProductRepo, Unit]] = List(
    Field("product", OptionType(ProductType),
      description = Some("Returns a product by ID."),
      arguments = Id :: Nil,
      resolve = c => c.ctx.product(c arg Id)
    ),
    Field("products", ListType(ProductType),
      description = Some("Returns all available products."),
      resolve = _.ctx.products
    )
  )
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.