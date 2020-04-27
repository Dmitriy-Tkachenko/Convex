package com.university.project;

import javax.swing.*;
import java.awt.*;

class Convex extends JPanel {
    private Figure fig;

    public Convex(){
        fig = new Void();
    }

    public void add(R2Point p){
        fig = fig.add(p);
    }

    public double area(){
        return fig.area();
    }

    public double perimeter(){
        return fig.perimeter();
    }

    public String getCoordinates() {
        return fig.getCoordinates();
    }

    public String getPerimeterAndArea() {
        return fig.getPerimeterAndArea();
    }

    public void draw(Graphics g) {
        fig.draw(g);
    }
}
