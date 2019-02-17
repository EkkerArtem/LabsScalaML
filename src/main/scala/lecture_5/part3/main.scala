package lecture_5.part3

import lecture_5.part1.{NonEmpty, Empty}

object main {
  def main(args: Array[String]): Unit = {
    def nth[T](n: Int, xs: List[T]): T =
      if (xs.isEmpty) throw  new IndexOutOfBoundsException
      else if (n == 0) xs.head
      else nth(n - 1, xs.tail)

    val list = new Cons(1, new Cons(2, new Cons(3, Nil)))

    println(nth(2, list))
    println(nth(4, list))
    println(nth(-1, list))

    val x: List[String] = Nil

    def f(xs: List[NonEmpty], x: Empty) = xs prepend x
  }
}
