package lecture_6.part3

object main {

  def msort[T](xs: List[T])(lt: (T,T) => Boolean): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }

      val (fst, snd) = xs splitAt n
      merge(msort(fst)(lt), msort(snd)(lt))
    }
  }

  def main(args: Array[String]): Unit = {
    val num = List(2, -4, 5, 7, 1)
    val sortedNum = msort(num)((x, y) => x < y)

    val fruits = List("apple", "pineapple", "orange", "banana")
    val sortedFruits = msort(fruits)((x: String, y : String) => x.compareTo(y) < 0)

    println(sortedNum)
    println(sortedFruits)
  }
}
