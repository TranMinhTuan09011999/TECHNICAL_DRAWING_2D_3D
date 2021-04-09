/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehinhcoban.shape.h3d;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import vehinhcoban.constant.SizeConstant;
import vehinhcoban.shape.h2d.Ellipse;
import vehinhcoban.shape.h2d.Line;
import vehinhcoban.shape.h2d.Point;

/**
 *
 * @author 09096
 */
public class HinhTru extends Shape3D {
    private String ten_tam;
    private int R;
    private Point3D tam_cao_3D;
    private  Point3D day_R1;
    private Point3D cao_R2;
     
    public HinhTru(Point3D p, int chieucao,int R,String ten_tam) {
        super(p, chieucao);
        this.R = R;
        this.ten_tam = ten_tam;
    }

    public void doHinhTru(BufferedImage image, int color) {
        setTam_cao_3D(new Point3D(super.diem.getX(), super.diem.getY(), super.diem.getZ()+super.canh));
        
        Point tam1 = super.diem.convert_3D_2D();
        Point tam2 = this.tam_cao_3D.convert_3D_2D();
        
        int r = getR()*5;
        int rong = r/4;
        
        Point tam_day = Point.convert(tam1);
        Point tam_cao = Point.convert(tam2);
        //day
        Ellipse day = new Ellipse(tam_day, r, rong);
        day.doElipseNetDut(image, color);

        //Point tam2 = new Point(Point.convert(tam1).getX(), Point.convert(tam1).getY());
        //dinh
        
        Ellipse dinh = new Ellipse(tam_cao,r, rong);
        dinh.drawShape(image, color);
        
        Point a_canhcao_1 = new Point(tam_day.getX()+r, tam_day.getY());
        Point b_canhcao_1 = new Point(tam_cao.getX()+r, tam_cao.getY());
        Line canhcao_1 = new Line(a_canhcao_1, b_canhcao_1);
        canhcao_1.drawShape(image, color);
        
        Point a_canhcao_2 = new Point(tam_day.getX()-r, tam_day.getY());
        Point b_canhcao_2 = new Point(tam_cao.getX()-r, tam_cao.getY());
        Line canhcao_2 = new Line(a_canhcao_2, b_canhcao_2);
        canhcao_2.drawShape(image, color);
        
        Line duong_noi_tam = new Line(tam_day, tam_cao);
        duong_noi_tam.drawLineNetDut(image, color);
        
        // ban kinh
        Line r_cao = new Line(tam_cao, b_canhcao_1);
        r_cao.drawShape(image, color);
        
        Line r_day = new Line(tam_day, a_canhcao_1);
        r_day.drawLineNetDut(image, color);
        
        setDay_R1(new Point3D(super.diem.getX()+R, super.diem.getY(), super.diem.getZ()));
        setCao_R2(new Point3D(getTam_cao_3D().getX()+R, getTam_cao_3D().getY(), getTam_cao_3D().getZ()));
        
        Graphics2D gd = (Graphics2D) image.createGraphics();
        gd.setColor(Color.RED);
        gd.setFont(new Font("TAHOMA", Font.BOLD, 18));
        gd.drawString(getTen_tam(), tam_day.getX()-15, tam_day.getY()+3);
        gd.drawString(getTen_tam()+"'", tam_cao.getX()-15, tam_cao.getY()-3);
        gd.drawString("R", a_canhcao_1.getX()+15, a_canhcao_1.getY()-3);
        gd.drawString("R'", b_canhcao_1.getX()+15, b_canhcao_1.getY()+3);
        
    }

    @Override
    public void drawShape3D(BufferedImage image, int color) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.doHinhTru(image, color);
    }

    public Point3D getTam_cao_3D() {
        return tam_cao_3D;
    }

    public void setTam_cao_3D(Point3D tam_cao_3D) {
        this.tam_cao_3D = tam_cao_3D;
    }

    public String getTen_tam() {
        return ten_tam;
    }

    public void setTen_tam(String ten_tam) {
        this.ten_tam = ten_tam;
    }

    public int getR() {
        return R;
    }

    public void setR(int R) {
        this.R = R;
    }

    public Point3D getDay_R1() {
        return day_R1;
    }

    public void setDay_R1(Point3D day_R1) {
        this.day_R1 = day_R1;
    }

    public Point3D getCao_R2() {
        return cao_R2;
    }

    public void setCao_R2(Point3D cao_R2) {
        this.cao_R2 = cao_R2;
    }

    

    
    
}
