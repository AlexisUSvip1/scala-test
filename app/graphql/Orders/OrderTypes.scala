package graphql

import sangria.schema._
import sangria.macros.derive._
import sangria.ast
import sangria.validation.ValueCoercionViolation
import models._
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import scala.util.{Try, Success, Failure}

// 1. Asegúrate de importar TODOS los tipos que usas en el deriveObjectType.
// Esto trae el 'implicit val PictureType' al alcance.
import PictureTypes._ // <-- Esta línea es vital

object OrderTypes {

  // Custom scalar type for LocalDateTime
  case object DateTimeCoercionViolation extends ValueCoercionViolation("Date time value expected")

  implicit val LocalDateTimeType: ScalarType[LocalDateTime] = ScalarType[LocalDateTime](
    "DateTime",
    description = Some("DateTime scalar type representing a date and time"),
    coerceOutput = (value, _) => value.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
    coerceUserInput = {
      case s: String => Try(LocalDateTime.parse(s, DateTimeFormatter.ISO_LOCAL_DATE_TIME)) match {
        case Success(date) => Right(date)
        case Failure(_) => Left(DateTimeCoercionViolation)
      }
      case _ => Left(DateTimeCoercionViolation)
    },
    coerceInput = {
      case ast.StringValue(s, _, _, _, _) => Try(LocalDateTime.parse(s, DateTimeFormatter.ISO_LOCAL_DATE_TIME)) match {
        case Success(date) => Right(date)
        case Failure(_) => Left(DateTimeCoercionViolation)
      }
      case _ => Left(DateTimeCoercionViolation)
    }
  )

  val IdentifiableType: InterfaceType[OrderRepo, Identifiable] = InterfaceType(
    "Identifiable",
    "Entity that can be identified",
    fields[OrderRepo, Identifiable](
      Field("id", StringType, resolve = _.value.id)
    )
  )

  implicit val OrderType: ObjectType[OrderRepo, Order] =
    deriveObjectType[OrderRepo, Order](
      Interfaces(IdentifiableType)
    )
}