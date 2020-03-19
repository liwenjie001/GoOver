import java.io.File

import scala.io.Source
import scala.reflect.api.TypeTags

/**
 * @ Author: Mr.Li 
 * @ Date: 2020-03-05 16:02 
 * @ Description: scala 中的特质
 **/
object TraitDemo {
  def main(args: Array[String]): Unit = {
    /**
     * 带有特质的对象，动态混入
     * 在构造对象时混入某个具体的特质，覆盖掉抽象方法，提供具体的实现
     */
    val logger = new ConsoleLogger1 with Logger
    /**
     * Manifest 上下文界定
     * Manifest 是scala 2.8 引入的一个特质，用于编译器在运行时也能获取泛型类型的信息。在JVM上，泛型参数类型T 在运行
     * 时是被擦掉的，编译器把T 当作Object 来对待 ，所以T的具体信息是无法获得的，为了使在运行时候获取T的信息，scala 需要额外的
     * Manifest 来存储T的信息，并做为参数用在方法的上下文当中。
     * 但是在 2.10 的版本中给替换了
     * Manifest 被我们的 TypeTag 替代了
     */
    def foo[T:Manifest](): Unit ={
      println("Manifest 保存泛型类型的信息")
    }
    /*def f001[T:TypeTags](): Unit = {

    }*/
    println("======================")
    // 隐私转换,这个关键字 implicit  是隐私转换
    implicit def a(d:Double) = d.toInt

    val il: Int = 3.5
    println(il)
    println("=========================")

    /**
     * 隐式值 ：
     * 将 name 变量标记为 implicit ， 所有编译器会在方法省略隐式方法的情况下搜索作用域内的隐式值作为缺少参数。
     */
    implicit val name = "Nick"



  }
}

/**
 * 特质中没有实现的方法就是抽象方法，类通过extends 继承特质，通过with可以继承多个特质
 * 所有的java 接口都是可以当作scala 的特质的
 * 特质的方法并不一定是抽象的
 */
trait Logger {
  def log(msg:String)
}

class ConsoleLogger extends Logger with Cloneable with Serializable {
  override def log(msg: String): Unit = {
    println(" 这是一个特质的Demo")



  }
}

trait ConsoleLogger1{
  def log(msg:String): Unit ={
    println(msg)
  }
}
class Account {
  protected var balance = 0.0
}
class SavingsAccount extends Account with ConsoleLogger1 {
  def withdraw(amount: Double): Unit = {
    if (amount > balance) log("余额不足")

  }
}

/**
 * 叠加在一起的特质
 * super 并不是指继承关系，而是指的加载顺序。
 * +
 */


/**
 * 利用隐式转换丰富类库功能
 * 如果需要一个类增加一个方法，可以通过隐式转换来实现 ，比如想为File 增加一个read方法，可以如下定义：
 * 有什么好处吗 ？  就是一个可以不修改原版本的代码而为原本的代码增加新功能
 */
class RichFile (val from: File) {
  def read = Source.fromFile(from.getPath).mkString

  implicit def file2RichFile(from:File) = new RichFile(from)
}




/**
 * 隐式类 ： scala 2.10 提供了 隐式类 ，可以使用implicit 声明类，但是需要注意以下几点：
 * 其所在的构造参数有且只有一个，
 * 隐式类必须被定义在"类" 或者 "伴生对象" 或者 "包对象"
 * 隐式类不能是case class （case class 在定义会自动生成伴生类对象与2矛盾）
 */
