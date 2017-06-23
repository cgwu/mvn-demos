package net.xman.tech.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.PropertyAccessor
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.CachingConfigurerSupport
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.interceptor.KeyGenerator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.lang.reflect.Method


/**
 * Created by sam on 17-6-21.
 * FIXME: Redis缓存使用
 * 参考: http://www.cnblogs.com/ityouknow/p/5748830.html
 */
@Configuration
@EnableCaching
class RedisConfig : CachingConfigurerSupport() {

    @Bean
    override fun keyGenerator(): KeyGenerator {
        // FIXME: kotlin生成匿名内部类的方法
        return object : KeyGenerator {
            override fun generate(target: Any, method: Method, vararg params: Any): Any {
                val sb = StringBuilder()
                sb.append(target.javaClass.name).append('$')
                sb.append(method.getName())
                for (obj in params) {
                    sb.append('$').append(obj.toString())
                }
                return sb.toString()
            }
        }
    }

    @Bean
    fun cacheManager(redisTemplate: RedisTemplate<*, *>): CacheManager {
        val rcm = RedisCacheManager(redisTemplate)
        //设置缓存过期时间
        //rcm.setDefaultExpiration(60);//秒
        return rcm
    }

    @Bean
    fun redisTemplate(factory: RedisConnectionFactory): RedisTemplate<String, String> {
        val template = StringRedisTemplate(factory)
        val jackson2JsonRedisSerializer = Jackson2JsonRedisSerializer(Any::class.java)
        val om = ObjectMapper()
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY)
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL)
        jackson2JsonRedisSerializer.setObjectMapper(om)
        template.valueSerializer = jackson2JsonRedisSerializer
        template.afterPropertiesSet()
        return template
    }

}