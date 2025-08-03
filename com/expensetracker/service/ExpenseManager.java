package com.expensetracker.service;

import com.expensetracker.model.Expense;
import java.util.*;

public class ExpenseManager {
	private List<Expense> expenses = new ArrayList<>();

	public ExpenseManager() {
		this.expenses = new ArrayList<>();
	}

	public void addExpense(Expense expense) {
		expenses.add(expense);
	}
    
	public List<Expense> getAllExpenses() {
		return new ArrayList<>(expenses);
	}

	public double getTotalExpense() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.getAmount();
        }
        return total;
    }
}
