/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehinhcoban.shape;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import vehinhcoban.constant.ColorConstant;
import vehinhcoban.constant.SizeConstant;
import vehinhcoban.shape.h2d.Line;
import vehinhcoban.shape.h2d.Point;

/**
 *
 * @author 09096
 */
public class Coordinate {

    public static void drawCoordinate2d(BufferedImage image) {
        for(int i=5;i<SizeConstant.WIDTH_DRAW_PLACE;i=i+5){
            Line li = new Line(new Point(i, 0), new Point(i, SizeConstant.HEIGHT_DRAW_PLACE) );
            li.veThuong(image, ColorConstant.BLACK_RGB);
        }
        
        for(int i=5;i<SizeConstant.HEIGHT_DRAW_PLACE;i=i+5){
            Line li = new Line(new Point(0, i), new Point(SizeConstant.WIDTH_DRAW_PLACE, i) );
            li.veThuong(image, ColorConstant.BLACK_RGB);
        }
        
        int x1_horizontal, y1_horizontal, x2_horizontal, y2_horizontal;
        int x1_vertical, y1_vertical, x2_vertical, y2_vertical;
        // vẽ trục hoành
        x1_horizontal = 0;
        y1_horizontal = SizeConstant.HEIGHT_DRAW_PLACE / 2;

        Point p1_horizontal = new Point(x1_horizontal, y1_horizontal);

        x2_horizontal = SizeConstant.WIDTH_DRAW_PLACE;
        y2_horizontal = y1_horizontal;

        Point p2_horizontal = new Point(x2_horizontal, y2_horizontal);

        Line horizontalBar = new Line(p1_horizontal, p2_horizontal);
        horizontalBar.drawShape(image, ColorConstant.BLACK_RGB);

        // vẽ trục tung
        x1_vertical = SizeConstant.WIDTH_DRAW_PLACE / 2;
        x2_vertical = x1_vertical;

        y1_vertical = 0;
        y2_vertical = SizeConstant.HEIGHT_DRAW_PLACE;

        Point p1_vertical = new Point(x1_vertical, y1_vertical);
        Point p2_vertical = new Point(x2_vertical, y2_vertical);

        Line verticalBar = new Line(p1_vertical, p2_vertical);
        verticalBar.drawShape(image, ColorConstant.BLACK_RGB);
        
        
        
        Graphics2D gd = (Graphics2D) image.createGraphics();
        gd.setColor(Color.RED);
        gd.setFont(new Font("TAHOMA", Font.BOLD, 20));
        gd.drawString("x", SizeConstant.WIDTH_DRAW_PLACE - 15, (SizeConstant.HEIGHT_DRAW_PLACE / 2) - 10);
        gd.drawString("y", (SizeConstant.WIDTH_DRAW_PLACE / 2) - 15, 15);
        gd.drawString("o", (SizeConstant.WIDTH_DRAW_PLACE / 2) - 15, (SizeConstant.HEIGHT_DRAW_PLACE / 2) + 15);
    }

    public static void drawCoordinate3D(BufferedImage image) {
         for(int i=5;i<SizeConstant.WIDTH_DRAW_PLACE;i=i+5){
            Line li = new Line(new Point(i, 0), new Point(i, SizeConstant.HEIGHT_DRAW_PLACE) );
            li.veThuong(image, ColorConstant.BLACK_RGB);
        }
        
        for(int i=5;i<SizeConstant.HEIGHT_DRAW_PLACE;i=i+5){
            Line li = new Line(new Point(0, i), new Point(SizeConstant.WIDTH_DRAW_PLACE, i) );
            li.veThuong(image, ColorConstant.BLACK_RGB);
        }
        
        Point toado_O = new Point((SizeConstant.WIDTH_DRAW_PLACE / 2), (SizeConstant.HEIGHT_DRAW_PLACE / 2));
        Point toado_Z = new Point(toado_O.getX(), 0);
        Point toado_X = new Point(toado_O.getX()*2, toado_O.getY());
        
        
        Point toado_Z1 = PhepBienDoi2D.doiXungDiemQuaO(Point.convert_user(toado_Z));
        Point toado_X1 = PhepBienDoi2D.doiXungDiemQuaO(Point.convert_user(toado_X));
        
        Point toado_Y = PhepBienDoi2D.xoayDiem(toado_Z1, Point.convert_user(toado_O), -45);
  
        Line Ox = new Line(toado_O, toado_X);
        Ox.drawShape(image, ColorConstant.BLACK_RGB);
        
        Line Oz = new Line(toado_O, toado_Z);
        Oz.drawShape(image, ColorConstant.BLACK_RGB);
        
        Line Ox1 = new Line(toado_O, Point.convert(toado_X1));
        Ox1.drawLineNetDut(image, ColorConstant.BLACK_RGB);
        
        Line Oz1 = new Line(toado_O, Point.convert(toado_Z1));
        Oz1.drawLineNetDut(image, ColorConstant.BLACK_RGB);
        
        Line Oy = new Line(toado_O,Point.convert(toado_Y.getX()-30,toado_Y.getY()-30));
        Oy.drawShape(image, ColorConstant.BLACK_RGB);
        
        Point chu_y = Point.convert(toado_Y.getX()-15,toado_Y.getY()-15);
        Graphics2D gd = (Graphics2D) image.createGraphics();
        
        gd.setColor(Color.RED);
        gd.setFont(new Font("TAHOMA", Font.BOLD, 20));
        gd.drawString("x", SizeConstant.WIDTH_DRAW_PLACE - 15, (SizeConstant.HEIGHT_DRAW_PLACE / 2) - 10);
        gd.drawString("z", (SizeConstant.WIDTH_DRAW_PLACE / 2) - 15, 15);
        gd.drawString("y",chu_y.getX()-10 ,chu_y.getY() );
        gd.drawString("o", (SizeConstant.WIDTH_DRAW_PLACE / 2) - 20, (SizeConstant.HEIGHT_DRAW_PLACE / 2) + 15);

    }
}
