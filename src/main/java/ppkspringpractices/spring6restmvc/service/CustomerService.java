package ppkspringpractices.spring6restmvc.service;

import ppkspringpractices.spring6restmvc.modal.Beer;
import ppkspringpractices.spring6restmvc.modal.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    List<Customer> listCustomer();

    Customer getCustomerById(UUID id);

    Customer saveNewCustomer(Customer customer);

    void updateCustomerById(UUID customerId, Customer customer);
}
