package osadnicizkatanu.surovina;

/**
 * Trieda reprezentuje tehla v hra Osadnici z Katanu
 * @author Adam
 */
public class Tehla extends Surovina {
    
    /**
     * Konstruktor vyvola konstruktor predka, kde preda informacie o obrazku,
     * ktory sa vykresluje ako reprezentacia tejto suroviny
     */
    public Tehla() {
        super("/OzK_tehlaVelka.jpg", "/OzK_tehlaMala.jpg", "tehla");
        //super("img/OzK_tehlaVelka.jpg", "img/OzK_tehlaMala.jpg", "tehla");
    }

}
