package osadnicizkatanu.hra;

/**
 * Trieda je vynimka, ktora sa vyhodi pri konci hry (ak nejaky hrac dosiahne 10 bodov)
 * @author Adam
 */
public class KoniecHryException extends Exception {

    /**
     * Konstruktor vytvori vynimku
     */
    public KoniecHryException() {
        super("koniec hry");
    }
    
}
