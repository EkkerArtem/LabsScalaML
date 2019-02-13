package lecture_5.part1

object Empty extends IntSet {
  override def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)

  override def contains(x: Int): Boolean = false

  override def toString: String = "."

  override def union(other: IntSet): IntSet = other
}
