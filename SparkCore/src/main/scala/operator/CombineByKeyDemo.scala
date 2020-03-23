package operator

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @ Author: Mr.Li 
 * @ Date: 2020-03-20 18:46 
 * @ Description: combineByKey 样例代码
 * 和 foldByKey 、aggregateByKey 底层用的都是一样的，只不过更底层一些
 **/
object CombineByKeyDemo {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("combineByKey Demo")
    val sc = new SparkContext(conf)
    // 创建数据源
    val scores = Array(("Fred", 88), ("Fred", 95), ("Fred", 91), ("Wilma", 93), ("Wilma", 95), ("Wilma", 98))

    val input = sc.parallelize(scores)
    input.combineByKey((v)=>(v,1),(acc:(Int,Int),v)=>(acc._1+v,acc._2+1),(acc1:(Int,Int),acc2:(Int,Int))=>(acc1._1+acc2._1,acc1._2+acc2._2))
        .map(data=>{
          (data._1,data._2._1/data._2._2) // 求平均分
        }).collect().foreach(println)


    sc.stop()
  }
}
