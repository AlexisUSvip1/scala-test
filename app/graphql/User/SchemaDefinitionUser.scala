package graphql.User


import graphql.{UserMutations, UserQuery, UserRepo}
import sangria.schema._

// Importar los campos de los módulos

object SchemaDefinitionUser {

  // 1. El QueryType se construye concatenando las listas de campos de todos los módulos de consultas.
  val QueryType = ObjectType("Query",
    fields[UserRepo, Any](
      (UserQuery.Fields): _* // Combina las listas de campos
    )
  )

  val MutationType = ObjectType("Mutation",
    fields[UserRepo, Any](
      (UserMutations.Fields): _*
    )
  )


  // 3. El esquema final usa los dos tipos raíz.
  val schema: Schema[UserRepo, Any] = Schema(QueryType, Some(MutationType))
}