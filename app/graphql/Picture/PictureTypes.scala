package graphql

import sangria.schema._
import sangria.macros.derive._
import models._

// Objeto para contener todos los tipos de imágenes
object PictureTypes {

  // 1. Tipo Picture
  // NOTA: Asume que tienes un 'case class Picture' definido en models._
  implicit val PictureType: ObjectType[Unit, Picture] =
    deriveObjectType[Unit, Picture](
      ObjectTypeDescription("The product picture"),
      DocumentField("url", "Picture CDN URL")
    )

  // Puedes añadir otros tipos relacionados con imágenes aquí (ej. PictureInputType)

}