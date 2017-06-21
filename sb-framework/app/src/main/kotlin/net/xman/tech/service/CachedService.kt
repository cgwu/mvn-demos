package net.xman.tech.service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.cache.annotation.Cacheable


/**
 * Created by sam on 17-6-21.
 */
@Service
class CachedService {
    private val log = LoggerFactory.getLogger(CachedService::class.java)

    @Cacheable("piDecimals")
    fun computePiDecimal(i: Int): Int {
        log.info("computePiDecimal: $i")
        return i * 3
    }

}