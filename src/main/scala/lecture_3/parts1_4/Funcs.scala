package lecture_3.parts1_4

object Funcs {

  /*def sum(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sum(f, a + 1, b)*/

  /*def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0
      else f(a) + sumF(a + 1, b)

    sumF
  }*/

  def sum(f: Int => Int)(a: Int, b: Int): Int = {
      if (a > b) 0 else f(a) + sum(f)(a + 1, b)
  }

  def sumInts: (Int, Int) => Int = sum(x => x)
  def sumCubes: (Int, Int) => Int = sum(x => x * x * x)
  def sumFactorials: (Int, Int) => Int = sum(fact)

  def id(x: Int): Int = x
  def cube(x: Int): Int = x * x * x
  def fact(x: Int): Int = if (x==0) 1 else fact(x-1)

  def tailRecursiveSum(f: Int => Int, a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int =
      if (a > b) acc
    else loop(a + 1,f(a) + acc)
    loop(a ,0)
  }

}
