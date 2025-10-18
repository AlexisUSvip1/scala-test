error id: file://<WORKSPACE>/app/graphql/ProductRepo.scala:scala/Some.
file://<WORKSPACE>/app/graphql/ProductRepo.scala
empty definition using pc, found symbol in pc: scala/Some.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -Some.
	 -Some#
	 -Some().
	 -scala/Predef.Some.
	 -scala/Predef.Some#
	 -scala/Predef.Some().
offset: 926
uri: file://<WORKSPACE>/app/graphql/ProductRepo.scala
text:
```scala
package graphql

import models.Product
import scala.concurrent.Future

class ProductRepo {
  
  // 1. Convertir a 'var' para que la lista sea mutable internamente.
  private var productsData: List[Product] = List(
    Product("1", "Cheesecake", "Tasty!"),
    Product("2", "Health Potion", "+50 HP")
  )

  // Nota: Por simplicidad con Sangria, devolveremos Future.successful
  // (aunque en un proyecto real harías una llamada asíncrona a la DB).

  // Obtiene un producto
  def product(id: String): Future[Option[Product]] = Future.successful {
    productsData.find(_.id == id)
  }

  // Obtiene todos los productos
  def products: Future[List[Product]] = Future.successful {
    productsData
  }

  // 2. Implementación CORRECTA de deleteProduct
  def deleteProduct(id: String): Future[Option[Product]] = Future.successful {
    // Buscar el producto antes de eliminar
    productsData.find(_.id == id) match {
      case @@Some(productToDelete) =>
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

empty definition using pc, found symbol in pc: scala/Some.