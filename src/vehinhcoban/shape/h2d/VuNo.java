/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehinhcoban.shape.h2d;

import java.awt.image.BufferedImage;
import vehinhcoban.constant.ColorConstant;

/**
 *
 * @author 09096
 */
public class VuNo extends Shape{
    protected Point tam1;
    protected Point tam2;
    protected Point tam3;
    protected Point tam4;
    protected int R;

    public VuNo(Point tam1, int R) {
        this.tam1 = tam1;
        this.R = R;
    }
    
    @Override
    public void drawShape(BufferedImage image, int color) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Circle cir =new Circle(Point.convert(tam1), R);
         cir.drawShape(image, ColorConstant.BLACK_RGB);
        cir.toMau(image, color);
       
         setTam4(new Point(tam1.getX(), tam1.getY()+18));
        Circle cir4 =new Circle(Point.convert(tam4), R+18);
        cir4.drawShape(image, ColorConstant.BLACK_RGB);
        cir4.toMau(image, color);
        
        setTam2(new Point(tam1.getX()-6, tam1.getY()+6));
        Circle cir2 =new Circle(Point.convert(tam2), R+9);
        cir2.drawShape(image, ColorConstant.BLACK_RGB);
        cir2.toMau(image, color);
        
        
        setTam3(new Point(tam1.getX()+4, tam1.getY()+10));
        Circle cir3 =new Circle(Point.convert(tam3), R+14);
         cir3.drawShape(image, ColorConstant.BLACK_RGB);
        cir3.toMau(image, color);
       
        
       
        
    }

    @Override
    void tinhTien(BufferedImage image, int tr_x, int tr_y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void xoay(BufferedImage image, double theta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Point getTam1() {
        return tam1;
    }

    public void setTam1(Point tam1) {
        this.tam1 = tam1;
    }

    public Point getTam2() {
        return tam2;
    }

    public void setTam2(Point tam2) {
        this.tam2 = tam2;
    }

    public Point getTam3() {
        return tam3;
    }

    public void setTam3(Point tam3) {
        this.tam3 = tam3;
    }

    public Point getTam4() {
        return tam4;
    }

    public void setTam4(Point tam4) {
        this.tam4 = tam4;
    }

    public int getR() {
        return R;
    }

    public void setR(int R) {
        this.R = R;
    }
    
}
