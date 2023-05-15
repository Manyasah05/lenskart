package service;

import entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    public Optional<CustomerEntity> findCustomerById(long id) throws Exception;
    public CustomerEntity findCustomerByName(String name) throws Exception;
    public List<CustomerEntity> getAllCustomer();
    public CustomerEntity addNewCustomer(CustomerEntity newCustomer);
    public CustomerEntity replaceCustomer(CustomerEntity customerEntity, Long id) throws Exception;
}
