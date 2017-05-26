/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawroutes;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author michelefidelis
 */
public class DrawLines extends JPanel {

    int numCoord;
    String ch;
    int[] route;
    int[][]  c;
    
    public void readFile() {
        
        int value;
        String nameArq="";
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Write the name of file:");
        nameArq = input.nextLine();
        
        try {
            input = new Scanner(new File(nameArq));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DrawLines.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        //read number of coordenadas
        numCoord = input.nextInt();
        
        c = new int[numCoord][2];
        
        route = new int[numCoord + 1];
        
        //Matrix of coordenadas
        for (int i = 0; i < numCoord; i++) {
            for (int j = 0; j < 2; j++) {
                    
                value = input.nextInt();
                c[i][j] = 2*value;
            }
                
        }
        
        //Route
        for(int i = 0; i < numCoord; i++) {
            
            value = input.nextInt();
            route[i] = value - 1;
            ch = input.next();
       
            
        }
        route[numCoord] = route[0];
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        g.translate(100, 100);
        
        int x1, y1, x2, y2;
        for (int i = 0; i < numCoord; i++) {
            
            x1 = c[route[i]][0];
            y1 = c[route[i]][1];
            x2 = c[route[i + 1]][0];
            y2 = c[route[i + 1]][1];
            
           // System.out.printf("%d - %d -> %d - %d\n", x1, y1, x2, y2);
            
            g.setColor(Color.RED);
            g.fillOval(x1 - 3, y1 - 3, 5, 6);
            
            g.setColor(Color.BLACK);
            g.drawLine(x1, y1, x2, y2);
            
        }
       
    }

    
    
    
}
