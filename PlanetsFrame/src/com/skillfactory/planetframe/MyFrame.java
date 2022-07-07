package com.skillfactory.planetframe;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.AttributeSet.ColorAttribute;
import java.text.Format;
import java.text.NumberFormat;
import java.util.Arrays;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame {

	protected String content;
	ResultFrame resultFrame;

	public MyFrame() {
		
		setSize(824, 666);
		setTitle("Planetary Calculator");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(860, 222));
		panel.setBackground(Color.darkGray);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));

		JLabel label1 = new JLabel();
		label1.setText("Find out the tribe and the ascension tribe of the number!");
		label1.setBackground(Color.pink);
		label1.setOpaque(true);
		label1.setForeground(Color.black);
		label1.setFont(new Font("Consolas", Font.PLAIN, 23));
		label1.setBounds(17, 17, 300, 180);
		JLabel label5 = new JLabel();
		label5.setText("Enter the number:");
		label5.setBackground(Color.pink);
		label5.setOpaque(true);
		label5.setForeground(Color.black);
		label5.setFont(new Font("Consolas", Font.ITALIC, 31));
		label5.setBounds(17, 17, 300, 180);
		panel.add(label1);
		panel.add(label5);
		add(panel, BorderLayout.NORTH);
		
		
		JPanel panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension(674, 189));
		panel2.setBackground(Color.darkGray);
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 50));
		
		JTextField inputField = new JTextField(null);
		inputField.setPreferredSize(new Dimension(674, 178));
		inputField.setFont(new Font("Consolas", Font.BOLD, 29));
		inputField.setForeground(Color.black); // text color
		inputField.setBackground(Color.yellow); // background color
		inputField.setCaretColor(Color.red); // caret color
		panel2.add(inputField);

		add(panel2);

		JPanel panel3 = new JPanel();
		panel3.setPreferredSize(new Dimension(860, 222));
		panel3.setBackground(Color.darkGray);
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 33, 33));

		JButton button = new JButton();
		button.setFocusable(false);
		button.setFont(new Font("Monospaced", Font.ITALIC, 22));
		button.setForeground(Color.red);
		button.setBackground(Color.green);
		button.setPreferredSize(new Dimension(177, 97));
		button.setText("GO!");

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				content = inputField.getText();
				if (inputField.getText().length() < 1) {
					JOptionPane.showMessageDialog(null, "Please, enter the number", "Correction needed",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (hasNumbers(content) == false) {
					inputField.setText(null);
					JOptionPane.showMessageDialog(null, "Please, enter some number", "Correction needed",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (inputField.getText().length() > 10){ 
					JOptionPane.showMessageDialog(null, "Please enter a smaller number", "Correction needed",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					new ResultFrame(process(content));
					inputField.setText(null);
				}
			}

		});
		panel3.add(button);

		JButton button2 = new JButton();
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Terminated.");
				System.exit(0);

			}

		});
		button2.setFocusable(false);
		button2.setFont(new Font("Monospaced", Font.ITALIC, 22));
		button2.setForeground(Color.red);
		button2.setBackground(Color.green);
		button2.setPreferredSize(new Dimension(177, 97));
		button2.setText("Exit");
		panel3.add(button2);

		add(panel3, BorderLayout.SOUTH);

		setVisible(true);

	}

	public static boolean hasNumbers(String text) {
		char[] chars = text.toCharArray();
		boolean answer = false;
		for (char a : chars) {
			if (a == '0' || a == '1' || a == '2' || a == '3' || a == '4' || a == '5' || a == '6' || a == '7' || a == '8'
					|| a == '9') {
				answer = true;
			}
		}
		return answer;

	}

	public static int process(String text) {
		char[] charArray = text.toCharArray();
		char[] numArray = new char[charArray.length];
		int counter = 0;
		for (char a : charArray) {
			if (a == '0' || a == '1' || a == '2' || a == '3' || a == '4' || a == '5' || a == '6' || a == '7' || a == '8'
					|| a == '9') {
				numArray[counter] = a;
				counter++;
			}
		}
		// System.out.println(Arrays.toString(numArray));
		char[] numArrayFin = new char[counter];
		for (int i = 0; i < counter; i++) {
			numArrayFin[i] = numArray[i];
		}
		// System.out.println(Arrays.toString(numArrayFin));
		int number = Integer.parseInt(String.valueOf(numArrayFin));
		return number;
	}

}
