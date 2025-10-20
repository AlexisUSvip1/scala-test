package graphql

import graphql.{OrderQueries, OrderRepo}
import sangria.schema._

// Importar los campos de los módulos

object SchemaDefinitionOrder {

  // 1. El QueryType se construye concatenando las listas de campos de todos los módulos de consultas.
  val QueryType = ObjectType("Query",
    fields[OrderRepo, Unit](
      (OrderQueries.Fields): _* // Combina las listas de campos
    )
  )


  // 3. El esquema final usa los dos tipos raíz.
  val schema: Schema[OrderRepo, Unit] = Schema(QueryType)
}