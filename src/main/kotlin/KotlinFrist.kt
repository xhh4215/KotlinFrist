// 数据类
data class PersonPeople(val name: String, val age: Int? = null)

fun main() {
    // 此处使用了命名参数
    val person = listOf(PersonPeople("Alice"), PersonPeople("Bod", 12))

    val oldest = person.maxBy { it.age ?: 0 }
    println("The oldest is $oldest")
}