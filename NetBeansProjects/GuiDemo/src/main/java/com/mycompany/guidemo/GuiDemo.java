/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guidemo;

import javax.swing.JOptionPane;

/**
 *
 * @author Last_
 */
public interface GuiDemo {
    
    public static void main(String[] args){
        String firstNumber = JOptionPane.showInputDialog("Enter first number");
        String secondNumber = JOptionPane.showInputDialog("Enter second number");

        // Convert String input to integer values for us to calculate
        int num1 = Integer.parseInt(firstNumber);
        int num2 = Integer.parseInt(secondNumber);
        int sum = num1 + num2;
        
        System.out.println();
        JOptionPane.showMessageDialog(null, "This sum is " + sum);
    }
}
