package graphql
import sangria.schema._
import UserTypes._
object UserQuery  {
  val Id = Argument("id",StringType)

  val Fields: List[Field[UserRepo,Unit]] = List(
    Field("user", OptionType(UserType),
      description = Some("Returns a user by ID."),
      arguments = Id :: Nil,
      resolve = c => c.ctx.getUserById(c arg Id)
    ),
    Field("users", ListType(UserType),
      description = Some("Returns all available products."),
      resolve = _.ctx.getAllUsers
    ),
    Field("userBProduct", OptionType(UserType),
      description = Some("Returns  available user products."),
      resolve = c => c.ctx.getUserByProduct(c arg Id)
    ),
  )
}