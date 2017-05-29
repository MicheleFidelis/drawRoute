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

    int option, numCoord, numMed;
    String ch;
    int[] route; //Draw Route
    int[][] p_m; //Draw P-M
    
    int[][]  c;
    int[][]  c_m;
    
    public void readFile() {
        
        int value;
        String nameArq="";
        Scanner input;
	
        
        try {
	    
            Scanner choose = new Scanner(System.in);
            
            //Choose the problem
            System.out.print("Choose the Draw:\n 1- Draw route \n 2 - Draw P_M \n Option:");
        
            option = choose.nextInt();
            
            input = new Scanner(FileChooser.getFile());
            
            //read number of coordenadas
            numCoord = input.nextInt();
        
            c = new int[numCoord][2];
            
            route = new int[numCoord + 1];
            p_m = new int[numCoord][2];
            
            //Matrix of coordenadas
            for (int i = 0; i < numCoord; i++) {
                for (int j = 0; j < 2; j++) {
                    
                    value = input.nextInt();
                    c[i][j] = 4*value;
                
                }
                
            }
        
            if(option == 1){
                //Route
                for(int i = 0; i < numCoord; i++) {
            
                   value = input.nextInt();
                   route[i] = value - 1;
                   ch = input.next();
           
                }
                route[numCoord] = route[0];
            }else{
                //P_M
                numMed = input.nextInt();
                
                c_m = new int[numMed][2];
                
                for (int i = 0; i < numMed; i++) {
                    for (int j = 0; j < 2; j++) {
                    
                       value = input.nextInt();
                       c_m[i][j] = 4*value;
                
                    }
                
                }
                
                for(int i = 0; i < numCoord; i++) {
                    for(int j = 0; j < 2; j++){
                        
                        value = input.nextInt();
                        p_m[i][j] = value - 1;
                        System.out.println(p_m[i][j]);
                    }
                   
                }
            }
	
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DrawLines.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        g.translate(100, 100);
        
        int x1, y1, x2, y2;
        
        
        for (int i = 0; i < numCoord; i++) {
            
            if(option == 1) {
            
                x1 = c[route[i]][0];
                y1 = c[route[i]][1];
                x2 = c[route[i + 1]][0];
                y2 = c[route[i + 1]][1];
                
                g.setColor(Color.RED);
                g.fillOval(x1 - 3, y1 - 3, 5, 6);
            
                g.setColor(Color.BLACK);
                g.drawLine(x1, y1, x2, y2);
            
                
            }else{
                
                x1 = c[p_m[i][0]][0];
                y1 = c[p_m[i][0]][1];
                x2 = c_m[p_m[i][1]][0];
                y2 = c_m[p_m[i][1]][1];
                
                g.setColor(Color.blue);
                g.fillOval(x2 - 3, y2 - 3, 5, 6);
            
                g.setColor(Color.RED);
                g.fillOval(x1 - 3, y1 - 3, 5, 6);
            
                g.setColor(Color.BLACK);
                g.drawLine(x1, y1, x2, y2);
            }
            
           // System.out.printf("%d - %d -> %d - %d\n", x1, y1, x2, y2);
            
            
        }
       
    }

    
    
    
}