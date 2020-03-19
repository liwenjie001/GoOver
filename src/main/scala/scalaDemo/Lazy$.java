/**
 * @ Author: Mr.Li
 * @ Date: 2020-03-03 00:29
 * @ Description: TODO
 **/
object Lazy {
  def main(args: Array[String]): Unit = {
    lazy val msg = init()
    println("lazy 方法没有执行")
    println(msg)
  }
  def init(): String ={
    println("init 方法执行")
    "嘿嘿嘿，我来了"
  }
  }
