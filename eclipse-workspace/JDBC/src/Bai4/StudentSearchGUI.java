package Bai4;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Bai3.StudentAndClassManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class StudentSearchGUI {
    private JTable table;
    private DefaultTableModel tableModel;
    private JComboBox<String> searchComboBox;
    private JTextField searchField1, searchField2;
    private JButton searchButton;
    static StudentAndClassManager frame = new StudentAndClassManager();

    public StudentSearchGUI() {
        
        // Set up the table
        tableModel = StudentAndClassManager.sinhVienModel;

        // Set up the search panel
        JPanel searchPanel = new JPanel();
        searchComboBox = new JComboBox<>(new String[]{"Mã SV", "Họ tên", "Lớp", "Điểm TB"});
        searchField1 = new JTextField(15);
        searchField2 = new JTextField(15);
        searchField2.setVisible(false); // Initially hidden
        searchButton = new JButton("Tìm");

        searchPanel.add(searchComboBox);
        searchPanel.add(searchField1);
        searchPanel.add(searchField2);
        searchPanel.add(searchButton);
        frame.sinhVienPanel.add(searchPanel);
        // Add action listeners
        searchComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) searchComboBox.getSelectedItem();
                if ("Điểm TB".equals(selectedOption)) {
                    searchField2.setVisible(true);
                } else {
                    searchField2.setVisible(false);
                }
                frame.sinhVienPanel.revalidate();
                frame.sinhVienPanel.repaint();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchStudents();
            }
        });
    }

    private void searchStudents() {
        String selectedOption = (String) searchComboBox.getSelectedItem();
        String query = "";

        switch (selectedOption) {
            case "Mã SV":
                query = "SELECT * FROM SinhVien WHERE MaSV = ?";
                break;
            case "Họ tên":
                query = "SELECT * FROM SinhVien WHERE HoTen LIKE ?";
                break;
            case "Lớp":
                query = "SELECT * FROM SinhVien WHERE maLop = ?";
                break;
            case "Điểm TB":
                query = "SELECT * FROM SinhVien WHERE DiemTB BETWEEN ? AND ?";
                break;
        }

        String url = "jdbc:mysql://localhost:3306/QLSV";
        String user = "root";
        String password = "password";

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement(query);

            if ("Điểm TB".equals(selectedOption)) {
                stmt.setFloat(1, Float.parseFloat(searchField1.getText()));
                stmt.setFloat(2, Float.parseFloat(searchField2.getText()));
            } else {
                stmt.setString(1, searchField1.getText());
            }

            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Lấy tên cột từ CSDL
            tableModel.setColumnCount(0);
            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnName(i));
            }

            // Lấy dữ liệu sinh viên
            tableModel.setRowCount(0);
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                tableModel.addRow(row);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed. Check output console");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
             new StudentSearchGUI();
             try {
				frame.frame3.setVisible(true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
}
