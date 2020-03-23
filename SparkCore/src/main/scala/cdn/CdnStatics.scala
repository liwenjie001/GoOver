package cdn

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import scala.util.matching.Regex

/**
 * @ Author: Mr.Li 
 * @ Date: 2020-03-23 15:39 
 * @ Description: 这个是使用spark RDD  的练习
 **/
object CdnStatics {
  // 要使用正则表达式 匹配出来IP 或者按照顺序去匹配也是可以的
  //匹配IP地址
  val IPPattern = "((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))".r
  //匹配视频文件名
  val videoPattern = "([0-9]+).mp4".r

  //[15/Feb/2017:11:17:13 +0800]  匹配 2017:11 按每小时播放量统计
  val timePattern = ".*(2017):([0-9]{2}):[0-9]{2}:[0-9]{2}.*".r

  //匹配 http 响应码和请求数据大小
  val httpSizePattern = ".*\\s(200|206|304)\\s([0-9]+)\\s.*".r

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("DedicatedIP").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val input: RDD[String] = sc.textFile("C:\\Users\\lllll\\IdeaProjects\\HelloWold\\SparkCore\\src\\main\\resources\\cdn.txt")
    //统计独立IP访问量前10位
    //    ipStatics(input)
    //统计每个视频独立IP数
    //    videoIpStatics(input)
    //统计一天中每个小时间的流量
    flowOfHour(input)
  }

  // 统计独立的IP
  def ipStatics(data: RDD[String]): Unit = {
    val ipNums: RDD[(String, Int)] = data.map(data => (IPPattern.findFirstIn(data).get, 1))
      .reduceByKey((x, y) => x + y)
      .sortBy(_._2, false)
    ipNums.take(10).foreach(println)
  }

  def videoIpStatics(data: RDD[String]): Unit = {
    // 这里面要过滤掉空的值
    data.filter(x => x.matches(".*([0-9]+)\\.mp4.*")).map(data => (videoPattern.findFirstIn(data).mkString, IPPattern.findFirstIn(data).mkString))
      .groupBy(_._1) // 根据视频文件名称分组
      .map(data => {
        (data._1, data._2.toList.distinct.size)
      }) // 对里面的IP进行去重
      .sortBy(_._2, false)
      .take(10)
      .foreach(println)
  }

  def flowOfHour(data: RDD[String]): Unit = {
    def isMatch(pattern: Regex, str: String):Boolean = {
      str match {
        case pattern(_*) => true
        case _ => false
      }
    }

    /**
     * 获取日志中小时和http 请求体大小
     *
     * @param line
     * @return
     */
    def getTimeAndSize(line: String) = {
      var res = ("", 0L)
      try {
        // 正则匹配的
        val httpSizePattern(code, size) = line
        val timePattern(year, hour) = line
        res = (hour, size.toLong)
      } catch {
        case ex: Exception => ex.printStackTrace()
      }
      res
    }
    //3.统计一天中每个小时间的流量
    data.filter(x=>isMatch(httpSizePattern,x))
      .filter(x=>isMatch(timePattern,x))
      .map(x=>getTimeAndSize(x))
      .groupByKey()
      .map(x=>(x._1,x._2.sum))
      .sortByKey()
      .foreach(x=>println(x._1+"时 CDN流量="+x._2/(1024*1024*1024)+"G"))
  }
}
