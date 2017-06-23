package net.xman.tech.common

/**
 * Test Syntax.
 */

fun testLambda() {
    var sum = { x: Int, y: Int ->
        println("x=$x, y=$y")
        x + y
    }
    println(sum(1, 2))

    ({ println("lambda") })()

    //library function run
    run { println("lambda2") }

    // 赋值给函数变量
    fun salute() = println("Salute!")
    run(::salute)

    // Lazy exec
    var r1 = listOf(1, 2, 3, 4).asSequence()
            .map { print("map($it) "); it * it }
            .filter { print("filter($it) "); it % 2 == 0 }
            .toList()
    println()
    println(r1)

    // Eager exec
    var r2 = listOf(1, 2, 3, 4)
            .map { print("map($it) "); it * it }
            .filter { print("filter($it) "); it % 2 == 0 }

    println()
    println(r2)
}

fun main(args: Array<String>) {
    testLambda()
//    println("test")
}

