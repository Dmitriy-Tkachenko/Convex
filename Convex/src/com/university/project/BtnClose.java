package com.university.project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BtnClose extends JButton {
    private Convex convex;

    public BtnClose(Convex convex) {
        super("Save");
        this.convex = convex;

        MyButtonListener listener = new MyButtonListener();
        this.addActionListener(listener);
    }

    private class MyButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            File points = new File("C:\\Files\\University\\Convex", "Points.txt");
            try {
                if (points.createNewFile()) {
                    createFile(points);
                    System.out.println("\nСоздан файл Points.txt");
                } else {
                    createFile(points);
                    System.out.println("\nОбновлен файл Points.txt");
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage() + "\n");
            }
        }
    }

    private void createFile(File points) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(points);
            String str = convex.getCoordinates().concat(convex.getPerimeterAndArea());
            fileOutputStream.write((str + "\n").getBytes());
            fileOutputStream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
