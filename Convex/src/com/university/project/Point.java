package com.university.project;

import java.awt.*;

//Класс "Одноугольник", реализующий интерфейс фигуры.
class Point implements Figure{
    private R2Point p;

    public Point(R2Point p){
        this.p = p;
    }

    public double perimeter(){
        return 0.0;
    }

    public double area(){
        return 0.0;
    }

    public Figure add(R2Point q){
        if(!R2Point.equal(p, q)) {
            return new Segment(p, q);
        }
        else
            return this;
    }

    public String getCoordinates() {
        return "x = " + p.getX() + " y = " + p.getY();
    }

    @Override
    public String getPerimeterAndArea() {
        return "\nS = 0" + "\nP = 0";
    }


    public void draw(Graphics g){
        g.fillOval((int) p.getX(), (int) p.getY(), 2, 2);
    }
}
