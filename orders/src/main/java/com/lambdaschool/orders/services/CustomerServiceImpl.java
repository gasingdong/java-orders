package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Agent;
import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.models.Order;
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

  @Transactional
  @Override
  public Customer add(Customer customer) {
    Customer newCustomer = new Customer();

    newCustomer.setCustname(customer.getCustname());
    newCustomer.setAgent(customer.getAgent());
    newCustomer.setCustcity(customer.getCustcity());
    newCustomer.setCustcountry(customer.getCustcountry());
    newCustomer.setGrade(customer.getGrade());
    newCustomer.setWorkingarea(customer.getWorkingarea());
    newCustomer.setPhone(customer.getPhone());
    newCustomer.setOpeningamt(customer.getOpeningamt());
    newCustomer.setReceiveamt(customer.getReceiveamt());
    newCustomer.setPaymentamt(customer.getPaymentamt());
    newCustomer.setOutstandingamt(customer.getOutstandingamt());

    for (Order order : customer.getOrders()) {
      newCustomer.getOrders().add(
          new Order(order.getOrdamount(), order.getAdvanceamount(), newCustomer,
              order.getOrddescription()));
    }

    return custrepos.save(newCustomer);
  }

  @Override
  public void delete(long id) {

    if (custrepos.findById(id).isPresent()) {
      custrepos.deleteById(id);
    } else {
      throw new EntityNotFoundException(Long.toString(id));
    }
  }

  @Transactional
  @Override
  public Customer update(Customer customer, long id) {
    Customer currentCustomer = custrepos.findById(id)
        .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

    String custname = customer.getCustname();
    Agent agent = customer.getAgent();
    String custcity = customer.getCustcity();
    String custcountry = customer.getCustcountry();
    String grade = customer.getGrade();
    String workingarea = customer.getWorkingarea();
    String phone = customer.getPhone();
    Double openingamt = customer.getOpeningamt();
    Double receiveamt = customer.getReceiveamt();
    Double paymentamt = customer.getPaymentamt();
    Double outstandingamt = customer.getOutstandingamt();

    if (custname != null) {
      currentCustomer.setCustname(custname);
    }

    if (agent != null) {
      currentCustomer.setAgent(agent);
    }

    if (custcity != null) {
      currentCustomer.setCustcity(custcity);
    }

    if (custcountry != null) {
      currentCustomer.setCustcountry(custcountry);
    }

    if (grade != null) {
      currentCustomer.setGrade(grade);
    }

    if (workingarea != null) {
      currentCustomer.setWorkingarea(workingarea);
    }

    if (phone != null) {
      currentCustomer.setPhone(phone);
    }

    if (openingamt != null) {
      currentCustomer.setOpeningamt(openingamt);
    }

    if (receiveamt != null) {
      currentCustomer.setReceiveamt(receiveamt);
    }

    if (paymentamt != null) {
      currentCustomer.setPaymentamt(paymentamt);
    }

    if (outstandingamt != null) {
      currentCustomer.setOutstandingamt(outstandingamt);
    }

    return custrepos.save(currentCustomer);
  }
}
