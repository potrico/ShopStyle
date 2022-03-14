package com.ms.customer.controller;

import com.ms.customer.dto.CustomerDTO;
import com.ms.customer.dto.CustomerFormDTO;
import com.ms.customer.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1",produces= "application/json")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl service;

    @PostMapping(path = "/users")
    public ResponseEntity<CustomerDTO> save(@RequestBody CustomerFormDTO body) {
        CustomerDTO customer = this.service.save(body);
        return ResponseEntity.ok(customer);
    }

    @GetMapping(path = "/users/{id}")
    public ResponseEntity<CustomerDTO> search (@PathVariable(value = "id") Long id){
        return ResponseEntity.ok(this.service.search(id));
    }

    @PutMapping(path = "/users/{id}")
    public ResponseEntity<CustomerDTO> update (@PathVariable(value = "id") Long id, @RequestBody CustomerFormDTO body){
        return ResponseEntity.ok(this.service.update(id,body));
    }

}
