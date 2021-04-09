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
import vehinhcoban.shape.PhepBienDoi2D;
import vehinhcoban.shape.h2d.Line;
import vehinhcoban.shape.h2d.Point;

/**
 *
 * @author 09096
 */
public class HinhHopChuNhat extends Shape3D {

    protected int dai;
    protected int rong;
    
    protected Point3D Diem2;
    protected Point3D Diem3;
    protected Point3D Diem4;
    protected Point3D Diem5;
    protected Point3D Diem6;
    protected Point3D Diem7;
    protected Point3D Diem8;
    
    public HinhHopChuNhat(int dai, int rong, Point3D diem, int cao) {
        super(diem, cao);
        this.dai = dai;
        this.rong = rong;
       
    }

    public void doHinhHopChuNhat(BufferedImage image, int color) {
        int theta = -45;
        Point A = super.diem.convert_3D_2D();
        Point A2 = new Point(A.getX() + getRong(), A.getY());
        Point A4 = new Point(A.getX(), A.getY() + super.canh);
        Point A3 = new Point(A2.getX(), A2.getY() + super.canh);

        //xoay A5,6,7,8 quanh A1,2,3,4
        Point A5 = PhepBienDoi2D.xoayDiem(new Point(A.getX(), A.getY() + getDai()), A, theta);
        Point A6 = PhepBienDoi2D.xoayDiem(new Point(A2.getX(), A2.getY() + getDai()), A2, theta);
        Point A7 = PhepBienDoi2D.xoayDiem(new Point(A3.getX(), A3.getY() + getDai()), A3, theta);
        Point A8 = PhepBienDoi2D.xoayDiem(new Point(A4.getX(), A4.getY() + getDai()), A4, theta);

        Point[][] cap_canh = {{A, A2}, {A, A4}, {A2, A3}, {A3, A4},
                                        {A6, A7}, {A7, A8},{A4, A8}, {A3, A7}, {A2, A6}
                                        };
        Point[][] cap_canh_an = {{A, A5}, {A8, A5}, {A5, A6}};
        for (int i = 0; i < 9; i++) {
                Point x = Point.convert(cap_canh[i][0]);
                Point y = Point.convert(cap_canh[i][1]);
                Line li = new Line(x, y);
                li.drawShape(image, color);
        }
        for (int i = 0; i < 3; i++) {
                Point x = Point.convert(cap_canh_an[i][0]);
                Point y = Point.convert(cap_canh_an[i][1]);
                Line li = new Line(x, y);
                li.drawLineNetDut(image, color);
           
        }
        setDiem2(new Point3D(super.diem.getX()+rong,super.diem.getY(),super.diem.getZ()));
        setDiem3(new Point3D(super.diem.getX()+rong,super.diem.getY(),super.diem.getZ()+super.canh));
        setDiem4(new Point3D(super.diem.getX(),super.diem.getY(),super.diem.getZ()+super.canh));
        
        setDiem5(new Point3D(super.diem.getX(),super.diem.getY()+dai,super.diem.getZ()));
        setDiem6(new Point3D(super.diem.getX()+rong,super.diem.getY()+dai,super.diem.getZ()));
        setDiem7(new Point3D(super.diem.getX()+rong,super.diem.getY()+dai,super.diem.getZ()+super.canh));
        setDiem8(new Point3D(super.diem.getX(),super.diem.getY()+dai,super.diem.getZ()+super.canh));
        
        Graphics2D gd = (Graphics2D) image.createGraphics();
        gd.setColor(Color.RED);
        gd.setFont(new Font("TAHOMA", Font.BOLD, 18));
        Point[] points_ve_ten = {A,A2,A3,A4,A5,A6,A7,A8};
        for(int i =0;i<8;i++){
            Point p = new Point(points_ve_ten[i].getX()-3,points_ve_ten[i].getY()+3);
            Point temp = Point.convert(p);
            gd.drawString(i+1+"",temp.getX(), temp.getY());
        }
    }

    public int getDai() {
        return dai;
    }

    public void setDai(int dai) {
        this.dai = dai;
    }

    public int getRong() {
        return rong;
    }

    public void setRong(int rong) {
        this.rong = rong;
    }

    @Override
    public void drawShape3D(BufferedImage image, int color) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.doHinhHopChuNhat(image, color);
    }

    public Point3D getDiem2() {
        return Diem2;
    }

    public void setDiem2(Point3D Diem2) {
        this.Diem2 = Diem2;
    }

    public Point3D getDiem3() {
        return Diem3;
    }

    public void setDiem3(Point3D Diem3) {
        this.Diem3 = Diem3;
    }

    public Point3D getDiem4() {
        return Diem4;
    }

    public void setDiem4(Point3D Diem4) {
        this.Diem4 = Diem4;
    }

    public Point3D getDiem5() {
        return Diem5;
    }

    public void setDiem5(Point3D Diem5) {
        this.Diem5 = Diem5;
    }

    public Point3D getDiem6() {
        return Diem6;
    }

    public void setDiem6(Point3D Diem6) {
        this.Diem6 = Diem6;
    }

    public Point3D getDiem7() {
        return Diem7;
    }

    public void setDiem7(Point3D Diem7) {
        this.Diem7 = Diem7;
    }

    public Point3D getDiem8() {
        return Diem8;
    }

    public void setDiem8(Point3D Diem8) {
        this.Diem8 = Diem8;
    }

}
