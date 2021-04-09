/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehinhcoban.shape.h2d;

import java.awt.image.BufferedImage;
import vehinhcoban.constant.ColorConstant;
import vehinhcoban.shape.PhepBienDoi2D;

/**
 *
 * @author 09096
 */
public class HinhThang extends Shape{
    private Point diem;
    private int canh;
    private int cao;

    public HinhThang(Point diem, int canh,int cao) {
        this.diem = diem;
        this.canh = canh;
        this.cao = cao;
    }

    @Override
    void drawShape(BufferedImage image, int color) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Point trung_diem_day = new Point(diem.getX()+canh/2, diem.getY());
        
        Point diem_doi_dien = new Point(diem.getX()+canh, diem.getY());
        
//        Point diem_cao_trai = PhepBienDoi2D.xoayDiem(trung_diem_day, diem, 80);
//        Point diem_cao_phai = PhepBienDoi2D.xoayDiem(trung_diem_day, diem_doi_dien, -80);
        
        Point diem_cao_trai = new Point(diem.getX()+3, diem.getY()+cao);
        Point diem_cao_phai = new Point(diem.getX()+canh-3, diem.getY()+cao);
        
        Line canh_day = new Line(Point.convert(diem), Point.convert(diem_doi_dien));
        canh_day.drawShape(image, ColorConstant.BLACK_RGB);
        
        Line canh_nghieng_trai = new Line(Point.convert(diem), Point.convert(diem_cao_trai));
        canh_nghieng_trai.drawShape(image, ColorConstant.BLACK_RGB);
        Line canh_nghieng_phai = new Line(Point.convert(diem_doi_dien), Point.convert(diem_cao_phai));
        canh_nghieng_phai.drawShape(image, ColorConstant.BLACK_RGB);
        Line canh_cao = new Line(Point.convert(diem_cao_trai), Point.convert(diem_cao_phai));
        canh_cao.drawShape(image, ColorConstant.BLACK_RGB);
        
        
        //to mau
        Point td_thuc = Point.convert(trung_diem_day);
        int k =5;
        for(int i =canh_nghieng_trai.getPoints().size()-5;i>=5;i--){
               
               for(int j = 0;j<canh*5/2-5;j++){
                   
                    Point ve  = new Point(td_thuc.getX()-canh*5/2+j+5, td_thuc.getY()-k);
                    if(ve.getX()>canh_nghieng_trai.getPoints().get(i).getX()+5){
                       Point.putPoint(ve, image, color);
                    }
               }
               k++;
        }
        k=5;
        for(int i =canh_nghieng_phai.getPoints().size()-5;i>=5;i--){
               
               for(int j = 0;j<canh*5/2-5;j++){
                   
                    Point ve  = new Point(td_thuc.getX()+canh*5/2-j-5, td_thuc.getY()-k);
                    if(ve.getX()<canh_nghieng_phai.getPoints().get(i).getX()-5){
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

    public Point getDiem() {
        return diem;
    }

    public void setDiem(Point diem) {
        this.diem = diem;
    }

    public int getCanh() {
        return canh;
    }

    public void setCanh(int canh) {
        this.canh = canh;
    }

    public int getCao() {
        return cao;
    }

    public void setCao(int cao) {
        this.cao = cao;
    }
   
}
