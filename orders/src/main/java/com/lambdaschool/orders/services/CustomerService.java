package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Customer;
import java.util.List;

public interface CustomerService {

  List<Customer> findAll();

  Customer findCustomerByName(String name);

  Customer add(Customer customer);

  void delete(long id);

  Customer update(Customer customer);
}
