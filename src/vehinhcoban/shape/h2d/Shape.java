package vehinhcoban.shape.h2d;

import java.awt.image.BufferedImage;
import java.util.ArrayList;


public abstract class Shape {

    protected ArrayList<Point> points;

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }

    abstract void drawShape(BufferedImage image, int color);

    abstract void tinhTien(BufferedImage image, int tr_x, int tr_y);
    
    abstract void xoay(BufferedImage image, double theta);
}
