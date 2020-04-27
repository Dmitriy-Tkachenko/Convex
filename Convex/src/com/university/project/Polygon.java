package com.university.project;

import java.awt.*;
import java.awt.geom.Path2D;

//Класс "Многоугольник", реализующий интерфейс фигуры.
class Polygon extends Deq implements Figure{
    private double s, p;
    private String coordinates;

    public Polygon(R2Point a, R2Point b, R2Point c) {
        pushFront(b);

        if (b.light(a, c)){
            pushFront(a);
            pushBack(c);
        }
        else{
            pushFront(c);
            pushBack(a);
        }

        p = R2Point.dist(a, b) + R2Point.dist(b, c)+ R2Point.dist(c, a);
        s = Math.abs(R2Point.area(a, b, c));

        coordinates = "x = " + a.getX() + " y = " + a.getY() + " \nx = " + b.getX() + " y = " + b.getY() + " \nx = " + c.getX() + " y = " + c.getY();
    }

    public double perimeter(){
        return p;
    }

    public double area(){
        return s;
    }

    private void grow(R2Point a, R2Point b, R2Point t){
        p -= R2Point.dist(a, b);
        s += Math.abs(R2Point.area(a, b, t));
    }

    public Figure add(R2Point t){
        int i;
        //Ищем освещенные ребра, просматривая их одно за другим.
        for(i = length(); i>0 && !t.light(back(), front()); i--)
            pushBack(popFront());

        //УТВЕРЖДЕНИЕ:
        //либо ребро [back(), front()] освещено из t,
        //либо освещенных ребер нет совсем.
        if (i>0){
            R2Point x;
            grow(back(), front(), t);

            //Удаляем все освещенные ребра из начала дека.
            for(x = popFront(); t.light(x, front()); x = popFront())
                grow(x, front(), t);
            pushFront(x);

            //Удаляем все освещенные ребра из конца дека.
            for (x = popBack(); t.light(back(), x); x = popBack())
                grow(back(), x, t);
            pushBack(x);

            //Завершаем обработку добавляемой точки.
            p += R2Point.dist(back(), t) + R2Point.dist(t, front());
            pushFront(t);
        }
        coordinates = coordinates.concat(" \nx = " + front().getX() + " y = " + front().getY());
        return this;
    }

    @Override
    public String getCoordinates() {
        return coordinates;
    }

    @Override
    public String getPerimeterAndArea() {
        return "\nS = " + area() + " F = " + perimeter();
    }

    public void draw(Graphics g){
        Path2D p = new Path2D.Double();
        p.moveTo(back().getX(), back().getY());
        for (int i = 0; i < length(); i++) {
            p.lineTo(back().getX(), back().getY());
            pushFront(popBack());
        }
        p.closePath();
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Window.getRandomColor());
        g2d.fill(p);
    }
}
