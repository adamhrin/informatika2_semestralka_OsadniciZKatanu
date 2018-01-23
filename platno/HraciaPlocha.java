package osadnicizkatanu.platno;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.JPanel;
import osadnicizkatanu.policko.HraciePolicko;
import osadnicizkatanu.policko.PolickoCislo;
import osadnicizkatanu.surovina.Drevo;
import osadnicizkatanu.surovina.Kamen;
import osadnicizkatanu.surovina.Obilie;
import osadnicizkatanu.surovina.Ovca;
import osadnicizkatanu.surovina.Surovina;
import osadnicizkatanu.surovina.Tehla;

/**
 * Trieda reprezentuje hraciu plochu hry Osadnici z Katanu
 * @author Adam
 */
public class HraciaPlocha extends JPanel {
    private HraciePolicko[][] hraciePolicka;
    private int pocetStlpcov;
    private int pocetRiadkov;
    private int velkostPolicka;
    
    private ArrayList<String> zoznamNazvovSurovin;
    
    private ArrayList<Surovina> zoznamPouzitelnychSurovin;
    
    private HraciaPlochaCisla hraciaPlochaCisla;
    
    /**
     * Konstruktor, ktory sa vola pri pridani tohto komponentu do hlavneho okna
     */
    public HraciaPlocha() {
    }
    
    /**
     * Konstruktor, ktory vytvara hraciu plochu z hracich policok
     * @param pocetStlpcov pocet stlpcov s hracimi polickami
     * @param pocetRiadkov pocet riadkov s hracimi polickami
     * @param velkostPolicka velkost jedneho hracieho policka
     * @param plochaCisla plocha zobrazujuca cisla na hracej ploche
     */
    public HraciaPlocha(int pocetStlpcov, int pocetRiadkov, int velkostPolicka, HraciaPlochaCisla plochaCisla) {
        this.hraciaPlochaCisla = plochaCisla;
        this.pocetStlpcov = pocetStlpcov;
        this.pocetRiadkov = pocetRiadkov;
        this.velkostPolicka = velkostPolicka;
        this.hraciePolicka = new HraciePolicko[this.pocetRiadkov][this.pocetStlpcov];
        
        this.zoznamNazvovSurovin = new ArrayList<>();
        this.nacitajSubor();
        this.shuffleZoznamSurovin();
        
        this.zoznamPouzitelnychSurovin = new ArrayList<>();
        this.zoznamPouzitelnychSurovin.add(new Drevo());
        this.zoznamPouzitelnychSurovin.add(new Kamen());
        this.zoznamPouzitelnychSurovin.add(new Obilie());
        this.zoznamPouzitelnychSurovin.add(new Ovca());
        this.zoznamPouzitelnychSurovin.add(new Tehla());
        
        this.vytvorPlochu();
    }
    
    /**
     * metoda vytvori hraciu plochu z hracich policok
     */
    public void vytvorPlochu() {
        for (int y = 0; y < this.pocetRiadkov; y++) {
            for (int x = 0; x < this.pocetStlpcov; x++) {
                
                String nazovSurovinyZoZoznamu;
                nazovSurovinyZoZoznamu = this.zoznamNazvovSurovin.get(0);
                
                for (Surovina surovina : this.zoznamPouzitelnychSurovin) {
                    if (surovina.getNazov().equals(nazovSurovinyZoZoznamu)) {
                        PolickoCislo polickoCislo = this.hraciaPlochaCisla.getPolickoCislo(x, y);
                        HraciePolicko policko = new HraciePolicko(this.velkostPolicka, surovina, polickoCislo, "velke");
                        this.hraciePolicka[y][x] = policko;
                        this.add(policko.dajKomponent());
                    }
                }
                this.zoznamNazvovSurovin.remove(0);
            }
        }   
    }
    
    /**
     * metoda nahodne zoradi nazvy surovin v zozname nazovov surovin
     */
    public void shuffleZoznamSurovin() {
        Collections.shuffle(this.zoznamNazvovSurovin);
    }

    /**
     * metoda nacita subor so zoznamom surovin
     */
    public void nacitajSubor() {
        File subor = new File("zoznamSurovin.txt");
        try (Scanner citac = new Scanner(subor)) {
            for (int i = 0; i < 20; i++) {
                String nazovSuroviny = citac.nextLine();
                this.zoznamNazvovSurovin.add(nazovSuroviny);
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("Súbor " + subor.getName() + " neexistuje");
        }    
    }

    HraciePolicko getPolicko(int indexX, int indexY) {
        return this.hraciePolicka[indexY][indexX];
    }
    
    
}
