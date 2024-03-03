class A:
  def method[T](it: Seq[T]): Iterable[T] = it

class B extends A:
  opaque type X[T] = Seq[T] // opaque type alias
  override def method[T](it: Seq[T]): X[T] = // X is subtype of Iterable
    it.reverse

val b = new B()
val res1: B#X[Int] = b.method(Seq(1, 2, 3))
println(res1) // prints List(3, 2, 1)

val res2 = b.method(res1) // Found: (Playground.res1 : Playground.B#X[Int])    Required: Seq[Any]
