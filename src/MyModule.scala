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

  private def formatFibonacciRecursive(n: Int): String = {
    val msg = "The fibonacci number of %d is %d"
    msg.format(n, fibonacciRecursive(n))
  }

  private def formatFibTailRecursive(n: Int): String = {
    val msg = "The fibonacci (TR) number of %d is %d"
    msg.format(n, fibonacciTailRecursive(n))
  }

  private def formatFactorial(n: Int): String = {
    val msg = "The factorial of %d is %d"
    msg.format(n, factorial(n))
  }

  private def formatAbs(x: Int) = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

  def main(args: Array[String]): Unit = {
    println(formatAbs(42))
    println(formatFactorial(7))
    println(formatFibonacciRecursive(4))
    println(formatFibTailRecursive(4))
  }

}