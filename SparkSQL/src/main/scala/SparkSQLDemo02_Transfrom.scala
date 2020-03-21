import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
 * @ Author: Mr.Li
 * @ Date: 2020-03-21 22:09
 * @ Description: 这个是Spark SQL 的创建c
 * 在创建对象的时候可以通过看源码可以猜到怎么创建对象，这也是一种学习方式
 **/
object SparkSQLDemo02_Transfrom {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("Spark SQL").setMaster("local[*]")
    val spark =  SparkSession.builder().config(sparkConf).getOrCreate()

    // 添加隐式转换 ，这个隐式转换添加新的功能的
    // 以后写程序的时候要把隐式转换也直接加上，深的下次没有加的时候，不好弄
    import spark.implicits._
    // RDD
    val rdd = spark.sparkContext.makeRDD(List((1, "zhangsan", 22), (2, "lisi", 22), (3, "wangwu", 12)))
    // DF
    val df = rdd.toDF("id", "name", "age")
    // DS
    val ds = df.as[User]
    // DF
    val df1 = ds.toDF()
    // RDD
    val rdd1 = df1.rdd
    rdd1.foreach(row =>{
      println(row.getInt(0))
    })
    spark.stop()
  }
}
case class User(id:Int,name:String,age:Int)