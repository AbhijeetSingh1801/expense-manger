package com.expensetracker.service;

import java.util.*;

import com.expensetracker.model.Expense;
import com.expensetracker.util.FileUtil;

public class ExpenseManager {
	private List<Expense> expenses = new ArrayList<>();

	public ExpenseManager() {
		this.expenses = FileUtil.loadExpenses();
	}

	public void addExpense(Expense expense) {
		expenses.add(expense);
        FileUtil.saveExpenses(expenses); 
	}
    
	public List<Expense> getAllExpenses() {
		return new ArrayList<>(expenses);
	}

	public double getTotalExpense() {
        return expenses.stream().mapToDouble(Expense::getAmount).sum();
    }
}
