package GUI;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class PictureFile {
    private File geoFile = new File("src/picture/geometry.jpg");
    private ImageIcon background;
//    private Image
    public PictureFile(){
        background = new ImageIcon(((new ImageIcon(getgeoPath()).getImage()).getScaledInstance( 800, 500, java.awt.Image.SCALE_SMOOTH)));
    }

    public String getgeoPath(){
        System.out.println(this.geoFile.getAbsolutePath());
        return this.geoFile.getAbsolutePath();
    }

    public JLabel getBackgroundImage(){
        JLabel backgroundImageLabel = new JLabel(background);
        return backgroundImageLabel;
    }
}
