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
public class CoiXayGio extends Shape{
    protected Point diemVe;
    protected Point diemMai;
    protected Point diemThan;
    protected Point diemDauDayDien;
    protected Point diemDauDayDienTram;
    protected Point diemTramDien1;
    protected Point diemTramDien2;
    protected Point diemTramDien3;
    protected Rectangle tram1;
    protected Rectangle tram2;
    protected Rectangle tram3;
    protected boolean chieu_xoay;
    
    
    //CANH 1
    protected Point diemCanh1;
    protected Point diemCanh2;
    
    //CANH 2
    protected Point diemCanh3;
    protected Point diemCanh4;
    
    //CANH 3
    protected Point diemCanh5;
    protected Point diemCanh6;
    
    //CANH 4
    protected Point diemCanh7;
    protected Point diemCanh8;
    
    protected int r_dauQuay = 5;
    public CoiXayGio(Point diemVe) {
        this.diemVe = diemVe;
        this.chieu_xoay = true;
        this.diemThan = new Point(diemVe.getX()-6, diemVe.getY()-41);
        this.diemDauDayDien=  new Point(diemThan.getX()+12, diemThan.getY()+5);
        this.diemDauDayDienTram = new Point(diemThan.getX()+12+20, diemThan.getY());
       // this.diemDauDayDien = new Point(diemThan.getX()+12, diemThan.getY()+5);
        this.diemTramDien1 = diemDauDayDienTram;
        this.diemTramDien2 = new Point(diemDauDayDienTram.getX()+10,diemDauDayDienTram.getY());
        this.diemTramDien3 = new Point(diemDauDayDienTram.getX()+20,diemDauDayDienTram.getY());
        this.tram1 = new Rectangle(diemTramDien1, 10, 20);
        this.tram2 = new Rectangle(diemTramDien2, 10, 20);
        this.tram3 = new Rectangle(diemTramDien3, 10, 20);
    }
    
    public void doCoiXayGio(BufferedImage image, int color){
        
        //dau
        Circle dauQuay = new Circle(Point.convert(diemVe.getX(), diemVe.getY()), r_dauQuay*5);
        dauQuay.drawShape(image, ColorConstant.BLACK_RGB);
        //than
        HinhThang than = new HinhThang(getDiemThan(),12,37);
        than.drawShape(image, color);
        //mai
        setDiemMai(new Point(diemVe.getX()-6, diemVe.getY()+r_dauQuay));
        HinhTamGiac tamgiac = new HinhTamGiac(12,getDiemMai(),10);
        tamgiac.drawShape(image, color);
        //DAY DIEN
        Line day_dien = new Line(Point.convert(getDiemDauDayDien()), Point.convert(new Point(getDiemDauDayDienTram().getX(), getDiemDauDayDienTram().getY()+5)));
        day_dien.drawLineNetDut(image, ColorConstant.BLACK_RGB);


        //4 canh
        setDiemCanh1(Point.convert(diemVe.getX()+r_dauQuay+23, diemVe.getY()+10));
        setDiemCanh2(Point.convert(diemVe.getX()+r_dauQuay+16, diemVe.getY()-10));
        
        setDiemCanh3(Point.convert(diemVe.getX()+10, diemVe.getY()+r_dauQuay+16));
        setDiemCanh4(Point.convert(diemVe.getX()-10, diemVe.getY()+r_dauQuay+23));
        
        setDiemCanh5(Point.convert(diemVe.getX()-r_dauQuay-16, diemVe.getY()+10));
        setDiemCanh6(Point.convert(diemVe.getX()-r_dauQuay-23, diemVe.getY()-10));

        setDiemCanh7(Point.convert(diemVe.getX()+10, diemVe.getY()-r_dauQuay-23));
        setDiemCanh8(Point.convert(diemVe.getX()-10, diemVe.getY()-r_dauQuay-16));
        

    }
    @Override
    public void drawShape(BufferedImage image, int color) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.doCoiXayGio(image, color);
    }

    @Override
    void tinhTien(BufferedImage image, int tr_x, int tr_y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void xoay(BufferedImage image, double theta_user) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Point diemve_convert= Point.convert(diemVe.getX(),diemVe.getY());
        double theta = 0;
        if(chieu_xoay==true){
            theta = -theta_user;
        }else{
            theta = theta_user;
        }
        //canh 1
        Point p1_canh1 = PhepBienDoi2D.xoayDiem(getDiemCanh1(), diemve_convert, theta);
        setDiemCanh1(p1_canh1);
        Line  li1_canh1 = new Line(diemve_convert, p1_canh1);
        li1_canh1.drawShape(image, ColorConstant.GREEN_RGB);
        
        Point p2_canh1 = PhepBienDoi2D.xoayDiem(getDiemCanh2(), diemve_convert,theta);
        setDiemCanh2(p2_canh1);
        Line  li2_canh1 = new Line(diemve_convert, p2_canh1);
        li2_canh1.drawShape(image, ColorConstant.GREEN_RGB);
        
        Line li3_canh1 = new Line(p1_canh1, p2_canh1);
        li3_canh1.drawShape(image, ColorConstant.GREEN_RGB);
        
        //canh 2
        Point p1_canh2 = PhepBienDoi2D.xoayDiem(getDiemCanh3(), diemve_convert,theta);
        setDiemCanh3(p1_canh2);
        Line  li1_canh2 = new Line(diemve_convert, p1_canh2);
        li1_canh2.drawShape(image, ColorConstant.RED_RGB);
        
        Point p2_canh2 = PhepBienDoi2D.xoayDiem(getDiemCanh4(), diemve_convert,theta);
        setDiemCanh4(p2_canh2);
        Line  li2_canh2 = new Line(diemve_convert, p2_canh2);
        li2_canh2.drawShape(image, ColorConstant.RED_RGB);
        
        Line li3_canh2 = new Line(p1_canh2, p2_canh2);
        li3_canh2.drawShape(image, ColorConstant.RED_RGB);
        
        //canh 3
        Point p1_canh3 = PhepBienDoi2D.xoayDiem(getDiemCanh5(), diemve_convert,theta);
        setDiemCanh5(p1_canh3);
        Line  li1_canh3 = new Line(diemve_convert, p1_canh3);
        li1_canh3.drawShape(image, ColorConstant.GREEN_RGB);
        
        Point p2_canh3 = PhepBienDoi2D.xoayDiem(getDiemCanh6(), diemve_convert,theta);
        setDiemCanh6(p2_canh3);
        Line  li2_canh3 = new Line(diemve_convert, p2_canh3);
        li2_canh3.drawShape(image, ColorConstant.GREEN_RGB);
        
        Line li3_canh3 = new Line(p1_canh3, p2_canh3);
        li3_canh3.drawShape(image, ColorConstant.GREEN_RGB);
//        
        //canh4
        Point p1_canh4 = PhepBienDoi2D.xoayDiem(getDiemCanh7(), diemve_convert,theta);
        setDiemCanh7(p1_canh4);
        Line  li1_canh4 = new Line(diemve_convert, p1_canh4);
        li1_canh4.drawShape(image, ColorConstant.RED_RGB);
        
        Point p2_canh4 = PhepBienDoi2D.xoayDiem(getDiemCanh8(), diemve_convert,theta);
        setDiemCanh8(p2_canh4);
        Line  li2_canh4 = new Line(diemve_convert, p2_canh4);
        li2_canh4.drawShape(image, ColorConstant.RED_RGB);
        
        Line li3_canh4 = new Line(p1_canh4, p2_canh4);
        li3_canh4.drawShape(image, ColorConstant.RED_RGB);
        
    }

    /**
     * @return the diemVe
     */
    public Point getDiemVe() {
        return diemVe;
    }

    /**
     * @param diemVe the diemVe to set
     */
    public void setDiemVe(Point diemVe) {
        this.diemVe = diemVe;
    }

    public Point getDiemCanh1() {
        return diemCanh1;
    }

    public void setDiemCanh1(Point diemCanh1) {
        this.diemCanh1 = diemCanh1;
    }

    public Point getDiemCanh2() {
        return diemCanh2;
    }

    public void setDiemCanh2(Point diemCanh2) {
        this.diemCanh2 = diemCanh2;
    }

    public Point getDiemCanh3() {
        return diemCanh3;
    }

    public void setDiemCanh3(Point diemCanh3) {
        this.diemCanh3 = diemCanh3;
    }

    public Point getDiemCanh4() {
        return diemCanh4;
    }

    public void setDiemCanh4(Point diemCanh4) {
        this.diemCanh4 = diemCanh4;
    }

    public int getR_dauQuay() {
        return r_dauQuay;
    }

    public void setR_dauQuay(int r_dauQuay) {
        this.r_dauQuay = r_dauQuay;
    }

    public Point getDiemCanh5() {
        return diemCanh5;
    }

    public void setDiemCanh5(Point diemCanh5) {
        this.diemCanh5 = diemCanh5;
    }

    public Point getDiemCanh6() {
        return diemCanh6;
    }

    public void setDiemCanh6(Point diemCanh6) {
        this.diemCanh6 = diemCanh6;
    }

    public Point getDiemCanh7() {
        return diemCanh7;
    }

    public void setDiemCanh7(Point diemCanh7) {
        this.diemCanh7 = diemCanh7;
    }

    public Point getDiemCanh8() {
        return diemCanh8;
    }

    public void setDiemCanh8(Point diemCanh8) {
        this.diemCanh8 = diemCanh8;
    }

    public boolean isChieu_xoay() {
        return chieu_xoay;
    }

    public void setChieu_xoay(boolean chieu_xoay) {
        this.chieu_xoay = chieu_xoay;
    }

    public Point getDiemMai() {
        return diemMai;
    }

    public void setDiemMai(Point diemMai) {
        this.diemMai = diemMai;
    }

    public Point getDiemThan() {
        return diemThan;
    }

    public void setDiemThan(Point diemThan) {
        this.diemThan = diemThan;
    }

    public Point getDiemDauDayDien() {
        return diemDauDayDien;
    }

    public void setDiemDauDayDien(Point diemDauDayDien) {
        this.diemDauDayDien = diemDauDayDien;
    }

    

    public Point getDiemDauDayDienTram() {
        return diemDauDayDienTram;
    }

    public void setDiemDauDayDienTram(Point diemDauDayDienTram) {
        this.diemDauDayDienTram = diemDauDayDienTram;
    }

    public Point getDiemTramDien1() {
        return diemTramDien1;
    }

    public void setDiemTramDien1(Point diemTramDien1) {
        this.diemTramDien1 = diemTramDien1;
    }

    public Point getDiemTramDien2() {
        return diemTramDien2;
    }

    public void setDiemTramDien2(Point diemTramDien2) {
        this.diemTramDien2 = diemTramDien2;
    }

    public Point getDiemTramDien3() {
        return diemTramDien3;
    }

    public void setDiemTramDien3(Point diemTramDien3) {
        this.diemTramDien3 = diemTramDien3;
    }

    public Rectangle getTram1() {
        return tram1;
    }

    public void setTram1(Rectangle tram1) {
        this.tram1 = tram1;
    }

    public Rectangle getTram2() {
        return tram2;
    }

    public void setTram2(Rectangle tram2) {
        this.tram2 = tram2;
    }

    public Rectangle getTram3() {
        return tram3;
    }

    public void setTram3(Rectangle tram3) {
        this.tram3 = tram3;
    }
    
}
