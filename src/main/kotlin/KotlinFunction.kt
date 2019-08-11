//使用import关键在来实现对顶层函数的使用
import strings.joinToStringTwo

/***
 * Kotlin的函数的定义和使用
 * - 用于处理集合，字符串，和正则表达式的函数
 * - 使用命名参数，默认参数，以及中缀表达式的语法
 * - 通过扩展函数和属性来适配java
 * - 使用顶层函数，局部函数和属性架构代码
 */
fun main() {
    //使用toString打印list集合
//    println(list.toString())
    println(joinToStringTwo(list, "：", "（", "）"))
    println("栾桂明".lastChar())
}

/***
 * 在kotlin中创建集合
 */
//使用setof创建set集合
val set = setOf("小黑", "小黑", "小黑")
//使用arrayListOf创建一个list集合
val list = arrayListOf("小黑", "小黑", "小黑", "小黑", "小黑", "小黑", "小黑", "小黑")
//使用hashmapOf创建一个map集合
val map = hashMapOf(1 to "a", 2 to "b", 3 to "c", 4 to "d")

/***
 * param1  collection 被操作的集合
 * param2  separator  分隔符
 * param3  prefix     左边的起始符
 * param4  postfix    右边的结束符
 */
fun <T> joinToString(collection: Collection<T>, separator: String, prefix: String, postfix: String): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

/****
 * 命名参数
 * 当调用一个Kotlin定义的函数的时候，可以显示的标明一些参数的名称，如果在调用一个函数的时候
 * 指明了一个参数的名称，为了避免混淆，那么它之后的参数也都要标明名称
 */
fun <T> MyjoinToString(collection: Collection<T>) {
    joinToString(collection, separator = ":", postfix = "{", prefix = "}")
}

/***
 * 默认参数值
 * 在kotlin中你可以在声明函数的时候指定参数的默认值
 * 当你使用常规的调用语法的时候，必须按照函数声明中定义的参数顺序来给定参数，可以不写
 * 如果使用命名参数，可以不写中间的参数，也可以按你想要的顺序给定参数值
 * 函数的默认值是被编译到被调用的函数中的而不是函数调用的地方
 */
fun <T> joinToStringTwo(
    collection: Collection<T>,
    separator: String = ",",
    postfix: String = " ",
    prefix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}
//顶层函数看 join.kt这个文件
/**
 * 顶层属性
 * 和函数一样，属性也可以放在文件的顶层，在一个类的外面包存单独的数据片
 */
//声明一个顶层属性
var opCount = 0

fun performOperation() {
    //改变顶层属性的值
    opCount++
}

/***
 * 如果你想把一个常量以 public static final 的属性暴露给java
 * 可以使用const关键在来修饰
 */
const val UNIX_LINE = "\n"

fun reportOperationCount() {
    //读取顶层属性的数值
    println("Operation performed $opCount times")
}

/***
 * 给别人的类添加方法，扩展函数和扩展属性
 *  - 扩展函数：实现扩展函数你所要做的就是，就是把你要扩展的类或者是接口的名称，放在即将添加的函数前面，这个
 *    类的名称被称为接收者类型，用来调用这个扩展函数的那个对象，叫做接收者对象
 *  - 在扩展函数中，你可以直接访问被扩展的类的其他方法和属性，就像访问自己方法中的类一样
 *  - 在使用扩展函数的时候需要使用import进行导入，命名冲突的时候使用as关键字修改名称
 */
//扩展函数
fun String.lastChar(): Char = this.get(this.length - 1)
//扩展属性
val String.lastChar:Char get() = get(length-1)
/**
 * 可变参数：让函数支持任意数量的参数  (这里没看明白)
 *     - 当你在调用一个函数来创建列表的时候，可以传递任意个数的参数给他
 */

/**
 *  -中缀调用 1 函数名称直接放在目标对象名称和参数之间
 *   1.to("one")
 *   1 to "one"
 *           2 中缀表达式可以与只有一个参数的函数一起使用 无论是普通函数还是扩展函数
 *           3 要使用中缀符号调用函数，需要使用infix修饰符来标记他
 *  -to 函数会返回一个Pair类型的对象，Pair是Kotlin标准库中的类
 *      他用来表示一对元素，Pair和to的声明都用到了范型（我们可以用Pair的内容来初始化两个变量）
 */
infix  fun Any.to(other:Any) = Pair(this,other)
/***
 * 可以使用mapOf函数来创建map函数
 */
val maptwo = mapOf(1 to "one",7 to "seven",53 to "fifty-seven")
