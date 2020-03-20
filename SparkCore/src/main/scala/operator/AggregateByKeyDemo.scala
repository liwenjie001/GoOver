package operator

import org.apache.spark.{SparkConf, SparkContext}

/**
 * author: Mr.Li 
 * create: 2020-03-20 21:14 
 * description: AggregateByKey 参考 hadoop combine 进行理解更好一些，像reduceByKey groupByKey 都是这个算子的一种简写
 *  记住 spark 中所有ByKey 的算子必须要是键值对的RDD 才可以调用的
 *  1. 可以自定义分区内和分区间不同算子的转换。
 **/
object AggregateByKeyDemo {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("combineByKey Demo")
    val sc = new SparkContext(conf)

    val input = sc.makeRDD(List(("a",3),("a",2),("c",4),("b",3),("c",6),("c",8)),2)

    val aggregateByKeyRDD = input.aggregateByKey(0)(math.max(_,_),_+_)

    aggregateByKeyRDD.collect().foreach(println)
    sc.stop()
  }
}
