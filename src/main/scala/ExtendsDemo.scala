/**
 * @ Author: Mr.Li 
 * @ Date: 2020-03-05 15:13 
 * @ Description: 类
 **/
object ExtendsDemo {
  def main(args: Array[String]): Unit = {
    /**
     * 类型检查和转换
     * 要测试某个对象是否属于某个给定的类的时候，可以使用isInstanceOf方法
     * 用asInstanceOf 将引用转换为之类的引用。classOF获取对象类名
     */
    println("Hello World".isInstanceOf[String])
    println("Hello World".asInstanceOf[String])
    println(classOf[String])
    // protected 在scala中比Java要更严格一些，即 只有继承关系才可以访问，同一个包下，也是不可以的。
    // 可以重写属性的。

  }
}
class Person {
  var name = ""

}
class Employee extends Person {
  var salary = 0.0
  def destination = "员工名称："+ name + " 薪水 "+ salary
}

/**
 * 之类实现抽象方法不需要override
 */


