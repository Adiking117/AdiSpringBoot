package com.adi.library.customer.Mapper;

import com.adi.library.customer.DTO.CustomerRequest;
import com.adi.library.customer.DTO.CustomerResponse;
import com.adi.library.customer.Entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer toCustomer(CustomerRequest request);

    CustomerResponse fromCustomer(Customer customer);
}

