package com.example.clusteredscheduler

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class ClusteredSchedulerApplication

fun main(args: Array<String>) {
    runApplication<ClusteredSchedulerApplication>(*args)
}
