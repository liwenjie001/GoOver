

/**
 * @ Author: Mr.Li 
 * @ Date: 2020-03-09 19:27 
 * @ Description: 在scala 中获取信息是比较便捷的
 **/
class A {}
object TypeSyllabus {
  /**
   * 注意typeOf[A] 和 classOf[A] 方法接收的都是类型符号（symbol）并不是对象实例
   * @param args
   */
  def main(args: Array[String]): Unit = {
    import scala.reflect.runtime.universe._
    println(typeOf[A])
    println(classOf[A])
  }


}
