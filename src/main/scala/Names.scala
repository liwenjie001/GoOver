

/**
 * @ Author: Mr.Li 
 * @ Date: 2020-03-04 14:38 
 * @ Description: TODO
 **/
object Names {
  def unapplySeq (str: String) : Option[Seq[String]] = {
    if (str.contains(","))
      Some(str.split(","))
    else
      None
  }

  /**
   * 模式匹配使用
   * @param args
   */
  def main(args: Array[String]): Unit = {
    val nameString = "Alice,Bob,Thomas"
    nameString match {
      case Names(first,second,third) => {
        println("the string contains three people's names")
        println(s"$first $second $third")
      }
      case _ => println("nothing matched")
    }
  }

}
