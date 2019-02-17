package lecture7.part3

import lecture_5.part1.{Empty, IntSet, NonEmpty}

object main {

  def main(args: Array[String]): Unit = {

    val a: Array[NonEmpty] = Array(new NonEmpty(1, Empty, Empty))
    val b: Array[IntSet] = a //exception in this line coz arrays in Scala are not covariant
    b(0) = Empty
    val s: NonEmpty = a(0)
  }
}
