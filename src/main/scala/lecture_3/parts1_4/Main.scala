package lecture_3.parts1_4
import Exercise._
import Exercise2._
import Funcs._

object Main extends App {

  println(sumInts(1,4))
  println(sumCubes(1,4))
  println(sumFactorials(1,4))

  println("must be 50 " + tailRecursiveSum(x => x* x, 3, 5))

  println(sum (cube) (1,4))

  println("must be 144 : " + product(x => x * x)(3,4))
  println("must be 120 : " + Exercise.fact(5))

  println(sqrt(2))
}
