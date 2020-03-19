/**
 * @ Author: Mr.Li
 * @ Date: 2020-03-04 14:08
 * @ Description: Ssala 提取器
 **/
object Square {
  /**
   * 模式匹配，什么才算模式匹配呢？ 即，case 中unapply 方法返回some 集合则为模式匹配成功，返回none
   * 集合则为匹配失败，下面我们来看几个例子做详细探讨。
   * 调用unapply ，传入number
   * 接收返回值并判断返回值是None ，还是Some
   * 如果是Some 则可以解开，并将其中的值赋值给n （就是case Square(n) 中的n）
   * unapply apply 在调用的时候可以省下函数名称
   * 有了apply 伴生类对象 如果没有伴生类对象得话 需要New 对象的，但是在没有这些内容的时候，不需要new 对象就可以使用了
   * unapply 方法就刚好恰好相反，他是接受一个对象，从对象中提取出来的值。
   * unapply 方法主要用于模式匹配中
   * @param z
   * @return
   */
  def unapply(z: Double): Option[Double] = Some(math.sqrt(z))

  def main(args: Array[String]): Unit = {
    // 模式匹配
    val number: Double = 36.0
    val unit = number match {
      case Square(n) => println(s"square root of $number is $n")
      case _ => println("nothing matched")
    }
    println(unit)
  }



}
