package javaPractical;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeApp4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Welcome App");
        frame.setSize(400, 200);
        frame.setLayout(null);

        // Create the text field
        JTextField textField = new JTextField();
        textField.setBounds(50, 50, 250, 30);
        frame.add(textField);

        // Create the "OK" button
        JButton okButton = new JButton("OK");
        okButton.setBounds(50, 100, 100, 30);
        frame.add(okButton);

        // Create the "Clear" button
        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(170, 100, 100, 30);
        frame.add(clearButton);

        // Action listener for the "OK" button
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("Welcome");
            }
        });

        // Action listener for the "Clear" button
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
            }
        });

        frame.setVisible(true);
    }
}
