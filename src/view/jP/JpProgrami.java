/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.jP;

import controler.MetodePrograma;
import controler.misc.Postavke;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import model.Program;

/**
 *
 * @author ahilis001
 */
public class JpProgrami extends JPanel{
    
    static JpProgrami jpProgrami = new JpProgrami();

    public JpProgrami() {
    }
    
    public static JpProgrami generirajObrazac(){
        
        MetodePrograma.izradiListuSvihPrograma();
    
        jpProgrami.removeAll();
        //postavljanje layouta
        jpProgrami.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTH;

        c.gridx = 0;
        c.gridy = 1;
        //dodavanje programa na početni jFrame
        for (Program program : Program.getAlstListaPrograma()) {
            
            //ako je program zapamcen u datoteki konfiguracije, dodaje se u jPanel 
            if (Postavke.getPostavke().get("odabraniProgrami").toString().contains(program.getStrNaziv())) {
                
                jpProgrami.add(JpProgram.generirajObrazac(program), c);
                c.gridx++;
            }
            
            if (Integer.parseInt(Postavke.getPostavke().get("brojStupaca").toString()) == c.gridx) {
                c.gridx = 0;
                c.gridy++;        
            }
        }
        
        return jpProgrami;
    }
}
