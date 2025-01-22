package com.adi.jobapp.company.service;

import com.adi.jobapp.company.dao.CompanyDAO;
import com.adi.jobapp.company.model.Company;
import com.adi.jobapp.job.model.Job;
import com.adi.jobapp.review.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService{

    private CompanyDAO companyDAO;

    @Autowired
    public CompanyServiceImpl(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyDAO.findAll();
    }

    @Override
    public Company getCompanyById(long id) {
        return companyDAO.findById(id).orElse(null);
    }

    @Override
    public List<Job> getJobsByComapny(long id) {
        Company company = getCompanyById(id);
        if(company != null){
            return company.getJobs();
        }
        return  null;
    }

    @Override
    public List<Review> getReviewsByCompany(long id) {
        Company company = getCompanyById(id);
        if(company != null){
            return company.getReviews();
        }
        return  null;
    }

    @Override
    public Company createCompany(Company company) {
        companyDAO.save(company);
        return company;
    }

    @Override
    public Company updateCompany(long id, Company updatedCompany) {
        Optional<Company> companyToUpdate = companyDAO.findById(id);
        if(companyToUpdate.isPresent()){
            Company c = companyToUpdate.get();
            c.setName(updatedCompany.getName());
            c.setDescription(updatedCompany.getDescription());
            companyDAO.save(c);
            return c;
        }
        return null;
    }

    @Override
    public boolean deleteComapny(long id) {
        try {
            companyDAO.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
