package net.xman.tech.common.service

import java.io.Serializable
import java.math.BigDecimal
import javax.jws.WebMethod
import javax.jws.WebParam
import javax.jws.WebService
import javax.jws.soap.SOAPBinding

/* data class .net调用出错 */
//data class MathWsReq(
//        var op1: BigDecimal = BigDecimal.ZERO,
//        var op2: BigDecimal = BigDecimal.ZERO,
//        var op: Char = '+',
//        var result: BigDecimal? = null
//) : Serializable

/* TODO: BigDecimal接收到参数值为0 */
class MathWsReq : Serializable {
    var op1: BigDecimal = BigDecimal.ZERO
    var op2: BigDecimal = BigDecimal.ZERO
    var op: Char = '+'
    var result: BigDecimal? = null
}

class MathDoubleReq : Serializable {
    var op1: Double = 0.0
    var op2: Double = 0.0
    var op: Char = '+'
    var result: Double? = null
}

/*
public class Req {
	public Req(){}

	private String name;
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
}
转化为了 ==>
class Req {
    var name: String? = null
}
* */

/*
* 测试CXF WebService: JAX-WS, JAX-RS.
* */
@WebService(targetNamespace = "http://hello.webservice.com", name = "helloService")
//@javax.jws.soap.SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
interface HelloWebService {
    @WebMethod
    fun sayHi(@WebParam(name = "custom_name") name: String): String

    @WebMethod
    fun calc(@WebParam(name = "request") req: MathWsReq): MathWsReq

    @WebMethod
    fun calcDouble(@WebParam(name = "request") req: MathDoubleReq): MathDoubleReq
}
