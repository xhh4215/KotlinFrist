import java.io.File

/**
 * kotlin关键字在多种情况下出现，但是他都遵循一个核心的理念，这个关键字是定义一个类同时创建一个实例
 * 使用场景
 *  - 对象声明是创建单例的一种方式
 *  - 伴生对象
 *  - 对象表达式：用来代替java 的匿名内部类
 */
/***
 * kotlin通过对象声明的功能实现java 的单例模式，对象声明是将类的声明
 * 和该类的单一实例声明结合在一起
 *  - 对象声明通过object关键字引入
 *  - 对象声明可以很高效地用一句话定义一个类和该类的变量
 *  - 对象声明可以包含属性，方法，初始化语句等的声明
 *  - 对象声明在定义的时候就创建了，不需要在别的地方调用构造器
 */
//实现的是忽略大小写比较文件的路径
object CaseInsensitiveFilecomparator : Comparator<File> {
    override fun compare(file1: File, file2: File): Int {
        return file1.path.compareTo(file2.path, ignoreCase = true)
    }
}

/***
 * 可以在类中声明对象，这样的对象同样只有一个单一的实例，他在每个容器类的实例
 * 中并不具有不同的实例
 */
data class Persosn(val name: String) {
    object NameComparator : Comparator<Persosn> {
        override fun compare(o1: Persosn, o2: Persosn): Int = o1.name.compareTo(o2.name)


    }
}