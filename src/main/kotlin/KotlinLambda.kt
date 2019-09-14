import data.Person
import java.awt.Button
import java.awt.CompositeContext
import java.lang.StringBuilder
import javax.naming.Context

fun statue() = println("Statue")
/**
 * lambda的简介：作为函数参数的代码块
 */
fun main() {
    println("最大年龄的人" + perple.maxBy {
        it.name
    })
    println("两个数求和" + sum(12, 12))
    val people = People("栾桂明", 26, "男")
    val age = { people: People -> people.age }
    val age2 = people::age
    println("age" + age + "age2" + age2)
    println(run { ::statue })
    val people1 = createPeople()
    println("this is a people " + people1)
    println(alphabet())
}

/**
 * 手动在集合中搜索
 */
fun findTheOlder(person: List<Person>) {
    //存储最大年龄
    var maxAge = 0
//    存储最大年龄的人
    var theOlder: Person? = null
    for (person in person) {
        if (person.age > maxAge) {
            maxAge = person.age
            theOlder = person
        }
    }
}

/***
 * lambda 最初形式
 */
fun maxByOne(person: List<Person>) {
    person.maxBy({ p: Person -> p.age })
}

/***
 * 如果lambda表达式是最后一个参数，他可以放在括号的外边
 */
fun maxByTwo(person: List<Person>) {
    person.maxBy() { p: Person -> p.age }
}

/***
 * 如果lambda是唯一的一个参数那圆括号可以不写
 */
fun maxByThree(person: List<Person>) {
    person.maxBy { p: Person -> p.age }
}

/***
 * 参数的类型可以自动推导
 */
fun maxByFour(person: List<Person>) {
    person.maxBy { p -> p.age }
}

/***
 * 使用it代替命名参数
 */
fun maxByFive(person: List<Person>) {
    person.maxBy {
        println("这是lambda表达式的使用")
        it.age
    }
    //成员引用和调用该函数的lambda 的表达式具有相同的类型因此可以互换
    // people.maxBy{People.age}
}

/**
 * 使用lambda表达式获取最大值
 */
val perple = listOf(Person("Alice", 29), Person("Bob", 30))
/***
 * lambda的基本语法
 * {param:Type,param:Type-> fun name(x,y)}
 */

//调用保存在变量中的lambda表达式
val sum = { x: Int, y: Int -> x + y }

/***
 * 在函数的内部声明一个匿名内部类的时候，能够引用这个函数的参数个局部变量
 * 在lambda可以做同样的事
 * action<T> 是一个参数为string 类型的函数
 * action<T> -> Unit
 *
 */
fun printlnMessage(messages: Collection<String>, prefix: String) {
    //在lambda中访问prefix 参数
    messages.forEach {
        println("$prefix $it")
    }
}

/****
 * it代表传入的lambda的执行的函数的参数
 * 一般情况下变量的生命周期被限制在声明的函数的内部，但是如果这个变量被
 * lambda捕获就可以存储稍后执行
 */
fun printlnProblemCounts(response: Collection<String>) {
    var clientError = 0
    var serverError = 0
    response.forEach {
        if (it.startsWith("4")) {
            clientError++
        } else if (it.startsWith("5")) {
            serverError++
        }
    }
}

/****
 * 如果lambda表达式被用作事件处理器或者是其他的一步操作的执行情况 对
 * 变量的修改只会在lambda执行的时候发生
 */
fun tryToCountButtonClicks(button: Button): Int {
    var clicks = 0
//    button.onCLick { clicks++ }
    return clicks
}

/***
 * 成员引用 可以把函数转化为一个值来传递
 * 语法 类名 :: 成员
 * 成员引用和调用该函数的lambda 的表达式具有相同的类型因此可以互换
 */
data class People(val name: String, val age: Int, val gender: String)

/***
 * 可以使用构造方法引用存储或者是延迟执行创建类实例的动作，构造方法引用形式是双引号后加类名称
 */
fun createPeople(): People {
    val create = ::People
    val p = create("小黑", 26, "男")
    return p

}

/***
 * 带接受者的lambda with和apply
 * with:是一个接受两个参数的函数他把他的第一个参数转化作为第二个参数传个lambda内的接收者
 * 返回的是lambda 的执行结果
 */
fun alphabet() = with(StringBuilder()) {
    for (letter in 'a'..'z') {
        append(letter)
    }
    append(" Now I Konw This Is A Alphabet")
    toString()
}

/***
 *  * with:是一个接受两个参数的函数他把他的第一个参数转化作为第二个参数传个lambda内的接收者
 * 返回的是接收者对象 的执行结果
 */
fun alphabet1() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
        append(" Now I Konw This Is A Alphabet")

    }
}.toString()
