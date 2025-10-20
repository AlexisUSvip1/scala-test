package models

import java.time.LocalDateTime

// Define el caso Order
case class Order(
                  id: String,                   // ID único de la orden
                  userId: String,               // ID del usuario que hizo la compra
                  productId: String,            // ID del producto (puede ser una lista si hay varios productos)
                  quantity: Int,                // Cantidad del producto
                  totalAmount: Double,          // Monto total de la orden
                  status: String,               // Estado de la orden (pendiente, pagado, enviado, etc.)
                  createdAt: LocalDateTime      // Fecha de creación de la orde
                ) extends Identifiable