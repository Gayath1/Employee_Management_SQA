package com.employee.sqa;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class viewEmployee extends JFrame {

	static final String DB_URL = "jdbc:mysql://remotemysql.com:3306/QoQsk4BeEJ";
    static final String username = "QoQsk4BeEJ";
    static final String password = "r7p32rsm8e";
    
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewEmployee frame = new viewEmployee();
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
	public viewEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1056, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id"
			}
		));
		table.setBounds(48, 92, 915, 328);
		contentPane.add(table);
	}
	
    Connection conn;
    PreparedStatement view;
    
    private void employee_table(){
    
        int count;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, username, password);
            view = conn.prepareStatement("SELECT * FROM buildings");
            
            ResultSet rs = view.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            
            count = rss.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)table.getModel();
            df.setRowCount(0);
            
            while(rs.next()){
            
                Vector v1 = new Vector();
                for(int i=1; i<=count; i++){
                    v1.add(rs.getString("emp_id"));
                    v1.add(rs.getString("emp_name"));
                    v1.add(rs.getString("emp_mobile"));
                    
                    
                }
                df.addRow(v1);
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(viewEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(viewEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
    
    }
}
