package osadnicizkatanu.surovina;


/**
 * Trieda reprezentuje drevo v hra Osadnici z Katanu
 * @author Adam
 */
public class Drevo extends Surovina {
    
    /**
     * Konstruktor vyvola konstruktor predka, kde preda informacie o obrazku,
     * ktory sa vykresluje ako reprezentacia tejto suroviny
     */
    public Drevo() {
        super("/OzK_drevoVelke.jpg", "/OzK_drevoMale.jpg", "drevo");
        //super("img/OzK_drevoVelke.jpg", "img/OzK_drevoMale.jpg", "drevo");
    }

    
}
