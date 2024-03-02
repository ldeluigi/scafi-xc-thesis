package it.unibo.scafi.xc.language.foundation

import scala.util.NotGiven
import scala.annotation.implicitNotFound

object DistributedSystemUtilities:
  @implicitNotFound(
    "Cannot share value of type ${T}. ${T} must be a primitive value type or a serializable type, and it must not be marked as NotShareable",
  )
  open class Shareable[T](using NotGiven[NotShareable[T]])

  final class NotShareable[T]

  given [T <: AnyVal | Serializable](using NotGiven[NotShareable[T]]): Shareable[T] = Shareable[T]()
end DistributedSystemUtilities
