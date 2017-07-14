package com.monitor.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "expenses")
public class Expense {

  @Id
  @GeneratedValue
  private Integer expenseId;

  @Column(name = "amount")
  private Double amount;

  @Column(name = "expensedate")
  private Date expenseDate;

  @Column(name = "name")
  private String name;

  @Column(name = "place")
  private String place;

  @ManyToOne
  @JoinColumn(name = "categoryid")
  private Category category;

  @ManyToOne
  @JoinColumn(name = "userid")
  private User user;

  public Integer getExpenseId() {
    return expenseId;
  }

  public void setExpenseId(Integer expenseId) {
    this.expenseId = expenseId;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Date getExpenseDate() {
    return expenseDate;
  }

  public void setExpenseDate(Date expenseDate) {
    this.expenseDate = expenseDate;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPlace() {
    return place;
  }

  public void setPlace(String place) {
    this.place = place;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }
}
