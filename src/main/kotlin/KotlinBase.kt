import java.lang.IllegalArgumentException
import java.util.*

/****
 * kotlin的基础其中包括
 * - 函数的声明，变量，类，枚举以及属性的学习
 * - Kotlin中的控制结构
 * - 智能类型转化
 * - 抛出和处理异常
 *
 */
fun main() {
//    hello kotlin
//    println("hello kotlin")
//    println(ValTestOne("11", "11"))
//    println(ValTestTwo())
//    println(StringTestOne("是一个Android程序员"))
//    println(StringTestTwo("是一个Android程序员", "同时想考研"))
//    println(getMneemonic(MyColor.BLUE))
    JavaForOne()
    JavaForTwo(2)

}

/***
 * - 关键在fun用来声明一个函数
 * - 参数的类型是跟在变量明的后边的
 * - 函数可以定义在文件的最外层，而不需要放在类里边
 * - fun 函数名 (参数列表)：返回值类型 {函数体}
 *
 * - 语句和表达式的区别
 *   表达式：是有值的并且能作为另一个表达式的一部分
 *   语句：语句总是包围着他的代码块中的顶层元素，并且没有自己的值
 */
//普通的函数
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}
//表达式函数体
/***
 * 函数式编程思想   把函数当作一个值来处理 可以用他来保存变量，把它当作变量来传递 或者当作其他
 * 函数的返回值
 */
fun maxTo(a: Int, b: Int) = if (a > b) b else a

/****
 * Kotlin 中变量的声明是以变量名称再加上变量类型来实现的
 */

val question = "the uitimate question of life  the universe and everything"

val answer = 42
/**
 * val (value)  不可变的引用 ，使用val声明的变量不能再初始化之后再次赋值的 他对应java的final变量
 *
 * var (variable) 可变的引用 ，这中变量的数值是可以改变的，对应于java的普通变量
 */
//如果能确保只有唯一的一条初始化的语句会执行，可以根据条件的不同对val变量进行初始化
fun ValTestOne(str1: String, str2: String): String {
    val message: String
    if (str1 == str2) {
        message = "Success"
    } else {
        message = "Failed"
    }
    return message
}

//val引用自身是不可变的但是他指向的对象可能是可变的 例如
fun ValTestTwo(): String {
    val languages = arrayListOf("java")
    languages.add("kotlin")
    languages.add("python")
    languages.add("c#")
    return languages.toString()

}

/***
 *  字符串模版：更简单的字符串格式化
 *  kotlin可以通过在变量的前面添加$实现应用局部变量的的字面值
 *  kotlin如果想再复杂的字符串中引用表达式的值可以通过 ${表达式} 来实现
 */
fun StringTestOne(str: String) {
    val name = "栾桂明"
    println("栾桂明$str")

}

fun StringTestTwo(str: String, str2: String) {
    val name = "栾桂明"
    println("栾桂明${str + str2}")

}

/****
 * 属性
 * 1 类的概念是把数据和处理数据的代码封装成一个单一的实体在java中数据存储在字段中通常是私有的要
 *   通过访问方法实现访问，在java中字段和访问器的组合常常被称作是属性，而在kotlin中属性是头等语言，
 *   在类中声明一个属性和声明一个变量时一样的
 * 2 基本上在你声明一个属性的时候就声明了对应的访问器(只读属性有一个getter方法，而可写属性包含getter和setter方法)
 *   访问器的默认实现很简单，创建一个存储值的字段以及放回值和更新值的getter和setter方法 如果需要的话可以自定义访问器
 */
//自定义访问器
class Rectangle(val height: Int, val width: Int) {
    val isQuare: Boolean
        //声明属性的getter方法
//        get() {
//            return height == width
//        }
        get() = height == width

}

/***
 * 声明枚举类
 * 枚举类并不是一个值列表 ，你可以给枚举类声明属性和方法
 * 枚举常量用的声明构造方法和属性的语法与之前的常规类一样
 */
// enum 是一个软关键字 只有在class前面的时候才有特殊的意思 其他的地方可以当作普通的变量处理
enum class Color(val r: Int, val g: Int, val b: Int) {
    //声明枚举类内部的常量  常量必须以分号结尾
    RGB(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0), GREEN(0, 255, 0),
    BLUE(0, 0, 255), INDIGO(75, 0, 130);

    //定义一个方法
    fun rgb() = (r * 256 + g) * 256 + b


}

enum class MyColor {
    RED, YELLOW, BLUE, INDIGO
}

/***
 * 使用when处理枚举类
 * -  when 是一个又返回值的表达式，因此可以直接返回我很表达式的表达式体函数
 */

fun getMneemonic(color: MyColor) = when (color) {
    MyColor.RED -> "this is red"
    MyColor.YELLOW -> "this is yellow"
    MyColor.BLUE -> "this is blue"
    MyColor.INDIGO -> "this is indigo"
}

/***
 * when 表达式中可以将多个数值合并到一个分之中
 */
fun getWarmth(color: MyColor) =
    when (color) {
        MyColor.RED, MyColor.BLUE, MyColor.INDIGO -> {
            "this is a wram color"

        }
        MyColor.YELLOW -> {
            "this is yellow"
        }
    }

/***
 * when表达式中使用任意的对象
 */
fun mix(c1: MyColor, c2: MyColor) =
    when (setOf(c1, c2)) {
        setOf(MyColor.RED, MyColor.YELLOW) -> {
            "ORANGE"

        }
        setOf(MyColor.YELLOW, MyColor.INDIGO) -> {
            "GREEN"

        }
        else -> {
            throw Exception("Dirty color")
        }
    }

/***
 * 使用不带参数的when
 * 如果没有给when表达式提供参数，分之条件就是任意的布尔表达式。
 */

fun mixOPtimized(c1: MyColor, c2: MyColor) =
    when {
        (c1 == MyColor.RED && c2 == MyColor.INDIGO) || (c1 == MyColor.YELLOW && c2 == MyColor.RED)
        -> MyColor.RED
        else -> {
            throw Exception("Dirty color")
        }
    }

/**
 * is：检查判断一个变量是否是某种类型
 * as：关键字来表示到特定类型的显示转化
 * if分之中只有一个表达式 花括号是可以不写的，如果if分之是一个代码块，代码块中的最后一个表达式会被作为结果返回
 */
interface Expr

class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int {
    if (e is Num) {
        val n = e as Num
        return n.value
    }

    if (e is Sum) {
        return eval(e.right) + eval(e.left)
    }
    throw IllegalArgumentException("Unkonw expression")
}

/**
 * 循环
 * kotlin中没有和常规的java一样的for循环 先初始化变量 ，再循环是每一步更新数值，并在满足某个限制条件的
 * 时候退出，这种常见的循环方法kotlin使用区间的概念
 * - 区间：本质是两个数值之间的间隔，这两个数值通常是数字：一个起始值一个是结束值 使用
 *   ..运算符来表示区间 kotlin中的区间是闭合的
 *
 */
fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz"
    i % 3 == 0 -> "Fizz"
    i % 5 == 0 -> "Buzz"
    else -> "$i"


}

/****
 * for   ... in 循环在常见的迭代集合
 */
fun JavaForOne() {
    for (i in 1..100) {
        println(fizzBuzz(i))
    }
}

/****
 * dwonTo 是一个递减的区间的创建
 * step 迭代的步长
 */
fun JavaForTwo(step: Int) {
    for (i in 100 downTo 1 step step) {
        println(fizzBuzz(i))

    }
}

val binaryReps = TreeMap<Char, String>()
/***
 * 迭代map集合
 *   in检查集合或者是区间
 *   !in检查不属于集合和区间
 */
fun MapTest() {
    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }

    for ((letter, binary) in binaryReps) {
        println("$letter=$binary")
    }
}
