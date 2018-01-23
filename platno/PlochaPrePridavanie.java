package osadnicizkatanu.platno;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import osadnicizkatanu.hra.Hrac;
import osadnicizkatanu.hra.HracPanel;
import osadnicizkatanu.hra.KoniecHryException;
import osadnicizkatanu.hra.KontrolaPravidiel;
import osadnicizkatanu.policko.HraciePolicko;
import osadnicizkatanu.policko.IPolickoPrePridavanie;
import osadnicizkatanu.policko.PolickoPrePridavanieCesty;
import osadnicizkatanu.policko.PolickoPrePridavanieObce;
import osadnicizkatanu.policko.PolickoPrePridavaniePrazdne;

/**
 * Trieda reprezentuje neviditelnu plochu pre pridavanie objketov na hraciu plochu
 * @author Adam
 */
public class PlochaPrePridavanie extends JPanel {
    private int pocetStlpcov;
    private int pocetRiadkov;
    private int velkostPolicka;
    private IPolickoPrePridavanie[][] polickaPrePridavanie;
    private HraciaPlocha hraciaPlocha;
    private KontrolaPravidiel kontrolaPravidiel;
    private boolean plochaPreCestyJeAktivna;
    private boolean plochaPreDedinyJeAktivna;
    private boolean plochaPreMestaJeAktivna;
    
    /**
     * Konstruktor, ktory sa vola pri pridani tohto komponentu do hlavneho okna
     */
    public PlochaPrePridavanie() {
    }

    /**
     * Konstruktor vytvara plochu pre pridavanie objektov 
     * @param pocetStlpcov pocet stlpcov s polickami pre pridavanie
     * @param pocetRiadkov pocet riadkov s polickami pre pridavanie
     * @param velkostPolicka velkost jedneho policka pre pridavanie
     * @param hraciaPlocha viditelna hracia plocha, s ktorou plocha pre pridavanie spolupracuje
     */
    public PlochaPrePridavanie(int pocetStlpcov, int pocetRiadkov, int velkostPolicka, HraciaPlocha hraciaPlocha) {
        this.kontrolaPravidiel = new KontrolaPravidiel(velkostPolicka);
        this.hraciaPlocha = hraciaPlocha;
        this.pocetStlpcov = pocetStlpcov;
        this.pocetRiadkov = pocetRiadkov;
        this.velkostPolicka = velkostPolicka;
        this.polickaPrePridavanie = new IPolickoPrePridavanie[this.pocetRiadkov][this.pocetStlpcov];
        this.nacitajSubor();
        this.vytvorPlochu();
    }
    
    /**
     * metoda vytvori plochu pre pridavanie z policok pre pridavanie
     */
    public void vytvorPlochu() {
        for (int y = 0; y < this.pocetRiadkov; y++) {
            for (int x = 0; x < this.pocetStlpcov; x++) {
                this.add((JComponent)this.polickaPrePridavanie[y][x]);
            }
        }   
    }
    
    /**
     * metoda nacita zo suboru, ako sa maju vytvarat jednotlive policka pre pridavanie
     */
    public void nacitajSubor() {
        File subor = new File("polickaPrePridavanie.txt");
        try (Scanner citac = new Scanner(subor)) {
            for (int i = 0; i < this.pocetRiadkov; i++) {                
                String riadok = citac.nextLine();
                for (int j = 0; j < this.pocetStlpcov; j++) {
                    switch (riadok.charAt(j)) {
                        case 'o' :
                            PolickoPrePridavanieObce obec = new PolickoPrePridavanieObce();
                            this.polickaPrePridavanie[i][j] = obec;
                            this.add(obec);
                            obec.setVisible(false);
                            break;
                        case 'c' :
                            PolickoPrePridavanieCesty cesta = new PolickoPrePridavanieCesty();
                            this.polickaPrePridavanie[i][j] = cesta;
                            this.add(cesta);
                            cesta.setVisible(false);
                            break;
                        case 'p' :
                            PolickoPrePridavaniePrazdne prazdne = new PolickoPrePridavaniePrazdne(this.velkostPolicka);
                            this.polickaPrePridavanie[i][j] = prazdne;
                            prazdne.setVisible(false);
                            break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Súbor " + subor.getName() + " neexistuje");
        }
    }

    /**
     * metoda nastavi konkretnemu policku pre pridavanie tie hracie policka, 
     * ktore policko pre pridavanie prekryva - inymi slovami, kto ma na tomto policku pre priadavanie postavenu obec
     * pobera suroviny z hracich policok "pod" nim
     * @param point bod, na ktory hrac klikol
     */
    private void nastavPolickuPrePridavanieHraciePolicka(Point point) {
        int indexXPolPridavacie = this.getIndexX(point);
        int indexYPolPridavacie = this.getIndexY(point);

        
        int indexXSuroviny1 = (int)(indexXPolPridavacie / 2) - 1;
        int indexYSuroviny1 = (int)(indexYPolPridavacie / 2) - 1;
        if (indexXSuroviny1 >= 0 && indexYSuroviny1 >= 0) {
            HraciePolicko hraciePolicko1 = this.hraciaPlocha.getPolicko(indexXSuroviny1, indexYSuroviny1);
            this.polickaPrePridavanie[indexYPolPridavacie][indexXPolPridavacie].nastavHraciePolicko(hraciePolicko1);
        }
        
        int indexXSuroviny2 = (int)(indexXPolPridavacie / 2);
        int indexYSuroviny2 = (int)(indexYPolPridavacie / 2) - 1;
        if (indexXSuroviny2 <= 3 && indexYSuroviny2 >= 0) {
            HraciePolicko hraciePolicko2 = this.hraciaPlocha.getPolicko(indexXSuroviny2, indexYSuroviny2);
            this.polickaPrePridavanie[indexYPolPridavacie][indexXPolPridavacie].nastavHraciePolicko(hraciePolicko2);
        }
        
        int indexXSuroviny3 = (int)(indexXPolPridavacie / 2) - 1;
        int indexYSuroviny3 = (int)(indexYPolPridavacie / 2);
        if (indexXSuroviny3 >= 0 && indexYSuroviny3 <= 4) {
            HraciePolicko hraciePolicko3 = this.hraciaPlocha.getPolicko(indexXSuroviny3, indexYSuroviny3);
            this.polickaPrePridavanie[indexYPolPridavacie][indexXPolPridavacie].nastavHraciePolicko(hraciePolicko3);
        }
        
        int indexXSuroviny4 = (int)(indexXPolPridavacie / 2);
        int indexYSuroviny4 = (int)(indexYPolPridavacie / 2);
        if (indexXSuroviny4 <= 3 && indexYSuroviny4 <= 4) {
            HraciePolicko hraciePolicko4 = this.hraciaPlocha.getPolicko(indexXSuroviny4, indexYSuroviny4);
            this.polickaPrePridavanie[indexYPolPridavacie][indexXPolPridavacie].nastavHraciePolicko(hraciePolicko4);
        }
    }
    
    /**
     * metoda vracia x-ovy index policka v ploche pre pridavanie podla bodu z parametra
     * @param point bod, na ktory hrac klikol
     * @return x-ovy index policka v ploche pre pridavanie
     */
    public int getIndexX(Point point) {
        int indexX = (int)((int)point.getX() / this.velkostPolicka);
        return indexX;
    }
    
    /**
     * metoda vracia y-ovy index policka v ploche pre pridavanie podla bodu z parametra
     * @param point bod, na ktory hrac klikol
     * @return y-ovy index policka v ploche pre pridavanie
     */
    public int getIndexY(Point point) {
        int indexY = (int)((int)point.getY() / this.velkostPolicka);
        return indexY;
    }

    /**
     * metoda vykresli cestu na konkretne policko pre pridavanie podla pointu z parametra
     * @param point bod, na ktory hrac klikol
     * @param hracNaRade hrac prave na rade
     */
    void vykresliCestu(Point point, Hrac hracNaRade) {
        int indexX = this.getIndexX(point);
        int indexY = this.getIndexY(point);
        this.polickaPrePridavanie[indexY][indexX].vykresliSa(hracNaRade, indexY, "cesta");
        hracNaRade.pridajSiPoint(point);
    }

    /**
     * metoda vykresli dedinu na konkretne policko pre pridavanie podla pointu z parametra
     * @param point bod, na ktory hrac klikol
     * @param hracNaRade hrac prave na rade
     */
    void vykresliDedinu(Point point, Hrac hracNaRade) {
        int indexX = this.getIndexX(point);
        int indexY = this.getIndexY(point);
        this.nastavPolickuPrePridavanieHraciePolicka(point);
        hracNaRade.pridajPolickoPrePridavanie(this.polickaPrePridavanie[indexY][indexX]);
        this.polickaPrePridavanie[indexY][indexX].vykresliSa(hracNaRade, indexY, "dedina");
        hracNaRade.pridajSiPoint(point);
    }
    
    /**
     * metoda vykresli mesto na konkretne policko pre pridavanie podla pointu z parametra
     * @param point bod, na ktory hrac klikol
     * @param hracNaRade hrac prave na rade
     */
    void vykresliMesto(Point point, Hrac hracNaRade) {
        int indexX = this.getIndexX(point);
        int indexY = this.getIndexY(point);
        hracNaRade.poberajDvojnasobokSurovin(this.polickaPrePridavanie[indexY][indexX]);
        this.polickaPrePridavanie[indexY][indexX].vykresliSa(hracNaRade, indexY, "mesto");
        hracNaRade.pridajSiPoint(point);
    }

    /**
     * metoda vracia, ci je dane policko uz pouzite pre cestu
     * @param point bod, na ktory hrac klikol
     * @return ci je dane policko uz pouzite pre cestu
     */
    boolean polickoJePouzitePreCestu(Point point) {
        int indexX = this.getIndexX(point);
        int indexY = this.getIndexY(point);
        return this.polickaPrePridavanie[indexY][indexX].jePouzite();
    }
    
    /**
     * metoda vracia, ci je dane policko uz pouzite pre dedinu
     * @param point bod, na ktory hrac klikol
     * @return ci je dane policko uz pouzite pre dedinu
     */
    boolean polickoJePouzitePreDedinu(Point point) {
        int indexX = this.getIndexX(point);
        int indexY = this.getIndexY(point);
        return this.polickaPrePridavanie[indexY][indexX].jePouzitePreDedinu();
    }
    
    /**
     * metoda vracia, ci je dane policko uz pouzite pre mesto
     * @param point bod, na ktory hrac klikol
     * @return ci je dane policko uz pouzite pre mesto
     */
    boolean polickoJePouzitePreMesto(Point point) {
        int indexX = this.getIndexX(point);
        int indexY = this.getIndexY(point);
        return this.polickaPrePridavanie[indexY][indexX].jePouzitePreMesto();
    }

    /**
     * metoda vracia nazov objektu, ktory mozno polozit na dane miesto urcene pointom
     * @param point bod, na ktory hrac klikol
     * @return nazov objektu, ktory mozno polozit na dane miesto
     */
    String getNazovPolozitelnehoObjektu(Point point) {
        int indexX = this.getIndexX(point);
        int indexY = this.getIndexY(point);
        return this.polickaPrePridavanie[indexY][indexX].getNazovPolozitelnehoObjektu();
    }

    /**
     * metoda vracia, ci je policko uz pouzite pre dedinu konkretneho hraca
     * @param hracNaRade hrac prave na rade
     * @param point bod, na ktory hrac klikol
     * @return ci je policko uz pouzite pre dedinu konkretneho hraca
     */
    boolean polickoJePouzitePreDedinuHraca(Hrac hracNaRade, Point point) {
        return hracNaRade.maPolickoNaPointe(point, this.velkostPolicka);
    }
    
    /**
     * metoda vracia velkost policka pre pridavanie
     * @return velkost policka pre pridavanie
     */
    int getVelkostPolicka() {
        return this.velkostPolicka;
    }

    /**
     * Metoda sa vykonava, ked hrac klikol na plochu pre pridavanie a riesi pokladanie (vykreslenie) 
     * konkretneho objektu na plochu
     * @param hracNaRade hrac prave na rade
     * @param tah poradove cislo tahu
     * @param point bod, na ktory hrac klikol
     * @param hlavneOkno hlavne okno zobrazujuce hru
     */
    void vykonajAkciu(Hrac hracNaRade, int tah, Point point, JFrame hlavneOkno) {
        String typ = this.getNazovPolozitelnehoObjektu(point);
        HracPanel hracNaRadePanel = (HracPanel)hracNaRade.getPanel();
        
        if (!this.plochaPreCestyJeAktivna && !this.plochaPreDedinyJeAktivna && !this.plochaPreMestaJeAktivna) {
            JOptionPane.showMessageDialog(hlavneOkno, "Najprv si vyber objekt, ktorý chceš kúpiť");
        } else if (this.plochaPreCestyJeAktivna && typ.equals("cesta")) {
            if (this.polickoJePouzitePreCestu(point)) {
                JOptionPane.showMessageDialog(hlavneOkno, "Sem nemôžeš položiť cestu", "Pozor!", JOptionPane.ERROR_MESSAGE);
            } else if (this.kontrolaPravidiel.hracMozePolozitObjekt(hracNaRade, point, tah)
                    || this.kontrolaPravidiel.hracMozePolozitCestu(hracNaRade, point, tah)) {
                this.vykresliCestu(point, hracNaRade);
                this.setPlochaPreCesty(false);
                if (tah <= 4) {
                    hracNaRadePanel.setStlacitelnostKupovacichTlacidiel(false);
                } else {
                    hracNaRadePanel.setStlacitelnostKupovacichTlacidiel(true);
                }
            }
        } else if (this.plochaPreDedinyJeAktivna && typ.equals("obec")) {
            if (this.polickoJePouzitePreDedinu(point)) {
                JOptionPane.showMessageDialog(hlavneOkno, "Sem nemôžeš položiť dedinu", "Pozor!", JOptionPane.ERROR_MESSAGE);
            } else if (this.kontrolaPravidiel.hracMozePolozitObjekt(hracNaRade, point, tah)) {
                this.vykresliDedinu(point, hracNaRade);
                this.plochaPreDedinyJeAktivna = false;
                if (tah <= 4) {
                    hracNaRadePanel.aktivujTlacidloKupCestu();
                } else {
                    hracNaRadePanel.setStlacitelnostKupovacichTlacidiel(true);
                }
            }
        } else if (this.plochaPreMestaJeAktivna && typ.equals("obec")) {
            
            //ak je na policku uz dedina ale nie je tam este mesto, tak je to spravne
            if (this.polickoJePouzitePreDedinuHraca(hracNaRade, point)
                && !this.polickoJePouzitePreMesto(point)) {
                this.vykresliMesto(point, hracNaRade);
                this.plochaPreMestaJeAktivna = false;
            } else {
                JOptionPane.showMessageDialog(hlavneOkno, "Sem nemôžeš položiť mesto", "Pozor!", JOptionPane.ERROR_MESSAGE);
            }
            hracNaRadePanel.setStlacitelnostKupovacichTlacidiel(true);
        }
        
        try {
            hracNaRade.overKoniecHry();
        } catch (KoniecHryException ex) {
            JOptionPane.showMessageDialog(hlavneOkno, "KONIEC HRY!\nVyhráva " + hracNaRade.getMeno());
            System.exit(0);
        }
    }

    /**
     * metoda nastavuje aktivitu tejto plochy pre pokladanie cesty
     * @param ako ci ma byt aktivna
     */
    void setPlochaPreCesty(boolean ako) {
        this.plochaPreCestyJeAktivna = ako;
    }

    /**
     * metoda nastavuje aktivitu tejto plochy pre pokladanie dediny
     * @param ako ci ma byt aktivna
     */
    void setPlochaPreDediny(boolean ako) {
        this.plochaPreDedinyJeAktivna = ako;
    }

    /**
     * metoda nastavuje aktivitu tejto plochy pre pokladanie mesta
     * @param ako ci ma byt aktivna
     */
    void setPlochaPreMesta(boolean ako) {
        this.plochaPreMestaJeAktivna = ako;
    }
}
