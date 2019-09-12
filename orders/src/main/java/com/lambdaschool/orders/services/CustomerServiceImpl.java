package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.repos.CustomersRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomersRepository custrepos;

  @Override
  public List<Customer> findAll() {
    return null;
  }

  @Override
  public Customer findCustomerByName() {
    return null;
  }

  @Override
  public Customer add(Customer customer) {
    return null;
  }

  @Override
  public void delete(long id) {

  }

  @Override
  public Customer update(Customer customer) {
    return null;
  }
}
