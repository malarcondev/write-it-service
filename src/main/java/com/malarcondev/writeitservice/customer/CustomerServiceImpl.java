package com.malarcondev.writeitservice.customer;

import com.malarcondev.writeitservice.core.ApplicationUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService{

    private final CustomerRepository customerRepository;
    @Override
    public UUID createCustomer(ApplicationUser applicationUser, CreateCustomerRequest createCustomerRequest){
        Customer customer = new Customer(applicationUser);
        customer.setUser(applicationUser);
        customer.setAge(createCustomerRequest.age());
        customer.setAddress(createCustomerRequest.address());
        customerRepository.save(customer);
        return customer.getId();
    }

    @Override
    public Customer getCustomerById(UUID customer_id) {
        return null;
    }

    @Override
    public RetrieveCustomerRequest RetrieveCustomerById(UUID customer_id) {
        return null;
    }

    @Override
    public RetrieveCustomerRequest updateCustomer(UUID customerId, UpdateCustomerRequest updateCustomerRequest) {
        return null;
    }

    @Override
    public Customer getCustomerByUserId(UUID user_id) {
        return null;
    }
}
