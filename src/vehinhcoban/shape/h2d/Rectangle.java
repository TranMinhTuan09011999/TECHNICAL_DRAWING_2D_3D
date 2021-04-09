package vehinhcoban.shape.h2d;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import vehinhcoban.constant.ColorConstant;

public class Rectangle extends Shape {

    private Point a;
    private int length;
    private int width;

    public Rectangle(Point a, int length, int width) {
        super();
        this.a = a;
        this.length = length;
        this.width = width;
        points = new ArrayList<>();
    }

    public void doHinhChuNhat(BufferedImage image, int color) {
        int x1 = a.getX() + length;
        int y1 = a.getY();
        Point b = Point.convert(x1, y1);

        int x2 = a.getX();
        int y2 = a.getY() + width;
        Point d = Point.convert(x2, y2);

        int x3 = x2 + length;
        int y3 = y2;
        Point c = Point.convert(x3, y3);

        setA(Point.convert(a.getX(), a.getY()));

        Line ab = new Line(a, b);
        ab.drawShape(image, ColorConstant.BLACK_RGB);
        Point.putPoint(a, image, ColorConstant.BLACK_RGB);

        Line bc = new Line(b, c);
        bc.drawShape(image, ColorConstant.BLACK_RGB);
        Point.putPoint(b, image, ColorConstant.BLACK_RGB);

        Line cd = new Line(c, d);
        cd.drawShape(image, ColorConstant.BLACK_RGB);
        Point.putPoint(c, image, ColorConstant.BLACK_RGB);

        Line da = new Line(d, a);
        da.drawShape(image, ColorConstant.BLACK_RGB);
        Point.putPoint(d, image, ColorConstant.BLACK_RGB);

        // to mau
        for (int i = width*5 - 3; i >= 5; i--) {
            for (int j = 5; j < length*5-3; j++) {
                Point p = new Point(a.getX() + j, a.getY() - i);
                Point.putPoint(p, image, color);

            }
        }
    }
    public void toMauHinh(BufferedImage image, int color){
        setA(Point.convert(getA()));
        for (int i = width*5 - 3; i >= 5; i--) {
            for (int j = 5; j < length*5-3; j++) {
                
                Point p = new Point(getA().getX() + j, getA().getY() - i);
                Point.putPoint(p, image, color);

            }
        }
    }
            
            
    @Override
    public void drawShape(BufferedImage image, int color) {
        // TODO Auto-generated method stub
        this.doHinhChuNhat(image, color);
    }
    
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    @Override
    public void tinhTien(BufferedImage image, int tr_x, int tr_y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void xoay(BufferedImage image, double theta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
