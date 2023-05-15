package service;

import entity.CustomerEntity;
import repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<CustomerEntity> findCustomerById(long id) throws Exception {
        Optional<CustomerEntity> customerEntity = repository.findById(id);
        if (!customerEntity.isPresent()) {
            throw new Exception("Customer not found");
        }
        return customerEntity;
    }

    @Override
    public CustomerEntity findCustomerByName(String name) throws Exception {
        CustomerEntity customerEntity = repository.findByName(name);
        if (customerEntity == null) {
            throw new Exception("Customer not found");
        }
        return customerEntity;
    }

    @Override
    public List<CustomerEntity> getAllCustomer() {
        return repository.findAll();
    }

    @Override
    public CustomerEntity addNewCustomer(CustomerEntity newCustomer) {
        return repository.save(newCustomer);
    }

    @Override
    public CustomerEntity replaceCustomer(CustomerEntity customerEntity, Long id) throws Exception {
        Optional<CustomerEntity> optionalCustomer = repository.findById(id);
        if (!optionalCustomer.isPresent()) {
            throw new Exception("Customer not found");
        }
        CustomerEntity customer = optionalCustomer.get();
        customer.setId(customerEntity.getId());
        customer.setName(customerEntity.getName());
        customer.setEmail(customerEntity.getEmail());
        customer.setNumber(customerEntity.getNumber());
        return repository.save(customer);
    }
}
