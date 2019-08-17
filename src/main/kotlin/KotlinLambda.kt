import java.net.CacheResponse

/**
 * lambda的简介：作为函数参数的代码块
 */
/***
 * lambda和集合
 */
fun main() {
    println(sum(5, 6))
    /*****
     * people.maxBy({p:Person3->p.age})
     * 如果lambda是函数调用的最后一个参数 可以把它拿到括号外边
     * people.maxBy(){p:Person3->p.age}
     * 如果lambda是唯一的参数可以去掉调用代码中的空括号
     * people.maxBy{p:Person3->p.age}
     * 类型推导
     *  people.maxBy(){p:->p.age}
     * 使用默认参数代替命名参数
     *  people.maxBy(){it.age}
     *
     *
     */
    print(people.maxBy { it.age })
}

//基本语法
val sum = { x: Int, y: Int -> x * y }
val people = listOf(
    Person3("栾桂明", 12),
    Person3("栾桂明", 13),
    Person3("栾桂明", 14),
    Person3("栾桂明", 15),
    Person3("栾桂明", 16),
    Person3("栾桂明", 24)
)

class Person3(val nickname: String, val age: Int)

/**
 * 在函数内部使用lambda表达式可以访问这个函数的参数和lambda之前定义的局部变量
 * foreach所做的就是将集合中的每一个元素都调用给指定的lambda
 * kotlin可以在lambda内部访问非final变量甚至修改他
 */
//在lambda中访问类中的变量
fun printlnMessage(message: Collection<String>, prefix: String) {
    message.forEach {
        println("$prefix $it")
    }
}
//在lambda中修改类中的变量
fun printlnProblemCount(response: Collection<String>) {
    var centError = 0
    var serverError = 0
    response.forEach {

        if (it.startsWith("4")){
            centError++
        }else if(it.endsWith("5")){
             serverError++
        }
    }

}
