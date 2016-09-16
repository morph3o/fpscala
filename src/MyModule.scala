object MyModule {

  def factorial(n: Int): Int = {
    def go(n: Int, acc: Int): Int =
      if(n <= 0) acc
      else go(n - 1, n * acc) //This is in tail position as it returns the value of the recursive call directly
    go(n, 1)
  }

  private def formatFactorial(n: Int): String = {
    val msg = "The factorial of %d is %d"
    msg.format(n, factorial(n))
  }

  def abs(n: Int): Int = {
    if(n < 0) -n
    else n
  }

  private def formatAbs(x: Int) = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

  def main(args: Array[String]): Unit = {
    println(formatAbs(42))
    println(formatFactorial(7))
  }

}