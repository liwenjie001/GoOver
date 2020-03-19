/**
 * @ Author: Mr.Li
 * @ Date: 2020-03-09 16:33
 * @ Description: 正则表达式
 **/
object RegexDemo {
  def main(args: Array[String]): Unit = {
    val regex = new Regex("(S|s)cala")
    val regex1 =  "(S|s)cala".r
    val str = "Scala is scalable and cool"
    println((regex1 findAllIn str).mkString(","))
  }
}
