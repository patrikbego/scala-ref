
/**
  * Created by patrik007 on 09/04/2017.
  */
class FunctionsImpl {

  def a = 2
  def c = 500

  def callFunctionsMethod(): Unit = {
    Functions.functionWithNamedArgs(a, c)
  }

}
