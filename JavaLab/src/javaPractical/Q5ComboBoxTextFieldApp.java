package javaPractical;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Q5ComboBoxTextFieldApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("ComboBox to TextField");
        frame.setSize(400, 200);
        frame.setLayout(null);

        // Create a combo box with items
        String[] items = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBox.setBounds(50, 50, 150, 30);
        frame.add(comboBox);

        // Create a text field
        JTextField textField = new JTextField();
        textField.setBounds(50, 100, 150, 30);
        frame.add(textField);

        // Action listener for combo box selection
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) comboBox.getSelectedItem();
                textField.setText(selectedItem);
            }
        });

        frame.setVisible(true);
    }
}
