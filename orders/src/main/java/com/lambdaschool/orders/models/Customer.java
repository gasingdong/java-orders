package com.lambdaschool.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long custcode;

  @Column(nullable = false)
  private String custname;

  private String custcity;
  private String workingarea;
  private String custcountry;
  private String grade;
  private Double openingamt;
  private Double receiveamt;
  private Double paymentamt;
  private Double outstandingamt;
  private String phone;

  @ManyToOne
  @JoinColumn(name = "agentcode", nullable = false)
  @JsonIgnoreProperties("agents")
  private Agent agent;

  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonIgnoreProperties("customer")
  private List<Order> orders = new ArrayList<>();

  public Customer(String custname, String custcity, String workingarea, String custcountry,
      String grade, Double openingamt, Double receiveamt, Double paymentamt, Double outstandingamt,
      String phone, Agent agent) {
    this.custname = custname;
    this.custcity = custcity;
    this.workingarea = workingarea;
    this.custcountry = custcountry;
    this.grade = grade;
    this.openingamt = openingamt;
    this.receiveamt = receiveamt;
    this.paymentamt = paymentamt;
    this.outstandingamt = outstandingamt;
    this.phone = phone;
    this.agent = agent;
  }

  public Customer() {
  }

  public long getCustcode() {
    return custcode;
  }

  public void setCustcode(long custcode) {
    this.custcode = custcode;
  }

  public String getCustname() {
    return custname;
  }

  public void setCustname(String custname) {
    this.custname = custname;
  }

  public String getCustcity() {
    return custcity;
  }

  public void setCustcity(String custcity) {
    this.custcity = custcity;
  }

  public String getWorkingarea() {
    return workingarea;
  }

  public void setWorkingarea(String workingarea) {
    this.workingarea = workingarea;
  }

  public String getCustcountry() {
    return custcountry;
  }

  public void setCustcountry(String custcountry) {
    this.custcountry = custcountry;
  }

  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

  public Double getOpeningamt() {
    return openingamt;
  }

  public void setOpeningamt(Double openingamt) {
    this.openingamt = openingamt;
  }

  public Double getReceiveamt() {
    return receiveamt;
  }

  public void setReceiveamt(Double receiveamt) {
    this.receiveamt = receiveamt;
  }

  public Double getPaymentamt() {
    return paymentamt;
  }

  public void setPaymentamt(Double paymentamt) {
    this.paymentamt = paymentamt;
  }

  public Double getOutstandingamt() {
    return outstandingamt;
  }

  public void setOutstandingamt(Double outstandingamt) {
    this.outstandingamt = outstandingamt;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Agent getAgent() {
    return agent;
  }

  public void setAgent(Agent agent) {
    this.agent = agent;
  }

  public List<Order> getOrders() {
    return orders;
  }

  public void setOrders(List<Order> orders) {
    this.orders = orders;
  }
}
