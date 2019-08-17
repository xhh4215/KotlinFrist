import javax.lang.model.element.NestingKind

/**
 * 伴生对象：工厂方法和静态成员
 * kotlin中类并不能拥有静态成员
 */
fun main() {
    A.bar()
}

class A {
    /**
     * 创建一个A的伴生对象
     * 伴生对象就是可以在没有类的实例的情况下调用，访问类的内部的成员
     * companion 加了这个关键字可以通过容器的名称来访问属性和方法
     */
    companion object {
        fun bar() {
            println("Companion object called")
        }
    }
}

class Account private constructor(val nickname: String) {
    /***
     * 此处使用的工厂方式创建Account的实例
     */
    companion object {
        fun newSubscribingAccount(email: String) = Account(email.substringBefore('@'))

        fun newFaceBookAccount(accountId: Int) = Account(getFaceBook(accountId))
    }
}
/**
 * 伴生对象是一个声明再类内部的普通的对象，他可以有名字，实现一个接口或者是扩展函数和属性等等
 */


//伴生对象实现接口
class Person1(val name:String){
    companion object:JSONFactory<Person1> {
        override fun fromJson(jsonText: String): Person1= fromJson("实现了一个接口的伴生对象")

    }
}
interface JSONFactory<T>{
    fun fromJson(jsonText:String):T
}
//伴生对象扩展
class Person2(val fristname:String,vallastname:String){
    companion object {

    }
}

fun Person2.Companion.fronJson(json:String):Person2{
    return Person2("栾","桂明")
}
/***
 * 对象表达式：实现java中的匿名内部类
 *
 * 对象表达式与对象声明不同每次对象表达式都会被执行 创建一个新的实例对象
 * window.addMouseListener{
 *    object:MouseAdapter(){
 *        override fun mouseClick(e:MouseEvent){
 *        // todo
 *        }
 *        override fun mouseEnter(e:MouseEvent){
 *        // todo
 *        }
 *    }
 * }
 */




