package com.expensetracker.ui;

import java.time.LocalDate;
import java.util.Scanner;

import com.expensetracker.model.Expense;
import com.expensetracker.service.ExpenseManager;

public class ConsoleUI {
    private final ExpenseManager manager = new ExpenseManager();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("=== Welcome to Expense Tracker ===");

        boolean running = true;
        while (running) {
            System.out.println("\n1. Add Expense\n2. View All Expenses\n3. View Total\n4. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear newline

            switch (choice) {
                case 1 -> addExpense();
                case 2 -> viewExpenses();
                case 3 -> viewTotal();
                case 4 -> running = false;
                default -> System.out.println("Invalid choice.");
            }
        }

        System.out.println("Goodbye!");
    }

    private void addExpense() {
        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        Expense expense = new Expense(category, amount, LocalDate.now());
        manager.addExpense(expense);

        System.out.println("✅ Expense added.");
    }

    private void viewExpenses() {
        System.out.println("Expenses:");
        for (Expense e : manager.getAllExpenses()) {
            System.out.println(e);
        }
    }

    private void viewTotal() {
        double total = manager.getTotalExpense();
        System.out.printf("Total Expense: ₹%.2f%n", total);
    }
    
}