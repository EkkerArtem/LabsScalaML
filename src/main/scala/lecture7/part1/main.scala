package lecture7.part1

object main {

  val f = (x: Int) => x * x

  val f2 = new Function[Int,Int] {
    def apply(x: Int) = x * x
  }


  def main(args: Array[String]): Unit = {
    println(f(7))
    println(f2.apply(7))
  }
}
