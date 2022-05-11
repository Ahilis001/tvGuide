/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.JCheckBox;

/**
 *
 * @author Ahilis
 */
public class Program {
    
    static ArrayList<Program> alstListaPrograma = new ArrayList<>();
    
    JCheckBox jcbOdaberiProgram = new JCheckBox();
    Icon iIkona;
    String strNaziv;
    String strLinkPrograma;
    ArrayList<Show> alstListaShowa = new ArrayList<>();
    String strDrzava;

    public Program(Icon iIkona, String strNaziv, String strLinkPrograma, String strDrzava) {
        this.iIkona = iIkona;
        this.strNaziv = strNaziv;
        this.strLinkPrograma = strLinkPrograma;
        this.strDrzava = strDrzava;
    }
    
    //todo obrisati
//    public Program(String strNaziv, String strLinkPrograma) {
//        this.strNaziv = strNaziv;
//        this.strLinkPrograma = strLinkPrograma;
//    }

    public static ArrayList<Program> getAlstListaPrograma() {
        return alstListaPrograma;
    }

    public static void setAlstListaPrograma(ArrayList<Program> alstListaPrograma) {
        Program.alstListaPrograma = alstListaPrograma;
    }

    public String getStrNaziv() {
        return strNaziv;
    }

    public void setStrNaziv(String strNaziv) {
        this.strNaziv = strNaziv;
    }

    public String getStrLinkPrograma() {
        return strLinkPrograma;
    }

    public void setStrLinkPrograma(String strLinkPrograma) {
        this.strLinkPrograma = strLinkPrograma;
    }

    public ArrayList<Show> getAlstListaShowa() {
        return alstListaShowa;
    }

    public void setAlstListaShowa(ArrayList<Show> alstListaShowa) {
        this.alstListaShowa = alstListaShowa;
    }

    public JCheckBox getJcbOdaberiProgram() {
        return jcbOdaberiProgram;
    }

    public void setJcbOdaberiProgram(JCheckBox jcbOdaberiProgram) {
        this.jcbOdaberiProgram = jcbOdaberiProgram;
    }

    public Icon getiIkona() {
        return iIkona;
    }

    public void setiIkona(Icon iIkona) {
        this.iIkona = iIkona;
    }

    public String getStrDrzava() {
        return strDrzava;
    }

    public void setStrDrzava(String strDrzava) {
        this.strDrzava = strDrzava;
    }
}
