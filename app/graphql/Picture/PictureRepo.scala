package graphql

import models.Picture
import scala.concurrent.Future

class PictureRepo {

  // 1. Usar 'var' para permitir la mutación (eliminación/actualización) en memoria.
  private var pictureData: List[Picture] = List(
    // Asumo que tu modelo Picture tiene un constructor que acepta (id: String, url: String)
    // Si tu modelo es 'case class Picture(width: Int, height: Int, url: Option[String])', esto causará un error.
    // Si el modelo es el simple de ID/URL, este código es válido.

      Picture("1", 300, 300, Some("https://cdn.example.com/picture-300-1.jpg")),
      Picture("2", 600, 600, Some("https://cdn.example.com/picture-600-2.jpg"))

  )

  // === QUERIES ===

  // Obtiene una imagen por ID (La firma con String es correcta si el Id del esquema es String)
  def getPicture(id: String): Future[Option[Picture]] = Future.successful {
    pictureData.find(_.id == id)
  }

  // Obtiene todas las imágenes
  def getPictures: Future[List[Picture]] = Future.successful {
    pictureData
  }

  // === MUTATIONS ===

  // Elimina una imagen por ID
  def deletePicture(id: String): Future[Option[Picture]] = Future.successful {
    // 1. Buscar la imagen antes de intentar eliminar
    pictureData.find(_.id == id) match {
      case Some(pictureToDelete) =>
        // 2. Crear una nueva lista sin el elemento y reasignar el 'var'
        pictureData = pictureData.filterNot(_.id == id)
        // 3. Devolver la imagen que fue eliminada
        Some(pictureToDelete)
      case None =>
        None
    }
  }

  // 💡 Método addPicture (una mutación típica, no solicitada, pero útil para completar el CRUD)
  /*
  def addPicture(newPicture: Picture): Future[Picture] = Future.successful {
      pictureData = pictureData :+ newPicture
      newPicture
  }
  */
}