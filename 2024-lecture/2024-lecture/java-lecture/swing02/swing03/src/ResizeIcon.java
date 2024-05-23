import javax.swing.*;
import java.awt.*;

public class ResizeIcon extends ImageIcon {
    private Image image;
    private int width;
    private int height;

    public ResizeIcon(String filename) {
        super(filename);
        image = this.getImage();

    }
    public ImageIcon getResizedImage(int width, int height) {
        Image resizeImage = image.getScaledInstance(width,height,Image.SCALE_SMOOTH); // 이미지 크기 설정
        return new ImageIcon(resizeImage);
    }
}
