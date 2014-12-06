package it.car2go.main;

import it.car2go.windows.MacchineFrame;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Client Swing di Web Service Rest!" );
        
        JFrame frame = new MacchineFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        
    }
}
