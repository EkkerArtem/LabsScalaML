package lecture_3.parts1_4

object Exercise2 {
  val tolerance = 0.0001

  def isCloseEnough(x: Double, y: Double): Boolean =
    Math.abs((x - y) / x) / x < tolerance

  def fixedPoint(f: Double => Double)(firstGuess: Double): Double = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }

    iterate(firstGuess)
  }

  def averageDump(f: Double => Double)(x: Double): Double = (x + f(x))/2

  def sqrt(x: Double): Double = fixedPoint(averageDump(y => x / y))(1.0)
}
