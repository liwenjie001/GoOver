/*
/**
 * @ Author: Mr.Li 
 * @ Date: 2020-03-04 22:21 
 * @ Description: Scala的类的介绍
 **/
object ScalaClassDemo {
  def main(args: Array[String]): Unit = {
    val dog = new Dog
    dog.shout("汪汪汪")
    println(dog.currentLeg)
    println("============================")
    // getter setter 方法的使用
    println(dog.leg)
    val dog2 = new Dog
    dog2.leg_=(10)
    println(dog2.leg)




  }
}
/**
 *  简单类 和 无参方法
 *  如果方法定义的时候不带，那么在调用的时候就不应该带括号的
 *  getter setter 方法
 *  对于scala中的每一个属性，编译后，会有一个私有的字段相应的getter setter 的方法生成
 */
class Dog {
  private var _leg = 4
  // 类似于 getter 方法
  def leg = _leg
  // 类似于 setter 方法 leg_= 需要连着写 不能分开
  def leg_=(newLeg: Int) {
    _leg = newLeg
  }

  def shout(content:String): Unit ={
    println(content)
  }
  def currentLeg = leg
  println("======================================")
  val person = new Person
  person.setName("Liujunying")
  val name: String = person.getName
  println(name)
  println("======================================")
  private val classConstructor = new ClassConstructor("傲慢与偏激", 20.5)
  println(classConstructor.myPrintln)
  println("======================================")
  val classConstructor2 = new ClassConstructor2("aa", 20)
  val classConstructor2_2 = new ClassConstructor2()

}
/**
 *  @BeanProperty 这个注解 会自动生成 getter setter 方法
 */
import scala.beans.BeanProperty
import scala.collection.mutable.ArrayBuffer

class Person {
  @BeanProperty
  var name : String = _
}

/**
 * scala 中构造分为主构造器和辅助构造器
 * 主构造器的构造直接放在类名的后面
 */
class ClassConstructor (var name : String,private var pirce : Double){
  def myPrintln = println(name + " " + pirce)

}

/**
 * 主构造器 会执行类定义中的所有语句
 */
class ClassConstructor2(val name: String = "", val price: Double = 0) {
  println(name + "," + price)
}

/**
 * this 辅助构造器
 */
class Preson {
  private var name = ""
  private var age = 0
  def this(name:String){
    this()
    this.name = name
  }
  def this(name:String,age:Int){
    this(name)
    this.age = age
  }
  // 定义一个描述
  def description = name + " is " + age + " years old"
}

/**
 * 嵌套类
 * 即 在class 中，定义一个class ，以此类推。
 * Java 中的内部类从属外部类，scala 中的内部类从属于实例
 * 1） 创建一个嵌套类，模拟局域网的聊天
 */

class NetWork {
  class Member (val name : String){
     val members = new ArrayBuffer[Member]()
  }

  private val members = new ArrayBuffer[Member]()
  def join (name:String): Unit ={
    val m = new Member(name)
    members += m
    m
  }

}


*/
