/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawroutes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author geraldo
 */
public class FileChooser {

    public static File getFile() {

        JFileChooser fileChooser = new JFileChooser();
        
        fileChooser.setFileFilter(new FileNameExtensionFilter("text File", "txt", "txt"));
        
        if (fileChooser.showOpenDialog(fileChooser) == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        System.out.println("file not choose");
        return null;
    }
    

}