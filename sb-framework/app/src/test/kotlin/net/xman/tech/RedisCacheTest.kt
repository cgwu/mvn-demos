package net.xman.tech

import net.xman.tech.common.domain.UserEntity
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.data.redis.core.ValueOperations
import org.springframework.test.context.junit4.SpringRunner
import java.util.concurrent.TimeUnit


/**
 * Created by on 2017-06-23.
 */

@RunWith(SpringRunner::class)
@SpringBootTest
class TestRedis {

    @Autowired
    private val strRedisTemplate: StringRedisTemplate? = null

    @Autowired
    private val redisTemplate: RedisTemplate<*, *>? = null

    @Test
    @Throws(Exception::class)
    fun test() {
        strRedisTemplate!!.opsForValue().set("aaa", "111")
        Assert.assertEquals("111", strRedisTemplate!!.opsForValue().get("aaa"))
    }

    @Test
    @Throws(Exception::class)
    fun testObj() {
        val user = UserEntity("aa@126.com", 30, "123")
        val operations = redisTemplate!!.opsForValue() as ValueOperations<String, UserEntity>
        operations.set("com.neox", user)
        operations.set("com.neox.f", user, 10, TimeUnit.SECONDS)
        Thread.sleep(2000)
//        //redisTemplate.delete("com.neo.f");
        val exists = (redisTemplate!! as RedisTemplate<String,UserEntity>).hasKey("com.neox.f")!!
        if (exists) {
            println("exists is true")
        } else {
            println("exists is false")
        }
        // Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
    }
}