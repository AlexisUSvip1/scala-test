error id: file://<WORKSPACE>/app/graphql/Picture/PictureQueries.scala:`<none>`.
file://<WORKSPACE>/app/graphql/Picture/PictureQueries.scala
empty definition using pc, found symbol in pc: `<none>`.
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 265
uri: file://<WORKSPACE>/app/graphql/Picture/PictureQueries.scala
text:
```scala
package graphql

object PictureQueries {
    var Id = Argument("id", StringType)


    val Fields: Lidt[Field[PictureRepo, Unit]= List(
        Field("picture", OptionType(PictureType),
            description = Some("Returns a picture by ID."),
            argumen@@ts = Id :: Nil,
            resolve = c => c.ctx.picture(c arg Id)
        ),
        Field("pictures", ListType(PictureType),
            description = Some("Returns all available pictures."),
            resolve = _.ctx.pictures
        )
    )]    
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.