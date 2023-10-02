package com.example.clusteredscheduler.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
class JobAlloc(
    val jobName: String,
    var instanceId: String,
    var startDateTime: LocalDateTime,
    var endDateTime: LocalDateTime,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    companion object {
        fun initialize(
            jobName: String,
            instanceId: String,
        ): JobAlloc {
            return JobAlloc(
                jobName = jobName,
                instanceId = instanceId,
                startDateTime = LocalDateTime.now(),
                endDateTime = LocalDateTime.now().plusMinutes(5),
            )
        }
    }
}