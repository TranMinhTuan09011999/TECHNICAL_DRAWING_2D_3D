/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehinhcoban.shape.h2d;

import java.awt.Color;
import java.awt.image.BufferedImage;
import vehinhcoban.constant.ColorConstant;
import vehinhcoban.constant.SizeConstant;
import vehinhcoban.shape.PhepBienDoi2D;

/**
 *
 * @author 09096
 */
public class TongQuan2D extends Shape{

    public TongQuan2D() {
    }
    public void veTroi(BufferedImage image){
        Color color = new Color(255,218,185);
        for(int i =0 ;i<150;i++){
            for(int j =0 ;j<SizeConstant.WIDTH_DRAW_PLACE;j++){
                Point.putPoint(new Point(j, i),image,color.getRGB());
            }
        }
    }
    public void veBien(BufferedImage image){
        Color color = new Color(0, 255, 255);
        for(int i =150 ;i<SizeConstant.HEIGHT_DRAW_PLACE-300;i++){
            for(int j =0 ;j<SizeConstant.WIDTH_DRAW_PLACE;j++){
                Point.putPoint(new Point(j, i),image,color.getRGB());
            }
        }
    }
    public void veDatLien(BufferedImage image){
        Color color = new Color(128, 128, 0);
        for(int i =263 ;i<SizeConstant.HEIGHT_DRAW_PLACE-200;i++){
            for(int j =0 ;j<SizeConstant.WIDTH_DRAW_PLACE;j++){
                Point.putPoint(new Point(j, i),image,color.getRGB());
            }
        }
    }
    public void veDuong(BufferedImage image){
        Color color = new Color(192, 192, 192);
        for(int i =362 ;i<SizeConstant.HEIGHT_DRAW_PLACE;i++){
            for(int j =0 ;j<SizeConstant.WIDTH_DRAW_PLACE;j++){
                Point.putPoint(new Point(j, i),image,color.getRGB());
            }
        }
        Line li = new Line(new Point(0, 462), new Point(SizeConstant.WIDTH_DRAW_PLACE, 462));
        li.drawLineNetDut(image, ColorConstant.BLACK_RGB);
        // mui ten 1
        Point mt1_dd = new Point(SizeConstant.WIDTH_DRAW_PLACE/2-70, 410);
        Point temp = new Point(SizeConstant.WIDTH_DRAW_PLACE/2-40, 410);
        Point mt1_dd_xoay1 = PhepBienDoi2D.xoayDiem(temp, mt1_dd, 45);
        Point mt1_dd_xoay2 = PhepBienDoi2D.xoayDiem(temp, mt1_dd, -45);
        Point mt2_dd = new Point(SizeConstant.WIDTH_DRAW_PLACE/2+70, 410);
        Line duong_muiten = new Line(mt1_dd, mt2_dd);
        duong_muiten.drawShape(image, ColorConstant.BLACK_RGB);
        Line duong_mt_1 = new Line(mt1_dd, mt1_dd_xoay1);
        duong_mt_1.drawShape(image, ColorConstant.BLACK_RGB);
        
        Line duong_mt_2 = new Line(mt1_dd, mt1_dd_xoay2);
        duong_mt_2.drawShape(image, ColorConstant.BLACK_RGB);
        // mui ten 2
        Point mt1_dd2 = new Point(SizeConstant.WIDTH_DRAW_PLACE/2-70, 512);
        Point temp2 = new Point(SizeConstant.WIDTH_DRAW_PLACE/2-40, 512);
        Point mt2_dd_xoay1 = PhepBienDoi2D.xoayDiem(temp2, mt1_dd2, 45);
        Point mt2_dd_xoay2 = PhepBienDoi2D.xoayDiem(temp2, mt1_dd2, -45);
        Point mt2_dd2 = new Point(SizeConstant.WIDTH_DRAW_PLACE/2+70, 512);
        
        Line duong_muiten2 = new Line(mt1_dd2, mt2_dd2);
        duong_muiten2.drawShape(image, ColorConstant.BLACK_RGB);
        
        Line duong_mt2_1 = new Line(mt1_dd2, mt2_dd_xoay1);
        duong_mt2_1.drawShape(image, ColorConstant.BLACK_RGB);
       
        Line duong_mt2_2 = new Line(mt1_dd2, mt2_dd_xoay2);
        duong_mt2_2.drawShape(image, ColorConstant.BLACK_RGB);
        
    }
    
    @Override
    public void drawShape(BufferedImage image, int color) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        veBien(image);
        veDatLien(image);
        veDuong(image);
        veTroi(image);
        
      
    }

    @Override
    void tinhTien(BufferedImage image, int tr_x, int tr_y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void xoay(BufferedImage image, double theta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
