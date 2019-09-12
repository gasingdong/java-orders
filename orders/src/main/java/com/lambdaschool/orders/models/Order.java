package com.lambdaschool.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long ordnum;

  private double ordamount;
  private double advanceamount;
  private String orddescription;

  @ManyToOne
  @JoinColumn(name = "custcode", nullable = false)
  @JsonIgnoreProperties("customers")
  private Customer customer;

  public Order(double ordamount, double advanceamount, String orddescription, Customer customer) {
    this.ordamount = ordamount;
    this.advanceamount = advanceamount;
    this.orddescription = orddescription;
    this.customer = customer;
  }

  public Order() {
  }

  public long getOrdnum() {
    return ordnum;
  }

  public void setOrdnum(long ordnum) {
    this.ordnum = ordnum;
  }

  public double getOrdamount() {
    return ordamount;
  }

  public void setOrdamount(double ordamount) {
    this.ordamount = ordamount;
  }

  public double getAdvanceamount() {
    return advanceamount;
  }

  public void setAdvanceamount(double advanceamount) {
    this.advanceamount = advanceamount;
  }

  public String getOrddescription() {
    return orddescription;
  }

  public void setOrddescription(String orddescription) {
    this.orddescription = orddescription;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
}
