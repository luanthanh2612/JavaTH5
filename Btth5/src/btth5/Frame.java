/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btth5;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import static java.awt.Label.CENTER;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author PC
 */
public class Frame extends JFrame implements ActionListener{
    JLabel jlblTitle,jlblTest;
    JTextArea jtxtNoiDung;
    JButton jbtnSave,jbtnOpen,jbtnClose;
    RoundButton btnround;
    JFileChooser jfChooser = new JFileChooser();
    public Frame(String title) throws HeadlessException {
        super(title);
        
        this.setSize(400,400);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
        addControls();
    }

    private void addControls() {
        
        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
         this.add(pnMain);
         
        JPanel pnTitle = new JPanel();
        jlblTitle = new JLabel("Noi Dung File");
        jlblTitle.setAlignmentX(CENTER_ALIGNMENT);
        jlblTitle.setForeground(Color.BLUE);
        jlblTitle.setFont(new Font("arial", Font.BOLD, 20));
        pnTitle.add(jlblTitle);
        pnMain.add(pnTitle);
        
       
        jtxtNoiDung = new JTextArea();
        jtxtNoiDung.setSize(20, 30);
        pnMain.add(jtxtNoiDung);
     
        
        JPanel pnButton = new JPanel(); 
        jbtnOpen = new JButton();
        jbtnSave = new JButton(); 
        jbtnClose = new JButton();
        btnround = new RoundButton("Test");
        
        jbtnOpen.setText("Doc file");
        jbtnSave.setText("Save File");
        jbtnClose.setText("Dong");
        
        //customzie button
        
        
        jbtnOpen.setBackground(new Color(59, 89, 182));
        jbtnOpen.setFocusPainted(false);
        jbtnOpen.setForeground(Color.WHITE);
        jbtnOpen.setFont(new Font("Tahoma", Font.BOLD, 12)); 
        jbtnOpen.setBorderPainted(false);
       
        
        
        jbtnSave.setBackground(new Color(80, 92, 130));
        jbtnSave.setFocusPainted(false);
        jbtnSave.setForeground(Color.WHITE);
        jbtnSave.setFont(new Font("Tahoma", Font.BOLD, 12)); 
        jbtnSave.setBorderPainted(false);
        
        
        btnround.setBackground(Color.GRAY);
        //event
        
        jbtnClose.addActionListener(this);
        jbtnOpen.addActionListener(this);
        jbtnSave.addActionListener(this);
        
         pnButton.add(jbtnOpen);
         pnButton.add(jbtnSave);
         pnButton.add(jbtnClose);
         pnButton.add(btnround);
         
         pnMain.add(pnButton);
         
//       JPanel pnTest = new JPanel();
//       jlblTest = new JLabel();
//       pnTest.add(jlblTest);
//       pnMain.add(pnTest);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       Object buttonClicked = e.getSource();
       if(buttonClicked == jbtnClose){
           System.exit(0);
       }else if(buttonClicked == jbtnOpen){
           if(jfChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
               File fileChon = jfChooser.getSelectedFile();
               jtxtNoiDung.setText("");
               try {
                   FileReader fr = new FileReader(fileChon);
                   BufferedReader br = new BufferedReader(fr);
                   String line;
                   do{
                       line = br.readLine();
                       if(line != null){
                           jtxtNoiDung.append(line + "\n");
                       }
                   }while(line != null);
                   br.close();
                   fr.close();
               } catch (FileNotFoundException ex) {
                   Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
               } catch (IOException ex) {
                   Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
               }
               
           }
       }else if(buttonClicked == jbtnSave){
            if(jfChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
               File fileChon = jfChooser.getSelectedFile();
                try {
                    FileWriter fw = new FileWriter(fileChon);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(jtxtNoiDung.getText());
                    bw.flush();
                    bw.close();
                    fw.close();
                    
                } catch (IOException ex) {
                    Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                }
       }
    }else if(buttonClicked == btnround){
//       
           System.out.println("Hahaha");
    }
    
    
    
    }
}
