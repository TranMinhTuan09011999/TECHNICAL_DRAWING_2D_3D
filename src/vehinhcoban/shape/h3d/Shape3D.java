/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehinhcoban.shape.h3d;

import java.awt.image.BufferedImage;

/**
 *
 * @author 09096
 */
public abstract class Shape3D {
    protected Point3D diem;
    protected int canh;
    public abstract void drawShape3D(BufferedImage image,int color);

    public Shape3D(Point3D diem, int canh) {
        this.diem = diem;
        this.canh = canh;
    }
    
    public Point3D getDiem() {
        return diem;
    }

    public void setDiem(Point3D diem) {
        this.diem = diem;
    }

    public int getCanh() {
        return canh;
    }

    public void setCanh(int canh) {
        this.canh = canh;
    }
 
}

   