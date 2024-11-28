package ppkspringpractices.spring6restmvc.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ppkspringpractices.spring6restmvc.controller.NotFoundException;
import ppkspringpractices.spring6restmvc.dto.CustomerDTO;
import ppkspringpractices.spring6restmvc.mappers.CustomerMapper;
import ppkspringpractices.spring6restmvc.repositories.CustomerRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Primary
@RequiredArgsConstructor
public class CustomerServiceJPA implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerDTO> listCustomer() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::customerToCustomerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(UUID id) {
        return Optional.ofNullable(customerMapper
                .customerToCustomerDTO(customerRepository
                        .findById(id)
                        .orElseThrow(() -> new NotFoundException("User not found with username: "))));
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customer) {
        return null;
    }

    @Override
    public void updateCustomerById(UUID customerId, CustomerDTO customer) {

    }

    @Override
    public void deleteById(UUID customerId) {

    }
}
