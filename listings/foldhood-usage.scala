def foldhoodingPlusProgram(using ExchangeCalculusContextWithHopDistance): Int =
  foldhoodPlus(0)(_ + _) {
    nbr(self) + nbr("3").toInt + nbrRange
  }
