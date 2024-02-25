if x < 0 then
  println("negative")
else if x == 0 then
  println("zero")
else
  println("positive")

val y = if a < b then a else b


val ints = List(1, 2, 3, 4, 5)
for i <- ints do println(i)

val doubles = for i <- ints yield i * 2


var z = 1
while
  z < 3
do
  println(z)
  z += 1


val result = i match
  case 1 => "one"
  case 2 => "two"
  case _ => "other"


class Person(var firstName: String, var lastName: String):
  def printFullName() =
    println(s"First name: $firstName")
    println(s"Last name: $lastName")

val p = Person("John", "Stephens")
