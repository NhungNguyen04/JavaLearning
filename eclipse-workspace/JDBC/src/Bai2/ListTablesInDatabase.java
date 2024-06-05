package Bai2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class ListTablesInDatabase {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/QLSV";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Database Tables");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            // Tạo JTable
            JTable table = new JTable();
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Table Name");
            table.setModel(model);

            // Kết nối đến CSDL và lấy danh sách các bảng
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                 ResultSet rs = conn.getMetaData().getTables(null, null, "%", new String[]{"TABLE"})) {

                // Thêm tên bảng vào model
                while (rs.next()) {
                    String tableName = rs.getString("TABLE_NAME");
                    model.addRow(new Object[]{tableName});
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
