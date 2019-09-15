package data

fun main() {
    print(printlnAllCapps("小傻子"))
    println("length" + strLenSafe("abcdefghigk"))
}

/***
 * 如果一个变量定义为可空类型那对他的操作也会受限制
 * 1 不再能调用他的方法
 * 2 不能把它赋值给非空的变量
 * 3 函数参数的问题
 *
 * 能做什么：最重要的就是和null进行比较 在进行比较之后编译器就会记住
 * 在这次比较的作用域内把它当作非空来对待
 */
fun strLengthSafe(s: String?): Int = if (s != null) s.length else 0

/**
 * 安全调用运算符 ?.
 * 他是把一次null的检查和一次方法的调用合并成一个操作
 *
 *
 *
 * foor?.bar()- 1 foor!=null ->foor.bar()
 *              2 foor=null->null
 */
fun printlnAllCapps(s: String?) {
    val allCapps: String? = s?.toUpperCase()
    println(allCapps)
}

/***
 * 使用空安全调用处理属性
 */
class Employee(val name: String, val manager: Employee?)

fun managerName(employee: Employee): String? = employee.manager?.toString()
/***
 * Elvis运算符?:
 * param1 ?: param2  如果param1不为空表达式的值为param1 如果param1为空表达式的值为param2
 */
fun strLenSafe(s: String?): Int = s?.length ?: 0

/***
 * as  安全转化
 *
 *  foo as type 1 foo is type foo as type
 *              2 foo !is type null
 */
class Person1(val fristname: String, val lastname: String) {
    override fun equals(other: Any?): Boolean {
        val otherperson = other as? Person1 ?: return false
        return otherperson.fristname == fristname && otherperson.lastname == lastname
    }

    override fun hashCode(): Int {
        return fristname.hashCode() * 37 + lastname.hashCode()
    }
}
/**
 * !! 非空断言
 * foo ！！ 1 foo !=null  foo
 *         2 foo ==null   nullpointerexception
 */

