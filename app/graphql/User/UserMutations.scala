package graphql

import sangria.schema._

object UserMutations {

  // Reutilizar argumentos
  val Id = Argument("id", StringType)

  // Lista de campos de mutación relacionados con productos
  val Fields: List[Field[UserRepo, Any]] = List(
    Field("deleteUser", OptionType(UserTypes.UserType),
      description = Some("Deletes a product by ID."),
      arguments = Id :: Nil,
      resolve = c => c.ctx.deleteUserById(c.arg(Id))  // Usar c.arg(Id) para obtener el argumento
    ),
  )
}