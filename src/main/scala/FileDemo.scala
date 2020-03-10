
import java.io.{File, PrintWriter}

import org.junit.Test

import scala.io.{Source, StdIn}



/**
 * @ Author: Mr.Li
 * @ Date: 2020-03-06 15:01
 * @ Description: 文件和正则表达式
 **/

class FileDemo {
  /**
   * 文件转数组
   */
  @Test
  def fileToArray (): Unit ={
    val source = Source.fromFile("D:\\text\\pd.txt")
    val array = source.getLines().toArray // 把文件内容转换成 数组
    for (i <- array){
      println(i)
    }
    source.close()
  }

  /**
   * 文件内容转成字符串
   */
  @Test
  def fileToString(): Unit = {
    val source = Source.fromFile("D:\\text\\pd.txt")
    val string = source.mkString
    println("测试")
    println(string)
    source.close()
  }

  /**
   * 标记记得close 关闭文件流
   *
   */
  @Test
  def readFile(): Unit = {

    val source = Source.fromFile("D:\\text\\pd.txt")
    val lines = source.getLines()// 获取每一行文件
    for (i <- lines) {
      println(i)
    }
    // 关闭文件流
    source.close()
  }

  /**
   * 读取字符
   * 由于Source.fromFile直接返回就是Iterator[Char],所以可以直接对其进行迭代，按照字符访问里面的每一个元素
   */
  @Test
  def readChar (): Unit ={
    val sourceChar = Source.fromFile("D:\\text\\pd.txt", "UTF-8")
    for (ch <- sourceChar){
      println(ch)
    }
    sourceChar.close()
  }

  /**
   * 读取词话单元和数字
   * 如果想 将以某个字符或某个正则表达式分开的字符成组读取，可以这么做
   */
  @Test
  def readWorldAndNum (): Unit ={
    val source = Source.fromFile("D:\\text\\pd.txt")
    val strings = source.mkString.split(",")
    println(strings.mkString(" "))
    source.close()
  }

  /**
   * 读取网络资源
   */
  @Test
  def readFromUrl (): Unit ={
    val webFile = Source.fromURL("http://www.baidu.com")
    webFile.foreach(print(_))
    webFile.close()
  }

  /**
   * 写入数据到文件
   */
  @Test
  def writeToFile(): Unit ={
    val writer = new PrintWriter(new File("嘿嘿飞.txt"))
    for (i<- 1 to 100 ){
      writer.println(i)
    }
    writer.close()

  }

  /**
   * 控制台操作
   * 控制台交互 老 API
   */
  @Test
  def readConsoleOld(): Unit ={
    print("请输入内容： ")
    val str = Console.readLine()
    println("刚才输入的内容是 ： " + str)
  }

  /**
   * 控制台交互
   * 新API
   */
  @Test
  def readConsoleNew(): Unit ={
    println("请输入内容： ")
    val str = StdIn.readLine()
    println("控制台输入的内容为 ： " + str)
  }


}
