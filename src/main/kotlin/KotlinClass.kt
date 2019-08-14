import java.io.Serializable

/**
 * @funcation 实现的是对kotlin的类的学习
 * @date 2019年 8月 14日
 * @weather  sunny
 */
fun main() {
    Button().click()
}

/**
 *  kotlin 中的接口和java8中的的相似可以包含抽象方法的定义以及非抽象方法的实现
 *  但不能包含任何状态
 *  使用interface关键字实现对接口的声明
 */

interface Clickable {
    //抽象方法 所有的实现这个接口的类都必须提供这个方法的实现
    fun click()

    //接口内部的默认实现方法
    fun showOff() = println("I m Clickable")
}

interface Focusable {
    fun setFocus(b: Boolean) {
        println("I ${if (b) "get" else "lost"} focus.")
    }

    open fun showOff() = println("I m Focusable")
}

/***
 * 如果同样的继承成员有不止一个的实现，必须提供一个显示的实现
 */
class Button : Clickable, Focusable {
    override fun showOff() {
        //使用尖括号加父类名字的super关键字标明你想要调用那个父类的方法
        super<Clickable>.showOff()
        super<Focusable>.showOff()

    }

    //overtide 关键字标记重写的方法
    override fun click() {
        println("i was click")
    }

}

/***
 * 1 使用open关键字标记的类是可以被其他的类继承的
 * 2
 *
 */
open class RichButton : Clickable {
    //这个类是final的不能在子类中重写
    fun disable() {}

    //这个函数是open的可以在子类中重写
    open fun animate() {}

    //不加final关键字这个函数重写了一个open的函数并且自己也是open的
    //加了final关键字就不能被重写了
    final override fun click() {}

}

/***
 * 使用abstract关键字创建一个抽象了 ，这个类不能创建实例
 * final      不能被重写               类中的成员默认使用
 * open       可以被重写               需要明确的标明
 * abstract   必须被重写               只能在抽象类中使用
 * override   重写父类或接口的成员      如果没有final关键字默认是open的
 *
 */
abstract class Animated {
    /***
     * 这个函数是抽象函数，没有实现必须子类继承来实现
     */
    abstract fun animated()

    /***
     * 抽象类中的非抽象函数默认并不是open但是可以标记为open
     */
    open fun StopAnimated() {

    }
}

/***
 * 在java中在一个类中声明一个类默认的会变成这个类的内部类
 * 内部类对象隐式的包含了外部类的引用
 */
interface State : Serializable

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State)
}

class ButtonTwo : View {
    override fun restoreState(state: State) {

    }

    override fun getCurrentState(): State = ButtonState()

    /***
     * 在A类中声明一个类B       在Java中          在Kotlin中
     *  嵌套类                 static class A    class A
     *  内部类                 class A           inner Class A
     * 这个类与java的静态内部类相似  嵌套类不持有外部类的引用而内部类持有
     * 在kotlin中使用this@外部类名称访问外部类
     */
    class ButtonState : State {

    }
}

/***
 * sealed类为父类添加一个sealed修饰符，对可能创建的子类作出严格的限制，所有的直接子类必须嵌套在父类中
 */
//将基类标记为密封类
sealed class MyExpr{
    class Num(val value:Int):MyExpr()
    class Sum(val left:Expr,val right:Expr):MyExpr()
}
fun eavl(e:MyExpr){
    when(e){
        is MyExpr.Num -> e.value
        is MyExpr.Sum -> eval(e.right)+ eval(e.left)
    }
}