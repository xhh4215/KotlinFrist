import data.Person
import kotlin.reflect.KProperty

/***
 * @function 该文件用以学习数据类和类的委托的
 * @author 栾桂明
 * @date 2019年8月17日
 */
fun main() {
    val client = Client("栾桂明", 1870119)
    val client2 = Client("栾桂明", 1870119)
    val client3 = ClientOne("栾桂明", 1870119)
    println(client.equals(client2))
    println(client.toString())
    println(client3.toString())
}

/***
 * -对于一个类在kotlin中也会提供一种默认的方式获取对象的字符串形式
 * -在kotlin中==是检查对象是否相等，而不是比较引用。这里会编译成调用equals()
 *  kotlin通过===比较引用
 * - 以上这三个被重写的方法可以通过在一个类的前边添加data关键字有kotlin自动
 *   生成，即数据类
 */
class Client(val name: String, val postCode: Int) {
    //重写toString
    override fun toString(): String = "Client(name=$name,postCode = $postCode)"

    //重写equals
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Client) {
            return false
        }
        return name == other.name && postCode == other.postCode
    }

    //重写hashCode
    override fun hashCode(): Int = name.hashCode() * 31 + postCode
}

data class ClientOne(val name: String, val postCode: Int)
/***
 * 没有使用委托的实现，此时是为一些没有被设计为可
 * 扩展的类添加一些行为，要使用装饰器模式
 */

class DelegateCollection<T> : Collection<T> {
    override val size: Int get() = innerList.size
    private val innerList = arrayListOf<T>()
    override fun contains(element: T): Boolean = innerList.contains(element)
    override fun containsAll(elements: Collection<T>): Boolean = innerList.containsAll(elements)
    override fun isEmpty(): Boolean = innerList.isEmpty()
    override fun iterator(): Iterator<T> = innerList.iterator()

}

/***
 * 此处的by关键字实现的功能是 将innerlist对象存储在DelegateCollectionTwo类中
 * 并且编译器会生成并转发所有的innerlist的Collection方法
 */
class DelegateCollectionTwo<T>(
    innerlist: Collection<T> = ArrayList<T>()
) : Collection<T> by innerlist {}


/***
 * object 关键字的学习
 *  - obejct关键字通常是定义一个类同时创建一个对象
 *  - 使用场景 单例模式，伴生对象，对象表达式
 */
/***
 * object实现的是对象的声明 （java中的单例）
 * 对象的声明和类差不多  唯一不一样的是不能有构造器
 * 与普通的类不同的是对象声明是在声明的时候就创建了
 * 可以通过对象名加 .的方式访问属性
 */
object Payroll{
    val allEmployees = arrayListOf<Person>()

    fun calculateSalary():Int{
        return 10000
    }
}
/**
 * 属性委托
 * 委托语法：val/var<属性名>:<类型> by<表达式> by后边的表达式是该委托
 * 属性的get() set() 会委托给它的getValue()和setValue()属性委托不用
 * 实现任何接口只需要提供getValue()和setValue()方法
 * - 当我们从委托到一个 Delegate 实例的 p 读取时，将调用 Delegate 中的 getValue() 函数， 所以它第一个参数是读出 p 的对象、第二个参数保存了对 p 自身的描述 （例如你可以取它的名字)。 例如:
 * - 类似地，当我们给 p 赋值时，将调用 setValue() 函数。前两个参数相同，第三个参数保存将要被赋予的值
 */

class Example(){
    //将字符串p委托给Delegate()
    var p:String by Delegate()
}

class Delegate(){
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}