package operator

import org.apache.spark.{SparkConf, SparkContext}

/**
 * author: Mr.Li 
 * create: 2020-03-20 21:14 
 * description: foldByKey是aggregateByKey 的一个简写，这个是分区内和分区间的函数是一样的
 *
 **/
object FoldByKeyDemo {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("combineByKey Demo")
    val sc = new SparkContext(conf)

    val input = sc.makeRDD(List(("a",3),("a",2),("c",4),("b",3),("c",6),("c",8)),2)

    val foldByKeyRDD = input.foldByKey(0)(_+_)

    foldByKeyRDD.collect().foreach(println)
    sc.stop()
  }
}
