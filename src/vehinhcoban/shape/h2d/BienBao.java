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
public class BienBao extends Shape{
    protected Point diemThan;
    protected Point diemBien;
    protected Point diemKyHieu;

    public BienBao(Point diemBien) {
        this.diemThan = new Point(diemBien.getX()-3, diemBien.getY()-31);;
        this.diemBien = diemBien;
        this.diemKyHieu = new Point(diemBien.getX()-5, diemBien.getY()-2);
    }
    
    @Override
    public void drawShape(BufferedImage image, int color) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Circle bang = new Circle(Point.convert(getDiemBien()), 35);
        bang.drawShape(image, ColorConstant.BLACK_RGB);
        bang.toMau(image, ColorConstant.RED_RGB);
        
        Rectangle thanh_ngang = new Rectangle(getDiemKyHieu(), 10, 3);
        thanh_ngang.toMauHinh(image, ColorConstant.WHITE_RGB);
        
        Rectangle thanh_doc = new Rectangle(getDiemThan(), 6, 23);
        thanh_doc.drawShape(image,  ColorConstant.BLUE_RGB);
    }

    @Override
    void tinhTien(BufferedImage image, int tr_x, int tr_y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void xoay(BufferedImage image, double theta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Point getDiemThan() {
        return diemThan;
    }

    public void setDiemThan(Point diemThan) {
        this.diemThan = diemThan;
    }

    public Point getDiemBien() {
        return diemBien;
    }

    public void setDiemBien(Point diemBien) {
        this.diemBien = diemBien;
    }

    public Point getDiemKyHieu() {
        return diemKyHieu;
    }

    public void setDiemKyHieu(Point diemKyHieu) {
        this.diemKyHieu = diemKyHieu;
    }
    
}
