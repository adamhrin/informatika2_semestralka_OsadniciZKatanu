package osadnicizkatanu.policko;

import osadnicizkatanu.hra.Hrac;

/**
 * Interface reprezentujuci policko pre pridavanie
 * @author Adam
 */
public interface IPolickoPrePridavanie {
    
    /**
     * metoda vracia nazov objektu, ktory mozno polozit na dane policko pre pridavanie
     * @return nazov objektu, ktory mozno polozit na dane policko
     */
    String getNazovPolozitelnehoObjektu();

    /**
     * metoda nastavuje policku pre pridavanie hracie policko
     * @param hraciePolicko ktore sa nastavi policku pre pridavanie
     */
    void nastavHraciePolicko(HraciePolicko hraciePolicko);

    /**
     * metoda vykresluje na policko dany objekt
     * @param hrac hrac prave na rade
     * @param indexY y-ovy index policka pre pridavanie
     * @param typ typ objektu (pri obci)
     */
    void vykresliSa(Hrac hrac, int indexY, String typ);
    
    /**
     * metoda vracia, ci je dane policko uz pouzite pre nejaky objekt
     * @return ci je pouzite
     */
    boolean jePouzite();
    
    /**
     * metoda vracia, ci je dane policko uz pouzite pre dedinu
     * @return ci je dane policko uz pouzite pre dedinu
     */
    boolean jePouzitePreDedinu();
    
    /**
     * metoda vracia, ci je dane policko uz pouzite pre mesto
     * @return ci je dane policko uz pouzite pre mesto
     */
    boolean jePouzitePreMesto();

    /**
     * metoda vracia konkretne hracie policko zo zoznamu hracich policok, ktore policko pre pridavanie prekryva
     * @param index index v zozname hracich policok
     * @return hracie policko ktore prekryva polciko pre pridavanie
     */
    HraciePolicko getHraciePolicko(int index);
    
    /**
     * metoda vracia pocet hracich policok, ktore policko pre pridavanie prekryva
     * @return pocet hracich policok, ktore policko pre pridavanie prekryva
     */
    int getPocetHracichPolicokKtorePrekryvam();
    
}