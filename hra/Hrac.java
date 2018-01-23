package osadnicizkatanu.hra;

import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import osadnicizkatanu.hra.prislusenstvo.Cesta;
import osadnicizkatanu.hra.prislusenstvo.Dedina;
import osadnicizkatanu.hra.prislusenstvo.Mesto;
import osadnicizkatanu.policko.HraciePolicko;
import osadnicizkatanu.policko.IPolickoPrePridavanie;
import osadnicizkatanu.surovina.Drevo;
import osadnicizkatanu.surovina.Kamen;
import osadnicizkatanu.surovina.Obilie;
import osadnicizkatanu.surovina.Ovca;
import osadnicizkatanu.surovina.Surovina;
import osadnicizkatanu.surovina.Tehla;


/**
 * Trieda reprezentuje hraca hrajuceho hru
 * @author Adam
 */
public class Hrac {
    private int pocetBodov;
    
    private final ArrayList<Cesta> zoznamCiest;
    private final ArrayList<Dedina> zoznamDedin;
    private final ArrayList<Mesto> zoznamMiest;
    
    private final ArrayList<Surovina> inventarSurovin;
    private final ArrayList<HraciePolicko> vlastneneHraciePolickaPoberaneDvakrat;
    private final ArrayList<HraciePolicko> vlastneneHraciePolickaPoberaneRaz;
    private final ArrayList<Point> zoznamVlastnenychPointov;   
    private final String meno;
    private final String farba;
    private final Cesta cestaReprezentacna;
    private final Dedina dedinaReprezentacna;
    private final Mesto mestoReprezentacne;
    
    private JPanel panel;
    
    /**
     * Konstruktor vytvori noveho hraca s menom a farbou svojich figuriek
     * @param meno meno hraca
     * @param farba farba figuriek hraca (je len modra alebo cervena)
     */
    public Hrac(String meno, String farba) {
        this.farba = farba;
        this.pocetBodov = 0;
        this.meno = meno;
        this.vlastneneHraciePolickaPoberaneRaz = new ArrayList<>();
        this.vlastneneHraciePolickaPoberaneDvakrat = new ArrayList<>();
        this.zoznamVlastnenychPointov = new ArrayList<>();
        this.inventarSurovin = new ArrayList<>();
        
        this.zoznamCiest = new ArrayList<>();
        this.zoznamDedin = new ArrayList<>();
        this.zoznamMiest = new ArrayList<>();

        this.pridajSurovinu(new Drevo());
        this.pridajSurovinu(new Drevo());
        this.pridajSurovinu(new Drevo());
        this.pridajSurovinu(new Drevo());
        this.pridajSurovinu(new Drevo());
        
        this.pridajSurovinu(new Tehla());
        this.pridajSurovinu(new Tehla());
        this.pridajSurovinu(new Tehla());
        this.pridajSurovinu(new Tehla());
        this.pridajSurovinu(new Tehla());
        
        this.pridajSurovinu(new Ovca());
        this.pridajSurovinu(new Ovca());
        this.pridajSurovinu(new Ovca());
        
        this.pridajSurovinu(new Obilie());
        this.pridajSurovinu(new Obilie());
        this.pridajSurovinu(new Obilie());

        
        this.pridajSurovinu(new Kamen());


        this.cestaReprezentacna = new Cesta(this);
        this.dedinaReprezentacna = new Dedina(this);
        this.mestoReprezentacne = new Mesto(this);

        
        for (int i = 0; i < 15; i++) {
            this.zoznamCiest.add(this.cestaReprezentacna);
        }
        
        for (int i = 0; i < 5; i++) {
            this.zoznamDedin.add(this.dedinaReprezentacna);
        }
        
        for (int i = 0; i < 4; i++) {
            this.zoznamMiest.add(this.mestoReprezentacne);
        }
        
    }
    
    /**
     * metoda overi, ci ma hrac dostatok surovin na kupenie cesty (drevo a tehla)
     * ak ano, tieto suroviny sa hracovi odoberu
     * @return ci ma hrac dostatok surovin na kupenie cesty
     */
    public boolean maNaKupenieCesty() {
        Drevo drevoNaVymazanie = null;
        Tehla tehlaNaVymazanie;
        
        for (int index = 0; index < this.inventarSurovin.size(); index++) {
            if (this.inventarSurovin.get(index) instanceof Drevo) {
                drevoNaVymazanie = (Drevo)this.inventarSurovin.get(index); 
            }
        }
        
        if (drevoNaVymazanie == null) {
            return false;
        }
        
        for (int index = 0; index < this.inventarSurovin.size(); index++) {
            if (this.inventarSurovin.get(index) instanceof Tehla) {
                tehlaNaVymazanie = (Tehla)this.inventarSurovin.get(index);
                this.inventarSurovin.remove(drevoNaVymazanie);
                this.inventarSurovin.remove(tehlaNaVymazanie);
                return true;
            }
        }
        return false;
    }
    
    /**
     * metoda zisti, ci ma hrac suroviny na kupenie dediny (drevo, tehla, ovca, obilie)
     * ak ano, tieto suroviny sa hracovi odoberu z inventara
     * @return ci ma hrac suroviny na kupenie dediny
     */
    public boolean maNaKupenieDediny() {
        Drevo drevoNaVymazanie = null;
        Tehla tehlaNaVymazanie = null;
        Obilie obilieNaVymazanie = null;
        Ovca ovcaNaVymazanie;
        
        for (int index = 0; index < this.inventarSurovin.size(); index++) {
            if (this.inventarSurovin.get(index) instanceof Drevo) {
                drevoNaVymazanie = (Drevo)this.inventarSurovin.get(index);
                break;
            }
        }        
        if (drevoNaVymazanie == null) {
            return false;
        }
        
        for (int index = 0; index < this.inventarSurovin.size(); index++) {
            if (this.inventarSurovin.get(index) instanceof Tehla) {
                tehlaNaVymazanie = (Tehla)this.inventarSurovin.get(index);
                break;
            }
        }
        if (tehlaNaVymazanie == null) {
            return false;
        }
        
        for (int index = 0; index < this.inventarSurovin.size(); index++) {
            if (this.inventarSurovin.get(index) instanceof Obilie) {
                obilieNaVymazanie = (Obilie)this.inventarSurovin.get(index);
                break;
            }
        }
        if (obilieNaVymazanie == null) {
            return false;
        }
        
        for (int index = 0; index < this.inventarSurovin.size(); index++) {
            if (this.inventarSurovin.get(index) instanceof Ovca) {
                ovcaNaVymazanie = (Ovca)this.inventarSurovin.get(index);
                this.inventarSurovin.remove(drevoNaVymazanie);
                this.inventarSurovin.remove(tehlaNaVymazanie);
                this.inventarSurovin.remove(obilieNaVymazanie);
                this.inventarSurovin.remove(ovcaNaVymazanie);
                return true;
            }
        }
        return false;
    }
    
    /**
     * metoda overi, ci ma hrac dostatok surovin na kupenie mesta (dve obilia a tri kamene)
     * ak ano, odoberie tieto suroviny z inventara surovin
     * @return ci ma hrac suroviny na kupenie mesta
     */
    public boolean maNaKupenieMesta() {
        Obilie obilieNaVymazanie1 = null;
        Obilie obilieNaVymazanie2 = null;
        Kamen kamenNaVymazanie1 = null;
        Kamen kamenNaVyamzanie2 = null;
        Kamen kamenNaVymazanie3;
        
        int index1;
        int index2;
        int index3;
        int index4;
        int index5;
        
        for (index1 = 0; index1 < this.inventarSurovin.size(); index1++) {
            if (this.inventarSurovin.get(index1) instanceof Obilie) {
                obilieNaVymazanie1 = (Obilie)this.inventarSurovin.get(index1);
                break;
            }
        }
        if (obilieNaVymazanie1 == null) {
            return false;
        }
        
        for (index2 = index1 + 1; index2 < this.inventarSurovin.size(); index2++) {
            if (this.inventarSurovin.get(index2) instanceof Obilie) {
                obilieNaVymazanie2 = (Obilie)this.inventarSurovin.get(index2);
                break;
            }
        }
        if (obilieNaVymazanie2 == null) {
            return false;
        }
        
        for (index3 = 0; index3 < this.inventarSurovin.size(); index3++) {
            if (this.inventarSurovin.get(index3) instanceof Kamen) {
                kamenNaVymazanie1 = (Kamen)this.inventarSurovin.get(index3);
                break;
            }
        }
        if (kamenNaVymazanie1 == null) {
            return false;
        }
        
        for (index4 = index3 + 1; index4 < this.inventarSurovin.size(); index4++) {
            if (this.inventarSurovin.get(index4) instanceof Kamen) {
                kamenNaVyamzanie2 = (Kamen)this.inventarSurovin.get(index4);
                break;
            }
        }
        if (kamenNaVyamzanie2 == null) {
            return false;
        }
        
        for (index5 = index4 + 1; index5 < this.inventarSurovin.size(); index5++) {
            if (this.inventarSurovin.get(index5) instanceof Kamen) {
                kamenNaVymazanie3 = (Kamen)this.inventarSurovin.get(index5);
                this.inventarSurovin.remove(obilieNaVymazanie1);
                this.inventarSurovin.remove(obilieNaVymazanie2);
                this.inventarSurovin.remove(kamenNaVymazanie1);
                this.inventarSurovin.remove(kamenNaVyamzanie2);
                this.inventarSurovin.remove(kamenNaVymazanie3);
                return true;
            }
        }
        return false;
    }
    
    /**
     * metoda vrati obrazkovu reprezentaciu mesta hraca
     * @return vrati obrazkovu reprezentaciu mesta hraca
     */
    public Image getMestoReprezentacia() {
        return this.mestoReprezentacne.getReprezentacia();
    }
    
    /**
     * metoda vrati obrazkovu reprezentaciu horizontalnej cesty hraca
     * @return vrati obrazkovu reprezentaciu horizontalnej cesty hraca
     */
    public Image getCestaHorizontalnaReprezentacia() {
        return this.cestaReprezentacna.getReprezentaciaHorizontalna();
    }
    
    /**
     * metoda vrati obrazkovu reprezentaciu vertikalnej cesty hraca
     * @return vrati obrazkovu reprezentaciu vertikalnej cesty hraca
     */
    public Image getCestaVertikalnaReprezentacia() {
        return this.cestaReprezentacna.getReprezentaciaVertikalna();
    }

    /**
     * metoda vrati obrazkovu reprezentaciu cesty hraca
     * @return vrati obrazkovu reprezentaciu cesty hraca
     */
    public Image getDedinaReprezentacia() {
        return this.dedinaReprezentacna.getReprezentacia();
    }
     /**
      * metoda prida do inventara surovin hracovi surovinu podla parametra
      * @param surovina surovina, ktora sa prida hracovi do inventara surovin
      */
    public void pridajSurovinu(Surovina surovina) {
        this.inventarSurovin.add(surovina);
    }

    /**
     * metoda vrati cislo predstavujuce pocet surovin daneho druhu (podla parametra),
     * ktore ma hrac v inventari
     * @param surovina surovina, ktorej pocetnost v inventari zistujem
     * @return pocet surovin daneho druhu (podla parametra)
     */
    public int getPocetSurovinDanehoDruhu(Surovina surovina) {
        int pocitadlo = 0;
        for (Surovina aktualnaSurovina : this.inventarSurovin) {
            if (aktualnaSurovina.getNazov().equals(surovina.getNazov())) {
                pocitadlo++;
            }
        }
        return pocitadlo;
    }

    /**
     * metoda prida policko pre pridavanie (cesty, dediny, mesta)
     * @param polickoPrePridavanieObce policko, ktore sa hracovi pridava
     */
    public void pridajPolickoPrePridavanie(IPolickoPrePridavanie polickoPrePridavanieObce) {
        this.pridajHraciePolickaPoberaneRaz(polickoPrePridavanieObce);
    }

    /**
     * metoda prida do zoznamu "vlastnenych" hracich policok take hracie policka,
     * ktore policko pre pridavanie obce prekryva (cize obec na nom postavena pobera suroviny "spod nej")
     * @param polickoPrePridavanieObce policko pre pridavanie obce, spod ktoreho pridavam hracie policko so surovinami
     */
    private void pridajHraciePolickaPoberaneRaz(IPolickoPrePridavanie polickoPrePridavanieObce) {
        int pokial = polickoPrePridavanieObce.getPocetHracichPolicokKtorePrekryvam();
        for (int i = 0; i < pokial; i++) {
            this.vlastneneHraciePolickaPoberaneRaz.add(polickoPrePridavanieObce.getHraciePolicko(i));
        }
    }

    /**
     * metoda prida hracovi suroviny podla toho, ake cislo prislo v parametri (padlo na kocke v hre)
     * a tym padom hrac ziska tie suroviny, ktore su pod tymto cislom na hracej ploche
     * a ak tieto suroviny ziskal cez mesto, pridaju sa hracovi dva kusy tejto suroviny
     * @param hracNaRade hrac, ktory je aktualne v hre na rade
     * @param vysledok cislo, ktore padlo na kocke (sucet)
     * @param okno hlavne okno zobrazujuce celu hru
     */
    public void pridajSiSuroviny(Hrac hracNaRade, int vysledok, JFrame okno) {
        String vypis = "";
        int pocitadloPridanychSurovin = 0;
        for (HraciePolicko hraciePolicko : this.vlastneneHraciePolickaPoberaneRaz) {
            if (hraciePolicko.getCislo() == vysledok) {
                this.pridajSurovinu(hraciePolicko.getSurovina());
                
                vypis += "\n" + hraciePolicko.getSurovina().getNazov();
                pocitadloPridanychSurovin++;
            }
        }
        for (HraciePolicko hraciePolicko : this.vlastneneHraciePolickaPoberaneDvakrat) {
            if (hraciePolicko.getCislo() == vysledok) {
                this.pridajSurovinu(hraciePolicko.getSurovina());
                    
                vypis += "\n" + hraciePolicko.getSurovina().getNazov();
                pocitadloPridanychSurovin++;
            }
        }
        
        if (pocitadloPridanychSurovin > 0) {
            if (pocitadloPridanychSurovin == 1) {
                JOptionPane.showMessageDialog(okno, this.meno + " ziskava 1 novu surovinu:" + vypis);
            } else if (pocitadloPridanychSurovin <= 4) {
                JOptionPane.showMessageDialog(okno, this.meno + " ziskava " + pocitadloPridanychSurovin + " nove suroviny:" + vypis);
            } else if (pocitadloPridanychSurovin >= 5) {
                JOptionPane.showMessageDialog(okno, this.meno + " ziskava " + pocitadloPridanychSurovin + " novych surovin:" + vypis);
            }
        } else if (hracNaRade.equals(this)) {
            JOptionPane.showMessageDialog(okno, this.meno + " - bohužiaľ, nevyšlo :)");
        }
    }

    /**
     * metoda prida hracie policka pod polickom pre pridavanie obce (z parametra)
     * do zoznamu hracich policok poberanych dvojnasobne, cize na policku pre pridavanie je mesto
     * @param polickoPrePridavanieObce policko, pod ktorym su hracie policka, ktorych suroviny budem poberat dvojnasobne
     */
    public void poberajDvojnasobokSurovin(IPolickoPrePridavanie polickoPrePridavanieObce) {
        int pokial = polickoPrePridavanieObce.getPocetHracichPolicokKtorePrekryvam();
        for (int i = 0; i < pokial; i++) {
            this.vlastneneHraciePolickaPoberaneDvakrat.add(polickoPrePridavanieObce.getHraciePolicko(i));
        }
    }
    
    /**
     * metoda vymaze cestu zo zoznamu ciest
     */
    public void removeCesta() {
        this.zoznamCiest.remove(0);
    }
    
    /**
     * metoda vymaze dedinu zo zoznamu dedin 
     */
    public void removeDedina() {
        this.zoznamDedin.remove(0);
    }
    
    /**
     * metoda vymaze mesto zo zoznamu miest
     */
    public void removeMesto() {
        this.zoznamMiest.remove(0);
    }

    /**
     * metoda vrati pocet ciest, ktore ma aktualne hrac v zozname ciest
     * @return pocet ciest, ktore ma aktualne hrac v zozname ciest
     */
    public int getPocetCiest() {
        return this.zoznamCiest.size();
    }

    /**
     * metoda vrati pocet dedin, ktore ma akutalne hrac v zozname dedin
     * @return pocet dedin, ktore ma akutalne hrac v zozname dedin
     */
    public int getPocetDedin() {
        return this.zoznamDedin.size();
    }

    /**
     * metoda vrati pocet miest, ktore ma akutalne hrac v zozname miest
     * @return pocet miest, ktore ma akutalne hrac v zozname miest
     */
    public int getPocetMiest() {
        return this.zoznamMiest.size();
    }

    /**
     * metoda vracia, ci ma hrac v zozname nejaku cestu
     * @return ci ma hrac v zozname nejaku cestu
     */
    public boolean maCestu() {
        return !this.zoznamCiest.isEmpty();
    }

    /**
     * metoda vracia, ci ma hrac v zozname nejaku dedinu
     * @return ci ma hrac v zozname nejaku dedinu
     */
    public boolean maDedinu() {
        return !this.zoznamDedin.isEmpty();
    }

    /**
     * metoda vracia, ci ma hrac v zozname nejake mesto
     * @return ci ma hrac v zozname nejake mesto
     */
    public boolean maMesto() {
        return !this.zoznamMiest.isEmpty();
    }
    
    /**
     * metoda overuje, ci hrac moze postavit mesto, to znamena, ci uz kupil nejaku dedinu
     * zistuje sa, ci je zoznam dedin plny alebo nie (ak nie, znamena to, ze hrac uz dedinu kupil,
     * cize moze kupit aj mesto)
     * @return 
     */
    public boolean mozePostavitMesto() {
        return this.zoznamDedin.size() != 5;
    }
    
    /**
     * metoda prida dedinu do zoznamu dedin
     */
    public void pridajDedinu() {
        this.zoznamDedin.add(this.dedinaReprezentacna);
    }

    /**
     * metoda vrati meno hraca
     * @return meno hraca
     */
    public String getMeno() {
        return this.meno;
    }

    /**
     * metoda prida hracovi bod do zoznamu bodov 
     * presnejsie bod reprezentuje neprepocitane suradnice bodu, kde hrac klikol
     * @param point bod, na ktory hrac klikol
     */
    public void pridajSiPoint(Point point) {
        this.zoznamVlastnenychPointov.add(point);
    }

    /**
     * metoda zistuje, ci ma hrac postaveny nejaky komponent (cesta, obec) na danom policku
     * @param point bod, na ktorom je komponent
     * @param velkostPolicka velkost policka pre pridavanie 
     * @return ci ma hrac policko na bode
     */
    public boolean maPolickoNaPointe(Point point, int velkostPolicka) {
        int pointX = (int)((int)point.getX() / velkostPolicka);
        int pointY = (int)((int)point.getY() / velkostPolicka);
        for (Point aktualnyPoint : this.zoznamVlastnenychPointov) {
            int aktualnyPointX = (int)((int)aktualnyPoint.getX() / velkostPolicka);
            int aktualnyPointY = (int)((int)aktualnyPoint.getY() / velkostPolicka);
            if (aktualnyPointX == pointX && aktualnyPointY == pointY) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * metoda zistuje, ci ma hrac postaveny nejaky komponent (cesta, obec) na danom policku
     * @param x x-ova suradnica bodu kde zistujem, ci mam policko pre pridavanie
     * @param y y-ova suradnica bodu kde zistujem, ci mam policko pre pridavanie
     * @param velkostPolicka velkost policka pre pridavanie 
     * @return ci ma hrac policko na bode
     */
    public boolean maPolickoNaPointe(int x, int y, int velkostPolicka) {
        for (Point aktualnyPoint : this.zoznamVlastnenychPointov) {
            int aktualnyPointX = (int)((int)aktualnyPoint.getX() / velkostPolicka);
            int aktualnyPointY = (int)((int)aktualnyPoint.getY() / velkostPolicka);
            if (aktualnyPointX == x && aktualnyPointY == y) {
                return true;
            }
        }
        return false;
    }

    /**
     * metoda vrati pocet bodov, ktore uz hrac nahral
     * @return pocet bodov, ktore uz hrac nahral
     */
    public int getPocetBodov() {
        return this.pocetBodov;
    }

    /**
     * metoda pripocita hracovi body
     * @param kolko kolko bodov pripocita hracovi
     */
    public void pripocitajBody(int kolko) {
        this.pocetBodov += kolko;
    }

    /**
     * metoda vrati farbu hracovych komponentom
     * @return farba hracovych komponentom
     */
    public String getFarba() {
        return this.farba;
    }
    
    /**
     * metoda nastavi hracovi hraci panel so surovinami a tlacidlami
     * @param panel hraci panel hracovi
     */
    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
    
    
    /**
     * metoda vrati hraci panel hraca
     * @return hraci panel hraca
     */
    public JPanel getPanel() {
        return this.panel;
    }
    
    /**
     * metoda overuje, ci uz hrac nedosiahol 10 bodov
     * ak ano, vyhodi vynimku pre signalizaciu konca hry
     * @throws KoniecHryException 
     */
    public void overKoniecHry() throws KoniecHryException {
        if (this.pocetBodov == 10) {
            throw new KoniecHryException();
        }
    }
}
