package Bai5;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Bai3.StudentAndClassManager;
import Bai4.StudentSearchGUI;

public class SortStudent {
	
	private JTable table;
    private DefaultTableModel tableModel;
    private JComboBox<String> searchComboBox;
    private JTextField searchField1, searchField2;
    private JButton searchButton;
    static StudentAndClassManager frame = new StudentAndClassManager();
    String query = "";
    
    public void PerformSortStudent () throws SQLException {
    	// Load the MySQL JDBC driver
    	frame.sinhVienModel.setRowCount(0); // Clear existing data
        try (Connection conn = DriverManager.getConnection(frame.DB_URL, frame.USER, frame.PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                frame.sinhVienModel.addRow(new Object[]{
                        rs.getInt("maSV"),
                        rs.getString("hoTen"),
                        rs.getInt("maLop"),
                        rs.getFloat("diemTB")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();  
        }
    }
    
    public SortStudent() {
    	
    	// Model sinh viên
    	tableModel = StudentAndClassManager.sinhVienModel;
    	
    	// Thêm radio button vào panel
    	ButtonGroup radioButtonGroup = new ButtonGroup();
    	JRadioButton increButton = new JRadioButton("Điểm trung bình tăng dần");
    	JRadioButton decreButton = new JRadioButton("Điểm trung bình giảm dần");
    	radioButtonGroup.add(increButton);
    	radioButtonGroup.add(decreButton);
    	
    	increButton.addActionListener((ActionListener) -> {
    		query = "select * from sinhvien order by diemTB;";
    		try {
				PerformSortStudent();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	});
    	
    	decreButton.addActionListener((ActionListener) -> {
    		query = "select * from sinhvien order by diemTB desc;";
    		try {
				PerformSortStudent();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	});
    	
    	JPanel buttonPanel = new JPanel();
    	buttonPanel.setLayout(new FlowLayout());
    	
    	buttonPanel.add(increButton);
    	buttonPanel.add(decreButton);
    	
    	frame.sinhVienPanel.add(buttonPanel);
    }
    
    public static void main(String[] args) {
        new SortStudent();
        try {
			frame.frame3.setVisible(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
