package javaPractical;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Q3ColorButtonApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Color Button App");
        frame.setSize(400, 300);
        frame.setLayout(null);

        JButton redButton = new JButton("RED");
        redButton.setBounds(50, 50, 100, 30);
        frame.add(redButton);

        JButton blueButton = new JButton("BLUE");
        blueButton.setBounds(50, 100, 100, 30);
        frame.add(blueButton);

        JButton greenButton = new JButton("GREEN");
        greenButton.setBounds(50, 150, 100, 30);
        frame.add(greenButton);

        JLabel resultLabel = new JLabel("Color will be displayed here");
        

        redButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultLabel.setText("RED");
                resultLabel.setForeground(Color.RED);
            }
        });
        resultLabel.setBounds(50, 200, 300, 30);
        frame.add(resultLabel);
        
        blueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultLabel.setText("BLUE");
                resultLabel.setForeground(Color.BLUE);
            }
        });

        greenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultLabel.setText("GREEN");
                resultLabel.setForeground(Color.GREEN);
            }
        });

        frame.setVisible(true);
    }
}
