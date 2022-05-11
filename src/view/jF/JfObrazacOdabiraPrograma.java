/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.jF;

import controler.misc.Postavke;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextField;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Program;

/**
 *
 * @author Ahilis
 */
public class JfObrazacOdabiraPrograma extends JFrame{
    
    TextField tfInterval, tfDatotekaObroka, tfCoX, tfCoY;
    JComboBox<String> jcSortiranje = new JComboBox<>();
//    ArrayList<ComboItem> listaSortiranja = new ArrayList<>();
    
    public JfObrazacOdabiraPrograma(){
    }
    
    /**
     * Generira obrazac postavki.
     */
    public void generirajObrazac(){
        
        //inicijalizacija jFramea postavki
        JfObrazacOdabiraPrograma jfObrazacOdabiraPrograma = new JfObrazacOdabiraPrograma();
        
        //postavljanje poravnanja i layouta jFramea
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.BOTH;
        
        jfObrazacOdabiraPrograma.setLayout(new GridBagLayout());
        jfObrazacOdabiraPrograma.setLocation(Integer.parseInt(Postavke.getPostavke().getProperty("koordinateAplikacijeX")), Integer.parseInt(Postavke.getPostavke().getProperty("koordinateAplikacijeY")));
        
        //lista lista programa po drzavama
        ArrayList<ArrayList<Program>> alAlListaPrograma = new ArrayList<>();
        alAlListaPrograma.add(new ArrayList<>());
        
        for (int i = 0; i < Program.getAlstListaPrograma().size(); i++) {
            
            try {
                //ako je drzava ista kao i na programu prije dodaje se u istu listu
                if (Program.getAlstListaPrograma().get(i).getStrDrzava().equals(Program.getAlstListaPrograma().get(i-1).getStrDrzava())) {
                    alAlListaPrograma.get(alAlListaPrograma.size() - 1).add(Program.getAlstListaPrograma().get(i));
            
                } 
                
                //inace se izraduje nova lista dodaje u tu listu
                else{
                    alAlListaPrograma.add(new ArrayList<>());
                    alAlListaPrograma.get(alAlListaPrograma.size() - 1).add(Program.getAlstListaPrograma().get(i));
                }
                
            } catch (Exception e) {
                //za prvi program u listi
                alAlListaPrograma.get(alAlListaPrograma.size() - 1).add(Program.getAlstListaPrograma().get(i));
            }
        }
        
        ArrayList<JPanel> alJpPrograma = new ArrayList<>();
        
        for (ArrayList<Program> arrayList : alAlListaPrograma) {
            
            //jPanel za programe
            JPanel jpPonudeniProgrami = new JPanel(new GridBagLayout());
            jpPonudeniProgrami.setBorder(javax.swing.BorderFactory.createTitledBorder(null, arrayList.get(0).getStrDrzava(), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0)));
            
            c.anchor = GridBagConstraints.NORTH;
            c.gridx = 0;
            c.gridy = 0;
            
            for (Program program : arrayList) {
                jpPonudeniProgrami.add(new JLabel(program.getStrNaziv()), c);

                c.gridx++;
                //ako je program zapamcen u datoteki konfiguracije, dodaje se u jPanel 
                if (Postavke.getPostavke().get("odabraniProgrami").toString().contains(program.getStrNaziv())) {

                    program.getJcbOdaberiProgram().setSelected(true);
                }

                jpPonudeniProgrami.add(program.getJcbOdaberiProgram(), c);
                c.gridx = 0;
                c.gridy++;

            }
            alJpPrograma.add(jpPonudeniProgrami);
        }
        
        //dodavanje jButtona za spremanje i zatvaranje
        JButton jbSpremiSveIZatvori = new JButton("Spremi i zatvori");
        jbSpremiSveIZatvori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                              
                
                
                //ako nije unesen interval ili nije broj
//                try {
//                    Integer.parseInt(tfInterval.getText());
//                    if (tfInterval.getText().equals("") ) {
//                        tfInterval.setText("60");
//                    }
//                } catch (Exception e) {
//                    tfInterval.setText("60");
//                }
                
                //ako nije unesen naziv datoteke
//                if (tfDatotekaObroka.getText().equals("") ) {
//                    tfDatotekaObroka.setText("obroci.txt");
//                }
                
                //ako nije unesena koordinata X ili nije broj
//                try {
//                    Integer.parseInt(tfCoX.getText());
//                    if (tfCoX.getText().equals("") ) {
//                        tfCoX.setText("0");
//                    }
//                } catch (Exception e) {
//                    tfCoX.setText("0");
//                }

                //ako nije unesena koordinata Y ili nije broj
//                try {
//                    Integer.parseInt(tfCoY.getText());
//                    if (tfCoY.getText().equals("") ) {
//                        tfCoY.setText("0");
//                    }
//                } catch (Exception e) {
//                    tfCoY.setText("0");
//                }
                
//                Postavke.ucitajKonfiguraciju();

                jbSpremiSveIZatvorictionPerformed(jfObrazacOdabiraPrograma, evt);
            }
        });
        
        //todo pogledati y
        c.gridx = 0;
        c.gridy = 7;
        jfObrazacOdabiraPrograma.add(jbSpremiSveIZatvori, c);

        //dodavanje panela u jFrame
        c.gridx = 0;
        c.gridy = 0;
        
        for (JPanel jPanel : alJpPrograma) {
            jPanel.revalidate();
            jfObrazacOdabiraPrograma.add(jPanel, c);
            c.gridx++;
        }
        
        jfObrazacOdabiraPrograma.setUndecorated(true);
        jfObrazacOdabiraPrograma.revalidate();
        jfObrazacOdabiraPrograma.pack();
        jfObrazacOdabiraPrograma.setVisible(true);
    }    
    
    /**
     * metoda spremanje postavki i zatvaranje obrasca postavki
     * @param jfObrazac
     * @param evt 
     */
    private void jbSpremiSveIZatvorictionPerformed(JFrame jfObrazac, java.awt.event.ActionEvent evt) { 
        
        String strOdabraniProgrami = "";
        for (Program program  : Program.getAlstListaPrograma()) { 
            if (program.getJcbOdaberiProgram().isSelected()) {
                strOdabraniProgrami += program.getStrNaziv() + ";";
            }
        } 
        Postavke.azurirajKonfiguracijuListaPrograma(Postavke.getPostavke(), strOdabraniProgrami);
//        Postavke.azurirajKonfiguraciju(Postavke.getPostavke(), this);
        jfObrazac.dispose();
//        MetodeMisc.azurirajOglase(Postavke.getPocetna());
    } 

    public TextField getTfInterval() {
        return tfInterval;
    }

    public void setTfInterval(TextField tfInterval) {
        this.tfInterval = tfInterval;
    }

    public TextField getTfCoX() {
        return tfCoX;
    }

    public void setTfCoX(TextField tfCoX) {
        this.tfCoX = tfCoX;
    }

    public TextField getTfCoY() {
        return tfCoY;
    }

    public void setTfCoY(TextField tfCoY) {
        this.tfCoY = tfCoY;
    }

    public TextField getTfDatotekaObroka() {
        return tfDatotekaObroka;
    }

    public void setTfDatotekaObroka(TextField tfDatotekaObroka) {
        this.tfDatotekaObroka = tfDatotekaObroka;
    }
}
