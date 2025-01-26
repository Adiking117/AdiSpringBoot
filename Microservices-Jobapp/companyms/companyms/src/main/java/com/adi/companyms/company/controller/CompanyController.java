package com.adi.companyms.company.controller;


import com.adi.companyms.company.Response.CompanyResponse;
import com.adi.companyms.company.model.Company;
import com.adi.companyms.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies(){
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyResponse> getCompanyById(@PathVariable long id){
        return ResponseEntity.ok(new CompanyResponse("Company",companyService.getCompanyById(id)));
    }


    @PostMapping(value = "/add", produces = "application/json")
    public ResponseEntity<CompanyResponse> createCompany(@RequestBody Company company){
        if(companyService.createCompany(company) != null){
            return ResponseEntity.ok(new CompanyResponse("Company has been created",company));
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<CompanyResponse> updateComapny(@PathVariable long id,@RequestBody Company company){
        if(companyService.updateCompany(id,company) != null){
            return ResponseEntity.ok(new CompanyResponse("Company has been updated",company));
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteCompany(@PathVariable long id){
        if(companyService.deleteComapny(id)){
            return ResponseEntity.ok("Comapny has been destoryed");
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
