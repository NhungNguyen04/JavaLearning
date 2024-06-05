package Bai1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class StudentDatabaseApp {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/QLSV";
    private static final String USER = "root"; 
    private static final String PASS = "password"; 

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Student Database");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);

            // Tạo JTable
            JTable table = new JTable();
            DefaultTableModel model = new DefaultTableModel();
            table.setModel(model);

            // Kết nối đến CSDL và lấy dữ liệu
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM SinhVien")) {

                // Lấy thông tin cột từ ResultSet
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();

                // Thêm tên cột vào model
                for (int i = 1; i <= columnCount; i++) {
                    model.addColumn(metaData.getColumnName(i));
                }

                // Thêm dữ liệu vào model
                while (rs.next()) {
                    Object[] row = new Object[columnCount];
                    for (int i = 1; i <= columnCount; i++) {
                        row[i - 1] = rs.getObject(i);
                    }
                    model.addRow(row);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            // Thêm JTable vào JFrame
            frame.add(new JScrollPane(table), BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }
}
