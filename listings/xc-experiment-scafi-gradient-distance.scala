def distanceTo(source: Boolean, metric: NValue[Double]): Double =
    exchange(Double.PositiveInfinity)(n =>
      mux(source) {
        0.0
      } {
        (n + metric).withoutSelf.fold(Double.PositiveInfinity)(Math.min)
      }
    )

