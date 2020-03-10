/**
 * @ Author: Mr.Li 
 * @ Date: 2020-03-04 15:19 
 * @ Description: 样例类首先是类 ，除此之外它是为模式匹配而优化的类，样例类用case 关键字进行声明
 **/
object CaseClassDemo {
  def main(args: Array[String]): Unit = {
    // 当我们有一个类型为Amount的对象时，我们可以用模式匹配来匹配他们的类型，并将属性值绑定到变量
    for (amt <- Array(Dollar(1000.0),Currency(1000.0,"EUR"),Nothing)){
      val str = amt match {
        case Dollar(v) => "$" + v
        case Currency(_, u) => u
        case Nothing => ""
      }
      println("amt: " + str)
    }
    println("=============================")
    // copy 方法和代名参数
    // copy 创建一个对象值一样的新对象，并可以通过带名参数来修改某些属性。
    val amt = Currency(20,"EUR")
    val price = amt.copy(value = 19)
    println(amt)
    println(price)
    println(amt.copy(unit = "CHF"))
    // case 语句的中置（缀表达式）
    /**
     * 什么是 中置表达式 ？
     * 1 + 2 这个就是中置表达式。如果unapply 方法产生一个元组，你可以在case 语句中使用中置表达式
     * 比如你可以匹配一个List 序列
     */
    List(1,7,2,9) match {
      case first::second::rest => println(first + second + rest.length)
      case _ => 0
    }
    // 匹配嵌套结构
    val sale = Bundle("愚人节大甩卖", 10,
      Article("九阳真经", 40),
      Bundle("从出门到一条狗到装备全发光的修炼之路系列", 20,
        Article("《如何快速捡起地上的装备》", 80),
        Article("《名字起得太长躲在树后容易被地方发现》", 30)
      )
    )
    println("=============================")
    // 将 descr 绑定到第一个Article 的描述
    val str = sale match {
      case Bundle(_, _, Article(descr, _), _*) => descr
    }
    println(str)
    // 通过@ 表示法将嵌套的值绑定到变量。_* 绑定到Item 到 rest
    val tuple = sale match {
      case Bundle(_, _, art@Article(_, _), rest@_*) => (art, rest)
    }
    println(tuple)
    val tuple1 = sale match {
      case Bundle(_, _, art@Article(_, _), rest) => (art, rest)
    }
    println(tuple1)
    // 偏函数 ，它只会作用于指定类型的参数或者指定范围值的 参数实施计算。
    val f:PartialFunction[Char,Int] = {
      case '+' => 1
      case '-' => -1

    }
    println(f('-'))
    println(f.isDefinedAt('0'))
    println(f.isDefinedAt('+'))
    println(f('+'))
//    println(f(0))
    // 在深入一点 我们定义一个 将  List集合里面数据 +1 的偏函数
    val f1 = new PartialFunction[Any,Int] {
      override def apply(v1: Any): Int = v1.asInstanceOf[Int]  + 1

      override def isDefinedAt(x: Any): Boolean =  if (x.isInstanceOf[Int]) true else false
    }
    val rf1 = List(1,3,5,6,"seven") collect f1
    println(rf1)
  }

}

abstract class Amount
  case class Dollar (value : Double) extends Amount
  case class Currency (value : Double,unit: String) extends Amount
  case object Nothing extends  Amount

// 匹配嵌套结构
abstract class Item
case class Article (description:String,price:Double) extends Item
case class Bundle (description:String,discount:Double,item: Item*) extends Item
