type Elem[X] = X match
  case String => Char
  case Array[t] => t
  case Iterable[t] => t
