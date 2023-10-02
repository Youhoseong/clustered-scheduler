package com.example.clusteredscheduler

import com.example.clusteredscheduler.annotations.ClusterScheduled
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class LoggingScheduler {
    private val logger = LoggerFactory.getLogger(LoggingScheduler::class.java)

    @ClusterScheduled(name = "LoggingScheduler", fixedDelayMillis = 1000L)
    fun invoke() {
        logger.info("I'm alive..")
    }
}