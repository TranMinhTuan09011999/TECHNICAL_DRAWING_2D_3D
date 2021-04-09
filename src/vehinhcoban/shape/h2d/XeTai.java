/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehinhcoban.shape.h2d;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import vehinhcoban.constant.ColorConstant;
import vehinhcoban.constant.NameConstant;
import vehinhcoban.shape.PhepBienDoi2D;

/**
 *
 * @author 09096
 */
public class XeTai extends Shape {

    protected Point a;

    //2 tam banh xe
    protected Point x;
    protected Point y;
    
    protected Point diem_dau;
    protected Point diem_hop_dau;
    protected Point diem_cua_so;
    protected Point diem_den;
    
    //2 diem quay banh xe 1
    protected Point d1;
    protected Point d2;

    //2 diem quay banh xe 2
    protected Point d3;
    protected Point d4;

    protected String huong;
    protected boolean quayxe;

    protected int r_banhxe = 25;
    int dai_hopsau = 35;
    int cao_hopsau = 20;

    int dai_dau = 15;
    int cao_dau = 7;

    int dai_hopdau = 10;
    int cao_hopdau = 7;

    public XeTai(Point x) {
        this.a = x;
        this.huong = NameConstant.PHAI;
        this.quayxe = false;
        points = new ArrayList<>();
    }

    public void doXetai(BufferedImage image, int color) {

        // than
        Rectangle than = new Rectangle(getA(), dai_hopsau, cao_hopsau);
        than.drawShape(image, ColorConstant.GRAY_RGB);
        setDiem_dau(new Point(getA().getX() + dai_hopsau, getA().getY()));
        //dau
        Rectangle dau = new Rectangle(getDiem_dau(), dai_dau, cao_dau);
        dau.drawShape(image, ColorConstant.BLUE_RGB);
        //den
        setDiem_den(new Point(getA().getX() + dai_hopsau + dai_dau - 5, getA().getY() + 2));
        Rectangle den = new Rectangle(getDiem_den(), 5, 3);
        den.drawShape(image, ColorConstant.ORANGE_RGB);
        //HOP DAU
        setDiem_hop_dau(new Point(getA().getX() + dai_hopsau, getA().getY() + 7));
        Rectangle dau_nho = new Rectangle(getDiem_hop_dau(), dai_hopdau, cao_hopdau);
        dau_nho.drawShape(image, ColorConstant.RED_RGB);
        //buong lai
        setDiem_cua_so(new Point(getA().getX() + dai_hopsau + 2, getA().getY() + 8));
        Rectangle dau_nho2 = new Rectangle(getDiem_cua_so(), 6, 4);
        dau_nho2.drawShape(image, ColorConstant.WHITE_RGB);

        //banh xe 1
        Point b1 = Point.convert(getA().getX() + (r_banhxe / 5), getA().getY() - (r_banhxe / 5));
        setX(b1);
        Circle c1 = new Circle(b1, r_banhxe);
        c1.drawShape(image, color);

        // banh xe 2
        Point b2 = Point.convert(getA().getX() + dai_hopsau + (r_banhxe / 5), getA().getY() - (r_banhxe / 5));
        setY(b2);
        Circle c2 = new Circle(b2, r_banhxe);
        c2.drawShape(image, color);

        setD1(new Point(x.getX(), x.getY() - r_banhxe));
        setD2(new Point(x.getX(), x.getY() + r_banhxe));

        setD3(new Point(y.getX(), y.getY() - r_banhxe));
        setD4(new Point(y.getX(), y.getY() + r_banhxe));

    }

    public void doXetai_QuayXe(BufferedImage image, int color) {

        // than
        Rectangle than = new Rectangle(new Point(getA().getX(), getA().getY()), dai_hopsau, cao_hopsau);
        than.drawShape(image, ColorConstant.GRAY_RGB);

        //dau
        setDiem_dau(new Point(getA().getX() - dai_dau, getA().getY()));
        Rectangle dau = new Rectangle(getDiem_dau(), dai_dau, cao_dau);
        dau.drawShape(image, ColorConstant.BLUE_RGB);
        //den
        setDiem_den(new Point(getA().getX() - dai_dau, getA().getY() + 2));
        Rectangle den = new Rectangle(getDiem_den(), 5, 3);
        den.drawShape(image, ColorConstant.ORANGE_RGB);
        //HOP DAU
        setDiem_hop_dau(new Point(getA().getX() -dai_hopdau, getA().getY() + cao_dau));
        Rectangle dau_nho = new Rectangle(getDiem_hop_dau(), dai_hopdau, cao_hopdau);
        dau_nho.drawShape(image, ColorConstant.RED_RGB);
        //buong lai
        
        setDiem_cua_so( new Point(getA().getX() - 8, getA().getY() + 8));
        Rectangle dau_nho2 = new Rectangle(getDiem_cua_so(), 6, 4);
        dau_nho2.drawShape(image, ColorConstant.WHITE_RGB);

        //banh xe 1
        Point b1 = Point.convert(getA().getX() - (r_banhxe / 5), getA().getY() - (r_banhxe / 5));
        setX(b1);
        Circle c1 = new Circle(b1, r_banhxe);
        c1.drawShape(image, color);

        // banh xe 2
        Point b2 = Point.convert(getA().getX() + dai_hopsau - (r_banhxe / 5), getA().getY() - (r_banhxe / 5));
        setY(b2);
        Circle c2 = new Circle(b2, r_banhxe);
        c2.drawShape(image, color);

        setD1(new Point(x.getX(), x.getY() - r_banhxe));
        setD2(new Point(x.getX(), x.getY() + r_banhxe));

        setD3(new Point(y.getX(), y.getY() - r_banhxe));
        setD4(new Point(y.getX(), y.getY() + r_banhxe));

    }

    @Override
    public void drawShape(BufferedImage image, int color) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(quayxe == false){
            this.doXetai(image, color);
        }else{
            this.doXetai_QuayXe(image, color);
        }
    }

    @Override
    public void tinhTien(BufferedImage image, int tr_x, int tr_y) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Point a_tt = PhepBienDoi2D.tinhTienDiem(a, tr_x, tr_y);
        setA(a_tt);

    }

    @Override
    public void xoay(BufferedImage image, double theta) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //bx1 
        double theta_temp;
         if(quayxe == false){
            theta_temp = -theta;
        }else{
            theta_temp = theta;
        }
        setD1(PhepBienDoi2D.xoayDiem(getD1(), x, theta_temp));
        Line thanh_1 = new Line(x, getD1());
        thanh_1.drawShape(image, ColorConstant.BLACK_RGB);

        setD2(PhepBienDoi2D.xoayDiem(getD2(), x, theta_temp));
        Line thanh_2 = new Line(x, getD2());
        thanh_2.drawShape(image, ColorConstant.BLACK_RGB);

        //bx2
        setD3(PhepBienDoi2D.xoayDiem(getD3(), y, theta_temp));
        Line thanh_3 = new Line(y, getD3());
        thanh_3.drawShape(image, ColorConstant.BLACK_RGB);

        setD4(PhepBienDoi2D.xoayDiem(getD4(), y, theta_temp));
        Line thanh_4 = new Line(y, getD4());
        thanh_4.drawShape(image, ColorConstant.BLACK_RGB);
    }

    /**
     * @return the a
     */
    public Point getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(Point a) {
        this.a = a;
    }

    public Point getX() {
        return x;
    }

    public void setX(Point x) {
        this.x = x;
    }

    public Point getY() {
        return y;
    }

    public void setY(Point y) {
        this.y = y;
    }

    public Point getD1() {
        return d1;
    }

    public void setD1(Point d1) {
        this.d1 = d1;
    }

    public Point getD3() {
        return d3;
    }

    public void setD3(Point d3) {
        this.d3 = d3;
    }

    public int getR_banhxe() {
        return r_banhxe;
    }

    public void setR_banhxe(int r_banhxe) {
        this.r_banhxe = r_banhxe;
    }

    public Point getD2() {
        return d2;
    }

    public void setD2(Point d2) {
        this.d2 = d2;
    }

    public Point getD4() {
        return d4;
    }

    public void setD4(Point d4) {
        this.d4 = d4;
    }

    public String getHuong() {
        return huong;
    }

    public void setHuong(String huong) {
        this.huong = huong;
    }

    public boolean isQuayxe() {
        return quayxe;
    }

    public void setQuayxe(boolean quayxe) {
        this.quayxe = quayxe;
    }

    public Point getDiem_dau() {
        return diem_dau;
    }

    public void setDiem_dau(Point diem_dau) {
        this.diem_dau = diem_dau;
    }

    public Point getDiem_hop_dau() {
        return diem_hop_dau;
    }

    public void setDiem_hop_dau(Point diem_hop_dau) {
        this.diem_hop_dau = diem_hop_dau;
    }

    public Point getDiem_cua_so() {
        return diem_cua_so;
    }

    public void setDiem_cua_so(Point diem_cua_so) {
        this.diem_cua_so = diem_cua_so;
    }

    public Point getDiem_den() {
        return diem_den;
    }

    public void setDiem_den(Point diem_den) {
        this.diem_den = diem_den;
    }

}
