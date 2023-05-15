package controller;

import entity.CustomerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import repository.CustomerRepository;
import service.CustomerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    @Autowired
    private CustomerService service;


    @GetMapping("/customer")
    List<CustomerEntity> all() {
        return service.getAllCustomer();
    }

    @PostMapping("/customer")
    CustomerEntity newCustomer(@RequestBody CustomerEntity newCustomer) {
        return service.addNewCustomer(newCustomer);
    }
    @PutMapping("/customer/{id}")
    CustomerEntity replaceCustomer(@RequestBody CustomerEntity customerEntity, @PathVariable Long id) throws Exception {

        return  service.replaceCustomer(customerEntity,id);
    }
    @GetMapping("/findcustomer/{id}")
    Optional<CustomerEntity> findById(@PathVariable Long id) throws Exception {
        if (service.findCustomerById(id)==null) {
            System.out.println("No Customer Found");

        }
        return service.findCustomerById(id);
    }
    @GetMapping("/findcustomer/{name}")
    CustomerEntity findByName(@PathVariable String name) throws Exception {
        return service.findCustomerByName(name);
    }
}