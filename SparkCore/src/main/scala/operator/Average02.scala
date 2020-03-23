package operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @ Author: Mr.Li
 * @ Date: 2020-03-23 13:56
 * @ Description: 这个是第二种求平均值的方法，使用mapValue 来实现
 **/
object Average02 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("Average02")
    val sc = new SparkContext(conf)
    // 创建数据源
    val source = Array(("Fred", 88), ("Fred", 95), ("Fred", 91), ("Wilma", 93), ("Wilma", 95), ("Wilma", 98))
    val input: RDD[(String, Int)] = sc.makeRDD(source)
    input.mapValues(v=>(v,1)).reduceByKey((x,y)=>(x._1+y._1,x._2+y._2)).map({
      case(key,value) => (key,value._1/value._2)
    }).foreach(println)

    sc.stop()
  }
}
