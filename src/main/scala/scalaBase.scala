import scala.collection.mutable
import scala.collection.mutable._
import scala.util.control.Breaks

/**
 * @ Author: Mr.Li 
 * @ Date: 2020-03-02 18:51 
 * @ Description:Scala 基础语言
 **/
object scalaBase {
  def main(args: Array[String]): Unit = {
    val a:Double = 11.33
    val string = a.toString
    print(string)
    println()
    // 以下验证的是option 一些包装类 Some 代表一个值 None 代表什么也没有
    val map = Map("LiLei" -> 19,"haha"->20)
    print(map.get("LiLei"))
    println()
    print(map.get("hahaha"))
    println("=============================")
    // if else 是有返回值的。 如果返回值类型不一样的话，返回Any 。
    val a3 = 30
    val a4 = if (a3 > 20){
      "a3 大于 20"
    } else {
      "a3 小于 20"
    }
    println(a4)
    val a5 = if(a3>40){
      "a3 大于 40"
    }
    println(a5)
    var n = 1
    //noinspection TypeAnnotation
    val while1 = while (n<=10){
      n += 1
    }
    println(while1)
    // while 循环被中断了
    val loop = new Breaks
    loop.breakable{
      while (n<=20){
        n+=1
        if(n==18){
          loop.break()
        }
      }
    }
    println(n)
    /*for(i<- 1 to 3 ; j <- 1 to 3){
      println(i*j + " ")
    }
    println()*/
    for (i<- 1 until 3 ; j <- 1 until 3 ){
      print(i*j + " ")
    }
    println()

    for (i <- 1 to 3 if i != 2) {
      print(i + " ")
    }
    println()
    for (i <- 1 to 3; j = 4 - i) {
      print(j + " ")
    }
    println()
    val for1 = for (i<- 1 to 10) yield i
    println(for1)
    // 定长数组
    val arr = new Array[Int](10)
//  val arr = new Array(1,2)
    arr(0) = 1
    // 变长数组
    val arr2 = new ArrayBuffer[Int]()
    arr2.append(1)
    // 重新赋值
    arr2(0) = 5
    // 定长数组和变长数组之间的转换。
    arr.toBuffer // 把定长数组转换成为 变长的数组
    arr2.toArray // 把变长数组转换成为 定长的数组
    // 多维数组
    val arr3 = Array.ofDim[Double](3,4)
    arr3(2)(3) = 11.11
    //Scala 与 Java 的数组转 互转。
    val arr4 = ArrayBuffer("1","2","3","4")
    println("===================================")
    // Scala to Java
    import scala.collection.JavaConversions.bufferAsJavaList
    val javaArr = new ProcessBuilder(arr4)
    println(javaArr.command())
    // Java 数组转成Scala 数组
    import scala.collection.JavaConversions.asScalaBuffer
    import scala.collection.mutable.Buffer
    val scalaArr:mutable.Buffer[String] = javaArr.command()

    println(scalaArr)
    println("==================")
    // 数组的遍历
    for (i <- scalaArr){
      println(i)
    }
    // 元组可以理解成为一个容器,可以存放各种相同或者不同的类型的数据.
    val tuple1 = (1,2,3,4,5,"哈哈哈")
    println(tuple1)

    // 访问tuple 元组 这个
    val value = tuple1._6
    println(value)
    println("==============================")
    // 元组的遍历 方法一 .
    for (i<- tuple1.productIterator){
      print(i+ " ")
    }
    println()
    println("==============================")

    // 方式二
    tuple1.productIterator.foreach(i=>print(i + " "))
    println()
    println("==============================")
    tuple1.productIterator.foreach(print)
    println()
    println("==============================")
    // 如果list 列表为空 则使用 Nil 来表示
    val list1 = List(1,2)
    println(list1)
    // 访问 List 元素
    println("==============================")
    val i = list1(1)
    println(i)
    // List 元素的追加
    val list2 = list1 :+ 3
    println(list2)
    val list3 = 100 +: list2
    println(list3)
    val list4 = 1::2::3::4::Nil
    println(list4)
    println("==============================")
    // 队列 Queue
    // 队列数组是符合先进先出原则的
    val q1 = new mutable.Queue[Int]()
    println(q1)
    // 队列元素的追加
    q1 += 1
    println(q1)
    // 向队列中追加 List
    q1 ++= List(2,3,4)
    println(q1)
    // 按照j进入队列的顺序删除元素 一次删除一个元素
    q1.dequeue()
    println(q1)
    // 塞入数据
    q1.enqueue(8,9,10)
    println(q1)
    // 返回队列中的第一个元素.
    println(q1.head)
    // 返回最后一个元素
    println(q1.last)
    // 返回除第一个元素以外的元素
    println(q1.tail )
    // 映射 Map
    // 构造不可变的映射
    val map1= mutable.Map("LiWenJie"-> 22,"LiuJunYing"-> 24,"WenTing"-> 25)
    // 构造可变映射
    val map2 = Map("LiWenJie"-> 22,"LiuJunYing"-> 24,"WenTing"-> 25)
    // 空的映射
    val map3 = new mutable.HashMap[String,Int]
    // 对偶元组
    val map4 = mutable.Map(("LiWenJie",22),("LiuJunYing",23))
    // 取值
    val maybeInt = map1.get("LiWenJie")
    println(maybeInt)
    // 更新值
    map2("LiWenJie") = 99
    println(map2.get("LiWenJie"))
    // 增加新的元素
    map2 += ("Bob" -> 99)
    println(map2)
    // 减少新的元素
    map2 -= ("LiWenJie", "WenTing")
    println(map2)
    println("========")
    for ((k, v) <- map1) println(k + " is mapped to " + v)
    for (v <- map1.keys) println(v)
    for (v <- map1.values) println(v)
    for(v <- map1) println(v)
    println("=====================")
    // Set 集合是无序的并且不能有重复值.
    val set1 = mutable.Set(1,2,3)
    println(set1)
    // Set 可变集合的创建
    val set2 = Set(1,2,3)
    // 可变集合元素的添加
    set2.add(4)
    println(set2)
    println(set2 += 5)
    // 删除可变集合中的元素
    set2 -= 1
    println(set2)
    set2.remove(3)
    println(set2)
    println("======================")
    // 集合元素与函数的映射
    // map 将集合中的每一个元素映射到 某一个函数
    val name = List("Alice", "Bob", "Nick")
    println(name.map(_.toLowerCase()) )
    // flagmap flag 即 压扁 压平 扁平化 效果就是将集合中的每个元素的子元素映射到某一个函数中并返回新的集合
    val names = List("Alice", "Bob", "Nick")
    println(names.flatMap(_.toUpperCase()) )
    println("=======================")
    // 化简 折叠 扫描
    // 1) 折叠 ,化简 : 将二元函数引用于集合中的函数.
    val ll = List(1,2,3,4,5,6)
    val i1 = ll.reduceLeft(_ + _ )
    val i2 = ll.reduceRight(_ + _)
    println(i2)
    println(i1)
    val i3 = ll.reduceLeft(_ - _)
    println(i3 )
    val i4 = ll.reduceRight(_ - _)
    println(i4)
    println("=========================")
    // 2) 折叠化简 : fold fold 函数将上一步返回的值作为函数的第一个参数继续传参数与运算
    // 直到list 中的所有元素被遍历. 可以把reduceLeft 看做简化版本的foldLeft . 相关函数:fold foldLeft folfRight , 可以参考reduce 的相关方法理解
    val lll = List(1, 9, 2, 8)
    val i5 = lll.fold(0)((sum, any) => sum + any)
    println(i5)
    // foldRight  Right 也就代表着右边最后一个数 是 1
    val i6 = lll.foldRight(1)(_ - _)
    println(i6)
    // foldLeft  Left 是左边第一个数 是1
    val i7 = lll.foldLeft(1)(_ - _)
    println(i7)
    // 尖叫提示 foldLeft foldRight 有一种缩写的简单方法分别为: /: 和 :\

    // 折叠 化简 扫描 .
    // 这个理解需要结合上面的知识点,扫描,即被某个集合的所有的元素做fold操作,但会把生产的所有中间结果放置于一个集合中保存
    val i8 = (1 to 10).scanLeft(0)(_ + _)
    println(i8)
    val ints = (1 to 10).scanLeft(1)(_ - _)
    println(ints)
    println("============================")
    val list11 = List("15837312345", "13737312345", "13811332299")
    val list22 = List(17, 87)
    val tuples = list11.zip(list22)
    tuples.foreach(print(_))
    println()
    println("============================")
    // 迭代器
    // 你可以通过iterator 方法 从集合中获取一个迭代器,通过while 循环和for 循环对集合进行遍历
    val iterator = List("1", "2", "3", "4").iterator
    /*for (i<- iterator){
      print(i + " ")
    }*/
    while (iterator.hasNext){
      println(iterator.next())
    }
    println("====================")
    val ints1 = numsFrom(10)
    // tail 每使用一次,都会动态的按照规则向集合添加一个新元素
    println(ints1.tail)
    println(ints1)
    // 使用map 映射 stream 的元素并进行一些计算
    println(numsFrom(5).map(x=> x * x ))

    // Stream 的懒执行行为 ,你可以对其他集合应用 view 方法来得到类似的效果,该方法产出一个其方法总是被懒执行的集合,但是view 不会缓存数据
    // 每次都是重新计算.
    println("=============vive=================")
    viveDemo()
    println("=============scala多核cpu使用=================")
    (0 to 10 ).foreach(print(_))
    println()
    // 顺序乱了 所以这是调用了多核心处理。
    (0 to 10 ).par.foreach(print(_))
    println()
    // 查看并行集合中元素访问的线程。

    val result1 = (0 to 10000).map { case _ => Thread.currentThread().getName }.distinct
    val result2 = (0 to 10000).par.map { case _ => Thread.currentThread().getName }.distinct
    println(result1)
    println(result2)
    println("==============================")
    // 模式匹配
    var result = 0 // 必须是可变的数据类型 要不后边怎么给其赋值啊
    val op:Char = '-'
    op match {
      case '+' => result = 1
      case '-' => result = -1
      case _ => result = 0
    }
    println(result)
    println("===============守卫===============")
    // 守卫
    // 像 IF 表达式 一样 match 也提供了守卫功能 守卫可以是任何Boolean条件
    for (ch <- "+-3!"){
      var sign = 0
      var digit = 0
      ch match {
        case '+' => sign = 1
        case '-' => sign = -1
        case _ if ch.toString.equals("3") => digit = 3 // 这块代表的就是守卫
        case _ => sign = 0
      }
      println(ch + " " + sign + " " + digit)
    }
    println("==============================")
    // 模式中的变量
    // 如果case 关键字后跟个变量名 ，那么match 前表达式的值会赋值给case 那个变量
    val str = "+-3!"
    // indices 代表的是 一个范围
    for (i<- str.indices){ // 这里面i这个是数组的下标
      var sign = 0
      var digit = 0
      str(i) match {
        case '+' => sign = 1
        case '-' => sign = -1
        case ch if Character.isDigit(ch) => digit = Character.digit(ch,10)
        case _ =>
      }
      println(str(i) + " " + sign + " " + digit)

      // Map类型的泛型在匹配的时候，会自动删除泛型 ，只会匹配到Map的类型，而不会精确到Map里边的类型。
      /**
       * 匹配数组、列表、元组
       * Array(0) 匹配只有一个元素且为零的数组
       * Array(x,y) 匹配数组只有两个元素，并将两个元素赋值为 x，y
       * Array(x,_*) 匹配数组以0开始
       */
      println("==========================================")
      // 匹配数组
      for (arrs <- Array(Array(0),Array(1,0),Array(0,1,0),Array(1,1,0),Array(1,1,0,1))){
        val results = arrs match {
          case Array(0) => "0"
          case Array(x, y) => x + " " + y
          case Array(x, y, z) => x + " " + y + " " + z
          case Array(0, _*) => "0...."
          case _ => "something else "
        }
        println(results)
      }
      println("============================")
      // 匹配列表 与匹配数组相似，同样可以应用于列表
      for (lst <- Array(List(0),List(1,0),List(0,0,0),List(1,0,0))){
        val str1 = lst match {
          case 0 :: Nil => "0"
          case x :: y :: Nil => x + " " + y
          case 0 :: tail => "0...."
          case _ => "something else"
        }
       println(str1)
      }
      println("==========================================")
      // 匹配元组 同样应用于元组
      for (pair <- Array((0,1),(1,0),(1,1))){
        val str1 = pair match {
          case (0, _) => "0...."
          case (y, 0) => y + " 0"
          case _ => "neiher is 0"
        }
        println(str1)
      }
      // 变量声明中的模式
      // match 中的每一个case 都可以单独提取出来







    }








  }

  /**
   * 使用#:: 得到一个Stream
   * @param n
   * @return
   */
  def numsFrom(n:BigInt) : Stream[BigInt] = n #:: numsFrom(n + 1)

  /**
   * 找到一个 0 - 100000 以内所有数据倒序排序以后还是自己本身的数据
   */
  def viveDemo() = {
    val viewSquares = (1 to 100000).view.map(x => {
      // 要把数据进行格式转换啊。  把数据从String 转换成 ：Long 类型的数据啊
      x.toLong
    }).filter(x => {
      x.toString == x.toString.reverse
    })

    println(viewSquares(3))
    for (i<- viewSquares){
      print(i + " ")
    }
    println()
  }

}
