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
public class Nha extends Shape{
    protected Point diemve;
    protected Point diemMai;
    protected Point diemCuaSo1;
    protected Point diemCuaSo2;
    protected Point diemCua;
    int lenght = 40;
    int width = 20;
    public Nha(Point diemve){
        this.diemve = diemve;
        this.diemMai = new Point(diemve.getX(),diemve.getY()+20);
        this.diemCua = new Point(diemve.getX()+lenght/2-3,diemve.getY());
        this.diemCuaSo1= new Point(diemve.getX()+lenght/4-3,diemve.getY()+10);
        this.diemCuaSo2=new Point(diemve.getX()+lenght/2+lenght/4-3,diemve.getY()+10);
    }
    @Override
    public void drawShape(BufferedImage image, int color) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        Rectangle rec = new Rectangle(diemve, lenght,width);
        rec.drawShape(image, color);
        
        
        HinhTamGiac tm = new HinhTamGiac(40,getDiemMai() ,20);
        tm.drawShape(image, ColorConstant.ORANGE_RGB);
        
        Rectangle cua = new Rectangle(getDiemCua(), 6, 10);
        cua.drawShape(image, ColorConstant.WHITE_RGB);
        
        Rectangle cuaso = new Rectangle(getDiemCuaSo1(), 6, 6);
        cuaso.drawShape(image, ColorConstant.WHITE_RGB);
        
        Rectangle cuaso2 = new Rectangle(getDiemCuaSo2(), 6, 6);
        cuaso2.drawShape(image, ColorConstant.WHITE_RGB);
        
    }

    @Override
    void tinhTien(BufferedImage image, int tr_x, int tr_y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void xoay(BufferedImage image, double theta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Point getDiemve() {
        return diemve;
    }

    public void setDiemve(Point diemve) {
        this.diemve = diemve;
    }

    public Point getDiemMai() {
        return diemMai;
    }

    public void setDiemMai(Point diemMai) {
        this.diemMai = diemMai;
    }

    public Point getDiemCuaSo1() {
        return diemCuaSo1;
    }

    public void setDiemCuaSo1(Point diemCuaSo1) {
        this.diemCuaSo1 = diemCuaSo1;
    }

    public Point getDiemCuaSo2() {
        return diemCuaSo2;
    }

    public void setDiemCuaSo2(Point diemCuaSo2) {
        this.diemCuaSo2 = diemCuaSo2;
    }

    public Point getDiemCua() {
        return diemCua;
    }

    public void setDiemCua(Point diemCua) {
        this.diemCua = diemCua;
    }
    
}
