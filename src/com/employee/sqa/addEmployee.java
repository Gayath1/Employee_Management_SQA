package com.employee.sqa;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class addEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField emp_id_;
	private JTextField Emp_name_txt;
	private JTextField emp_mobile_txt;
	
	static final String DB_URL = "jdbc:mysql://remotemysql.com:3306/QoQsk4BeEJ";
    static final String username = "QoQsk4BeEJ";
    static final String password = "r7p32rsm8e";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addEmployee frame = new addEmployee();
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
	Connection conn;
	PreparedStatement insert;
	public addEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 983, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 969, 67);
		contentPane.add(panel);
		
		JLabel title = new JLabel("New Employee");
		title.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
		panel.add(title);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 77, 969, 399);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel empid_lbl = new JLabel("Emp_ID:");
		empid_lbl.setBounds(36, 55, 74, 24);
		empid_lbl.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		empid_lbl.setName("empId");
		panel_1.add(empid_lbl);
		
		emp_id_ = new JTextField();
		emp_id_.setBounds(134, 42, 188, 38);
		panel_1.add(emp_id_);
		emp_id_.setColumns(10);
		
		JLabel empname_lbl = new JLabel("Emp_Name:");
		empname_lbl.setName("empId");
		empname_lbl.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		empname_lbl.setBounds(422, 55, 107, 24);
		panel_1.add(empname_lbl);
		
		Emp_name_txt = new JTextField();
		Emp_name_txt.setColumns(10);
		Emp_name_txt.setBounds(558, 41, 369, 38);
		panel_1.add(Emp_name_txt);
		
		JLabel empmobile_lbl = new JLabel("Emp_Mobile:");
		empmobile_lbl.setName("empId");
		empmobile_lbl.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		empmobile_lbl.setBounds(36, 142, 120, 24);
		panel_1.add(empmobile_lbl);
		
		emp_mobile_txt = new JTextField();
		emp_mobile_txt.setColumns(10);
		emp_mobile_txt.setBounds(170, 128, 188, 38);
		panel_1.add(emp_mobile_txt);
		
		JLabel empdep_lbl = new JLabel("Emp_Department:");
		empdep_lbl.setName("empId");
		empdep_lbl.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		empdep_lbl.setBounds(422, 142, 164, 24);
		panel_1.add(empdep_lbl);
		
		JComboBox dep_combo = new JComboBox();
		dep_combo.setBorder(new LineBorder(new Color(0, 0, 0)));
		dep_combo.setBackground(SystemColor.text);
		dep_combo.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		dep_combo.setForeground(SystemColor.desktop);
		dep_combo.setModel(new DefaultComboBoxModel(new String[] {"Human Resource", "Information Technology", "Hygeine"}));
		dep_combo.setBounds(609, 128, 216, 35);
		panel_1.add(dep_combo);
		
		JButton submit = new JButton("Register");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String empId = emp_id_.getText();
		        String empName = Emp_name_txt.getText();
		        String empMobile = emp_mobile_txt.getText();
		        String dep = dep_combo.getSelectedItem().toString();
		        try {
		            Class.forName("com.mysql.jdbc.Driver");
		           conn = DriverManager.getConnection(DB_URL, username, password);
		           insert = conn.prepareStatement("INSERT INTO employee(emp_id,emp_name,emp_mobile,department)VALUES(?,?,?,?)");
		            
		            // insert data to relavant ? marks
		            insert.setString(1, empId);
		            insert.setString(2, empName);
		            insert.setString(3, empMobile);
		            insert.setString(4, dep);
		            
		            if(empId.isEmpty() || empName.isEmpty()|| empMobile.isEmpty()|| dep.isEmpty()){
		                JOptionPane.showInputDialog(this, "All Fields Required!");
		            }else{
		            // execute the query
		            insert.executeUpdate();
		            
		            // set pop-up message
		            JOptionPane.showInputDialog(this, "Record Added");
		            
		            // clear text boxes
		            emp_id_.setText("");
		            Emp_name_txt.setText("");
		            emp_mobile_txt.setText("");
		            
		            // focus on first textbox after clearing
		            emp_id_.requestFocus();
		            }
		        } catch (ClassNotFoundException ex) {
		            Logger.getLogger(addEmployee.class.getName()).log(Level.SEVERE, null, ex);
		            
		        } catch (SQLException ex) {
		            Logger.getLogger(addEmployee.class.getName()).log(Level.SEVERE, null, ex);
		        }
		        
				
			}
		});
		submit.setBackground(new Color(0, 128, 0));
		submit.setFont(new Font("Verdana", Font.BOLD, 21));
		submit.setBounds(359, 295, 188, 52);
		panel_1.add(submit);
	}
}



