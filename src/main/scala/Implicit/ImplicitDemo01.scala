package Implicit

/**
 * @ Author: Mr.Li 
 * @ Date: 2020-03-09 23:31 
 * @ Description: TODO
 **/
object ImplicitDemo01 {
  def main(args: Array[String]): Unit = {
    implicit def f1(d:Double):Int={
      d.toInt
    }
    val num:Int = 3.5
    println("num: " + num)
  }

}
