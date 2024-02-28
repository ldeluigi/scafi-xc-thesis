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

given ClassicFieldCalculusSyntax[ExchangeCalculusSemantics] with
    extension (language: ExchangeCalculusSemantics)
      override def nbr[V](expr: => NValues[language.ID, V]): NValues[language.ID, V] =
        summon[ExpressiveFieldCalculusSyntax[ExchangeCalculusSemantics]]
          .nbr(language)(expr)
      override def rep[A](init: => A)(f: A => A): A =
        summon[ExpressiveFieldCalculusSyntax[ExchangeCalculusSemantics]]
          .rep(language)(init)(nv => nv.map(f))
          .onlySelf
      override def share[A](init: => A)(f: A => A): A =
        summon[ExpressiveFieldCalculusSyntax[ExchangeCalculusSemantics]]
          .share(language)(init)(nv => nv.map(f))
          .onlySelf
