package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.services.CustomerService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

  @PostMapping(value = "", consumes = {"application/json"}, produces = {"application/json"})
  public ResponseEntity<?> addCustomer(@Valid @RequestBody Customer newCustomer) throws URISyntaxException {
    newCustomer = customerService.add(newCustomer);
    HttpHeaders responseHeaders = new HttpHeaders();
    URI newCustomerURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{custname}").buildAndExpand(newCustomer.getCustname()).toUri();
    responseHeaders.setLocation(newCustomerURI);
    return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
  }

  @PutMapping(value = "/{custcode}", consumes = {"application/json"}, produces = {"application/json"})
  public ResponseEntity<?> updateCustomer(@Valid @RequestBody Customer customer, @PathVariable long custcode) {
    customerService.update(customer, custcode);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping(value = "/{custcode}")
  public ResponseEntity<?> deleteCustomer(@PathVariable long custcode) {
    customerService.delete(custcode);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
