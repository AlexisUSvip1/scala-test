package models

case class Product(id: String, name: String, description: String) extends Identifiable {
  def picture(size: Int): Picture = {
    // Nota: Aquí, la lógica real buscaría la Picture real o construiría la URL.
    // Asumimos que el ID de la Picture es el mismo que el del Product.
    Picture(
      id = this.id,
      width = size,
      height = size,
      url = Some(s"https://cdn.com/$size/$id.jpg")
    )
  }
}
