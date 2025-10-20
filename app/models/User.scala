package models

import graphql._
import scala.concurrent.Future

case class User(
                 id: String,
                 name: String,
                 lastName: String,
                 age: Int,
                 productId: Option[String],
                 orderId: Option[String]
               ) extends Identifiable {

  def product(repo: ProductRepo): Future[Option[Product]] = {
    productId match {
      case Some(id) =>
        repo.product(id)
      case None =>
        Future.successful(None)
    }
  }
  def order(repo: OrderRepo): Future[Option[Order]] = {
    orderId match {
      case Some(id) =>
        repo.orderById(id)
      case None =>
        Future.successful(None)
    }
  }
}