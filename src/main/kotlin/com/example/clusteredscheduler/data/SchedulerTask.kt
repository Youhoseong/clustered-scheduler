package com.example.clusteredscheduler.data

import java.util.concurrent.Delayed

data class SchedulerTask(
    val jobName: String,
    val delayMillis: Long = 0L,
) : Delayed {
    private val startMillis: Long = System.currentTimeMillis() + delayMillis

    override fun compareTo(other: Delayed?): Int {
        return (startMillis - (other as SchedulerTask).startMillis).toInt()
    }

    override fun getDelay(unit: java.util.concurrent.TimeUnit): Long {
        val diff = startMillis - System.currentTimeMillis()
        return unit.convert(diff, java.util.concurrent.TimeUnit.MILLISECONDS)
    }
}