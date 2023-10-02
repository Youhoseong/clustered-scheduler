package com.example.clusteredscheduler.component

import com.example.clusteredscheduler.repository.JobAllocRepository

class SchedulerAllocationManager(
    private val jobAllocRepository: JobAllocRepository,
) {
    // 스케쥴러 점유 여부 체크
    fun isEnabled(jobName: String, instanceId: String): Boolean {
        val jobAllocation = jobAllocRepository.findByJobName(jobName)
        return jobAllocation == null
    }
}