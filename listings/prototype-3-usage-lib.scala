object AggregateLibraryDeveloper:
  // libraries can either be syntactic or semantic
  // semantic library make sense only for a specific semantics
  // syntactic library just rely on common syntax between semantics

  // if any library is needed, the import must be explicit, and it must be instantiated

  // example of syntactic library that works for many foundations:
  object MyLibrary:

    def distanceToGateways[AV[_], L <: AggregateFoundation[AV], D: Numeric: UpperBounded](using
        lang: L,
        branching: BranchingSyntax[AV, L],
        classicFieldCalculusSyntax: ClassicFieldCalculusSyntax[AV, L],
    )(
        local: Boolean,
        gateway: Boolean,
        distances: lang.AggregateValue[D],
    ): lang.AggregateValue[D] =
      import lang.convert, branching._
      branch(local)(summon[UpperBounded[D]].upperBound)(distanceTo[AV, L, D](gateway, distances))

  // example of semantic library that works only for a specific foundation:
  class MyLibrary2[ID](using lang: ExchangeCalculusSemantics[ID]):
    import lang._

    def randomMessages(): NValues[ID, Int] =
      neighbors.map(_ => Random.nextInt())
end AggregateLibraryDeveloper
