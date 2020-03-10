/**
 * @ Author: Mr.Li 
 * @ Date: 2020-03-05 00:19 
 * @ Description: scala 中对象的概念
 **/
object ObjectDemo {
  def main(args: Array[String]): Unit = {
    val cat1 = new Cat
    val cat2 = new Cat
    cat1.changeName("黑猫")
    cat2.changeName("白猫")
    cat1.described
    cat2.described
  }
}

/**
 * 伴生类 对象
 * 类和它的伴生类对象可以互相访问私有特性，他们必须存在同一个源文件中。必须同名。
 */
class Cat {
  val hair = Cat.hair
  private var name = ""
  def changeName(name:String): Unit ={
    this.name = name
  }
  def described  = println("hair" + "name:" + name )


}
// 伴生类对象。
object Cat{
  private var hair = 0
  private def growHair ={
    hair += 1
    hair
  }
}

/**
 * apply 方法 也可以很轻松的写单例模式
 * @param sex
 * @param name
 */
class Man private (val sex : String,name : String){
  def describe = {
    println("Sex:" + sex + "name:" + name)
  }
}
object Man {
//  def apply(sex: String, name: String): Man = new Man(sex, name)
  // 设置单例模式
  var instance : Man = null

  def apply(sex: String, name: String):Man= {
    if (instance == null){
      instance = new Man(sex, name)
    }
    instance
  }
}
