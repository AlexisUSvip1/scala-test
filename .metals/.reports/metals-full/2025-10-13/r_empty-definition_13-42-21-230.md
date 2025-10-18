error id: file://<WORKSPACE>/app/graphql/Picture/PictureRepo.scala:`<none>`.
file://<WORKSPACE>/app/graphql/Picture/PictureRepo.scala
empty definition using pc, found symbol in pc: `<none>`.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -models/Picture.
	 -models/Picture#
	 -models/Picture().
	 -Picture.
	 -Picture#
	 -Picture().
	 -scala/Predef.Picture.
	 -scala/Predef.Picture#
	 -scala/Predef.Picture().
offset: 153
uri: file://<WORKSPACE>/app/graphql/Picture/PictureRepo.scala
text:
```scala
package graphql
import models.Picture
import scala.concurrent.Future

object PictureRepo {
    private var pictureData: List[Picture] = List(
      Pictu@@re(1, "https://example.com/picture1.jpg"),
      Picture(2, "https://example.com/picture2.jpg")
    )

    def getPicture(id:Int): Future[Option[Picture]] = Future.successful {
      pictureData.find(_.id == id)
    }   

    def getPictures: Future[List[Picture]] = Future.successful {
      pictureData
    }

    def deletePicture(id: String): Future[Option[Picture]] = Future.successful {
    // Buscar el producto antes de eliminar
    pictureData.find(_.id == id) match {
      case Some(pictureToDelete) =>
        // 3. Crear la nueva lista sin el producto y reasignar a 'productsData'
        pictureData = pictureData.filterNot(_.id == id)
        // 4. Devolver el producto que fue eliminado
        Some(pictureToDelete) 
      case None =>
        // No se encontró nada, devolver None
        None
    }
  }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.