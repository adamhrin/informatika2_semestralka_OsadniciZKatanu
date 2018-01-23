package osadnicizkatanu.platno;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JPanel;
import osadnicizkatanu.policko.PolickoCislo;

/**
 * Trieda vytvori hraciu plochu s cislami na hracich polickach
 * @author Adam
 */
public class HraciaPlochaCisla extends JPanel {
    private PolickoCislo[][] policka;
    private int pocetStlpcov;
    private int pocetRiadkov;
    private int velkostPolicka;
    private ArrayList<Integer> zoznamCisel;

    /**
     * Konstruktor, ktory sa vola pri pridani tohto komponentu do hlavneho okna
     */
    public HraciaPlochaCisla() {
    }
 
    /**
     * Konstruktor vytvori hraciu plochu s cislami - cisla prisluchaju jednotlivym hracim polickam so surovinami
     * @param pocetStlpcov pocet stlpcov s ciselnymi polickami
     * @param pocetRiadkov pocet riadkov s ciselnymi polickami
     * @param velkostPolicka velkost jedneho ciselneho policka
     */
    public HraciaPlochaCisla(int pocetStlpcov, int pocetRiadkov, int velkostPolicka) {
        this.pocetStlpcov = pocetStlpcov;
        this.pocetRiadkov = pocetRiadkov;
        this.velkostPolicka = velkostPolicka;
        this.policka = new PolickoCislo[this.pocetRiadkov][this.pocetStlpcov];
        this.zoznamCisel = new ArrayList<Integer>();
        this.naplnZoznamCisel();
        this.shuffleZoznamCisel();
        this.vytvorPlochu();
    }
    
    /**
     * metoda vytvori plochu cisel z ciselnych policok
     */
    public void vytvorPlochu() {
        for (int y = 0; y < this.pocetRiadkov; y++) {
            for (int x = 0; x < this.pocetStlpcov; x++) {
                int cislo = this.zoznamCisel.get(0);
                
                PolickoCislo polickoCislo = new PolickoCislo(this.velkostPolicka, cislo);
                
                this.policka[y][x] = polickoCislo;
                this.add(polickoCislo);
                
                this.zoznamCisel.remove(0);
            }
        }
    }

    /**
     * metoda nahodne zoradi cisla v zozname cisel
     */
    public void shuffleZoznamCisel() {
        Collections.shuffle(this.zoznamCisel);
    }

    /**
     * metoda naplni zoznam cisel prislusnymi cislami
     */
    private void naplnZoznamCisel() {
        for (int i = 0; i < 2; i++) {
            for (int j = 2; j <= 12; j++) {
                this.zoznamCisel.add(j);
            }
        }
        
        //vymaze nezelane sedmicky
        this.zoznamCisel.remove(5);
        this.zoznamCisel.remove(15);
    }
    
    public PolickoCislo getPolickoCislo(int indexX, int indexY) {
        return this.policka[indexY][indexX];
    }
}
