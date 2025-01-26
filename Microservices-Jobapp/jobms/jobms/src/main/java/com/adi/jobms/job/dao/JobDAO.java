package com.adi.jobms.job.dao;

import com.adi.jobms.job.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobDAO extends JpaRepository<Job, Long> {
    // Syntax : JpaRepository<EntityName, PrimaryKey>
}
