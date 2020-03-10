package Implicit

/**
 * @ Author: Mr.Li 
 * @ Date: 2020-03-10 00:01 
 * @ Description: 用隐式转换丰富函数的类库
 **/
object ImplicitDemo02 {
  def main(args: Array[String]): Unit = {

    implicit def f1(mysql: Mysql):DB = {
      new DB
    }
    val mysql = new Mysql
    mysql.insert()
    mysql.delete()
  }
}
class Mysql{
  def insert(): Unit ={
    println("这是 insert")
  }
}
class DB {
  def delete(): Unit ={
    println("这是 delete")
  }
}
