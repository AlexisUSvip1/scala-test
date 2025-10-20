package graphql

import scala.concurrent.Future
import models.User // Asumiendo que User está en el paquete models

// Se corrige la sintaxis de la clase
class UserRepo(productRepo: ProductRepo, orderRepo: OrderRepo) {

  // Usamos 'var' para poder modificar la lista
  private var allUsers: List[User] = List(
    User("u1", "Alex", "Smith", 30, Some("1"), Some("1")),
    User("u2", "Bella", "Jones", 25, Some("2"), Some("1")),
    User("u3", "Charlie", "Brown", 40, Some("1"), Some("2"))
  )

  // Método para obtener un usuario por su ID
  def getUserById(idUser: String): Future[Option[User]] = Future.successful {
    allUsers.find(_.id == idUser)
  }

  // Método para obtener todos los usuarios
  def getAllUsers: Future[List[User]] = Future.successful {
    allUsers
  }

  // Método para obtener un usuario por el ID del producto
  def getUserByProduct(idProduct: String): Future[Option[User]] = Future.successful {
    allUsers.find { user =>
      user.productId.contains(idProduct)
    }
  }


  // Método para eliminar un usuario por su ID
  def deleteUserById(id: String): Future[Option[User]] = Future.successful {
    val userToDelete = allUsers.find(_.id == id)
    userToDelete match {
      case Some(user) =>
        allUsers = allUsers.filterNot(_.id == id)  // Elimina el usuario de la lista
        Some(user) 
      case None =>
        None  // Si no se encuentra el usuario, devuelve None
    }
  }

  def getProductById(idProduct: String): Future[Option[models.Product]] = {
    productRepo.product(idProduct)
  }
  def getOrderById(idOrder: String): Future[Option[models.Order]] = {
    orderRepo.orderById(idOrder)
  }
}
