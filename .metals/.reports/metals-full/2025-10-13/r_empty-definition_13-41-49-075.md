error id: file://<WORKSPACE>/app/graphql/Picture/PictureRepo.scala:scala/concurrent/Future.
file://<WORKSPACE>/app/graphql/Picture/PictureRepo.scala
empty definition using pc, found symbol in pc: scala/concurrent/Future.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -scala/concurrent/Future.
	 -Future.
	 -scala/Predef.Future.
offset: 526
uri: file://<WORKSPACE>/app/graphql/Picture/PictureRepo.scala
text:
```scala
package graphql
import models.Picture
import scala.concurrent.Future

object PictureRepo {
    private var pictureData: List[Picture] = List(
      Picture(1, "https://example.com/picture1.jpg"),
      Picture(2, "https://example.com/picture2.jpg")
    )

    def getPicture(id:Int): Future[Option[Picture]] = Future.successful {
      pictureData.find(_.id == id)
    }   

    def getPictures: Future[List[Picture]] = Future.successful {
      pictureData
    }

    def deleteProduct(id: String): Future[Option[Product]] = @@Future.successful {
    // Buscar el producto antes de eliminar
    productsData.find(_.id == id) match {
      case Some(productToDelete) =>
        // 3. Crear la nueva lista sin el producto y reasignar a 'productsData'
        productsData = productsData.filterNot(_.id == id)
        // 4. Devolver el producto que fue eliminado
        Some(productToDelete) 
      case None =>
        // No se encontró nada, devolver None
        None
    }
  }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: scala/concurrent/Future.