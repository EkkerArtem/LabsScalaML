package lecture_6.part3

object msortUsingOrdering {
  def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (ord.lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }

      val (fst, snd) = xs splitAt n
      merge(msort(fst), msort(snd))
    }
  }

  def main(args: Array[String]): Unit = {
    val num = List(2, -4, 5, 7, 1)
    val sortedNum = msort(num)

    val fruits = List("apple", "pineapple", "orange", "banana")
    val sortedFruits = msort(fruits)

    println(sortedNum)
    println(sortedFruits)
  }
}
