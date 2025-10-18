error id: file://<WORKSPACE>/app/graphql/Picture/PictureQueries.scala:scala/Unit#
file://<WORKSPACE>/app/graphql/Picture/PictureQueries.scala
empty definition using pc, found symbol in pc: scala/Unit#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 127
uri: file://<WORKSPACE>/app/graphql/Picture/PictureQueries.scala
text:
```scala
package graphql

object PictureQueries {
    var Id = Argument("id", StringType)


    val Fields: Lidt[Field[PictureRepo, Unit@@]= List(
        Field("picture", OptionType(PictureType),
            description = Some("Returns a picture by ID."),
            arguments = Id :: Nil,
            resolve = c => c.ctx.picture(c arg Id)
        ),
        Field("pictures", ListType(PictureType),
            description = Some("Returns all available pictures."),
            resolve = c => c.ctx.picture
    )]    
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: scala/Unit#