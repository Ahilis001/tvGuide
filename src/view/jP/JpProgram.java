/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.jP;

import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import model.Program;
import model.Show;

/**
 *
 * @author Ahilis
 */
public class JpProgram extends JPanel{
    
    static ArrayList<JpProgram> alstListaPrograma = new ArrayList<>();

    public JpProgram() {
        
//        this.setPreferredSize(new Dimension(260, 35 * Integer.parseInt((String) Postavke.getPostavke().get("maxShowPoProgramu"))));
    }
    
    public static JpProgram generirajObrazac(Program program) {
        
        JpProgram jpProgram = new JpProgram();
        
        //postavljanje poravnanja i layouta JjPanela
        jpProgram.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.insets = new Insets(2,0,0,2);  
        
        
//        jpProgram.setBorder(javax.swing.BorderFactory.createTitledBorder(null, program.getStrNaziv(), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11), new java.awt.Color(0, 0, 0)));
        jpProgram.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11), new java.awt.Color(0, 0, 0)));

        
        JPanel jpIkonaINaziv = new JPanel();
        jpIkonaINaziv.add(new JLabel(program.getiIkona()));
        jpIkonaINaziv.add(new JLabel(program.getStrNaziv()));
//        for (Show show : program.getAlstListaShowa()) {
//            
//            JPanel jpPomocniJP = new JPanel();
//            jpPomocniJP.setLayout(new FlowLayout());
//            jpPomocniJP.add(new JLabel("<html><div  style=background-color:" + show.getStrBoja() + ";color:" + show.getStrBoja() + ">!!</div></html>"));
//            
//            jpPomocniJP.add(new JLabel(show.getStrVrijemePocetka() + " - "));
//            
//            jpPomocniJP.add(MetodePrograma.otvoriStranicu(new JLabel(("<html>" + show.getStrNaziv()) + "</html>"), show.getStrLink()));
//            
//            jpProgram.add(jpPomocniJP, c);
//            c.gridy++;
//        }


                JEditorPane jep = new JEditorPane();
                
                jep.setContentType("text/html");//set content as html
//                jep.setPreferredSize(new Dimension(260, 50 * Integer.parseInt((String) Postavke.getPostavke().get("maxShowPoProgramu"))));
                String strSadrzaj = "<html><body><table border=\\\"1\\\" cellpadding=\\\"0\\\" cellspacing=\\\"0\\\">";
                for (Show show : program.getAlstListaShowa()) {
                    strSadrzaj +=  "<tr>"
                                    +   "<td width=\"10\" style=background-color:" + show.getStrBoja() + "></td>"
                                    +   "<td vertical-align: top; text-align: left; width=\"50\"> "+show.getStrVrijemePocetka()+" -</td>"
                                    +   "<td width=\"200\"; vertical-align: top; text-align: left;> "
                                    +       "<a style=\"color:black\" href=\"" + show.getStrLink() + "\">"
                                        + show.getStrNaziv()+"</td>"
                                 + "</tr>";
                }
                strSadrzaj += "</table></body></html>";
                
                
                jep.setText(strSadrzaj);

                jep.setEditable(false);//so its not editable
                jep.setOpaque(false);//so we dont see whit background

                jep.addHyperlinkListener(new HyperlinkListener() {
                    @Override
                    public void hyperlinkUpdate(HyperlinkEvent hle) {
                        if (HyperlinkEvent.EventType.ACTIVATED.equals(hle.getEventType())) {
                            
                            Desktop desktop = Desktop.getDesktop();
                            try {
                                desktop.browse(hle.getURL().toURI());
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                });









//todo obr
//        String strSadrzaj = "<html><table border=\\\"1\\\" cellpadding=\\\"0\\\" cellspacing=\\\"0\\\">";
//        for (Show show : program.getAlstListaShowa()) {
//            strSadrzaj +=  "<tr>"
//                            +   "<td width=\"10\" style=background-color:" + show.getStrBoja() + "></td>"
//                            +   "<td vertical-align: top; text-align: left; width=\"50\"> "+show.getStrVrijemePocetka()+" -</td>"
//                            +   "<td width=\"200\";text-align: left> "
//                            +       "<a href=\"http://example.com\">"
//                                +show.getStrNaziv()+"</td>"
//                         + "</tr>";
//        }
//        strSadrzaj += "</table></html>";
//        jpProgram.add(new JLabel(strSadrzaj));

        c.gridx = 0;
        c.gridy = 0;
        jpProgram.add(jpIkonaINaziv, c);
        
        c.gridx = 0;
        c.gridy = 1;
        jpProgram.add(jep, c);
        jpProgram.revalidate();
        jpProgram.repaint();
        return jpProgram;
    }
    
    

    public static ArrayList<JpProgram> getAlstListaPrograma() {
        return alstListaPrograma;
    }

    public static void setAlstListaPrograma(ArrayList<JpProgram> alstListaPrograma) {
        JpProgram.alstListaPrograma = alstListaPrograma;
    }
    
    
}
