error id: file://<WORKSPACE>/app/graphql/ProductRepo.scala:`<none>`.
file://<WORKSPACE>/app/graphql/ProductRepo.scala
empty definition using pc, found symbol in pc: `<none>`.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -product.
	 -product#
	 -product().
	 -scala/Predef.product.
	 -scala/Predef.product#
	 -scala/Predef.product().
offset: 348
uri: file://<WORKSPACE>/app/graphql/ProductRepo.scala
text:
```scala
package graphql

import models.Product

class ProductRepo {
  private val Products = List(
    Product("1", "Cheesecake", "Tasty!"),
    Product("2", "Health Potion", "+50 HP")
  )

  def product(id: String): Option[Product] =
    Products.find(_.id == id)

  def deleteProduct(id: String): Option[Product] =
    Products.find(_.id == id).map { pro@@duct =>
      Products -= product
      product
    }

  def products: List[Product] = Products
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.