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
public class HinhTamGiac extends Shape{
    private int canh;
    private int h;
    private Point diem;

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getCanh() {
        return canh;
    }

    public void setCanh(int canh) {
        this.canh = canh;
    }

    public Point getDiem() {
        return diem;
    }

    public void setDiem(Point diem) {
        this.diem = diem;
    }

    public HinhTamGiac(int canh, Point diem,int h) {
        this.canh = canh;
        this.diem = diem;
        this.h = h;
    }
    
    @Override
    void drawShape(BufferedImage image, int color) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Point diem2 = new Point(diem.getX()+canh, diem.getY());
        Point td = new Point(diem.getX()+canh/2, diem.getY());
        
        
        Point dinh = new Point(td.getX(), td.getY()+h);
        
        Point diem_thuc = Point.convert(diem);
        Point diem_2_thuc = Point.convert(diem2);
        Point dinh_thuc = Point.convert(dinh);
        Point td_thuc = Point.convert(td);
        
        Line canh1=new Line(dinh_thuc, diem_thuc);
        canh1.drawShape(image, ColorConstant.BLACK_RGB);
        Line canh2=new Line(diem_thuc, diem_2_thuc);
        canh2.drawShape(image, ColorConstant.BLACK_RGB);
        Line canh3=new Line(diem_2_thuc, dinh_thuc);
        canh3.drawShape(image, ColorConstant.BLACK_RGB);
        int k =5;
        for(int i =canh1.getPoints().size()-5;i>=5;i--){
               
               for(int j = 0;j<canh*5/2-5;j++){
                   
                    Point ve  = new Point(td_thuc.getX()-canh*5/2+j+5, td_thuc.getY()-k);
                    if(ve.getX()>canh1.getPoints().get(i).getX()+5){
                       Point.putPoint(ve, image, color);
                    }
               }
               k++;
        }
        k=5;
        for(int i =canh3.getPoints().size()-5;i>=5;i--){
               
               for(int j = 0;j<canh*5/2-5;j++){
                   Point ve = null;
                   
                       ve  = new Point(td_thuc.getX()+canh*5/2-j-5, td_thuc.getY()-k);
                    if(ve.getX()<canh3.getPoints().get(i).getX()-5){
                       Point.putPoint(ve, image, color);
                    }
               }
               k++;
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
