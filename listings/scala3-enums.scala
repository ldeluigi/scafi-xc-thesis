// Scala 3 enum sum type
enum Option[+T]:
  case Some(x: T)
  case None

// Scala 2 sum type
sealed trait Option[+T]
case class Some[+T](x: T) extends Option[T]
case object None extends Option[Nothing]
