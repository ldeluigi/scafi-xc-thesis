given ExpressiveFieldCalculusSyntax[ExchangeCalculusSemantics] with
    extension (language: ExchangeCalculusSemantics)
      override def rep[A](init: => language.AggregateValue[A])(
          f: language.AggregateValue[A] => language.AggregateValue[A],
      ): language.AggregateValue[A] =
        language.exchange(init)(prev => f(prev.onlySelf))

      override def nbr[A](expr: => language.AggregateValue[A]): language.AggregateValue[A] =
        language.exchange(expr)(n => (n, expr))

      override def share[A](init: => language.AggregateValue[A])(
          f: language.AggregateValue[A] => language.AggregateValue[A],
      ): language.AggregateValue[A] =
        language.exchange(init.onlySelf)(f)
