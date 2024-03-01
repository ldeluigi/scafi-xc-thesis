def exchange[T](initial: AggregateValue[T])(
    f: AggregateValue[T] => RetSend[AggregateValue[T]]
): AggregateValue[T]

import RetSend.{ *, given } // necessary to enable some of the styles below

// To send and return the same value:
exchange(0)(value => f(value))
exchange(0)(value => retsend(f(value)))

// To send and return potentially different values:
exchange(0)(value => (f(value), f2(value)))
exchange(0)(value => ret (f(value)) send f2(value))
exchange(0)(value => ret(f(value)).send(f2(value)))
exchange(0)(value => RetSend(f(value), f2(value)))
