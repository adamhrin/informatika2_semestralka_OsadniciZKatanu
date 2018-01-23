package osadnicizkatanu.surovina;

/**
 * Trieda reprezentuje obilie v hra Osadnici z Katanu
 * @author Adam
 */
public class Obilie extends Surovina {

    /**
     * Konstruktor vyvola konstruktor predka, kde preda informacie o obrazku,
     * ktory sa vykresluje ako reprezentacia tejto suroviny
     */
    public Obilie() {
        super("/OzK_obilieVelke.jpg", "/OzK_obilieMale.jpg", "obilie");
        //super("img/OzK_obilieVelke.jpg", "img/OzK_obilieMale.jpg", "obilie");
    }
    
}
