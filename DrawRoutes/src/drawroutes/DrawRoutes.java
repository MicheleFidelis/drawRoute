
package drawroutes;

import javax.swing.JFrame;

/**
 *
 * @author michelefidelis
 */
public class DrawRoutes {

    public static void main(String[] args) {
        
        //Create the panel
        DrawLines panel = new DrawLines();
        
        
        //Read File
        panel.readFile();
        
        //Create the Frame
        JFrame frame = new JFrame("Draw of Routes");
        
        //When the frame close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Define the size of frame(width, height)
        frame.setSize(600, 600);
        
        //Define the frame visible
        frame.setVisible(true);
        
        //Add frame on the panel
        frame.add(panel);
        // TODO code application logic here
    }
    
}