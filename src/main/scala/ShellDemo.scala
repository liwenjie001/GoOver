

/**
 * @ Author: Mr.Li 
 * @ Date: 2020-03-09 15:41 
 * @ Description: 控制进程
 *
 **/


object ShellDemo {
  /**
   * 我们可以使用scala来操作shell ,scala提供了scala.sys.process 包提供了用于shell程序交互工具。
   * !和！！的区别在于： process包中有一个将字符串隐式的转换成ProcessBuild 对象的功能，感叹号就是执行这个对象，
   * 单感叹号的意思就是程序执行成功返回0，执行失败返回非0，如果是双感叹号，则结果以字符串的形式返回。
   * @param args
   */
  def main(args: Array[String]): Unit = {
//    "ls -al "!
//    "ls -al" !!

  }
}
