package com.university.project;

import java.awt.*;

public class Rectangle {
    Convex convex;
    String[] str;
    String regex = "(([-+])?[0-9]+(\\.[0-9]+)?)+";
    double xMax, yMax, xMin, yMin, width, height, tmpX, tmpY;
    boolean flagX = false, flagY = false, thisX = true;

    Rectangle(Convex convex) {
        this.convex = convex;
    }

    void rectData() {
        str = convex.getCoordinates().split(" ");
        for (String s : str) {
            if (s.matches(regex)) {
                if (thisX) {
                    xMinAndMax(s);
                    thisX = false;
                } else {
                    yMinAndMax(s);
                    thisX = true;
                }
            }
        }
        width = Math.abs(xMax - xMin);
        height = Math.abs(yMax - yMin);
    }

    private void xMinAndMax(String s) {
        if (!flagX) {
            xMin = Double.parseDouble(s);
            xMax = Double.parseDouble(s);
            flagX = true;
        }
        tmpX = Double.parseDouble(s);
        if (tmpX >= xMax) {
            xMax = tmpX;
        } else if (tmpX <= xMin) {
            xMin = tmpX;
        }
    }

    private void yMinAndMax(String s) {
        if (!flagY) {
            yMin = Double.parseDouble(s);
            yMax = Double.parseDouble(s);
            flagY = true;
        }
        tmpY = Double.parseDouble(s);
        if (tmpY >= yMax) {
            yMax = tmpY;
        } else if (tmpY <= yMin) {
            yMin = tmpY;
        }
    }

    void draw(Graphics g) {
        rectData();
        g.setColor(Color.RED);
        g.drawRect((int) xMin,(int) yMin,(int) width,(int) height);
    }
}
