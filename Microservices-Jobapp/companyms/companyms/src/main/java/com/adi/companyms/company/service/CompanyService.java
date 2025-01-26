package com.adi.companyms.company.service;



import com.adi.companyms.company.model.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    Company getCompanyById(long id);
    Company createCompany(Company company);
    Company updateCompany(long id, Company company);
    boolean deleteComapny(long id);
}
