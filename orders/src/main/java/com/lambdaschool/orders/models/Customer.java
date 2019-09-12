package com.lambdaschool.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
  private String openingamt;
  private String receiveamt;
  private String outstandingamt;
  private String phone;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "agentcode", nullable = false)
  @JsonIgnoreProperties("agents")
  private Agent agent;

  public Customer(String custname, String custcity, String workingarea, String custcountry,
      String grade, String openingamt, String receiveamt, String outstandingamt,
      String phone, Agent agent) {
    this.custname = custname;
    this.custcity = custcity;
    this.workingarea = workingarea;
    this.custcountry = custcountry;
    this.grade = grade;
    this.openingamt = openingamt;
    this.receiveamt = receiveamt;
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

  public String getOpeningamt() {
    return openingamt;
  }

  public void setOpeningamt(String openingamt) {
    this.openingamt = openingamt;
  }

  public String getReceiveamt() {
    return receiveamt;
  }

  public void setReceiveamt(String receiveamt) {
    this.receiveamt = receiveamt;
  }

  public String getOutstandingamt() {
    return outstandingamt;
  }

  public void setOutstandingamt(String outstandingamt) {
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
}
