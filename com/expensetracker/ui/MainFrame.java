
package com.expensetracker.ui;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author abhijeetsingh
 */
public class MainFrame extends JFrame {
	public MainFrame() {
		setTitle("Expense Manager");                // Window title
		setSize(800, 600);                          // Width x Height
		setDefaultCloseOperation(EXIT_ON_CLOSE);    // Close app on X
		setLocationRelativeTo(null);                // Center the window
		setLayout(new BorderLayout());              // Layout manager

		ActionPanel actionPanel = new ActionPanel();
		DashBoardPannel dashboardPanel = new DashBoardPannel();
		ExpenseTablePanel tablePanel = new ExpenseTablePanel();
		// You can add panels later like:
		add(dashboardPanel, BorderLayout.NORTH);
		add(tablePanel, BorderLayout.CENTER);
		add(actionPanel, BorderLayout.SOUTH);

		// After defining tablePanel, dashboardPanel, and actionPanel
		actionPanel.addBtn.addActionListener(e -> {
			AddExpenseDialog dialog = new AddExpenseDialog(this);
			dialog.setVisible(true);
		
			if (dialog.isSubmitted()) {
			String date = dialog.getDate();
			String category = dialog.getCategory();
			String description = dialog.getDescription();
			double amount = dialog.getAmount();
		
			tablePanel.addExpense(date, category, description, amount);
		
			// Optional: update summary — assume income is fixed, e.g., ₹10,000
			dashboardPanel.updateSummary(10000, tablePanel.getTotalExpenses());
			}
		});
	}
}
