/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehinhcoban.shape.h2d;

import java.awt.image.BufferedImage;
import vehinhcoban.shape.PhepBienDoi2D;

/**
 *
 * @author 09096
 */
public class TiaDien extends Shape{
    protected Point diemPoint ;
    protected Point diemCuoi ;
    protected int doan = 2;

    public TiaDien(Point diemPoint) {
        this.diemPoint = diemPoint;
    }
    
    @Override
    public void drawShape(BufferedImage image, int color) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Point b = new Point(diemPoint.getX()+doan, diemPoint.getY());
        Point b_cv = Point.convert(b);
        Line ab = new Line(Point.convert(diemPoint),b_cv);
        ab.drawShape(image, color);
        
        Point c = new Point(b.getX()+doan-1, b.getY()+3);
        Point c_cv = Point.convert(c);
        Line bc = new Line(b_cv, c_cv);
        bc.drawShape(image, color);
        
        Point d = new Point(c.getX()+doan-1, b.getY()-3);
        Point d_cv = Point.convert(d);
        Line cd = new Line(c_cv, d_cv);
        cd.drawShape(image, color);
        
        Point e = new Point(d.getX()+doan-1, b.getY());
        Point e_cv = Point.convert(e);
        Line de = new Line(d_cv, e_cv);
        de.drawShape(image, color);
        
        Point f = new Point(e.getX()+doan, e.getY());
        Point f_cv = Point.convert(f);
        Line ef = new Line( e_cv,f_cv);
        ef.drawShape(image, color);
        setDiemCuoi(f);
    }

    @Override
    public void tinhTien(BufferedImage image, int tr_x, int tr_y) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Point p = PhepBienDoi2D.tinhTienDiem(getDiemPoint(), tr_x, tr_y);
        setDiemPoint(p);
    }

    @Override
    void xoay(BufferedImage image, double theta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Point getDiemPoint() {
        return diemPoint;
    }

    public void setDiemPoint(Point diemPoint) {
        this.diemPoint = diemPoint;
    }

    public Point getDiemCuoi() {
        return diemCuoi;
    }

    public void setDiemCuoi(Point diemCuoi) {
        this.diemCuoi = diemCuoi;
    }
    
}
