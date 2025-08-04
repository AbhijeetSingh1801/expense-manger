package com.expensetracker.ui;

import java.awt.*;
import javax.swing.*;

public class ActionPanel extends JPanel {
    public JButton addBtn;
    public JButton deleteBtn;

    public ActionPanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER));

        addBtn = new JButton("Add Expense");
        deleteBtn = new JButton("Delete Selected");

        add(addBtn);
        add(deleteBtn);
    }
}
