/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler.dretve;

import controler.misc.Postavke;
import view.jF.JfPocetna;
import view.jP.JpObrazacObavijestiIPostavki;


/**
 *
 * @author iduras
 */
public class DretvaAzuriranje extends Thread{
    
    private static DretvaAzuriranje dretva = new DretvaAzuriranje();
    
    private DretvaAzuriranje() {
    }
    
    @Override
    public void interrupt() {
        System.out.println("Dretva je završila s radom.");
        JpObrazacObavijestiIPostavki.getJtObavijest().setText("Greška u dretvi za ažuriranje.");
        super.interrupt(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        while (true) {  
            try {
                Thread.sleep(Integer.parseInt(Postavke.getPostavke().getProperty("intervalUMinutama")) * 1000 * 60);
                JfPocetna.azurirajObrazac();
            } catch (InterruptedException ex) {
//        JpObrazacObavijestiIPostavki.getJtObavijest().setText("Ažurirano: " + formatter.format(new Date(System.currentTimeMillis())));

                JpObrazacObavijestiIPostavki.getJtObavijest().setText("Greška kod ažuriranja");
//                Logger.getLogger(DretvaSat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public synchronized void start() {
        super.start(); //To change body of generated methods, choose Tools | Templates.
    }

    public static DretvaAzuriranje getDretva() {
        return dretva;
    }
}
