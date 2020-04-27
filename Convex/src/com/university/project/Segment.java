package com.university.project;

import java.awt.*;

//Класс "Двуугольник", реализующий интерфейс фигуры.
class Segment implements Figure{
    private R2Point p, q;

    public Segment(R2Point p, R2Point q){
        this.p = p;
        this.q = q;

    }

    public double perimeter(){
        return 2.0 * R2Point.dist(p, q);
    }

    public double area(){
        return 0.0;
    }

    public Figure add(R2Point r){
        if(R2Point.isTriangle(p, q, r))
            return new Polygon(p, q, r);

        if(q.inside(p, r))
            q = r;

        if(p.inside(r, q))
            p = r;

        return this;
    }

    @Override
    public String getCoordinates() {
        return "x = " + p.getX() + " y = " + p.getY() + " \nx = " + q.getX() + " y = " + q.getY();
    }

    @Override
    public String getPerimeterAndArea() {
        return "\nS = 0" +  "\nP = " + perimeter();
    }

    public void draw(Graphics g){
        Window.drawLine(g, p, q);
    }
}
