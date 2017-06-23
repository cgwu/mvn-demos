package net.xman.tech.config

import org.springframework.context.annotation.Configuration
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession

/**
 * Created by on 2017-06-23.
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60 * 10)
public class SessionConfig {

}