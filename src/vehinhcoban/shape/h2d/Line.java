package vehinhcoban.shape.h2d;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import vehinhcoban.constant.ColorConstant;

public class Line extends Shape {

    private Point d1;
    private Point d2;

    public Point getD1() {
        return d1;
    }

    public void setD1(Point d1) {
        this.d1 = d1;
    }

    public Point getD2() {
        return d2;
    }

    public void setD2(Point d2) {
        this.d2 = d2;
    }

    public Line(Point a, Point b) {
        super();
        d1 = a;
        d2 = b;
        super.points = new ArrayList<Point>();
    }

    public void doLine() {
        int x, y, dx, dy, p;
        dx = Math.abs(d1.getX() - d2.getX());
        dy = Math.abs(d1.getY() - d2.getY());
        if (dx > dy) {
            if (d1.getX() > d2.getX()) {
                Point temp = d1;
                d1 = d2;
                d2 = temp;
            }
            x = d1.getX();
            y = d1.getY();
            p = 2 * dy - dx;
            Point dv = new Point(x, y);
            points.add(dv);
            while (x != d2.getX()) {
                x++;
                if (p < 0) {
                    p = p + 2 * dy;
                } else {
                    p = p + 2 * (dy - dx);
                    if (d1.getY() > d2.getY()) {
                        y--;
                    } else {
                        y++;
                    }
                }
                dv = new Point(x, y);
                points.add(dv);
            }
        } else {
            if (d1.getY() > d2.getY()) {
                Point temp = d1;
                d1 = d2;
                d2 = temp;
            }
            int tmp = dx;
            dx = dy;
            dy = tmp;
            x = d1.getX();
            y = d1.getY();
            p = 2 * dy - dx;
            Point dv = new Point(x, y);
            points.add(dv);
            while (y < d2.getY()) {
                y++;
                if (p < 0) {
                    p = p + 2 * dy;
                } else {
                    if (d1.getX() > d2.getX()) {
                        x = x - 1;
                    } else {
                        x = x + 1;
                    }
                    p = p + 2 * (dy - dx);
                }
                dv = new Point(x, y);
                points.add(dv);
            }
        }
    }

    public void drawLineChamGach(BufferedImage image, int color) {
        this.doLine();
        int k = 0;
        int length_netgach = 10;
        int doChamGach = 20;
        int endKhoangTrang = 30;
        for (Point p : points) {
            if (k <= length_netgach) {
                Point.putPixel(p, image, ColorConstant.BLACK_RGB);
            } else {
                if (k == doChamGach) {
                    Point.putPixel(p, image, ColorConstant.BLACK_RGB);
                } else {
                    Point.putPixel(p, image, ColorConstant.WHITE_RGB);
                }
            }
            if (k == endKhoangTrang) {
                k = 0;
            }
            k++;
        }
    }

    public void drawLine2ChamGach(BufferedImage image, int color) {
        this.doLine();
        int k = 0;
        for (Point n : points) {
            k++;
            if ((k < 15 || k > 21) && (k < 24 || k > 31) && (k < 34)) {
                Point.putPixel(n, image, color);
            } else {
                Point.putPixel(n, image, ColorConstant.WHITE_RGB);
            }
            if (k == 40) {
                k = 0;
            }
        }
    }

    public void drawLineNetDut(BufferedImage image, int color) {
        this.doLine();
        int k = 0;
        for (Point p : points) {
            if (k <= 5) {
                Point.putPoint(p, image, color);
            }
            if (k == 15) {
                k = 0;
            }
            k++;
        }
    }
    public void veThuong(BufferedImage image, int color) {
        // TODO Auto-generated method stub
        this.doLine();
        for (Point p : points) {
            //Point.putPoint(p, image, color);
            Point.putPixel(p, image, color);
        }
    }
    @Override
    public void drawShape(BufferedImage image, int color) {
        // TODO Auto-generated method stub
        this.doLine();
        for (Point p : points) {
            //Point.putPoint(p, image, color);
            Point.putPoint(p, image, color);
        }
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
