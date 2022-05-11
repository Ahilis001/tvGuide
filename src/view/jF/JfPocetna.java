/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.jF;

import controler.misc.Postavke;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import view.jP.JpObrazacLegende;
import view.jP.JpObrazacObavijestiIPostavki;
import view.jP.JpProgrami;

/**
 *
 * @author Ahilis
 */
public class JfPocetna extends JFrame{
    
    static SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy. HH:mm:ss");

    static JfPocetna jFPocetniObrazac = new JfPocetna();
    
    public JfPocetna() {
    }
    
    public static void generirajObrazac(){
        
//        jFPocetniObrazac.removeAll();
        

        Postavke.ucitajKonfiguraciju();
        
        //postavljanje layouta
        jFPocetniObrazac.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;

        //todo spoziti jpanel za postavke i legendu
        //dodavanje obrasca obavijesi i postavki
        c.gridx = 0;
        c.gridy = 0;
        jFPocetniObrazac.add(JpObrazacObavijestiIPostavki.generirajObrazac(), c);
        
        //ako je odabrano da se legenda prikazuje,
        //dodaje se obrazac legende
        if (Postavke.getPostavke().get("prikaziLegendu").equals("true")) {
            c.gridx = 1;
            c.gridy = 0;
            jFPocetniObrazac.add(JpObrazacLegende.generirajObrazac(), c);
        }
        
        //dodavanje rasporeda
        c.gridx = 0;
        c.gridy = 1;
        jFPocetniObrazac.add(JpProgrami.generirajObrazac(), c);
        
        postaviIzgled(jFPocetniObrazac);
        jFPocetniObrazac.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFPocetniObrazac.setVisible(true);
        
        jFPocetniObrazac.revalidate();
        jFPocetniObrazac.repaint();
        jFPocetniObrazac.pack();
    }
    
    public static void azurirajObrazac(){
        
        Postavke.ucitajKonfiguraciju();
        
//        jFPocetniObrazac.removeAll();
         //postavljanje layouta
        jFPocetniObrazac.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;

        //todo spoziti jpanel za postavke i legendu
        c.gridx = 0;
        c.gridy = 0;
        jFPocetniObrazac.add(JpObrazacObavijestiIPostavki.generirajObrazac(), c);
        
        //ako je odabrano da se legenda prikazuje,
        //dodaje se obrazac legende
        if (Postavke.getPostavke().get("prikaziLegendu").equals("true")) {
            c.gridx = 1;
            c.gridy = 0;
            jFPocetniObrazac.add(JpObrazacLegende.generirajObrazac(), c);
        }
        
        //dodavanje rasporeda
        c.gridx = 0;
        c.gridy = 1;
        jFPocetniObrazac.add(JpProgrami.generirajObrazac(), c);
        
        JpObrazacObavijestiIPostavki.getJtObavijest().setText("Ažurirano: " + formatter.format(new Date(System.currentTimeMillis())));

        jFPocetniObrazac.revalidate();
        jFPocetniObrazac.repaint();
        jFPocetniObrazac.pack();
    }
    
    /**
     * postavlja izgled na "Windows"
     * @param jframe 
     */
    private static void postaviIzgled (JFrame jframe){
     /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jframe.setVisible(true);
            }
        });
    }

    public static JFrame getjFPocetniObrazac() {
        return jFPocetniObrazac;
    }

    public static void setjFPocetniObrazac(JfPocetna jFPocetniObrazac) {
        JfPocetna.jFPocetniObrazac = jFPocetniObrazac;
    }
    
    
}
