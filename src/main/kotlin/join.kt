@file:JvmName("StringFunctions")

package strings

/***
 * 顶层函数，是把函数直接放在代码文件的顶层，他不从属于任何类，这些放在文件顶层的函数依然是包内成员
 * ，如果你要从包访问他，则需要使用import 但不再需要额外的一层包
 * 要改变包含kotlin顶层函数的生成的类的名称，需要为这个文件添加@JvmName的注解，将其放在这个文件的
 * 开头，位于包名前面
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

/***
 * kotlin 标准库中的函数
 * 不能重写扩展函数
 */
fun <T> Collection<T>.joinToString(separator: String = ",", prefix: String = "", postfix: String = ""): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()

}

