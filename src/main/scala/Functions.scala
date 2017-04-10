import java.util.Date

import com.sun.deploy.net.proxy.PACFunctionsImpl

/**
  * Created by patrik007 on 07/04/2017.
  */
object Functions {

  def main(args: Array[String]): Unit = {
    println(addInt(removeInt(2, 1), 1))
    delayed(time())
    functionWithNamedArgs(b = 100, a = 1)
    functionWithNamedArgsWithDefValues()
    functionWithVariableArgs("1", "two", "five", "...")
    for (i <- 1 to 10)
      println("Factorial of " + i + ": = " + factorialRecursion(i))

    println(higherOrderFunction(lowerOrderFunction, 10))
    println(higherOrderFunction(lowerOrderFunction1, 10))
    println(factorialWithNestedFunction(2))
    println(anonFunction(3, 4))

    val date = new Date
    log(date, "message1" )

    Thread.sleep(1000)
    log(date, "message2" )

    Thread.sleep(1000)
    log(date, "message3" )

    val logWithDateBound = log(date, _ : String)

    logWithDateBound("message1" )
    Thread.sleep(1000)

    logWithDateBound("message2" )
    Thread.sleep(1000)

    logWithDateBound("message3" )

    println( "str1 + str2 = " +  curriedFunction("Hey ")(" You 2") )
  }

  def curriedFunction(s1: String)(s2: String) = {
    s1 + s2
  }

  def log(date: Date, message: String)  = {
    println(date + "----" + message)
  }

  var anonFunction = (x: Int, y: Int) => x * y

  def factorialWithNestedFunction(i: Int): Int = {
    def nestedFunction(i: Int, accumulator: Int): Int = {
      if (i <= 1)
        accumulator
      else
        nestedFunction(i - 1, i * accumulator)
    }

    nestedFunction(i, 1)
  }

  def higherOrderFunction(f: Int => String, v: Int) = f(v)

  def higherOrderFunction1(g: Int => String, paramWhichIsPassesIntoLowerFunction: Int) = g(paramWhichIsPassesIntoLowerFunction)

  def lowerOrderFunction[A](x: A) = "[" + x.toString() + "]"

  def lowerOrderFunction1(x: Int) = x.toString()

  def factorialRecursion(n: BigInt): BigInt = {
    if (n <= 1)
      1
    else
      n * factorialRecursion(n - 1)
  }

  def functionWithVariableArgs(args: String*) = {
    var i: Int = 0

    for (arg <- args) {
      println("Arg value[" + i + "] = " + arg);
      i = i + 1
    }
  }

  def functionWithNamedArgs(a: Int, b: Int) = {
    println("Value of a : " + a);
    println("Value of b : " + b);
  }

  def functionWithNamedArgsWithDefValues(a: Int = 1, b: Int = 2) = {
    functionWithNamedArgs(a, b)
  }

  def addInt(a: Int, b: Int): Int = {
    var sum: Int = 0
    sum = a + b
    return sum
  }

  def removeInt(a: Int, b: Int): Int = {
    return a - b;
  }

  def printMe(): Unit = {
    println("Hey, You!")
  }


  def time() = {
    println("Getting time in nano seconds")
    System.nanoTime
  }

  def delayed(t: => Long) = {
    println("In delayed method")
    println("Param: " + t)
  }
}
