fun main() {
    val user = MyUser("Alice")
    user.address = "dlfjasdkfjasdlkjfsadkfjsalkjfas"
}

/**
 * kotlin 中可以包含抽象属性的声明，
 * 例如
 * interface User{
 *   val nickname:String
 * }
 * 这意味着实现User接口的类需要提供一个取得nickname值的方式，接口并没有说明这个值应该存储到一个
 * 支持字段还是通过getter来获取，接口本身并不包含任何状态，只是实现这个接口的类需要的情况下会存储这个值
 */
interface account {
    val nickname: String
}

/***
 * 使用了简洁的语法在主构造器中声明了一个属性，这个属性的实现来自于account的抽象属性
 * 所以标记为override
 */
class privateAccount(override val nickname: String) : account

/***
 * 通过一个get方法对属性进行赋值
 */
class subscribingAccount(val email: String) : account {
    override val nickname: String
        get() = email.substringBefore('@')
}

class facebookAccount(val accountId: Int) : account {
    override val nickname = getFaceBook(accountId)
}


fun getFaceBook(accountId: Int): String = accountId.toString()
/**
 * 在setter中访问支持字段
 * -在 setter和getter的函数体中使用field关键字来访问支持字段的值
 *  在getter中只能读取在setter中既能读取也能修改
 * -如果使用默认的getter和setter系统会生成支持字段
 *  如果在自定义的getter和setter中没有使用field支持字段将不会呈现
 */
class MyUser(val name: String) {
    var address: String = "unspecified"
        set(value: String) {
            println(
                """
            Address was changed for $name:$field -> $value.
        """.trimIndent()
            )
        }
}

