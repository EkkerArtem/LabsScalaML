package lecture_5.part2

import lecture_3.parts5_7.Rational

object scratch {
 new Rational(1,2)

  def error(msg: String) = throw new Error(msg)

  def main(args: Array[String]): Unit = {
    println()
    error("test")
  }
}
