package net.xman.tech.common.service

import java.math.BigDecimal
import java.io.Serializable

//TODO: Hessian BigDecimal序列化是有bug的.
data class MathReq(
        var op1: BigDecimal,
        var op2: BigDecimal,
        val op: Char,
        var result: BigDecimal? = null
) : Serializable

data class NumberReq(
        var op1: Double,
        var op2: Double,
        val op: Char,
        var result: Double? = null
) : Serializable

interface GreetingService {
    fun sayHi(name: String): String

    fun calc(arg: MathReq): MathReq

    fun calcNumber(arg: NumberReq): NumberReq
}
