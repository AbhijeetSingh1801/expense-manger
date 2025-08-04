package com.expensetracker.util;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

import com.expensetracker.model.Expense;

public class FileUtil {
	private static final String FILE_PATH = "expenses.csv";

	public static void saveExpenses(List<Expense> expenses){
		try(PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH)))  {
			for (Expense e : expenses) {
				writer.println(e.getCategory() + "," + e.getAmount() + "," + e.getDate());
			  }
		} catch (Exception e) {
			System.out.println("Error saving expenses: " + e.getMessage());
		}
	}

	public static List<Expense> loadExpenses() {
		List<Expense> expenses = new ArrayList<>();
		File file = new File(FILE_PATH);
		if (!file.exists()) {
			return expenses;
		}
		try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if(parts.length == 3) {
					String category = parts[0];
					double amount = Double.parseDouble(parts[1]);
					LocalDate date = LocalDate.parse(parts[2]);
					expenses.add(new Expense(category, amount, date));
				}
			}
		} catch (Exception e) {
			System.out.println("Error loading expenses: " + e.getMessage());
		}
		return expenses;
	}
}
