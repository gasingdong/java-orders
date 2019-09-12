package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.services.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @GetMapping(value = "", produces = {"application/json"})
  public ResponseEntity<?> listAllCustomers() {
    List<Customer> results = customerService.findAll();
    return new ResponseEntity<>(results, HttpStatus.OK);
  }

  @GetMapping(value = "/{custname}", produces = {"application/json"})
  public ResponseEntity<?> getCustomerByName(@PathVariable String custname) {
    Customer result = customerService.findCustomerByName(custname);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }
}
