package javaPractical;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Q1NumberComparisonApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Number Comparison");
        frame.setSize(400, 300);
        frame.setLayout(null);

        JLabel l1 = new JLabel("First Number:");
        l1.setBounds(50, 10, 100, 30);
        frame.add(l1);

        JTextField t1 = new JTextField();
        t1.setBounds(150, 10, 150, 30);
        frame.add(t1);

        JLabel l2 = new JLabel("Second Number:");
        l2.setBounds(50, 50, 100, 30);
        frame.add(l2);

        JTextField t2 = new JTextField();
        t2.setBounds(150, 50, 150, 30);
        frame.add(t2);

        JLabel l3 = new JLabel("Result will be displayed here");
        l3.setBounds(50, 120, 300, 30);
        frame.add(l3);

        JButton smallButton = new JButton("Small");
        smallButton.setBounds(50, 170, 100, 30);
        frame.add(smallButton);

        JButton largeButton = new JButton("Large");
        largeButton.setBounds(170, 170, 100, 30);
        frame.add(largeButton);

        smallButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(t1.getText());
                    double num2 = Double.parseDouble(t2.getText());
                    double smaller = (num1 < num2) ? num1 : num2;
                    l3.setText("Smaller: " + smaller);
                } catch (Exception ex) {
                    l3.setText("Invalid input! Please enter numbers.");
                }
            }
        });

        largeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(t1.getText());
                    double num2 = Double.parseDouble(t2.getText());
                    double larger = (num1 > num2) ? num1 : num2;
                    l3.setText("Larger: " + larger);
                } catch (Exception ex) {
                    l3.setText("Invalid input! Please enter numbers.");
                }
            }
        });

        frame.setVisible(true);
    }
}
