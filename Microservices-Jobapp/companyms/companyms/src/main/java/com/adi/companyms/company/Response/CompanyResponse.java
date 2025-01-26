package com.adi.companyms.company.Response;


import com.adi.companyms.company.model.Company;

public class CompanyResponse {
    private String message;
    private Company company;

    public CompanyResponse(String message, Company company) {
        this.message = message;
        this.company = company;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "CompanyResponse{" +
                "message='" + message + '\'' +
                ", company=" + company +
                '}';
    }
}
