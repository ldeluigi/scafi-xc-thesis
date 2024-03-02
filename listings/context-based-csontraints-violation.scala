// New nbr definition:
def nbr[A: Shareable](using language: AggregateFoundation & FieldCalculusSyntax)(
  expr: A,
): language.AggregateValue[A] = language.nbr(expr)

// Bad usage example:
val _ = nbr(nbr(1))

// Compilation error:
//[error] -- [E172] Type Error: Test.scala:7:19
//[error]  7 |    val _ = nbr(nbr(1))
//[error]    |                       ^
//[error]    |Cannot share value of type c.NValues[Int]. c.NValues[Int] must be a primitive value type or a serializable type, and it must not be marked as NotShareable.
