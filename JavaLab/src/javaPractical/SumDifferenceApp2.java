package javaPractical;

import javax.swing.*;
import java.awt.event.*;

public class SumDifferenceApp2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sum and Difference Finder");
        frame.setSize(400, 300);
        frame.setLayout(null);

        JLabel l1 = new JLabel("First Number:");
        l1.setBounds(50, 30, 100, 30);
        frame.add(l1);

        JTextField t1 = new JTextField();
        t1.setBounds(150, 30, 150, 30);
        frame.add(t1);

        JLabel l2 = new JLabel("Second Number:");
        l2.setBounds(50, 70, 100, 30);
        frame.add(l2);

        JTextField t2 = new JTextField();
        t2.setBounds(150, 70, 150, 30);
        frame.add(t2);

        JLabel l3 = new JLabel("Result:");
        l3.setBounds(50, 110, 100, 30);
        frame.add(l3);

        JTextField outputField = new JTextField();
        outputField.setBounds(150, 110, 150, 30);
        outputField.setEditable(false);
        frame.add(outputField);

        JLabel instructionLabel = new JLabel("Press or release the mouse to calculate.");
        instructionLabel.setBounds(50, 150, 300, 30);
        frame.add(instructionLabel);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(50, 190, 100, 30);
        frame.add(calculateButton);

        calculateButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    int num1 = Integer.parseInt(t1.getText());
                    int num2 = Integer.parseInt(t2.getText());
                    int sum = num1 + num2;
                    outputField.setText("Sum: " + sum);
                } catch (Exception ex) {
                    outputField.setText("Invalid input!");
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                try {
                    int num1 = Integer.parseInt(t1.getText());
                    int num2 = Integer.parseInt(t2.getText());
                    int difference = num1 - num2;
                    outputField.setText("Difference: " + difference);
                } catch (Exception ex) {
                    outputField.setText("Invalid input!");
                }
            }
        });

        frame.setVisible(true);
    }
}
