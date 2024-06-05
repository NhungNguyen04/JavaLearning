package Bai1;

import java.awt.*;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // Import thư viện
        JFrame frame = new JFrame("Chương trình chào mừng");

        // Thiết lập cửa sổ chính
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);

        // Tạo panel chứa các thành phần giao diện
        JPanel panel = new JPanel();

        // Tạo hộp thoại nhập tên
        String name = JOptionPane.showInputDialog(frame, "Nhập tên của bạn:");

        // Hiển thị lời chào mừng
        JLabel label = new JLabel("Xin chào " + name + "!");
        panel.add(label);

        // Thêm thành phần vào cửa sổ
        frame.add(panel);

        // Hiển thị cửa sổ
        frame.setVisible(true);
    }
}
