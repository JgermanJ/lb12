package com.example.labus12.beans;

public record Point(double x, double y) {

    public double getY() {
        return y;
    }

    public double getX() {

        return x;
    }
    public String getStrX(){
        return String.format("%5.3f",x);
    }
}

