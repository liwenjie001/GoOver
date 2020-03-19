/**
 * @ Author: Mr.Li
 * @ Date: 2020-03-04 16:53
 * @ Description: 高阶函数
 **/
object FunDemo {
  def main(args: Array[String]): Unit = {

    /**
     *作为参数的函数
     * 函数作为一个变量传入到另一个函数中，那么该作为参数的函数类型是 function1  参数类型 => 返回类型
     */
    val ints = Array(1, 2, 3, 4).map(plus(_))
    // 返回是一个字符串对象的时候可以使用mkString 然后给其切割成 字符串暂时出来
    println(ints.mkString(","))
    // 匿名函数 没有函数名字的就是匿名函数
    val triple = (x:Double) => x * 3
    println(triple(2))
    println("===============高阶函数================")
    // 高阶函数 能够接收函数作为参数的函数就是高阶函数
    // 高阶函数
    //(f: Double => Double） 代表着输入的就是一个函数 Double 代表着函数的里面的输入类型 => Double 代表着函数返回值类型
    def highOrderFunction1(f: Double => Double) = f(10)
    def minus7(x: Double) = x - 7
    val result2 = highOrderFunction1(minus7)
    println(result2)
    // 高阶函数同样可以返回函数类型 参数是有类型推断的
    // (y:Int)=> x - y  是一个函数体
    def minusxy(x:Int):Int => Int = (y:Int)=> x - y
    val result3 = minusxy(5)(3)
    println(result3)

    /**
     * 闭包 闭包就是一个函数把外部的那些不属于自己的对象也包含（闭包）到里面去
     *  def minusxy(x:Int):Int => Int = (y:Int)=> x - y
     *  这就是一个闭包：
     *  1） 匿名函数(y：Int) => x - y 嵌套在minusxy 函数中
     *  2） 匿名函数（y:Int） => x - y 使用了匿名函数之外的变量x
     *  3 ) 函数minusxy 返回了引用了局部变量的匿名函数
     */
    val f1 = minusxy(10)
    val f2 = minusxy(10)
    println(f1(3) + f2(3)) // 此处的f1 和 f2 就是闭包的意思
    /**
     * 函数柯里化 其实上面这个就是柯里化的现象了，柯里化是一种现在，不是某种特性。
     * 比较两个字符串在忽略大小写的情况下是否相等，注意，这里是两个任务
     * 1. 全部转大写 或者 小写
     * 2. 比较是否相等
     * 针对这两个操作我们用一个函数去处理的思想，其实无意间也就是变成了 两个函数处理的思想
     *
     * 不要设立柯里化存在的意义这样的命题，柯里化，是面向函数编程思想的必然产生的结果。
     */
    val a = Array("Hello", "World")
    val b = Array("hello", "world")
    println(a.corresponds(b)(_.equalsIgnoreCase(_)))

    /**
     * 控制抽象
     * 控制抽象是一类函数
     * 1. 参数是函数
     * 2. 函数参数没有输入值也没有返回值
     */
    def runInThread (f1:() => Unit): Unit = {
      new Thread{
        override def run(): Unit = {
          f1()

        }
      }.start()
    }
    /*runInThread(()=> println("干活了！"))
    Thread.sleep(1000)*/
    println("====================")

    /**
     *  是不是感觉很爽，是不是有点线程池的味道了，同一个线程，可以动态的向里面加入不同的任务去执行
     *  上面的代码可以在省下一部分的
     */
    def runInThread1 (f1: => Unit) = {
      new Thread{
        override def run(): Unit = {
          f1
        }
      }.start()
    }

    runInThread1{
      println("干活了 ")
      Thread.sleep(1000)
      println("干完了 ")
    }











  }

  def plus(x:Int): Int = 3 + x

}
