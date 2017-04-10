def i = 20
if (i < 10)
  println("smaller then 10")
else if (i < 20)
  println("smaller then 20")
else if (i < 30)
  println("smaller then 30")
else if (i < 40)
  println("smaller then 40")


def j = 2
def c = 500

def callFunctionsMethod(): Unit = {
  Functions.functionWithNamedArgs(j, c)
}

callFunctionsMethod();
