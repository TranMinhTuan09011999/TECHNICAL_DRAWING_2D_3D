/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehinhcoban.shape;

import vehinhcoban.shape.h2d.Point;

/**
 *
 * @author 09096
 */
public class PhepBienDoi2D {

    public static double[][] nhanMatran(double[][] matA, double[][] matB) {
        double res[][] = new double[matA.length][];
        for (int i = 0; i < res.length; i++) {
            res[i] = new double[matA[i].length];
        }
        for (int i = 0; i < matA.length; i++) {
            for (int k = 0; k < matB.length; k++) {
                double temp = 0;
                for (int j = 0; j < matA[i].length; j++) {
                    temp += matA[i][j] * matB[j][k];
                }
                res[i][k] = temp;
            }
        }
        return res;
    }

    public static Point tinhTienDiem(Point a, int tr_x, int tr_y) {
        double[][] matrix_point = {{a.getX(), a.getY(), 1}};
        double[][] matrix_tinhtien = {{1, 0, 0},
        {0, 1, 0},
        {tr_x, tr_y, 1}};
        double[][] mt_ketqua = nhanMatran(matrix_point, matrix_tinhtien);

        return returnPoint(mt_ketqua);
    }

    public static Point xoayDiem(Point a, Point xoay_quanh_b, double theta) {
        double radians = Math.toRadians(theta);
        double matP[][] = {{a.getX(), a.getY(), 1}};
        double sinTheta = Math.sin(radians);
        double cosTheta = Math.cos(radians);
        double[][] rotMatrix = {{cosTheta, sinTheta, 0}, 
                                        {-sinTheta, cosTheta, 0}, 
                                        {(1-cosTheta)*xoay_quanh_b.getX()+sinTheta*xoay_quanh_b.getY(),-sinTheta*xoay_quanh_b.getX()+(1-cosTheta)*xoay_quanh_b.getY(), 1}};

        Point a_sau_xoay = returnPoint(nhanMatran(matP, rotMatrix));

        return a_sau_xoay;
    }

    public static Point doiXungDiemQuaO(Point p) {
        double matP[][] = {{p.getX(), p.getY(), 1}};
        double mat[][] = {{-1, 0, 0}, {0, -1, 0}, {0, 0, 1}};
        return returnPoint(nhanMatran(matP, mat));
    }

    public static Point doiXungDiemQuaOx(Point p) {
        double matP[][] = {{p.getX(), p.getY(), 1}};
        double mat[][] = {{1, 0, 0}, {0, -1, 0}, {0, 0, 1}};
        return returnPoint(nhanMatran(matP, mat));
    }

    public static Point doiXungDiemQuaOy(Point p) {
        double matP[][] = {{p.getX(), p.getY(), 1}};
        double mat[][] = {{-1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        return returnPoint(nhanMatran(matP, mat));
    }

    public static double[][] doiXungDiemQuaDiem(Point p, int xDistance, int yDistance) {
        double matP[][] = {{p.getX(), p.getY(), 1}};
        double mat[][] = {{1, 0, 0}, {0, 1, 0}, {2 * xDistance, 2 * yDistance, 1}};
        return nhanMatran(matP, mat);
    }

    public static Point returnPoint(double matrix[][]) {
        return new Point((int) matrix[0][0], (int) matrix[0][1]);
    }
}
