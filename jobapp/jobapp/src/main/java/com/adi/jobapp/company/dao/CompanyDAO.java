package com.adi.jobapp.company.dao;

import com.adi.jobapp.company.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDAO extends JpaRepository<Company,Long> {
}
