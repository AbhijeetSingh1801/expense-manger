package com.expensetracker.ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ExpenseTablePanel extends JPanel {

    private JTable table;
    private DefaultTableModel tableModel;

    public ExpenseTablePanel() {
        setLayout(new BorderLayout());

        String[] columns = { "Date", "Category", "Description", "Amount" };
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);
    }

    // Method to add a row
    public void addExpense(String date, String category, String description, double amount) {
        tableModel.addRow(new Object[]{ date, category, description, amount });
    }

    public double getTotalExpenses() {
        double sum = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            sum += (double) tableModel.getValueAt(i, 3); // amount column
        }
        return sum;
    }
    
}
