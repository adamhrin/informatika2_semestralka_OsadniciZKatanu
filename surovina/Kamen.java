package osadnicizkatanu.surovina;

/**
 * Trieda reprezentuje kamen v hra Osadnici z Katanu
 * @author Adam
 */
public class Kamen extends Surovina {

    /**
     * Konstruktor vyvola konstruktor predka, kde preda informacie o obrazku,
     * ktory sa vykresluje ako reprezentacia tejto suroviny
     */
    public Kamen() {
        super("/OzK_kamenVelky.jpg", "/OzK_kamenMaly.jpg", "kamen");
        //super("img/OzK_kamenVelky.jpg", "img/OzK_kamenMaly.jpg", "kamen");
    }

}
