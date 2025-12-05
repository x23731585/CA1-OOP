/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MEMBER2;

import javax.swing.JFrame;

public class MentalHealthHubFrame extends JFrame {

    public MentalHealthHubFrame() {
        setTitle("Mental Health Hub - Member 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);

        // Add your PANEL inside the frame
        add(new MentalHealthHubGui(new MentalHealthHub()));
    }

    public static void main(String[] args) {
        new MentalHealthHubFrame().setVisible(true);
    }
}
