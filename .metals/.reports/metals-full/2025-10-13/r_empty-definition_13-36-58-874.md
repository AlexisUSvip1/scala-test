error id: file://<WORKSPACE>/app/graphql/Product/ProductRepo.scala:scala/concurrent/Future.
file://<WORKSPACE>/app/graphql/Product/ProductRepo.scala
empty definition using pc, found symbol in pc: scala/concurrent/Future.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -scala/concurrent/Future.
	 -Future.
	 -scala/Predef.Future.
offset: 665
uri: file://<WORKSPACE>/app/graphql/Product/ProductRepo.scala
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
  def products: Future[List[Product]] = Future@@.successful {
    productsData
  }

  // 2. Implementación CORRECTA de deleteProduct
  def deleteProduct(id: String): Future[Option[Product]] = Future.successful {
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

  def updateProduct(
    id: String, 
    name: String, 
    description: String
  ): Future[Option[Product]] = Future.successful {
    
    productsData.find(_.id == id) match {
      case Some(oldProduct) =>
        // 1. Crear la nueva versión del producto
        val updatedProduct = oldProduct.copy(name = name, description = description)

        // 2. Reemplazar el producto antiguo en la lista 'productsData'
        productsData = productsData.map { p =>
          if (p.id == id) updatedProduct else p
        }
        
        // 3. Devolver el producto actualizado
        Some(updatedProduct)
        
      case None =>
        // Producto no encontrado
        None
    }
  }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: scala/concurrent/Future.