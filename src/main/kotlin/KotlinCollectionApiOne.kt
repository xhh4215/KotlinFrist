fun main() {
    FilterTest(lists)
    FilterPeopleTest(peoplelists)
    MapTest(lists)
    MapPeopleTest(peoplelists)
    FilterAndMapTest(peoplelists)
    FindMaxByFilter(peoplelists)
}

/***
 * fliter 函数遍历集合并选出应用给定的lambda后返回true的那些元素
 * filter排除你不想要的元素，但是他不会改变这些元素
 */
private val lists = listOf(1, 2, 3, 4, 5, 6)
private val peoplelists = listOf(
    People("栾桂明", 26, "男"),
    People("石涛", 25, "男"),
    People("赵艳", 24, "女"),
    People("栾跃军", 60, "男")
)

/***
 * filter{(action<T>-> Boolean):List<T>{}}
 */
fun FilterTest(list: List<Int>) {
    println(list.filter { (it - 1) % 2 == 0 })
}

fun FilterPeopleTest(peoplelist: List<People>) {
    println(peoplelist.filter { it.age > 25 })
}

/**
 * map函数是对集合中的每一个元素应用于给定的函数 并把他的结果收集
 * 到一个新的集合中
 */
fun MapTest(map: List<Int>) {
    println(map.map { it + 12 })
}

fun MapPeopleTest(peoplelist: List<People>) {
    //下边这两行代码是等价的 lambda和函数引用
    println(peoplelist.map { "这是一个转化集合的数据:" + it.name })
    println(peoplelist.map(People::name))
}

fun FilterAndMapTest(peoplelist: List<People>) {
    println(peoplelist.filter { it.age > 24 }.map { it.name })
}

fun FindMaxByFilter(peoplelist: List<People>) {
    val maxage = peoplelist.maxBy { it.age }!!.age
    println(peoplelist.filter { it.age == maxage })
}
