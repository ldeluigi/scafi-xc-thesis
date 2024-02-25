// Currying a function
def add(x: Int)(y: Int): Int = x + y

// Partial application of a curried function
val addTwo = add(2) _

// Usage
val result = addTwo(3) // result = 5
