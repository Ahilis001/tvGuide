
import controler.MetodePrograma;
import controler.dretve.DretvaAzuriranje;
import controler.misc.Postavke;
import java.io.IOException;
import view.jF.JfPocetna;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


/**
 *
 * @author Ahilis
 */
public class Pocetna {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Postavke.ucitajKonfiguraciju();
//        MetodePrograma.izradiListuPrograma();
        JfPocetna.generirajObrazac();
        DretvaAzuriranje.getDretva().start();
        
        // TODO code application logic here
    }
    
}
