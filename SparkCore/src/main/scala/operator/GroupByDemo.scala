package operator

import org.apache.spark.{SparkConf, SparkContext}

/**
 * author: Mr.Li 
 * create: 2020-03-20 21:14 
 * description: 根据groupBy 传入的函数的返回值进行分组(分区)
 **/
object GroupByDemo {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("combineByKey Demo")
    val sc = new SparkContext(conf)

    val input = sc.makeRDD(1 to 16 )

    val groupByRDD = input.groupBy(arr=>arr%2)

    groupByRDD.collect().foreach(println)
    sc.stop()
  }
}
