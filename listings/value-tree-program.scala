def myProgram(using ExchangeCalculusSemantics): Int =
    val _ = exchange(5)(nv1 =>
      val _ = branch(true) {
        val _ = nbr("a").fold("")(_ + _)
        share(Some(2))(nv3 =>
          val _ = exchange(3.22)(nv4 => nv4).fold(0.0)(_ + _)
          Some(branch(false) { -1 } {
            exchange(List(1))(nv => nv.map(_ ++ List(3, 7))).map(_.sum).onlySelf
          }),
        )
      } {
        None
      }
      nv1,
    ).onlySelf
    branch(false) { 1 } { exchange(2)(nv => nv).onlySelf }
