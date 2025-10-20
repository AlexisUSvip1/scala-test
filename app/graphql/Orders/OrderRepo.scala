package graphql

import models.Order

import java.time.LocalDateTime
import scala.concurrent.Future

class OrderRepo {
  private val listOrder: List[Order] = List(
    Order("1", "u1", "1", 2, 100.50, "pendiente", LocalDateTime.now()),
    Order("2", "u2", "2", 1, 50.00, "pagado", LocalDateTime.now()),
    Order("3", "u2", "3", 3, 150.75, "enviado", LocalDateTime.now())
  )


  def allOrders: Future[List[Order]] = Future.successful {
    listOrder
  }

  def orderById(id: String): Future[Option[Order]]=Future.successful{
    listOrder.find(_.id==id)
  }
}