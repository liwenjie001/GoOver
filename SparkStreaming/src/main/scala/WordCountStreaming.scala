import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * @ Author: Mr.Li 
 * @ Date: 2020-03-22 11:27 
 * @ Description: 使用parkStreaming 编写一个word count
 **/
object WordCountStreaming {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCountStreaming")
    val streamingContext: StreamingContext = new StreamingContext(conf, Seconds(5))
    val socketLineStream: ReceiverInputDStream[String] = streamingContext.socketTextStream("localhost", 7777)
    val wordDStream: DStream[String] = socketLineStream.flatMap(line => line.split(" "))
    val mapDStream: DStream[(String, Int)] = wordDStream.map((_, 1))
    mapDStream.reduceByKey(_+_).print() // 统计完打印一下
    streamingContext.start()
    streamingContext.awaitTermination()
  }
}
