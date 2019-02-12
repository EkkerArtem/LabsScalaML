package lecture_3.parts5_7

object SomeObj extends App {
  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)
  val v = new Rational(6, 9)

  def addRational(r: Rational, s: Rational): Rational =
    new Rational(
      r.numerator * s.denominator + s.numerator * r.denominator,
      r.denominator * s.denominator
    )

  def makeString(r: Rational) =
    r.numerator + "/" + r.denominator


  println(x.numerator)

  println(makeString(addRational(new Rational(1, 2), new Rational(2, 3))))

  println(x + y)

  println(x.neg)

  println(z - v)

  println(x - y - z)

  println(y + y)

  println(x < y)

  println(x.max(y))

  println(x max y)


  //new Rational(1, -1)

  println(new Rational(2))
}
