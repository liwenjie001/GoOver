package operator

import org.apache.spark.{SparkConf, SparkContext}

/**
 * author: Mr.Li 
 * create: 2020-03-20 21:14 
 * description: coalesce 算子 缩减分区
 * 用于大规模数据进行数据清洗以后缩减（合并）分区使用
 **/
object CoalesceDemo {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("combineByKey Demo")
    val sc = new SparkContext(conf)

    val input = sc.makeRDD(1 to 16 ,4)
    println("缩减分区之前："+input.partitions.size)
    val coalesceRDD = input.coalesce(3)
    println("缩减分区之后："+coalesceRDD.partitions.size)
    coalesceRDD.saveAsTextFile("output")
    sc.stop()
  }
}
