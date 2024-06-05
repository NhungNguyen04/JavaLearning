package Bai7;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class StudentStatisticsGUI {

    private JFrame frame;
    private JTextArea textArea;

    public StudentStatisticsGUI() {
        initialize();
        fetchAndDisplayStatistics();
    }

    private void initialize() {
        frame = new JFrame("Student Statistics");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private void fetchAndDisplayStatistics() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/qlsv";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             Statement statement = connection.createStatement()) {

            // Count the number of students in each class
            ResultSet resultSet = statement.executeQuery(
                "SELECT lop.MaLop, COUNT(sinhvien.maSV) AS student_count " +
                "FROM lop " +
                "JOIN sinhvien ON lop.MaLop = sinhvien.maLop " +
                "GROUP BY lop.MaLop"
            );

            textArea.append("Số học sinh của từng lớp:\n");
            while (resultSet.next()) {
                String maLop = resultSet.getString("MaLop");
                int studentCount = resultSet.getInt("student_count");
                textArea.append("Lớp: " + maLop + ", Số học sinh: " + studentCount + "\n");
            }

            // Class with the most students
            resultSet = statement.executeQuery(
                "SELECT lop.MaLop, COUNT(sinhvien.maSV) AS student_count " +
                "FROM lop " +
                "JOIN sinhvien ON lop.MaLop = sinhvien.maLop " +
                "GROUP BY lop.MaLop " +
                "ORDER BY student_count DESC " +
                "LIMIT 1"
            );

            textArea.append("\nLớp có nhiều học sinh nhất:\n");
            if (resultSet.next()) {
                String tenLop = resultSet.getString("MaLop");
                int studentCount = resultSet.getInt("student_count");
                textArea.append("Class: " + tenLop + ", Students: " + studentCount + "\n");
            }

            // Class with the highest average GPA
            resultSet = statement.executeQuery(
                "SELECT lop.MaLop, AVG(sinhvien.diemTB) AS average_gpa " +
                "FROM lop " +
                "JOIN sinhvien ON lop.MaLop = sinhvien.maLop " +
                "GROUP BY lop.MaLop " +
                "ORDER BY average_gpa DESC " +
                "LIMIT 1"
            );

            textArea.append("\nLớp có điểm trung bình cao nhất:\n");
            if (resultSet.next()) {
                String maLop = resultSet.getString("MaLop");
                double averageGpa = resultSet.getDouble("average_gpa");
                textArea.append("Lớp: " + maLop + ", Điểm trung bình: " + averageGpa + "\n");
            }

            // Class with the most failing students
            resultSet = statement.executeQuery(
                "SELECT lop.MaLop, COUNT(sinhvien.maSV) AS failing_students " +
                "FROM lop " +
                "JOIN sinhvien ON lop.MaLop = sinhvien.maLop " +
                "WHERE sinhvien.diemTB < 5 " +
                "GROUP BY lop.MaLop " +
                "ORDER BY failing_students DESC " +
                "LIMIT 1"
            );

            textArea.append("\nLớp có nhiều học sinh dưới 5 điểm nhất:\n");
            if (resultSet.next()) {
                String maLop = resultSet.getString("MaLop");
                int failingStudents = resultSet.getInt("failing_students");
                textArea.append("Lớp: " + maLop + ", Số học sinh: " + failingStudents + "\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error fetching data: " + e.getMessage(),
                                          "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                StudentStatisticsGUI window = new StudentStatisticsGUI();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

