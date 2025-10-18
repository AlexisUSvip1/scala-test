package graphql

import sangria.schema._
import ProductTypes._ // Importar los tipos definidos en ProductTypes

object ProductMutations {

  // Reutilizar argumentos
  val Id = Argument("id", StringType)
  val NewName = Argument("name", StringType)
  val NewDescription = Argument("description", StringType)

  // Lista de campos de mutación relacionados con productos
  val Fields: List[Field[ProductRepo, Unit]] = List(
    Field("deleteProduct", OptionType(ProductType),
      description = Some("Deletes a product by ID."),
      arguments = Id :: Nil,
      resolve = c => c.ctx.deleteProduct(c arg Id)
    ),
    Field("updateProduct", OptionType(ProductType),
      description = Some("Updates an existing product."),
      arguments = Id :: NewName :: NewDescription :: Nil,
      resolve = c => c.ctx.updateProduct(
        c arg Id, 
        c arg NewName, 
        c arg NewDescription
      )
    )
  )
}