/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Last_
 */
public class Gui extends JFrame {
    // Panels
    private JPanel greetPanel, masterBodyPanel;
    
    // Labels
    private JLabel lblFirstName, lblLastName, lblGreet;
    
    // Buttons
    private JButton btnReset, btnSubmit;
    
    // Text Fields
    private JTextField txtFldFirstName, txtFldLastName;
    
    // Constructor
    public Gui() {
        super("My First GUI"); // Name of the frame
        this.setLayout(new BorderLayout()); // Set JFrames' layout. If it hasn't done, all will be behind the scenes.
    }
    
    public static void main(String[] args) {
        Gui gui = new Gui();
        gui.pack();
        gui.setVisible(true);
    }

    private void setLayout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}