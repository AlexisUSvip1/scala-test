package graphql

import scala.concurrent.Future
import models.User // Asumiendo que User está en el paquete models

// Se corrige la sintaxis de la clase
class UserRepo(productRepo: ProductRepo) {

  private val allUsers: List[User] = List(
    User("u1", "Alex", "Smith", 30, Some("1")),
    User("u2", "Bella", "Jones", 25, Some("2")),
    User("u3", "Charlie", "Brown", 40, None)
  )

  // Se añade 'def' para definir un método
  def getUserById(idUser: String): Future[Option[User]] = Future.successful {
    if(allUsers.length == 0){

    }
    allUsers.find(_.id == idUser)
  }

  // Se añade 'val' y se corrige el tipo a List[User]
  def getAllUsers: Future[List[User]] = Future.successful {
    allUsers
  }

  // ✅ La lógica de esta función es CORRECTA y segura usando .contains
  def getUserByProduct(idProduct: String): Future[Option[User]] = Future.successful {
    allUsers.find { user =>
      user.productId.contains(idProduct)
    }
  }
  def getProductById(idProduct: String): Future[Option[models.Product]] = {    // Now you can call the actual ProductRepo method!
    productRepo.product(idProduct)
  }
}