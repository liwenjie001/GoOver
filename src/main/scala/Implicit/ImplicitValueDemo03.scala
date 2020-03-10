package Implicit

/**
 * @ Author: Mr.Li 
 * @ Date: 2020-03-10 00:13 
 * @ Description: TODO
 **/
object ImplicitValueDemo03 {
  def main(args: Array[String]): Unit = {
    implicit val str:String = "java"
    def hello(implicit name:String): Unit ={
      println("hello:"+name)
    }
    hello
  }
}
