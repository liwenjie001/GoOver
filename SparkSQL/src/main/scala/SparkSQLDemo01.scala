import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
 * @ Author: Mr.Li 
 * @ Date: 2020-03-21 22:09 
 * @ Description: 这个是Spark SQL 的创建c
 * 在创建对象的时候可以通过看源码可以猜到怎么创建对象，这也是一种学习方式
 **/
object SparkSQLDemo01 {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("Spark SQL").setMaster("local[*]")
    val spark =  SparkSession.builder().config(sparkConf).getOrCreate()
    val dataFrame = spark.read.json("in/people.json")
    dataFrame.show()
    println("=========================")
    // 创建一个sql 表
    dataFrame.createOrReplaceTempView("people")
    val frame = spark.sql("select * from people")
    frame.show()
    spark.stop()
  }
}
