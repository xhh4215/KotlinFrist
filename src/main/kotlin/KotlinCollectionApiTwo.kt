import data.Book

fun main() {
    println(AllTest(calllist))
    println(AnyTest(calllist))
    println(CountTest(calllist))
    println(GroupByTest(calllist))
    FlatMapTest(peoplelist)
    FlattenTest(listoflist)
}

//定义一个判别式
val canBeInClud = { p: People -> p.age <= 27 }
val calllist = listOf(People("栾桂明", 26, "男"), People("石涛", 25, "男"), People("赵艳", 28, "女"), People("栾跃军", 60, "男"))
val peoplelist = listOf(
    Book("Thursday Next", listOf("Jasper Frorde")),
    Book("Mort", listOf("Terry Pratchett")),
    Book("Good Omens", listOf("Terry Pratchett", "Meil Gaiman"))
)
val listoflist = listOf(listOf("Jasper Frorde"), listOf("Terry Pratchett"), listOf("Terry Pratchett", "Meil Gaiman"))

/***
 * all 对集合的操作是判断集合中是否所有的元素都满足判别式
 */
fun AllTest(person: List<People>): Boolean {
    return person.all { canBeInClud(it) }
}

/***
 * any 对集合的操作是判断集合总是否至少有一个满足判别式
 */
fun AnyTest(person: List<People>): Boolean {
    return person.any { canBeInClud(it) }
}

/***
 * count 对集合的操作是判断集合中有多少符合判别条件的元素
 */
fun CountTest(person: List<People>): Int {
    return person.count { people -> people.age > 26 }
}

/***
 * groupBy是按指定的元素为集合分组
 */
fun GroupByTest(person: List<People>) {
    println(person.groupBy { it.age })
}

/***
 * faltmap做的是两件事
 * 1 根据作为实参为集合中的元素做变换
 * 2 然后把多个列表合并成一个列表
 *
 *    "abc"              "def"
 *      |       映射       |
 *
 *  "a" "b" "c"       "d" "e""f"
 *      |       平铺       |
 *         "a b c d e f"
 */
fun FlatMapTest(booklist: List<Book>) {
    println(booklist.flatMap { it.author })
}

fun  FlattenTest(list: List<List<String>>){
    println(list.flatten())
}