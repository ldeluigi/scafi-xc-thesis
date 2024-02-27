// the runtime defines the vm implementations
// while the engine defines context and exchange implementations
object AggregateProgramDeveloper extends ExchangeCalculusRuntime with Engine:

  // a program can either subclass an interpreter
  private class MyProgram extends ExchangeCalculusInterpreter:

    override def main(): Any =
      this.rep(1)(_ + 1)

  // the following tests simulate a single round of execution
  @main def test1(): Unit =
    val p = MyProgram()
    val c: Context = EngineContext()
    println(p(c))
