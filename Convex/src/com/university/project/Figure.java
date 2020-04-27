package com.university.project;

import java.awt.*;

interface Figure{
    double perimeter();
    double area();
    Figure add(R2Point p);
    String getCoordinates();
    String getPerimeterAndArea();
    void draw(Graphics g);
}
