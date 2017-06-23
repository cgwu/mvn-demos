package net.xman.tech.common

import kotlin.reflect.KClass

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

//Upper bounds
//As the name implies, an upper
//bound restricts the types to those that are subclasses of the bound. To use an upper bound, we
//simply declare it alongside the type parameter
fun <T : Comparable<T>> min(first: T, second: T): T {
    val k = first.compareTo(second)
    return if (k <= 0) first else second
}

interface Serializable

//Multiple bounds
fun <T> minSerializable(first: T, second: T): T
        where T : Comparable<T>, T : Serializable {
    val k = first.compareTo(second)
    return if (k <= 0) first else second
}

fun testGeneric() {
    val a: Int = min(4, 5)
    val b: String = min("e", "c")
    println("a=$a, b=$b")
}

// Safe Cast: as?
fun testSafeCast(){
    val location:Any = "London"
    val safeString:String? = location as? String
    val safeInt:Int? = location as? Int
    println("safeString: $safeString, safeInt: $safeInt")
}

class Sandwich<F1,F2>()
// KClass
fun testKClass(){
    val name:String = "George"
    // 关于out: Transformation: Consumer in, Producer out! :-)
    // 参考: https://kotlinlang.org/docs/reference/generics.html
    val kclass1: KClass<out String> = name::class
    val kclass2: KClass<out String> = String::class
    println(kclass1 == kclass2)

    val types = Sandwich::class.typeParameters
    types.forEach {
        println("Type ${it.name} has upper bound ${it.upperBounds}")
    }
}

fun main(args: Array<String>) {
    testLambda()
    testGeneric()
    testSafeCast()
    testKClass()
}

