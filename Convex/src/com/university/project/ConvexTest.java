package com.university.project;

class ConvexTest{
    public static void main (String[] args) {
        Convex convex = new Convex();
        Window window = new Window(convex);
        while(true){
            convex.add(new R2Point());
            window.update(window.getGraphics());
            System.out.println("S = " + convex.area() + ", P = " + convex.perimeter());
        }
    }
}
