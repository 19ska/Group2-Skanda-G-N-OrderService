package com.demo.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.dto.CustomerDTO;
import com.demo.entities.Customers;
import com.demo.repositories.CustomerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<CustomerDTO> createCustomer(CustomerDTO customerDTO) {
        Customers customer = modelMapper.map(customerDTO, Customers.class);
        Customers savedCustomer = customerRepository.save(customer);
        CustomerDTO savedCustomerDTO = modelMapper.map(savedCustomer, CustomerDTO.class);
        return new ResponseEntity<>(savedCustomerDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CustomerDTO> getCustomerById(Long customerId) {
        Customers customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with ID: " + customerId));
        CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<Customers> customers = customerRepository.findAll();
        List<CustomerDTO> customerDTOs = customers.stream()
                .map(customer -> modelMapper.map(customer, CustomerDTO.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(customerDTOs, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> updateCustomer(Long customerId, CustomerDTO customerDTO) {
        Customers existingCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with ID: " + customerId));

        // Update existingCustomer fields with values from customerDTO
        modelMapper.map(customerDTO, existingCustomer);

        customerRepository.save(existingCustomer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
