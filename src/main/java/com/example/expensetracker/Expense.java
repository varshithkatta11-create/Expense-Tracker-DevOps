package com.example.expensetracker;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
public class Expense {
 @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
 private String title;
 private String category;
 private double amount;
 private LocalDate expenseDate;
 public Expense() {}
 public Expense(String title, String category, double amount, LocalDate expenseDate) {
  this.title=title; this.category=category; this.amount=amount; this.expenseDate=expenseDate;
 }
 public Long getId(){return id;} public String getTitle(){return title;} public void setTitle(String v){title=v;}
 public String getCategory(){return category;} public void setCategory(String v){category=v;}
 public double getAmount(){return amount;} public void setAmount(double v){amount=v;}
 public LocalDate getExpenseDate(){return expenseDate;} public void setExpenseDate(LocalDate v){expenseDate=v;}
}
