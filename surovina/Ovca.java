package osadnicizkatanu.surovina;


/**
 * Trieda reprezentuje ovca v hra Osadnici z Katanu
 * @author Adam
 */
public class Ovca extends Surovina {

    /**
     * Konstruktor vyvola konstruktor predka, kde preda informacie o obrazku,
     * ktory sa vykresluje ako reprezentacia tejto suroviny
     */
    public Ovca() {
        super("/OzK_ovcaVelka.jpg", "/OzK_ovcaMala.jpg", "ovca");
        //super("img/OzK_ovcaVelka.jpg", "img/OzK_ovcaMala.jpg", "ovca");
    }

}
