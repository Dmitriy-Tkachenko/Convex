package com.university.project;

import java.awt.*;

//Класс "Нульугольник", реализующий интерфейс фигуры.
class Void implements Figure {
    public double perimeter(){
        return 0.0;
    }

    public double area(){
        return 0.0;
    }

    public Figure add(R2Point p){
        return new Point(p);
    }

    @Override
    public String getCoordinates() {
        return "x = null y = null";
    }

    @Override
    public String getPerimeterAndArea() {
        return "\nS = 0\nP = 0";
    }

    public void draw(Graphics g){
    }
}
