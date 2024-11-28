package ppkspringpractices.spring6restmvc.mappers;

import org.mapstruct.Mapper;
import ppkspringpractices.spring6restmvc.dto.CustomerDTO;
import ppkspringpractices.spring6restmvc.entities.Customer;

@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDTO dto);

    CustomerDTO customerToCustomerDTO(Customer customer);
}
