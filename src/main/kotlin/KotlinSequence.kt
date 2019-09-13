fun main() {
    SequenceTest(peoplelists)
    CreateSequence()
}

private val peoplelists = listOf(
    People("栾桂明", 26, "男"),
    People("石涛", 25, "男"),
    People("赵艳", 24, "女"),
    People("栾跃军", 60, "男")
)

/**
 *  序列的操作分为2类
 *  中间操作：会返回一个序列 操作始终是惰性的
 *  末端操作：会返回一个结果 末端操作触发所有的延期计算
 *  Kotlin的惰性集合接口的入口就是Sequence接口
 *  可以使序列更高效的对集合执行链式操作，而不需要创建额外的集合保存中间结果
 *  asSequence()  集合转化为序列
 *  toList() 序列转化为集合
 */
fun SequenceTest(people: List<People>) {
    println(people.asSequence()
        .map { it.name }
        .filter { it.startsWith("栾") }
        .toList()
    )
}

/**
 * 创建序列 generateSequence函数
 * 这是一个两个参数的函数
 */
fun CreateSequence() {
    val naturalNUmber = generateSequence(0) {
        it + 1
    }
    val total = naturalNUmber.takeWhile { it<100 }
     println(total.sum())
}