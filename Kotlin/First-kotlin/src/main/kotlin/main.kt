fun main(args: Array<String>) {
    println("Hello World!")
    println(sum(10, 20))
    printSum(10, 30)

    forLoop()
}

fun sum(a: Int, b: Int) : Int {
    return a + b
}

fun printSum(a: Int, b: Int) : Unit {
    println("sum of $a and $b is ${a + b}")
}

fun forLoop() {
    println("[for] 반복문")
    val items = listOf("apple", "banana", "kiwi")

    /* NOTE : val 은 재할당 불가 |  var 은 재할당 가능 */

    for (item in items) {
        println(item)
    }

    for(index in items.indices) {
        println("item at $index is ${items[index]}")
    }
}