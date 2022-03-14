package com.ms.customer.service;

import com.ms.customer.dto.CustomerDTO;
import com.ms.customer.dto.CustomerFormDTO;
import org.springframework.stereotype.Component;

@Component
public interface CustomerService {

    CustomerDTO save(CustomerFormDTO body);

    CustomerDTO search(Long id);

    CustomerDTO update(Long id, CustomerFormDTO body);

}
