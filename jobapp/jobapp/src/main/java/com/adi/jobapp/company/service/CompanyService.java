package com.adi.jobapp.company.service;

import com.adi.jobapp.company.model.Company;
import com.adi.jobapp.job.model.Job;
import com.adi.jobapp.review.model.Review;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    Company getCompanyById(long id);
    List<Job> getJobsByComapny(long id);
    List<Review> getReviewsByCompany(long id);
    Company createCompany(Company company);

    Company updateCompany(long id,Company company);
    boolean deleteComapny(long id);
}
