package graphql.Picture

import graphql.{PictureQueries, PictureRepo}
import sangria.schema._

// Importar los campos de los módulos

object SchemaDefinitionPicture {

  // 1. El QueryType se construye concatenando las listas de campos de todos los módulos de consultas.
  val QueryType = ObjectType("Query",
    fields[PictureRepo, Unit](
      (PictureQueries.Fields): _* // Combina las listas de campos
    )
  )



  // 3. El esquema final usa los dos tipos raíz.
  val schema: Schema[PictureRepo, Unit] = Schema(QueryType)
}