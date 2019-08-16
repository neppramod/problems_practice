object PolymorphicFunctions {

  def findFirst1(ss: Array[String], key: String) : Int = {
    @annotation.tailrec
    def loop(n: Int): Int = {
      if (n >= ss.length) -1
      else if (ss(n) == key) n
      else loop(n+1)
    }

    loop(0)
  }

  def findFirst[A](as : Array[A], p : A => Boolean): Int = {
    @annotation.tailrec
    def loop(n: Int) : Int = {
      if (n >= as.length) -1
      else if (p(as(n))) n
      else loop(n+1)
    }

    loop(0)
  }

  def isSorted[A] (as: Array[A], ordered: (A,A) => Boolean) : Boolean = {
    @annotation.tailrec
    def loop(n: Int) : Boolean = {
      if (n+1 >= as.length) true;
      else if (!ordered(as(n), as(n+1))) false;
      else loop(n+1)
    }

    loop(0)
  }

  def main(args: Array[String]) : Unit = {
    println(findFirst(Array(50, 70, 20, 80), (x: Int) => x == 20))
    println(findFirst(Array("Bird", "Cat"), (x: String) => x.equals("Cat")))
    println(isSorted(Array(2,3,5,4), (x:Int, y: Int) => x <= y))
  }

  def partial1[A,B,C](a: A, f: (A,B) => C) : B => C =
    (b: B) => f(a,b)

  def curry[A,B,C](f: (A,B) => C) : A => (B => C) =
    a => b => f(a,b)

  def uncurry[A,B,C] (f: A => B => C) : (A,B) => C =
    (a,b) => f(a)(b)

  def compose[A,B,C] (f: B => C, g: A => B) : A => C =
    a => f(g(a))

}
