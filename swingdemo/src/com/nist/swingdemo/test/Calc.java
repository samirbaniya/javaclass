package com.nist.swingdemo.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Calc {
	public static void main(String[] args) {
		JFrame jframe = new JFrame();
		jframe.setSize(400,400);
		jframe.setResizable(false);
		jframe.setLayout(null);
		jframe.setTitle("Calculator");
		
		
		JLabel l1 = new JLabel("First Number:");
		l1.setBounds(10,10,100,30);
		jframe.add(l1);
		
		JTextField t1 = new JTextField();
		t1.setBounds(120,10,100,30);
		jframe.add(t1);
		
		JLabel l2 = new JLabel("Second Number:");
		l2.setBounds(10,60,100,30);
		jframe.add(l2);
		
		JTextField t2 =new JTextField();
		t2.setBounds(120, 60, 100, 30);
		jframe.add(t2);
		
		JLabel l3 = new JLabel("Total:");
		l3.setBounds(10, 110, 100, 30);
		jframe.add(l3);
		
		JTextField t3 = new JTextField();
		t3.setBounds(120, 110, 100, 30);
		t3.setEditable(false);
		jframe.add(t3);
		
		JButton addbtn = new JButton("+");
		addbtn.setBounds(10, 160, 100, 30);
		jframe.add(addbtn);
		
		MouseListener listener = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				String num1 = t1.getText();//"20"
				String num2 = t2.getText();//"10"
				int a = Integer.parseInt(num1);//20
				int b = Integer.parseInt(num2);//10
				int c = a - b;//10
				String result = String.valueOf(c);//"10"
				t3.setText(result);				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				String num1 = t1.getText();//"20"
				String num2 = t2.getText();//"10"
				int a = Integer.parseInt(num1);//20
				int b = Integer.parseInt(num2);//10
				int c = a + b;//30
				String result = String.valueOf(c);//"30"
				t3.setText(result);				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				String num1 = t1.getText();//"20"
				String num2 = t2.getText();//"10"
				int a = Integer.parseInt(num1);//20
				int b = Integer.parseInt(num2);//10
				int c = a / b;//2
				String result = String.valueOf(c);//"2"
				t3.setText(result);				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				String num1 = t1.getText();//"20"
				String num2 = t2.getText();//"10"
				int a = Integer.parseInt(num1);//20
				int b = Integer.parseInt(num2);//10
				int c = a * b;//200
				String result = String.valueOf(c);//"200"
				t3.setText(result);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				String num1 = t1.getText();//"20"
				String num2 = t2.getText();//"10"
				int a = Integer.parseInt(num1);//20
				int b = Integer.parseInt(num2);//10
				int c = a +a;//40
				String result = String.valueOf(c);//"40"
				t3.setText(result);				
			}
		};
		
		addbtn.addMouseListener(listener);
		
		jframe.setVisible(true);

}
}
