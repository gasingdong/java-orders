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
}
