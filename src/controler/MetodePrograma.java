/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import controler.misc.Postavke;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import model.Program;
import model.Show;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import view.jP.JpObrazacObavijestiIPostavki;

/**
 *
 * @author Ahilis
 */
public class MetodePrograma {
    
    static SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy. HH:mm:ss");
    static SimpleDateFormat formatterZaPrijepodne = new SimpleDateFormat("HHmm");
    /**
     * izrađuje listu programa iz URL-a
     * @param url programa
     */
    public static void izradiListuProgramaPoKriteriju(String url, String strDrzava){
        
            
            try {
                //todo obrr - sluzi za lokalnu datoteku
//                File input = new File("1.html");
//                Document document = Jsoup.parse(input, "UTF-8", "http://example.com/");
                
            //todo to ostaviti    
            //dohvaćanje stranice iz URL-a
            Document document = (Document) Jsoup.connect(url).get();
        
                //uzimanje odgovarajuće liste oglasa iz dokumenta
                Element listaPrograma = document.select("main").get(document.select("main").size()-1);
                
                //inicijalizacija max broja oglasa po upitu
                int intBrojShowZaPrikazPoProgramu = Integer.parseInt((String) Postavke.getPostavke().get("maxShowPoProgramu"));
                
                //uzimanje kompletne slike sa ikonama programa
//                URL url = new URL("http://www.mkyong.com/image/mypic.jpg");
                BufferedImage bigImg = ImageIO.read(new File("k16all.png"));
                final int width = 16;
                final int height = 16;

                //selektiranje svakog programa iz dokumenta
                for (Element element : listaPrograma.select("div.col-12.col-sm-6.col-lg-3.tvbox")) {
                    
                    //izrada programa i emisija
                    for (Element element1 : element.select("div.channel-shows")) {
                        
                        //todo za ikonu se treba pozicionirati na ispravni dio slike s URL-a: https://cdn-0.tvprofil.com/assets/36/k16all.png
                        //todo tu mijenjati koordinate
                        final int rows = 16;
                        final int cols = 16;
                        BufferedImage biIkona = bigImg.getSubimage( rows, cols, width, height );
                        ImageIcon icon = new ImageIcon(biIkona);

//                        for (int i = 0; i < rows; i++){
//                            
//                            for (int j = 0; j < cols; j++){
//                                
//                                biIkona[(i * cols) + j] = bigImg.getSubimage(
//                                    j * width,
//                                    i * height,
//                                    width,
//                                    height
//                                );
//                            }
//                        }


                        Program program = new Program(icon,
                                                      element.select("div.channel-title").text(),
                                                      "https://tvprofil.com/" + element.select("a").attr("href"),
                                                      strDrzava);
                        
                        
                        //izrada programa
//                        Program program = new Program(biIkona,
//                                                      element.select("div.channel-title").text(),
//                                                      "https://tvprofil.com/" + element.select("a").attr("href"));
                        
                        String[] strPoljeShowMorning, strPoljeShowAfternoon, strPoljeShowNight;
                        
                        //provjera ako je prije ili nakon 1600 sati (zna biti show u 0600 na prvom mjestu)
                        if (Integer.parseInt(formatterZaPrijepodne.format(new Date(System.currentTimeMillis()))) < 1600) {
                            //uzimanje html-a jednog show-a
                            strPoljeShowMorning = element1.select("div.morning-tv").toString().split("</div>\n</div>");
                            strPoljeShowAfternoon = element1.select("div.afternoon-tv").toString().split("</div>\n</div>");
                            strPoljeShowNight = element1.select("div.night-tv").toString().split("</div>\n</div>");
                        } 
                        
                        else {
                            //uzimanje html-a jednog show-a
                            strPoljeShowAfternoon = element1.select("div.afternoon-tv").toString().split("</div>\n</div>");
                            strPoljeShowNight = element1.select("div.night-tv").toString().split("</div>\n</div>");
                            strPoljeShowMorning = element1.select("div.morning-tv").toString().split("</div>\n</div>");
                        }
                        
                        ArrayList<String> strShow = new ArrayList(Arrays.asList(strPoljeShowMorning));
                        strShow.addAll(Arrays.asList(strPoljeShowAfternoon));
                        strShow.addAll(Arrays.asList(strPoljeShowNight));
                        
                        //za svaki show iz polja showova
                        for (String string : strShow) {
                                                        
                            //dodavanje div elemenata na kraj elementa polja 
                            //koji su se obrisali prilikom razdvajanja
                            final String html = string+"</div>\n</div>";

                            //kreiranje dokumenta kako bi se od stringa napravio element 
                            //koji se moze koristiti s jsoup-om
                            Document doc = Jsoup.parse(html, "", Parser.xmlParser());
                            Element tag = doc;
                            
                            //dohvat boje
                            String strBoja = "nema";
                            if (string.contains("tip0-tv")) {
                                strBoja = "white";
                            } 
                            
                            else if (string.contains("tip1-tv")) {
                                strBoja = "blue";
                            } 
                            
                            else if (string.contains("tip2-tv")) {
                                strBoja = "red";
                            } 
                            
                            else if (string.contains("tip3-tv")) {
                                strBoja = "green";
                            } 
                            
                            else if (string.contains("tip4-tv")) {
                                strBoja = "yellow";
                            } 
                            
                            else if (string.contains("tip5-tv")) {
                                strBoja = "gray";
                            } 
                            
                            //inicijalizacija novog show-a
                            Show noviShow = new Show(tag.select("div.time").text(), 
                                                     tag.select("div.track").text(), 
                                                     "https://tvprofil.com" + tag.select("a").attr("href"),
                                                     strBoja);
                            
                            //dodavanje showa u listu showova programa
                            if (!noviShow.getStrNaziv().equals("")) {
                                program.getAlstListaShowa().add(noviShow);
                            }
                            
                            //ako je dostignut max show po programu, prekida se dodavanje
                            if (program.getAlstListaShowa().size() == intBrojShowZaPrikazPoProgramu) {
                                break;
                            }
                        }
                        //dodavanje programa u listu objekata programa
                        Program.getAlstListaPrograma().add(program);
                    }
                } 
                
                JpObrazacObavijestiIPostavki.getJtObavijest().setText("Ažurirano: " + formatter.format(new Date(System.currentTimeMillis())));
            } 
            catch (Exception e) {
//                jpOglasiUpita.setBorder(javax.swing.BorderFactory.createTitledBorder(null, listaKlucnihRijeci(getPostavke().getProperty("kljucneRijeci"))[intBrojacJPanela].replace("+", " "), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0)));
//        
//                jpOglasiUpita.add(new JLabel("Nema rezultata za ovaj upit."));
//                Oglas.getListaOglasa().add(jpOglasiUpita);
//                intBrojacJPanela ++;
            }
    }
    
    /**
     * Za otvaranje url-a stranice u pregledniku nakon klika na sliku.
     * @param website
     * @param url 
     * @return  
     */
    public static JLabel otvoriStranicu(JLabel website, final String url) {
        website.setCursor(new Cursor(Cursor.HAND_CURSOR));
        website.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                        Desktop.getDesktop().browse(new URI(url));
                } catch (URISyntaxException | IOException ex) {
                }
            }
        });
        
        return website;
    }
    
    /**
     * Izraduje listu programa iz prosljedenih URL-a
     */
    public static void izradiListuSvihPrograma(){
        //ciscenje liste panela s programima
        Program.getAlstListaPrograma().clear();
    
        izradiListuProgramaPoKriteriju("https://tvprofil.com/index/drzava/", "Hrvatska");
        izradiListuProgramaPoKriteriju("https://tvprofil.com/at/index/land/", "Austrija");
        izradiListuProgramaPoKriteriju("https://tvprofil.com/si/index/drzava/", "Slovenija");
        izradiListuProgramaPoKriteriju("https://tvprofil.com/index/dokumentarni/", "dokumentarni");
        izradiListuProgramaPoKriteriju("https://tvprofil.com/index/film/", "filmski");
        izradiListuProgramaPoKriteriju("https://tvprofil.com/index/sport/", "sportski");
    }
}