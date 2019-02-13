package lecture_5.part1

abstract class IntSet {

  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}
