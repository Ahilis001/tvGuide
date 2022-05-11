/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Ahilis
 */
public class Show {

    String strVrijemePocetka;
    String strNaziv;
    String strLink;
    String strBoja;
    
    public Show() {
    }

    public Show(String strVrijemePocetka, String strNaziv, String strLink, String strBoja) {
        this.strVrijemePocetka = strVrijemePocetka;
        this.strNaziv = strNaziv;
        this.strLink = strLink;
        this.strBoja = strBoja;
    }

    public String getStrVrijemePocetka() {
        return strVrijemePocetka;
    }

    public void setStrVrijemePocetka(String strVrijemePocetka) {
        this.strVrijemePocetka = strVrijemePocetka;
    }

    public String getStrNaziv() {
        return strNaziv;
    }

    public void setStrNaziv(String strNaziv) {
        this.strNaziv = strNaziv;
    }

    public String getStrLink() {
        return strLink;
    }

    public void setStrLink(String strLink) {
        this.strLink = strLink;
    }

    public String getStrBoja() {
        return strBoja;
    }

    public void setStrBoja(String strBoja) {
        this.strBoja = strBoja;
    }
}
