/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btth5;

import javax.swing.SwingUtilities;

/**
 *
 * @author PC
 */
public class Btth5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
             Frame f = new Frame("Doc Ghi File");
            }
        });
    }
    
}
