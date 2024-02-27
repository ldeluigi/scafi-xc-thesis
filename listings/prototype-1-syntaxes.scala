// ExchangeCalculusSyntax.scala
trait ExchangeCalculusSyntax[L <: AggregateFoundation]:
  extension (language: L)
    def exchange[T](initial: language.AggregateValue[T])(
        f: language.AggregateValue[T] => (language.AggregateValue[T], language.AggregateValue[T]) |
          language.AggregateValue[T],
    ): language.AggregateValue[T]
// end ExchangeCalculusSyntax.scala

// FieldCalculusSyntax.scala
trait ClassicFieldCalculusSyntax[L <: AggregateFoundation]:
  extension (language: L)
    def nbr[V](expr: => language.AggregateValue[V]): language.AggregateValue[V]
    def rep[A](init: => A)(f: A => A): A
    def share[A](init: => A)(f: A => A): A
// end FieldCalculusSyntax.scala
