package com.example.clusteredscheduler.component

import com.example.clusteredscheduler.data.SchedulerTask
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.util.concurrent.DelayQueue

@Component
class SchedulerTaskRegistry {
    private val tasks: DelayQueue<SchedulerTask> = DelayQueue()

    fun takeAndAdd(scheduled: Scheduled): SchedulerTask {
        val task = this.tasks.take()
        val newTask = SchedulerTask(task.jobName, scheduled.fixedDelay)
        tasks.add(newTask)
        return task
    }
}