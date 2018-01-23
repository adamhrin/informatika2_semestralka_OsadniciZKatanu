package osadnicizkatanu.policko;

import javax.swing.JComponent;
import osadnicizkatanu.surovina.Surovina;
import osadnicizkatanu.surovina.VykreslovacSuroviny;

/**
 * Trieda reprezentuje hracie policko z hracej plochy
 * @author Adam
 */
public class HraciePolicko {
    private final int velkost;
    private final Surovina surovina;
    private final PolickoCislo polickoCislo;
    private final VykreslovacSuroviny vykreslovac;
    
    /**
     * Konstruktor vytvori hracie policko so surovinou a cislom
     * @param velkost velkost hracieho policka
     * @param surovina surovina na hracom policku
     * @param polickoCislo cislo na hracom policku
     * @param typVykreslenia typ policka, ci ma byt velke (pre plochu) alebo male (pre hracov panel)
     */
    public HraciePolicko(int velkost, Surovina surovina, PolickoCislo polickoCislo, String typVykreslenia) {
        this.velkost = velkost;
        this.surovina = surovina;
        this.polickoCislo = polickoCislo;
        this.vykreslovac = new VykreslovacSuroviny(this.surovina, 0, 0, typVykreslenia);
    }
    
    /**
     * metoda vracia cislo z hracieho policka
     * @return cislo z hracieho policka
     */
    public int getCislo() {
        return this.polickoCislo.getCislo();
    }

    /**
     * metoda vracia surovinu z hracieho policka
     * @return surovina z hracieho policka
     */
    public Surovina getSurovina() {
        return this.surovina;
    }
    
    /**
     * metoda vracia JComponent tohto policka
     * @return JComponent tohto policka
     */
    public JComponent dajKomponent() {
        return this.vykreslovac.dajKomponent();
    }
}
