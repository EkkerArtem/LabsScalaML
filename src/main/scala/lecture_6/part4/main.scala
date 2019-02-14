package lecture_6.part4

object main {

  def main(args: Array[String]): Unit = {
    val xs = List(1,2,3,4,5,6,7,8)
    val fs = xs.filter(x => x > 4)
    val ps = xs.partition(x => x > 4)
    val ts = xs.takeWhile(x => x > 0)
    val ds = xs.dropWhile(x => x == 4)
    val ss = xs.span(x => x > 4)
    println("Start list => " +  xs)
    println("Filter list => " +  fs)
    println("Partition list => " +  ps)
    println("TakeWhile list => " +  ts)
    println("DropWhile list => " +  ds)
    println("Span list => " +  ss)
println("------------------------------------------------")
    val num = List(2, -4, 5, 7, 1)
    println(num filter(x => x > 0))
    println(num filterNot(x => x > 0))
    println(num partition(x => x > 0))

    println(num takeWhile(x => x > 0))
    println(num dropWhile(x => x > 0))
    println(num span (x => x > 0))



  }
}
