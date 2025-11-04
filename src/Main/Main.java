/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import com.formdev.flatlaf.FlatLightLaf;
import view.*;


/**
 *
 * @author LENOVO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
   public static void main(String args[]) {
        try {
            FlatLightLaf.setup();
        } catch (Exception ex) {
            System.err.println("Gagal load tema FlatLaf: " + ex.getMessage());
        }
        java.awt.EventQueue.invokeLater(() -> new LoginMenu().setVisible(true));
    }
}
