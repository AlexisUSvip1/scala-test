package models

import graphql.ProductRepo
import scala.concurrent.Future

case class User(
                 id: String,
                 name: String,
                 lastName: String,
                 age: Int,
                 productId: Option[String]
               ) extends Identifiable {

  def product(repo: ProductRepo): Future[Option[Product]] = {
    productId match {
      case Some(id) =>
        repo.product(id)
      case None =>
        Future.successful(None)
    }
  }
}