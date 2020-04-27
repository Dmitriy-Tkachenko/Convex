package com.university.project;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private static final int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static final int HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    private Convex convex;
    private Rectangle rectangle;

    public Window(Convex convex){
        this.convex = convex;
        this.setTitle("Convex");
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        rectangle = new Rectangle(convex);

        JPanel jPanel = new JPanel();
        BtnClose btnClose = new BtnClose(convex);

        btnClose.setFocusPainted(false);
        btnClose.setContentAreaFilled(false);
        btnClose.setContentAreaFilled(false);

        jPanel.add(btnClose);
        getContentPane().add(jPanel, BorderLayout.EAST);

        this.setVisible(true);
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.translate(WIDTH / 2, HEIGHT / 2);
        g.drawLine(-WIDTH, 0, WIDTH, 0);
        g.drawLine(0, -HEIGHT, 0, HEIGHT);
        convex.draw(g);
        rectangle.draw(g);
    }

    public static void drawLine(Graphics g, R2Point f, R2Point s) {
        g.drawLine((int) f.getX(), (int) f.getY(), (int) s.getX(), (int) s.getY());
    }

    public static Color getRandomColor() {
        return new Color((int) (Math.random() * 0x1000000));
    }
}
