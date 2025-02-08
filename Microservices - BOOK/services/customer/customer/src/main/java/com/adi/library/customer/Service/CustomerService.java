package com.adi.library.customer.Service;

import com.adi.library.customer.DTO.CustomerRequest;
import com.adi.library.customer.DTO.CustomerResponse;

import java.util.List;

public interface CustomerService {
    CustomerResponse createCustomer(CustomerRequest request);
    CustomerResponse updateCustomer(String id,CustomerRequest request);
    List<CustomerResponse> getAllCustomers();
    CustomerResponse getCustomerById(String id);
    Boolean customerExistsOrNot(String id);
    void deleteCustomer(String id);
}
