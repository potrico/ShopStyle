package com.ms.customer.service;

import com.ms.customer.entity.Customer;
import com.ms.customer.dto.CustomerDTO;
import com.ms.customer.dto.CustomerFormDTO;
import com.ms.customer.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public CustomerDTO save(CustomerFormDTO body) {
        Customer customer = mapper.map(body, Customer.class);
        Customer customerResponse = this.repository.save(customer);
        return mapper.map(customerResponse, CustomerDTO.class);
    }

    @Override
    public CustomerDTO search(Long id) {
        Optional<Customer> customer = this.repository.findById(id);
        if (customer.isPresent()){
            return mapper.map(customer.get(), CustomerDTO.class);
        }
        throw new RuntimeException("Usuario não encontrado");
    }

    @Override
    public CustomerDTO update(Long id, CustomerFormDTO body) {
        Optional<Customer> customer = this.repository.findById(id);
        if (customer.isPresent()) {
            Customer customerToUpdate = mapper.map(body, Customer.class);
            customerToUpdate.setId(id);
            Customer updatedCustomer = repository.save(customerToUpdate);

            return mapper.map(updatedCustomer, CustomerDTO.class);
        }
        throw new RuntimeException("Usuario não encontrado");
    }

}
