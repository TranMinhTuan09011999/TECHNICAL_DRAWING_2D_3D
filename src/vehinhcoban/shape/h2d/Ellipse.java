package vehinhcoban.shape.h2d;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Ellipse extends Shape {

    private Point tam;
    private int a;
    private int b;

    public Point getTam() {
        return tam;
    }

    public void setTam(Point tam) {
        this.tam = tam;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public Ellipse(Point tam, int a, int b) {
        super();
        this.tam = tam;
        this.a = a;
        this.b = b;
        points = new ArrayList<Point>();
    }

    public void Ve4diem(BufferedImage image, int xc, int yc, int x, int y)//ve 4 diem doi xung
    {
        int color = 1;
        Point p1 = new Point(xc + x, yc + y);
        Point p2 = new Point(xc - x, yc + y);

        points.add(p1);
        points.add(p2);

    }

    public void Ve2diem(BufferedImage image, int xc, int yc, int x, int y) {
        int color = 1;
        Point p1 = new Point(xc - x, yc - y);
        Point p2 = new Point(xc + x, yc - y);
        points.add(p1);
        points.add(p2);

    }

    public void doElipseNetDut(BufferedImage image,int color)// ve elipse
    {
        float p, a2, b2;
        int x, y;
        a2 = (float) Math.pow(a, 2);
        b2 = (float) Math.pow(b, 2);
        x = 0;
        y = b;

        p = 2 * ((float) b2 / a2) - (2 * b) + 1;

        //ve nhanh thu 1(tu tren xuong )
        while (((float) b2 / a2) * x <= y) {
            Ve4diem(image, tam.getX(), tam.getY(), x, y);
            if (p < 0) {
                p = p + 2 * ((float) b2 / a2) * (2 * x + 3);
            } else {
                p = p - 4 * y + 2 * ((float) b2 / a2) * (2 * x + 3);
                y--;
            }
            x++;
            if (x % 15 <= 5) {
                Ve2diem(image, tam.getX(), tam.getY(), x, y);
            }
        }

        //ve nhanh thu 2(tu duoi len )
        y = 0;
        x = a;
        p = 2 * ((float) a2 / b2) - 2 * a + 1;
        while (((float) a2 / b2) * y <= x) {
            Ve4diem(image, tam.getX(), tam.getY(), x, y);

            if (p < 0) {
                p = p + 2 * ((float) a2 / b2) * (2 * y + 3);
            } else {
                p = p - 4 * x + 2 * ((float) a2 / b2) * (2 * y + 3);
                x = x - 1;
            }
            y = y + 1;

            Ve2diem(image, tam.getX(), tam.getY(), x, y);
        }
        for (Point point : points) {
            Point.putPoint(point, image, color);
        }
    }
    public void doElipse(BufferedImage image)// ve elipse
    {
        float p, a2, b2;
        int x, y;
        a2 = (float) Math.pow(a, 2);
        b2 = (float) Math.pow(b, 2);
        x = 0;
        y = b;

        p = 2 * ((float) b2 / a2) - (2 * b) + 1;

        //ve nhanh thu 1(tu tren xuong )
        while (((float) b2 / a2) * x <= y) {
            Ve4diem(image, tam.getX(), tam.getY(), x, y);
            if (p < 0) {
                p = p + 2 * ((float) b2 / a2) * (2 * x + 3);
            } else {
                p = p - 4 * y + 2 * ((float) b2 / a2) * (2 * x + 3);
                y--;
            }
            x++;
          
                Ve2diem(image, tam.getX(), tam.getY(), x, y);
        
        }

        //ve nhanh thu 2(tu duoi len )
        y = 0;
        x = a;
        p = 2 * ((float) a2 / b2) - 2 * a + 1;
        while (((float) a2 / b2) * y <= x) {
            Ve4diem(image, tam.getX(), tam.getY(), x, y);

            if (p < 0) {
                p = p + 2 * ((float) a2 / b2) * (2 * y + 3);
            } else {
                p = p - 4 * x + 2 * ((float) a2 / b2) * (2 * y + 3);
                x = x - 1;
            }
            y = y + 1;

            Ve2diem(image, tam.getX(), tam.getY(), x, y);
        }
       
    }
    @Override
    public void drawShape(BufferedImage image, int color) {
        // TODO Auto-generated method stub
        this.doElipse(image);
        for (Point p : points) {
            Point.putPoint(p, image, color);
        }
    }

    @Override
    void tinhTien(BufferedImage image, int tr_x, int tr_y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void xoay(BufferedImage image, double theta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
