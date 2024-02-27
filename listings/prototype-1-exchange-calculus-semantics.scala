trait ExchangeCalculusSemantics extends AggregateFoundation:
  type ID
  given idEquality: CanEqual[ID, ID] = CanEqual.derived

  case class NValues[ID, +V](default: V, values: MapView[ID, V]):
    def apply(id: ID): V = values.getOrElse(id, default)

  override type AggregateValue[T] = NValues[ID, T]

  protected def xcbranch[T](cond: AggregateValue[Boolean])(th: => AggregateValue[T])(
      el: => AggregateValue[T],
  ): AggregateValue[T]

  protected def xcexchange[T](init: AggregateValue[T])(
      f: AggregateValue[T] => (AggregateValue[T], AggregateValue[T]),
  ): AggregateValue[T]


  def self: ID // the id of the current device

  def neighbors: AggregateValue[ID] // the ids of the neighboring devices


  override given lift[ID]: Liftable[[V] =>> NValues[ID, V]] with
    extension [A](a: NValues[ID, A])
      override def map[B](f: A => B): NValues[ID, B] =
        NValues[ID, B](default = f(a.default), values = a.values.mapValues(f))

       override def lift[A, B, C](a: NValues[ID, A], b: NValues[ID, B])(f: (A, B) => C): NValues[ID, C] =
        ??? // omitted for brevity

      override def lift[A, B, C, D](a: NValues[ID, A], b: NValues[ID, B], c: NValues[ID, C])(
            f: (A, B, C) => D,
        ): NValues[ID, D] = ??? // omitted for brevity

  override def fold: Foldable[AggregateValue] = ??? // omitted for brevity

  override given convert[ID, V]: Conversion[V, NValues[ID, V]] with
    def apply(v: V): NValues[ID, V] = NValues[ID, V](default = v, values = MapView.empty)

  extension [T](av: NValues[ID, T])
    override def onlySelf: T = av(self)
    override def withoutSelf: NValues[ID, T] = av.copy(values = av.values.filterKeys(_ != self))

end ExchangeCalculusSemantics
