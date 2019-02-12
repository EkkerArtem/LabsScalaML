package lectures_1_2

import lectures_1_2.Funcs._

object Main extends App {
  println(max(List(1,2,3)))
  println(scalaAbs(4))
  println(scalaAbs(-4))

  println("must be FALSE " + and(x = false,y = false))
  println("must be FALSE " + and(x = false,y = true))
  println("must be FALSE " + and(x = false,y = loop))
  println("must be FALSE " + and(x = true,y = false))
  println("must be TRUE " + and(x = true,y = true))

  println("must be FALSE " + or(x = false,y = false))
  println("must be TRUE " + or(x = false,y = true))
  println("must be TRUE " + or(x = true,y = false))
  println("must be TRUE " + or(x = true,y = true))

  println(sqrt(0.000000000001))
  println(sqrt(2))
  println(sqrt(9))

  println(gcb(14, 21))

  println(factorial(4))
  println(tailRecursiveFactorial(4))

}
