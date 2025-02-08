package com.adi.library.customer.Service;

import com.adi.library.Exceptions.CustomerNotFoundException;
import com.adi.library.customer.DAO.CustomerDAO;
import com.adi.library.customer.DTO.CustomerRequest;
import com.adi.library.customer.DTO.CustomerResponse;
import com.adi.library.customer.Entity.Customer;
import com.adi.library.customer.Mapper.CustomerMapper;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerDAO customerDAO;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerDAO customerDAO, CustomerMapper customerMapper) {
        this.customerDAO = customerDAO;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponse createCustomer(CustomerRequest request) {
        var newCustomer = this.customerDAO.save(customerMapper.toCustomer(request));
        return customerMapper.fromCustomer(newCustomer);
    }

    @Override
    public CustomerResponse updateCustomer(String id, CustomerRequest request) {
        var customerToBeUpdated = customerDAO.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(
                        String.format("Cannot update customer: No customer found with the provided ID: %s", id)
                ));

        if (request.getFirstname() != null && !request.getFirstname().trim().isEmpty()) {
            customerToBeUpdated.setFirstname(request.getFirstname());
        }
        if (request.getLastname() != null && !request.getLastname().trim().isEmpty()) {
            customerToBeUpdated.setLastname(request.getLastname());
        }
        if (request.getEmail() != null && !request.getEmail().trim().isEmpty()) {
            customerToBeUpdated.setEmail(request.getEmail());
        }
        customerDAO.save(customerToBeUpdated);

        return customerMapper.fromCustomer(customerToBeUpdated);
    }


    @Override
    public List<CustomerResponse> getAllCustomers() {
        return customerDAO.findAll()
                .stream()
                .map(customerMapper::fromCustomer)
                .toList();
    }

    @Override
    public CustomerResponse getCustomerById(String id) {
        return customerDAO.findById(id)
//                .map(customer -> customerMapper.fromCustomer(customer))
                .map(customerMapper::fromCustomer)
                .orElseThrow(
                        () -> new CustomerNotFoundException(String.format("No customer found with the provided ID: %s", id))
                );
    }

    @Override
    public Boolean customerExistsOrNot(String id) {
        return customerDAO.existsById(id);
    }

    @Override
    public void deleteCustomer(String id) {
        if (!customerDAO.existsById(id)) {
            throw new CustomerNotFoundException(String.format("Cannot delete customer: No customer found with ID: %s", id));
        }
        customerDAO.deleteById(id);
    }
}
