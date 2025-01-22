package com.adi.jobapp.job.dao;

import com.adi.jobapp.job.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface JobDAO extends JpaRepository<Job, Long> {
    // Syntax : JpaRepository<EntityName, PrimaryKey>
}
