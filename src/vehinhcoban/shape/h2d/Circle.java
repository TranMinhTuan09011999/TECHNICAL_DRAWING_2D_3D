package vehinhcoban.shape.h2d;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import vehinhcoban.constant.SizeConstant;
import vehinhcoban.shape.PhepBienDoi2D;

public class Circle extends Shape {

    private Point tam;
    private int R;

    public Point getTam() {
        return tam;
    }

    public void setTam(Point tam) {
        this.tam = tam;
    }

    public int getR() {
        return R;
    }

    public void setR(int r) {
        R = r;
    }

    public Circle(Point tam, int r) {
        super();
        this.tam = tam;
        R = r;
        points = new ArrayList<Point>();
    }

    public void layDoiXungDiem(int x, int y) {
        Point D;

        int width = SizeConstant.WIDTH_DRAW_PLACE;
        int height = SizeConstant.HEIGHT_DRAW_PLACE;

        D = new Point(tam.getX() + x, tam.getY() + y);
        if (D.getX() > 0 && D.getX() < width && D.getY() > 0 && D.getY() < height) {
            points.add(D);
        }

        D = new Point(tam.getX() - x, tam.getY() + y);
        if (D.getX() > 0 && D.getX() < width && D.getY() > 0 && D.getY() < height) {
            points.add(D);
        }

        D = new Point(tam.getX() + x, tam.getY() - y);
        if (D.getX() > 0 && D.getX() < width && D.getY() > 0 && D.getY() < height) {
            points.add(D);
        }

        D = new Point(tam.getX() - x, tam.getY() - y);
        if (D.getX() > 0 && D.getX() < width && D.getY() > 0 && D.getY() < height) {
            points.add(D);
        }

        D = new Point(tam.getX() + y, tam.getY() + x);
        if (D.getX() > 0 && D.getX() < width && D.getY() > 0 && D.getY() < height) {
            points.add(D);
        }

        D = new Point(tam.getX() - y, tam.getY() + x);
        if (D.getX() > 0 && D.getX() < width && D.getY() > 0 && D.getY() < height) {
            points.add(D);
        }

        D = new Point(tam.getX() + y, tam.getY() - x);
        if (D.getX() > 0 && D.getX() < width && D.getY() > 0 && D.getY() < height) {
            points.add(D);
        }

        D = new Point(tam.getX() - y, tam.getY() - x);
        if (D.getX() > 0 && D.getX() < width && D.getY() > 0 && D.getY() < height) {
            points.add(D);
        }

    }

    public static int makeDistance(Point p1, Point p2) {
        return (int) Math.sqrt(
                (p2.getX() - p1.getX()) * (p2.getX() - p1.getX()) + (p2.getY() - p1.getY()) * (p2.getY() - p1.getY()));
    }

    public void doDuongTron() {
        int x, y, d;
        x = 0;
        y = R;
        d = 1 - R;
        while (x <= y) {
            layDoiXungDiem(x, y);
            if (d < 0)//diem MidPoint nam trong duong tron
            {
                d += 2 * x + 3;
            } else {//diem nam ngoai duong tron
                d += 2 * (x - y) + 5;
                y = y - 1;
            }
            x = x + 1;
        }
    }
    public void toMau(BufferedImage image, int color){
        int temp = getR();
     
        for(int i =5; i<temp;i++){
            setR(temp-i);
           // this.doDuongTron();
            setPoints(new ArrayList<>());
            this.drawShape(image, color);
        }
        setR(temp);
        
       
    }
    @Override
    public void drawShape(BufferedImage image, int color) {
        // TODO Auto-generated method stub
        this.doDuongTron();
        for (Point p : getPoints()) {
            Point.putPoint(p, image, color);
        }
    }

    @Override
    public void tinhTien(BufferedImage image, int tr_x, int tr_y) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        setTam(PhepBienDoi2D.tinhTienDiem(getTam(), tr_x, tr_y));
       //m this.drawShape(image, ColorConstant.WHITE_RGB);
    }

    @Override
    void xoay(BufferedImage image, double theta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
