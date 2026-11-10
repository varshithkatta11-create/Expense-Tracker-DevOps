package com.example.expensetracker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
@Controller
public class ExpenseController {
 private final ExpenseRepository repository;
 public ExpenseController(ExpenseRepository repository){this.repository=repository;}
 @GetMapping("/") public String home(Model model){
  model.addAttribute("expenses", repository.findAll());
  model.addAttribute("total", repository.findAll().stream().mapToDouble(Expense::getAmount).sum());
  model.addAttribute("expense", new Expense());
  return "index";
 }
 @PostMapping("/add") public String add(@RequestParam String title, @RequestParam String category,
   @RequestParam double amount, @RequestParam String expenseDate){
  if(title == null || title.isBlank() || amount <= 0) return "redirect:/";
  repository.save(new Expense(title.trim(), category, amount, LocalDate.parse(expenseDate)));
  return "redirect:/";
 }
 @PostMapping("/delete/{id}") public String delete(@PathVariable Long id){
  repository.deleteById(id); return "redirect:/";
 }
}
