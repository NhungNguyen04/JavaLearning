package Bai12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class HinhTron extends JPanel {

    private int banKinh = 50; // Bán kính hình tròn ban đầu

    public HinhTron() {
        setPreferredSize(new Dimension(300, 300));

        // Tạo slider để điều chỉnh kích thước hình tròn
        JSlider slider = new JSlider(50, 200, 50);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                banKinh = ((JSlider) e.getSource()).getValue();
                repaint(); // Vẽ lại hình tròn khi giá trị slider thay đổi
            }
        });

        // Thêm slider vào panel
        add(slider, BorderLayout.SOUTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Vẽ hình tròn với tâm (x, y) và bán kính banKinh
        int x = getWidth() / 2;
        int y = getHeight() / 2;
        g.setColor(Color.RED);
        g.fillOval(x - banKinh, y - banKinh, 2 * banKinh, 2 * banKinh);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Vẽ hình tròn");
        frame.add(new HinhTron());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
