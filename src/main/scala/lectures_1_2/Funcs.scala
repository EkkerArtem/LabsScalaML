package lectures_1_2

object Funcs {

  def sum(xs: List[Int]): Int = 0

  def max(xs: List[Int]): Int = 0

  def Test(x: Int, y: Int) = x * y

  def scalaAbs(x: Double): Double = if (x >= 0) x else -x

  def and(x: Boolean, y: => Boolean): Boolean = if (x) y else false

  def or(x: Boolean, y: => Boolean): Boolean = if (x) x else y

  def loop: Boolean = loop

  def sqrt(x: Double) = {

    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    def isGoodEnough(guess: Double) =
      scalaAbs(guess * guess - x) / x < 0.001

    def improve(guess: Double) =
      (guess + x / guess) / 2

    sqrtIter(1.0)
  }

  def gcb(a: Int, b: Int): Int =
    if (b == 0) a else gcb(b, a % b)

  def factorial(n: Int): Int =
    if (n == 0) 1 else n * factorial(n - 1)

  def tailRecursiveFactorial(n: Int): Int = {
    def loop(acc: Int, n: Int): Int =
      if (n == 0) acc
      else loop(acc * n, n - 1)
    loop(1, n)
  }
}
