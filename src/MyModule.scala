object MyModule {

  def fibonacciRecursive(n: Int): Int = {
    def go(n: Int): Int = {
      if(n <= 1) n
      else go(n-1) + go(n-2)
    }
    go(n)
  }

  def fibonacciTailRecursive(n: Int): Int = {
    def tr(num: Int, n0: Int, n1: Int): Int = {
      if (num == 0) n0
      else tr(num-1, n1, n0 + n1)
    }
    tr(n, 0, 1)
  }

  def factorial(n: Int): Int = {
    def go(n: Int, acc: Int): Int =
      if(n <= 0) acc
      else go(n - 1, n * acc) //This is in tail position as it returns the value of the recursive call directly
    go(n, 1)
  }

  def abs(n: Int): Int = {
    if(n < 0) -n
    else n
  }

  private def formatResult(name: String, n: Int, f: Int => Int): String = {
    val msg = "The %s of %d is %d"
    msg.format(name, n, f(n))
  }

  def main(args: Array[String]): Unit = {
    println(formatResult("absolut value", 42, abs))
    println(formatResult("factorial", 7, factorial))
    println(formatResult("fibonacci (recursive)", 4, fibonacciRecursive))
    println(formatResult("fibonacci (tail recursive)", 4, fibonacciTailRecursive))
  }

}