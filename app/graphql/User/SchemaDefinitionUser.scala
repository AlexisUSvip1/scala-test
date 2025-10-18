package graphql.User


import graphql.{UserQuery, UserRepo}
import sangria.schema._

// Importar los campos de los módulos

object SchemaDefinitionUser {

  // 1. El QueryType se construye concatenando las listas de campos de todos los módulos de consultas.
  val QueryType = ObjectType("Query",
    fields[UserRepo, Unit](
      (UserQuery.Fields): _* // Combina las listas de campos
    )
  )

  // 2. El MutationType se construye concatenando las listas de campos de todos los módulos de mutaciones.


  // 3. El esquema final usa los dos tipos raíz.
  val schema: Schema[UserRepo, Unit] = Schema(QueryType)
}