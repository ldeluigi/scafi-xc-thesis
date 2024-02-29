import it.unibo.scafi.xc.abstractions.Liftable.*
import it.unibo.scafi.xc.abstractions.boundaries.UpperBounded
import it.unibo.scafi.xc.language.foundation.AggregateFoundation
import it.unibo.scafi.xc.language.syntax.FieldCalculusSyntax

import FieldCalculusLibrary.share
import CommonLibrary.mux
import Numeric.Implicits.*

object GradientLibrary:
  def distanceEstimate[N: Numeric: UpperBounded]
  (using language: AggregateFoundation)(
      neighboursEstimates: language.AggregateValue[N],
      distances: language.AggregateValue[N],
  ): N = lift(neighboursEstimates, distances)(_ + _).withoutSelf.min

  def distanceTo[N: Numeric: UpperBounded](using
      language: AggregateFoundation & FieldCalculusSyntax,
  )(source: Boolean, distances: language.AggregateValue[N]): N =
    share[N](summon[UpperBounded[N]].upperBound)(av =>
      mux(source)(
        summon[Numeric[N]].zero
      )(
        distanceEstimate(av, distances)
      )
    )
