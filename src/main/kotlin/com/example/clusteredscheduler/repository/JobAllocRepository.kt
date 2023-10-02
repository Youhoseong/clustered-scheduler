package com.example.clusteredscheduler.repository

import com.example.clusteredscheduler.model.JobAlloc
import jakarta.persistence.LockModeType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Lock
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface JobAllocRepository : JpaRepository<JobAlloc, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Transactional
    @Query("SELECT ja FROM JobAlloc ja WHERE ja.jobName = :jobName")
    fun findByJobName(jobName: String): JobAlloc?
}