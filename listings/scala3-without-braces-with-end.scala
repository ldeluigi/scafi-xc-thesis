object test:
  val x = 0
  val i = 1

  if x < 0 then 
    println("negative")
  end if

  val ints = List(1, 2, 3, 4, 5)
  for i <- ints do
    println(i)
  end for

  var z = 1
  while z < 3 do
    println(z)
    z += 1
  end while

  val result = i match
    case 1 => "one"
    case 2 => "two"
    case _ => "other"
  end result

  class Person(var firstName: String, var lastName: String):
    def printFullName() =
      println(s"First name: $firstName")
      println(s"Last name: $lastName")
    end printFullName
  end Person
end test