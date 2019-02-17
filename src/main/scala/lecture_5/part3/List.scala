package lecture_5.part3

trait List[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]

  def prepend[U >: T](elem: U): List[U] = new Cons(elem, this)
}
