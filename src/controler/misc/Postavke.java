/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler.misc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Properties;
import view.jF.JfObrazacPostavki;
//import view.jFrame.JfObrazacPostavki;

/**
 *
 * @author Ahilis
 */
public class Postavke {

    public Postavke() {
        //u main dodati Postavke.ucitajKonfiguraciju();, 
        //ostale preko Postavke.getPostavke
    }
    
    //inicijalizacija postavki
    static Properties postavke = new Properties();
    
    
    /**
     * Metoda za otvaranje datoteke konfiguracije.
     * @param postavke
     */
    public static void ucitajKonfiguraciju(){
        
        File configFile = new File("konfiguracija.xml");
        
        try {
            FileReader reader = new FileReader(configFile);
            InputStream inputStream = new FileInputStream(configFile);
            //za datoteku .properties
//            postavke.load(inputStream);

            //za datoteku .xml
            postavke.loadFromXML(inputStream);
            reader.close();
        } catch (Exception ex) {
            
//            MetodeTajmera.dodajULog("Pocetna - ucitajKonfiguraciju - Greška kod učitavanja konfiguracijse datoteke.");
        } 
    }
    
    
    /**
     * Ažurira konfiguracijsku datoteku.
     * @param properties
     * @param op
     */
    public static void azurirajKonfiguraciju(Properties properties, JfObrazacPostavki op){
        try {
            //postavljanje postavki iz prosljeđenog ObrascaPostavki i otvaranje streama za upis u .xml datoteku
            try (FileOutputStream fos = new FileOutputStream("konfiguracija.xml")) {
//                tfInterval, tfDatotekaObroka,  tfMaxShowPoProgramu, tfBrojStupaca
                properties.setProperty("koordinateAplikacijeX", op.getTfCoX().getText());
                properties.setProperty("koordinateAplikacijeY", op.getTfCoY().getText());
                properties.setProperty("brojStupaca", op.getTfBrojStupaca().getText());
                properties.setProperty("maxShowPoProgramu", op.getTfMaxShowPoProgramu().getText());
                properties.setProperty("intervalUMinutama", op.getTfInterval().getText());
                properties.setProperty("prikaziLegendu", Boolean.toString(op.getJcbPrikaziLegendu().isSelected()));
                
                
//                properties.setProperty("sortiranje", op.getListaSortiranja().get(op.getJcSortiranje().getSelectedIndex()).getKey());
                
                //spremanje u .xml datoteku s komentarom
                properties.storeToXML(fos, "");
            }
        } catch (Exception ex) {
//            Pocetna.prikaziPoruku("greška kod ažuriranja postavki");
        }
    }
    
    /**
     * Ažurira konfiguracijsku datoteku.
     * @param properties
     * @param strOdabraniProgrami
     */
    public static void azurirajKonfiguracijuListaPrograma(Properties properties, String strOdabraniProgrami){
        
        //postavljanje postavki iz prosljeđenog ObrascaPostavki i otvaranje streama za upis u .xml datoteku
        try (FileOutputStream fos = new FileOutputStream("konfiguracija.xml")) {
            properties.setProperty("odabraniProgrami", strOdabraniProgrami);


//                properties.setProperty("sortiranje", op.getListaSortiranja().get(op.getJcSortiranje().getSelectedIndex()).getKey());

            //spremanje u .xml datoteku s komentarom
            properties.storeToXML(fos, "");
        }
         catch (Exception ex) {
//            Pocetna.prikaziPoruku("greška kod ažuriranja postavki");
        }
    }

    public static Properties getPostavke() {
        return postavke;
    }

    public static void setPostavke(Properties postavke) {
        Postavke.postavke = postavke;
    }
    
    
}
