/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.expensetracker.ui;

/**
 *
 * @author abhijeetsingh
 */
import java.awt.*;
import javax.swing.*;

public class DashBoardPannel extends JPanel {

	private JLabel incomeLabel;
	private JLabel expenseLabel;
	private JLabel balanceLabel;

	public DashBoardPannel() {
		setLayout(new GridLayout(1, 3));
        	setBorder(BorderFactory.createTitledBorder("Summary"));

		incomeLabel = new JLabel("Income: ₹0.0");
		expenseLabel = new JLabel("Expenses: ₹0.0");
		balanceLabel = new JLabel("Balance: ₹0.0");

		incomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		expenseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		balanceLabel.setHorizontalAlignment(SwingConstants.CENTER);

		add(incomeLabel);
		add(expenseLabel);
		add(balanceLabel);
	}

	public void updateSummary(double income, double expenses) {
        incomeLabel.setText("Income: ₹" + income);
        expenseLabel.setText("Expenses: ₹" + expenses);
        balanceLabel.setText("Balance: ₹" + (income - expenses));
    }
}
