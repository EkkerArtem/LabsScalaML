package lecture_3.parts1_4

object Exercise {
  def product(f: Int => Int)(a: Int, b: Int): Int = {
    if (a>b) 1 else f(a) * product(f)(a+1,b)
  }

  def fact(n: Int): Int = product(x => x)(1, n)
}
