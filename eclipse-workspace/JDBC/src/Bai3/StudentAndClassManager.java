package Bai3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class StudentAndClassManager {

    public static final String DB_URL = "jdbc:mysql://localhost:3306/QLSV";
    public static final String USER = "root"; 
    public static final String PASS = "password"; 
    
    public static JPanel sinhVienPanel;
    public static JPanel lopPanel;

    public static DefaultTableModel sinhVienModel;
    public DefaultTableModel lopModel;
    
    public static JFrame frame3 = new JFrame ("Student and Class Manager");

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentAndClassManager::new);
    }

    public StudentAndClassManager() {
        frame3 = new JFrame("Student and Class Manager");
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setSize(800, 600);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Tab SinhVien
        GridLayout layout = new GridLayout(3, 1);
        sinhVienPanel = new JPanel(new BorderLayout());
        sinhVienPanel.setLayout(layout);
        sinhVienModel = new DefaultTableModel(new String[]{"MaSV", "HoTen", "Lop", "DiemTB"}, 0);
        JTable sinhVienTable = new JTable(sinhVienModel);
        loadSinhVienData();
        sinhVienPanel.add(new JScrollPane(sinhVienTable));
        sinhVienPanel.add(createSinhVienControlPanel(sinhVienTable));
        tabbedPane.add("Sinh Viên", sinhVienPanel);

        // Tab Lop
        lopPanel = new JPanel(new BorderLayout());
        lopModel = new DefaultTableModel(new String[]{"MaLop", "TenLop", "CVHT"}, 0);
        JTable lopTable = new JTable(lopModel);
        loadLopData();
        lopPanel.add(new JScrollPane(lopTable), BorderLayout.CENTER);
        lopPanel.add(createLopControlPanel(lopTable), BorderLayout.SOUTH);
        tabbedPane.add("Lớp", lopPanel);

        frame3.add(tabbedPane);
        frame3.setVisible(true);
    }
    
    public void loadSinhVienData() {
        sinhVienModel.setRowCount(0); // Clear existing data
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM SinhVien")) {
            while (rs.next()) {
                sinhVienModel.addRow(new Object[]{
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

    private void loadLopData() {
        lopModel.setRowCount(0); // Clear existing data
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Lop")) {
            while (rs.next()) {
                lopModel.addRow(new Object[]{
                        rs.getInt("MaLop"),
                        rs.getString("TenLop"),
                        rs.getString("CVHT")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private JPanel createSinhVienControlPanel(JTable table) {
        JPanel panel = new JPanel(new GridLayout(2, 1));

        JPanel inputPanel = new JPanel(new GridLayout(2, 4));
        JTextField maSVField = new JTextField();
        JTextField hoTenField = new JTextField();
        JTextField lopField = new JTextField();
        JTextField diemTBField = new JTextField();

        inputPanel.add(new JLabel("MaSV"));
        inputPanel.add(maSVField);
        inputPanel.add(new JLabel("HoTen"));
        inputPanel.add(hoTenField);
        inputPanel.add(new JLabel("MaLop"));
        inputPanel.add(lopField);
        inputPanel.add(new JLabel("DiemTB"));
        inputPanel.add(diemTBField);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        panel.add(inputPanel);
        panel.add(buttonPanel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                     PreparedStatement stmt = conn.prepareStatement("INSERT INTO SinhVien VALUES (?, ?, ?, ?)")) {
                    stmt.setInt(1, Integer.parseInt(maSVField.getText()));
                    stmt.setString(2, hoTenField.getText());
                    stmt.setInt(3, Integer.parseInt(lopField.getText()));
                    stmt.setFloat(4, Float.parseFloat(diemTBField.getText()));
                    stmt.executeUpdate();
                    loadSinhVienData();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                     PreparedStatement stmt = conn.prepareStatement("UPDATE SinhVien SET HoTen = ?, maLop = ?, DiemTB = ? WHERE MaSV = ?")) {
                    stmt.setString(1, hoTenField.getText());
                    stmt.setInt(2, Integer.parseInt(lopField.getText()));
                    stmt.setFloat(3, Float.parseFloat(diemTBField.getText()));
                    stmt.setInt(4, Integer.parseInt(maSVField.getText()));
                    stmt.executeUpdate();
                    loadSinhVienData();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                     PreparedStatement stmt = conn.prepareStatement("DELETE FROM SinhVien WHERE MaSV = ?")) {
                    stmt.setInt(1, Integer.parseInt(maSVField.getText()));
                    stmt.executeUpdate();
                    loadSinhVienData();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    maSVField.setText(table.getValueAt(selectedRow, 0).toString());
                    hoTenField.setText(table.getValueAt(selectedRow, 1).toString());
                    lopField.setText(table.getValueAt(selectedRow, 2).toString());
                    diemTBField.setText(table.getValueAt(selectedRow, 3).toString());
                }
            }
        });

        return panel;
    }

    private JPanel createLopControlPanel(JTable table) {
        JPanel panel = new JPanel(new GridLayout(2, 1));

        JPanel inputPanel = new JPanel(new GridLayout(2, 3));
        JTextField maLopField = new JTextField();
        JTextField tenLopField = new JTextField();
        JTextField cvhtField = new JTextField();

        inputPanel.add(new JLabel("MaLop"));
        inputPanel.add(maLopField);
        inputPanel.add(new JLabel("TenLop"));
        inputPanel.add(tenLopField);
        inputPanel.add(new JLabel("CVHT"));
        inputPanel.add(cvhtField);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        panel.add(inputPanel);
        panel.add(buttonPanel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                     PreparedStatement stmt = conn.prepareStatement("INSERT INTO Lop VALUES (?, ?, ?)")) {
                    stmt.setInt(1, Integer.parseInt(maLopField.getText()));
                    stmt.setString(2, tenLopField.getText());
                    stmt.setString(3, cvhtField.getText());
                    stmt.executeUpdate();
                    loadLopData();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                     PreparedStatement stmt = conn.prepareStatement("UPDATE Lop SET TenLop = ?, CVHT = ? WHERE MaLop = ?")) {
                    stmt.setString(1, tenLopField.getText());
                    stmt.setString(2, cvhtField.getText());
                    stmt.setInt(3, Integer.parseInt(maLopField.getText()));
                    stmt.executeUpdate();
                    loadLopData();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                     PreparedStatement stmt = conn.prepareStatement("DELETE FROM Lop WHERE MaLop = ?")) {
                    stmt.setInt(1, Integer.parseInt(maLopField.getText()));
                    stmt.executeUpdate();
                    loadLopData();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    maLopField.setText(table.getValueAt(selectedRow, 0).toString());
                    tenLopField.setText(table.getValueAt(selectedRow, 1).toString());
                    cvhtField.setText(table.getValueAt(selectedRow, 2).toString());
                }
            }
        });

        return panel;
    }
}
