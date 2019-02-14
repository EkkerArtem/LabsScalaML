package lecture_6.part5

object main {

  def sum(xs: List[Int]): Int = (xs foldLeft 0) (_ + _)
  def product(xs: List[Int]): Int = (1 :: xs) reduceLeft (_ * _)

  def main(args: Array[String]): Unit = {
    val list = List(1,2,3,10)
    println(sum(list))
    println(product(list))
  }
}
