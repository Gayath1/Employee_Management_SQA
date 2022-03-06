package com.employee.sqa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1084, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1080, 97);
		contentPane.add(panel);
		
		JLabel title = new JLabel("Employee");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Nirmala UI", Font.BOLD, 59));
		panel.add(title);
		
		JButton addBtn = new JButton("New Employee");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		addBtn.setFont(new Font("Sylfaen", Font.BOLD, 18));
		addBtn.setBounds(201, 239, 201, 53);
		contentPane.add(addBtn);
		
		JButton viewBtn = new JButton("View Employee");
		viewBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		viewBtn.setFont(new Font("Sylfaen", Font.BOLD, 18));
		viewBtn.setBounds(567, 239, 201, 53);
		contentPane.add(viewBtn);
	}
}
