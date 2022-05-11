/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.jP;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import model.Show;

/**
 *
 * @author ahilis001
 */
public class JpObrazacLegende extends JPanel{

    public JpObrazacLegende() {
    }
    
    public static JpObrazacLegende generirajObrazac(){
        JpObrazacLegende jpObrazacLegende = new  JpObrazacLegende();
        
        JEditorPane jep = new JEditorPane();
        jpObrazacLegende.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Legenda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0)));
            
                
        jep.setContentType("text/html");//set content as html
//                jep.setPreferredSize(new Dimension(260, 50 * Integer.parseInt((String) Postavke.getPostavke().get("maxShowPoProgramu"))));
        String strSadrzaj = "<html><body><table border=\\\"1\\\" cellpadding=\\\"0\\\" cellspacing=\\\"0\\\">";

            strSadrzaj +=  "<tr>"
                            +   "<td width=\"10\" style=background-color:blue></td>"
                            +   "<td  vertical-align: top; text-align: left;> - film</td>"
                    
                            +   "<td width=\"10\" style=background-color:yellow></td>"
                            +   "<td vertical-align: top; text-align: left;> - informativni</td>"
                         + "</tr>"
                    
                         +"<tr>"
                            +   "<td width=\"10\" style=background-color:red></td>"
                            +   "<td vertical-align: top; text-align: left;> - serija</td>"
                    
                            +   "<td width=\"10\" style=background-color:gray></td>"
                            +   "<td vertical-align: top; text-align: left;> - dokumentarni</td>"
                         + "</tr>"
                    
                         +"<tr>"
                            +   "<td width=\"10\" style=background-color:green></td>"
                            +   "<td width=\"50\"; vertical-align: top; text-align: left;> - sport</td>"
                    
                            +   "<td width=\"10\" style=background-color:white></td>"
                            +   "<td vertical-align: top; text-align: left;> - ostalo</td>"
                         + "</tr>";

        strSadrzaj += "</table></body></html>";


        jep.setText(strSadrzaj);

        jep.setEditable(false);//so its not editable
        jep.setOpaque(false);//so we dont see whit background
        
            
        jpObrazacLegende.add(jep);
        jpObrazacLegende.revalidate();
        jpObrazacLegende.repaint();
        return jpObrazacLegende;
    }
}
