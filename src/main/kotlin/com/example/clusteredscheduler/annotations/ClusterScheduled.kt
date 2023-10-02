package com.example.clusteredscheduler.annotations

annotation class ClusterScheduled(
    val name: String,
    val fixedDelayMillis: Long = 0L,
)
