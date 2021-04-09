/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehinhcoban.model;

import javax.swing.JLabel;
import javax.swing.JTextField;
import vehinhcoban.shape.h2d.Point;
import vehinhcoban.shape.h3d.Point3D;

/**
 *
 * @author 09096
 */
public class XuLiComponent {

    public static void dienChiTietDiem2D(Point[] ds_point, JLabel... lblLabels) {
        int i = 0;
        for (JLabel label : lblLabels) {
            label.setText(ds_point[i].getX() + "," + ds_point[i].getY());
            i++;
        }
    }

    public static Point[] layDiemCanDienChiTietDiem2D(Point... points) {
        return points;
    }

    public static void dienChiTietDiem3D(Point3D[] ds_point, JLabel... lblLabels) {
        int i = 0;
        for (JLabel label : lblLabels) {
            label.setText(ds_point[i].getX() + "," + ds_point[i].getY() + "," + ds_point[i].getZ());
            i++;
        }
    }

    public static Point3D[] layDiemCanDienChiTietDiem3D(Point3D... points) {
        return points;
    }

    public static void resetTextField(JTextField... txt) {
        for (int i = 0; i < txt.length; i++) {
            txt[i].setText("");
        }
    }
    public static void resetLabel(JLabel... lbl) {
        for (int i = 0; i < lbl.length; i++) {
            lbl[i].setText("0,0");
        }
    }
    public static void resetLabel3D(JLabel... lbl) {
        for (int i = 0; i < lbl.length; i++) {
            lbl[i].setText("0,0,0");
        }
    }
}
