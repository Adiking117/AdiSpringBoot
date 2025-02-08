package com.adi.library.customer.Controller;

import com.adi.library.customer.DTO.CustomerRequest;
import com.adi.library.customer.DTO.CustomerResponse;
import com.adi.library.customer.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")


public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/create")
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody @Valid CustomerRequest request){
        return ResponseEntity.ok(customerService.createCustomer(request));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<CustomerResponse> updateCustomer(
            @PathVariable("id") String id,@RequestBody @Valid CustomerRequest request
    ){
        return ResponseEntity.ok(customerService.updateCustomer(id,request));
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllCustomers(){
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable String id){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable String id){
        customerService.deleteCustomer(id);
        return ResponseEntity.accepted().build();
    }

}
