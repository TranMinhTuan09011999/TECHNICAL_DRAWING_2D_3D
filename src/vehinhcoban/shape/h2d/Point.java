/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehinhcoban.shape.h2d;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import vehinhcoban.constant.SizeConstant;
import vehinhcoban.shape.h3d.Point3D;

/**
 *
 * @author 09096
 */
public class Point {

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Point(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public static void putPixel(Point point, BufferedImage image, int color_RGB) {
        if (point.getX() < image.getWidth() && point.getX() > 0
                && point.getY() < image.getHeight() && point.getY() > 0) {
            image.setRGB((int) point.getX(), (int) point.getY(), color_RGB);
        }
    }

    public static void putPoint(Point point, BufferedImage image, int color) {
        int width = 5;
        int length = 5;

        // to mau
        for (int i = width; i >= 0; i--) {
            for (int j = 0; j < length; j++) {
                Point p = new Point(point.getX() + j, point.getY() + i);
                if (p.getX() < image.getWidth() && p.getX() > 0
                        && p.getY() < image.getHeight() - 1 && p.getY() > 1) {
                    image.setRGB((int) p.getX(), (int) p.getY(), color);

                }
            }
        }
//         for(int i =5;i>0;i--){
//                for(int j=0;j<5;j++){
//                    int x = point.getX()+j;
//                    int y = point.getX()-i;
//                    if(x<=0||x>=SizeConstant.WIDTH_DRAW_PLACE||y<=0||y>=SizeConstant.HEIGHT_DRAW_PLACE){
//                           continue;
//                    }
//                    else{
//                        image.setRGB(x, y, color);
//                    }
//                    
//                }
//            }
//                                Rectangle rec  = new Rectangle(Point.convert_user(point), 5,5);
//                                rec.drawShape(image, color);
//            int width = 5;
//            int length = 5;
//            point = Point.convert(point.getX(), point.getY());
//            int x1 = point.getX() + length;
//            int y1 = point.getY();
//            Point b = new Point(x1, y1);
//
//            int x2 = point.getX();
//            int y2 = point.getY() + width;
//            Point d = new Point(x2, y2);
//
//            int x3 = x2 + length;
//            int y3 = y2;
//            Point c = new Point(x3, y3);
//
//            Line ab = new Line(point, b);
//            ab.drawLineWithSetRGB(image, color);
//            Point.putPixel(point, image,color);
//
//            Line bc = new Line(b, c);
//            bc.drawLineWithSetRGB(image, color);
//            Point.putPixel(b, image, color);
//
//            Line cd = new Line(c, d);
//            cd.drawLineWithSetRGB(image, color);
//            Point.putPixel(c, image, color);
//
//            Line da = new Line(d, point);
//            da.drawLineWithSetRGB(image, color);
//            Point.putPixel(d, image, color);

            // to mau
//            for (int i = width - 1; i >= 1; i--) {
//                for (int j = 1; j < length ; j++) {
//                    Point p = new Point(point.getX() + j, point.getY()+i);
//                    if (p.getX() < image.getWidth() && p.getX() > 0 
//            				&& p.getY() < image.getHeight() && p.getY() > 0) {
//            			image.setRGB((int) p.getX(),(int) p.getY(), ColorConstant.BLACK_RGB);
//            		
//            		}
//                }
        //}
        //}
    }

    public static void drawNamePoint(BufferedImage image, String name, Point p, Point goc) {
        Graphics2D graphics2d = (Graphics2D) image.getGraphics();
        graphics2d.setColor(Color.BLUE);
        graphics2d.drawString(name + "(" + goc.x + "," + goc.y + ")", p.getX() + 3, p.getY() - 3);
    }

    // đổi tọa độ của người dùng qua pixel
    public static Point convert(int x_user, int y_user) {
        // 1 don vi = 5 pixel
        int x;
        int y;
        int donvi = 5;

        x = (SizeConstant.WIDTH_DRAW_PLACE / 2) + (donvi * x_user);
        y = (SizeConstant.HEIGHT_DRAW_PLACE / 2) - (donvi * y_user);

        Point p = new Point(x, y);

        return p;
    }

    public static Point convert(Point a) {
        // 1 don vi = 5 pixel
        int x;
        int y;
        int donvi = 5;

        x = (SizeConstant.WIDTH_DRAW_PLACE / 2) + (donvi * a.getX());
        y = (SizeConstant.HEIGHT_DRAW_PLACE / 2) - (donvi * a.getY());

        Point p = new Point(x, y);

        return p;
    }

    public static Point convert_user(int x, int y) {
        // 1 don vi = 5 pixel
        int x_user;
        int y_user;
        int donvi = 5;

        x_user = (x - (SizeConstant.WIDTH_DRAW_PLACE / 2)) / donvi;
        y_user = (-(y - (SizeConstant.HEIGHT_DRAW_PLACE / 2)) / donvi) ;

        Point p = new Point(x_user, y_user);

        return p;
    }

    public static Point convert_user(Point a) {
        // 1 don vi = 5 pixel
        int x_user;
        int y_user;
        int donvi = 5;

        x_user = (a.getX() - (SizeConstant.WIDTH_DRAW_PLACE / 2)) / donvi;
        y_user = (-(a.getY() - (SizeConstant.HEIGHT_DRAW_PLACE / 2)) / donvi) ;

        Point p = new Point(x_user, y_user);

        return p;
    }
}
