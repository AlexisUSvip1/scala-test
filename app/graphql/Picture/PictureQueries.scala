package graphql
import sangria.schema._
import PictureTypes._ // Importar los tipos definidos en ProductTypes

object PictureQueries {
    var Id = Argument("id", StringType)


    val Fields: List[Field[PictureRepo, Unit]] = List(
        Field("picture", OptionType(PictureType),
            description = Some("Returns a picture by ID."),
            arguments = Id :: Nil,
            resolve = c => c.ctx.getPicture(c arg Id)
        ),
        Field("pictures", ListType(PictureType),
            description = Some("Returns all available pictures."),
            resolve = c => c.ctx.getPictures
        )  
    )  
}
