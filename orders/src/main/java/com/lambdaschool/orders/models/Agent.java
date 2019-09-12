package com.lambdaschool.orders.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "agents")
public class Agent {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long agentcode;

  @Column(unique = true, nullable = false)
  private String agentname;

  private String workingarea;
  private double commission;
  private String phone;
  private String country;

  public Agent(String agentname, String workingarea, double commission, String phone,
      String country) {
    this.agentname = agentname;
    this.workingarea = workingarea;
    this.commission = commission;
    this.phone = phone;
    this.country = country;
  }

  public Agent() {
  }

  public long getAgentcode() {
    return agentcode;
  }

  public void setAgentcode(long agentcode) {
    this.agentcode = agentcode;
  }

  public String getAgentname() {
    return agentname;
  }

  public void setAgentname(String agentname) {
    this.agentname = agentname;
  }

  public String getWorkingarea() {
    return workingarea;
  }

  public void setWorkingarea(String workingarea) {
    this.workingarea = workingarea;
  }

  public double getCommission() {
    return commission;
  }

  public void setCommission(double commission) {
    this.commission = commission;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }
}