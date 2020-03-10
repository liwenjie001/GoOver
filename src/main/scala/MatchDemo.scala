/**
 * @ Author: Mr.Li 
 * @ Date: 2020-03-04 15:09 
 * @ Description: 模式匹配的样例
 **/
object MatchDemo {
  def main(args: Array[String]): Unit = {
    // for 表达式中的模式

    import scala.collection.JavaConverters._
    for ((k,v) <- System.getProperties.asScala){
      println(k + "->" + v)
    }
    for ((k, "") <- System.getProperties.asScala)
      println(k)

    for ((k, v) <- System.getProperties.asScala if v == "")
      println(k)
    // 尖叫提示 for 中匹配会匹配会自动huluo失败的匹配

  }
}
