/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;

import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

/**
 *
 * @author TAN LOC
 */
public class XImage {



//    public static Image getAppIcon() {
//        URL url = XImage.class.getResource("/images/logo_github.png");
//        return new ImageIcon(url).getImage();
//    }


    public static boolean save(File src) {
        File dst = new File("logos", src.getName());
        if (!dst.getParentFile().exists()) {
            dst.getParentFile().mkdirs();//tao thu muc
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static ImageIcon read(String filename) {
        File path = new File("logos", filename);
        return new ImageIcon(path.getAbsolutePath());
    }
    
    public static ImageIcon getImageIcon(String filename) {
        File path = new File("images", filename);
        return new ImageIcon(path.getAbsolutePath());
    }

}
