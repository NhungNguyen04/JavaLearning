import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class nothing {
	
	private static final String url = "jdbc:mysql://localhost:3306/student";
    private static final String user = "root";
    private static final String password = "password";
    
    public static void main(String[] args) throws ClassNotFoundException {
    	JFrame frame = new JFrame("Database Tables");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Tạo JTable
        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Table Name");
        table.setModel(model);

        // Kết nối đến CSDL và lấy danh sách các bảng
        try (Connection conn = DriverManager.getConnection(url, user, password);
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
    }

}
