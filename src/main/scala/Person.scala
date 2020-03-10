/**
 * author: Mr.Li 
 * create: 2020-03-09 15:30 
 * description: 序列化
 **/
@SerialVersionUID(1L)
class Person extends Serializable {
  override def toString: String = name + ","+age
  val name = "Nick"
  val age = 20
}
