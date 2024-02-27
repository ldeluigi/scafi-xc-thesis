def gradient(source: Boolean): Double =
    rep(Double.PositiveInfinity){ distance =>
        mux(source) { 0.0 } {
            foldhoodPlus(Double.PositiveInfinity)(Math.min)(
                nbr{distance} + nbrRange
            )
        }
    }
