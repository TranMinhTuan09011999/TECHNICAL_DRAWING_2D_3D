package vehinhcoban.container;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import vehinhcoban.constant.ColorConstant;
import vehinhcoban.constant.SizeConstant;

public class DrawPlace extends JLabel {

    /**
     *
     */
    // nơi để vẻ các hình bằng đối tượng BUFFEREDIMAGE
    private static final long serialVersionUID = 1L;
     //type cua anh dang tung pixel
    protected int type = BufferedImage.TYPE_INT_ARGB;
    protected BufferedImage image;
    protected ImageIcon placeImage;

    public DrawPlace() {
       
        
        // chieu dai chieu rong cua anh
        setImage(new BufferedImage(SizeConstant.WIDTH_DRAW_PLACE, SizeConstant.HEIGHT_DRAW_PLACE, type));
        setPlaceImage(new ImageIcon(getImage()));
        this.setIcon(getPlaceImage());
        // set mau cho anh la toan trang
        paintPlaceWhite();

    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public ImageIcon getPlaceImage() {
        return placeImage;
    }

    public void setPlaceImage(ImageIcon placeImage) {
        this.placeImage = placeImage;
    }

    // to mau cho toan anh la mau trang

    public void paintPlaceWhite() {
        for (int i = 0; i < SizeConstant.WIDTH_DRAW_PLACE; i++) {
            for (int j = 0; j < SizeConstant.HEIGHT_DRAW_PLACE; j++) {
                image.setRGB(i, j, ColorConstant.WHITE_RGB);
            }
        }
    }

    // refresh lại drawplace

    public void refreshDrawPlace(BufferedImage image) {

        this.setIcon(new ImageIcon(image));

    }
    public void newImage(){
       this.setImage(new BufferedImage(SizeConstant.WIDTH_DRAW_PLACE, SizeConstant.HEIGHT_DRAW_PLACE, type));
       paintPlaceWhite();
    }
}
