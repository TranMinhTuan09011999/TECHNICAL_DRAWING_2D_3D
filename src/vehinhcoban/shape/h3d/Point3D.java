/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehinhcoban.shape.h3d;

import vehinhcoban.shape.h2d.Point;

/**
 *
 * @author 09096
 */
public class Point3D {
    protected int x;
    protected int y;
    protected int z;
    
    public Point3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Point convert_3D_2D(){
        //chieu len oxz với ox = ox , oy = oz
        int X_2D =(int) (this.x-this.y*(Math.sqrt(2)/2));
        int Y_2D = (int) (this.z-this.y*(Math.sqrt(2)/2));
        return new Point(X_2D, Y_2D);
    }
    
    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the z
     */
    public int getZ() {
        return z;
    }

    /**
     * @param z the z to set
     */
    public void setZ(int z) {
        this.z = z;
    }
    
}
