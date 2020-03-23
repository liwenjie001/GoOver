import org.apache.spark.{SparkConf, SparkContext}

/**
 * @ Author: Mr.Li 
 * @ Date: 2020-03-19 18:26 
 * @ Description: spark 单词统计
 **/

object WordCount {
//  val logger = LoggerFactory.getLogger(WordCount.getClass)
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("WordCount").setMaster("local[*]")
    val sc = new SparkContext(sparkConf)
    sc.textFile("C:\\Users\\lllll\\IdeaProjects\\HelloWold\\SparkCore\\src\\main\\resources\\word.txt")
      .flatMap(_.split(" "))
      .map((_, 1))
      .reduceByKey(_ + _)
      .collect().foreach(print)
//    logger.info("complete")
    sc.stop()
  }
}
