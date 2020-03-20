package operator

import org.apache.spark.{SparkConf, SparkContext}

/**
 * author: Mr.Li 
 * create: 2020-03-20 21:14 
 * description: 根据分区数重新通过所有网络重新洗牌所有数据
 **/
object GlomDemo {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("combineByKey Demo")
    val sc = new SparkContext(conf)

    val input = sc.makeRDD(1 to 16 ,4)
    //
    val glomRDD = input.glom()

    glomRDD.collect().foreach(arr=>{
      println(arr.mkString(","))
    })
    sc.stop()
  }
}
