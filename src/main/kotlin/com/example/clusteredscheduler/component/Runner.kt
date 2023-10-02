package com.example.clusteredscheduler.component

import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationContext
import org.springframework.context.SmartLifecycle
import org.springframework.stereotype.Component
import java.util.concurrent.atomic.AtomicBoolean

@Component
class Runner(
    private val schedulerTaskRegistry: SchedulerTaskRegistry,
    private val applicationContext: ApplicationContext,
) : SmartLifecycle {
    private val logger = LoggerFactory.getLogger(Runner::class.java)
    private val isRunning: AtomicBoolean = AtomicBoolean(false)

    override fun start() {
        try {
            isRunning.set(true)
            Thread {
                while(!Thread.currentThread().isInterrupted) {
                    try {
                        /** TODO
                         * 1. Annotation Scan
                         * 2. DelayedQueue에 Task 생성
                         * 3. Poll
                         * 4. Execute
                         */
                        Thread.sleep(3000)
                    } catch (e: InterruptedException) {
                        logger.error("[Runner] interrupted - threadName(${Thread.currentThread().name})", e)
                        Thread.currentThread().interrupt()
                    }
                }
            }.start()
        } catch (ex: Exception) {
            logger.error("[Runner] error", ex)
        } finally {
            isRunning.set(false)
        }
    }

    override fun stop() {
        logger.info("stop")
    }

    override fun isRunning(): Boolean {
        return isRunning.get()
    }
}