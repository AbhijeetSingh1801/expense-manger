package com.expensetracker.ui;

import java.awt.*;
import java.time.LocalDate;
import javax.swing.*;

public class AddExpenseDialog extends JDialog {
	private JTextField dateField;
	private JTextField categoryField;
	private JTextField descriptionField;
	private JTextField amountField;
	private boolean submitted = false;

	public AddExpenseDialog(JFrame parent) {
		super(parent, "Add Expense", true);	
		setLayout(new GridLayout(5, 2, 10, 10));
        setSize(400, 250);
        setLocationRelativeTo(parent);

		dateField = new JTextField(LocalDate.now().toString()); // Default today
        categoryField = new JTextField();
        descriptionField = new JTextField();
        amountField = new JTextField();

		JButton submitButton = new JButton("Add");
        JButton cancelButton = new JButton("Cancel");

		submitButton.addActionListener(e -> {
            submitted = true;
            setVisible(false);
        });

		cancelButton.addActionListener(e -> {
            submitted = false;
            setVisible(false);
        });

		add(new JLabel("Date (yyyy-mm-dd):"));
        add(dateField);
        add(new JLabel("Category:"));
        add(categoryField);
        add(new JLabel("Description:"));
        add(descriptionField);
        add(new JLabel("Amount:"));
        add(amountField);
        add(submitButton);
        add(cancelButton);
	}
	public boolean isSubmitted() {
        return submitted;
    }

    public String getDate() {
        return dateField.getText();
    }

    public String getCategory() {
        return categoryField.getText();
    }

    public String getDescription() {
        return descriptionField.getText();
    }

    public double getAmount() {
        return Double.parseDouble(amountField.getText());
    }


}
