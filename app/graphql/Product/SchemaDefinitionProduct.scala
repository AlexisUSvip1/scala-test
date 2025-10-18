package graphql.Product

import graphql.{ProductMutations, ProductQueries, ProductRepo}
import sangria.schema._

// Importar los campos de los módulos

object SchemaDefinitionProduct {

  // 1. El QueryType se construye concatenando las listas de campos de todos los módulos de consultas.
  val QueryType = ObjectType("Query",
    fields[ProductRepo, Unit](
      (ProductQueries.Fields): _* // Combina las listas de campos
    )
  )

  // 2. El MutationType se construye concatenando las listas de campos de todos los módulos de mutaciones.
  val MutationType = ObjectType("Mutation",
    fields[ProductRepo, Unit](
      (ProductMutations.Fields): _* // Combina las listas de campos
    )
  )

  // 3. El esquema final usa los dos tipos raíz.
  val schema: Schema[ProductRepo, Unit] = Schema(QueryType, Some(MutationType))
}