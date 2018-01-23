package osadnicizkatanu.hra;

import java.awt.Point;

/**
 * Trieda pre kontrolu pravidiel hry Osadnici z Katanu, presnejsie pre ukladanie objektov na hraciu plochu
 * @author Adam
 */
public class KontrolaPravidiel {
    private final int velkostPolickaPrePridavanie;

    /**
     * Konstruktor vytvori triedu starajucu sa o kontrolu pravidiel v hre
     * @param velkostPolickaPrePridavanie velkost prislusneho policka pre pridavanie prislusenstiev
     */
    public KontrolaPravidiel(int velkostPolickaPrePridavanie) {
        this.velkostPolickaPrePridavanie = velkostPolickaPrePridavanie;
    }

    /**
     * metoda overi, ci hrac moze polozit nejaky objekt na hraciu plochu
     * overuje sa, ci sa v specifikovanom okoli bodu, kde chce hrac nieco pridat, uz vyskytuju jeho objekty
     * @param hracNaRade hrac prave na rade
     * @param point bod, na ktory hrac klikol v hracej ploche
     * @param tah poradove cislo tahu
     * @return ci hrac moze polozit objekt na miesto kde klikol
     */
    public boolean hracMozePolozitObjekt(Hrac hracNaRade, Point point, int tah) {
        int polickoX = (int)((int)point.getX() / this.velkostPolickaPrePridavanie);
        int polickoY = (int)((int)point.getY() / this.velkostPolickaPrePridavanie);
        //kontrola, ci je tah vacsi ako styri, alebo dany objekt nie je dedina (je cesta, cize sa kontroluje vzdy)
        if (tah > 4 || polickoX % 2 == 1 || polickoY % 2 == 1) {
            //kontrola, ci hrac vlastni policko vlavo hore od daneho policka 
            if (polickoX - 1 >= 0 && polickoY - 1 >= 0) {
                if (hracNaRade.maPolickoNaPointe(polickoX - 1, polickoY - 1, this.velkostPolickaPrePridavanie)) {
                    return true;
                }
            }
            //kontrola, ci hrac vlastni policko nad danym polickom
            if (polickoY - 1 >= 0) {
                if (hracNaRade.maPolickoNaPointe(polickoX, polickoY - 1, this.velkostPolickaPrePridavanie)) {
                    return true;
                }
            }
            //kontrola, ci hrac vlastni policko vpravo hore od daneho policka
            if (polickoX + 1 <= 8 && polickoY - 1 >= 0) {
                if (hracNaRade.maPolickoNaPointe(polickoX + 1, polickoY - 1, this.velkostPolickaPrePridavanie)) {
                    return true;
                }
            }
            //kontrola, ci hrac vlastni policko vlavo od daneho policka
            if (polickoX - 1 >= 0) {
                if (hracNaRade.maPolickoNaPointe(polickoX - 1, polickoY, this.velkostPolickaPrePridavanie)) {
                    return true;
                }
            }
            //kontrola, ci hrac vlastni policko vpravo od daneho policka
            if (polickoX + 1 <= 8) {
                if (hracNaRade.maPolickoNaPointe(polickoX + 1, polickoY, this.velkostPolickaPrePridavanie)) {
                    return true;
                }
            }
            //kontrola, ci hrac vlastni policko vlavo dole od daneho policka
            if (polickoX - 1 >= 0 && polickoY + 1 <= 10) {
                if (hracNaRade.maPolickoNaPointe(polickoX - 1, polickoY + 1, this.velkostPolickaPrePridavanie)) {
                    return true;
                }
            }
            //kontrola, ci hrac vlastni policko dole od daneho policka
            if (polickoY + 1 <= 10) {
                if (hracNaRade.maPolickoNaPointe(polickoX, polickoY + 1, this.velkostPolickaPrePridavanie)) {
                    return true;
                }
            }
            //kontrola, ci hrac vlastni policko vpravo dole od daneho policka
            if (polickoX + 1 <= 8 && polickoY + 1 <= 10) {
                if (hracNaRade.maPolickoNaPointe(polickoX + 1, polickoY + 1, this.velkostPolickaPrePridavanie)) {
                    return true;
                }
            }
            //v okoli cesty hrac nevlastni ziadne policko = nemoze postavit cestu
            return false;
        } else {
            //prve styri tahy
            return true;
        }
    }
    
    /**
     * Specialna kontrola pre cesty, kedze cesty mozu byt v istej situacii polozene aj obpolicko
     * ak je cesta horizontalna, dalsia cesta moze byt polozena aj obpolicko vpravo a vlavo
     * ak je cesta vertikalna, dalsia cesta moze byt polozena aj obpolicko hore a dole
     * @param hracNaRade hrac prave na rade
     * @param point bod, na ktory hrac klikol v hracej ploche
     * @param tah poradove cislo tahu
     * @return ci hrac moze polozit cestu na miesto kde klikol
     */
    public boolean hracMozePolozitCestu(Hrac hracNaRade, Point point, int tah) {
        int polickoX = (int)((int)point.getX() / this.velkostPolickaPrePridavanie);
        int polickoY = (int)((int)point.getY() / this.velkostPolickaPrePridavanie);
        //ak je x-ovy index policko neparne cislo = policko zobrazuje horizontalnu cestu
        if (polickoX % 2 == 1) {
            //kontrola, ci hrac vlastni policko o dve policka vlavo
            if (polickoX - 2 >= 0) {
                if (hracNaRade.maPolickoNaPointe(polickoX - 2, polickoY, this.velkostPolickaPrePridavanie)) {
                    return true;
                }
            }
            //kontrola, ci hrac vlastni policko o dve policka vpravo
            if (polickoX + 2 <= 8) {
                if (hracNaRade.maPolickoNaPointe(polickoX + 2, polickoY, this.velkostPolickaPrePridavanie)) {
                    return true;
                }
            }
        }

        if (polickoX % 2 == 0) {
            //kontrola, ci hrac vlastni policko o dve policka hore
            if (polickoY - 2 >= 0) {
                if (hracNaRade.maPolickoNaPointe(polickoX, polickoY - 2, this.velkostPolickaPrePridavanie)) {
                    return true;
                }
            }
            //kontrola, ci hrac vlastni policko o dve policka dole
            if (polickoY + 2 <= 8) {
                if (hracNaRade.maPolickoNaPointe(polickoX, polickoY + 2, this.velkostPolickaPrePridavanie)) {
                    return true;
                }
            }
        }
        //v okoli obpolicka sa nenachadza ziadne mnou vlastnene policko
        return false;
    }
}
