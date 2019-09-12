package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.repos.CustomersRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityNotFoundException;
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
    List<Customer> results = new ArrayList<>();
    custrepos.findAll().forEach(results::add);
    return results;
  }

  @Override
  public Customer findCustomerByName(String name) throws EntityNotFoundException {
    Customer result = custrepos.findByCustname(name);

    if (result == null) {
      throw new EntityNotFoundException("Customer " + name + " not found!");
    }

    return result;
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
