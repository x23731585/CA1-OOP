/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


package MEMBER3;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Screen {

    public static void show(JPanel panel, String title) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }
}
