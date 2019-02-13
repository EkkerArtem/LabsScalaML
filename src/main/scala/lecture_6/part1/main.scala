package lecture_6.part1

object main {

  def removeAt[T](n: Int, xs: List[Int]): List[Int] =
    (xs take n) ::: (xs drop n+1)

  def main(args: Array[String]): Unit = {
    val list = List(1,2) ::: List(3,4)
    val list2 = List(1,2) :: List(3,4)
    println(list)
    println(list2)
    println(list.reverse)
    println(list2.reverse)
    val list3 = removeAt(0,removeAt(4,List(1,2,3,4,5)))
    println(list3)
  }
}
