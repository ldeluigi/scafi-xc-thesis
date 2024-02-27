// Foldable.scala
trait Foldable[F[_]]:
  extension [A](a: F[A]) def fold[B](base: B)(acc: (B, A) => B): B

// end Foldable.scala

// Liftable.scala
trait Liftable[F[_]]:
  extension [A](a: F[A]) def map[B](f: A => B): F[B]

  def lift[A, B, C](a: F[A], b: F[B])(f: (A, B) => C): F[C]

  def lift[A, B, C, D](a: F[A], b: F[B], c: F[C])(f: (A, B, C) => D): F[D]

object Liftable:
  def lift[A, B, C, F[_]: Liftable](a: F[A], b: F[B])(f: (A, B) => C): F[C] =
    summon[Liftable[F]].lift(a, b)(f)

  def lift[A, B, C, D, F[_]: Liftable](a: F[A], b: F[B], c: F[C])(f: (A, B, C) => D): F[D] =
    summon[Liftable[F]].lift(a, b, c)(f)

// end Liftable.scala

// AggregateFoundation.scala
trait AggregateFoundation:
  type AggregateValue[T]

  given lift: Liftable[AggregateValue]
  given fold: Foldable[AggregateValue]
  given convert[T]: Conversion[T, AggregateValue[T]]

  // Default builtins
  extension [T](av: AggregateValue[T])
    def onlySelf: T

    def withoutSelf: AggregateValue[T]

    def nfold[B](base: B)(acc: (B, T) => B): B =
      av.withoutSelf.fold(base)(acc)

end AggregateFoundation
// end AggregateFoundation.scala
