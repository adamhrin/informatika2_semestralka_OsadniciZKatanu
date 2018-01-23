package osadnicizkatanu.hra;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import osadnicizkatanu.platno.HlavneOkno;
import osadnicizkatanu.surovina.Drevo;
import osadnicizkatanu.surovina.Kamen;
import osadnicizkatanu.surovina.Obilie;
import osadnicizkatanu.surovina.Ovca;
import osadnicizkatanu.surovina.Tehla;

/**
 * Trieda reprezentuje hraci panel hraca s pocitadlami surovin, ciest, dedin, miest a pocitadlom bodov
 * @author Adam
 */
public class HracPanel extends JPanel {

    private Hrac hrac;
    private JLabel lblDrevo;
    private JLabel lblTehla;
    private JLabel lblObilie;
    private JLabel lblOvca;
    private JLabel lblKamen;
    private JLabel lblCesty;
    private JLabel lblMesta;
    private JButton btnKupCestu;
    private JButton btnKupDedinu;
    private JButton btnKupMesto;
    private JLabel lblPocetBodov;
    private JLabel lblDediny;
    private HlavneOkno hlavneOkno;
         
    /**
     * Konstruktor, ktory sa vola pri pridani tohto komponentu do hlavneho okna
     */
    public HracPanel() {
    }

    /**
     * Konstruktor, ktory prebera vsetko co je na paneli od hlavneho okna
     * inicializuje komponenty hracieho panelu
     * @param hrac hrac, ktoremu patri hraci panel
     * @param hlavneOkno hlavne okno, na ktorom sa panel zobrazuje
     * @param lblDrevo pocitadlo driev hraca
     * @param lblTehla pocitadlo tehal hraca
     * @param lblObilie pocitadlo obili hraca
     * @param lblOvca pocitadlo oviec hraca
     * @param lblKamen pocitadlo kamenov hraca
     * @param lblCesty pocitadlo ciest hraca
     * @param lblDediny pocitadlo dedin hraca
     * @param lblMesta pocitadlo miest hraca
     * @param btnKupCestu tlacidlo pre kupenie cesty
     * @param btnKupDedinu tlacidlo pre kupenie dediny
     * @param btnKupMesto tlacidlo pre kupenie mesta
     * @param lblPocetBodov pocitadlo bodov hraca
     */
    public HracPanel(Hrac hrac, JFrame hlavneOkno,
            JLabel lblDrevo, JLabel lblTehla, JLabel lblObilie, JLabel lblOvca, JLabel lblKamen, 
            JLabel lblCesty, JLabel lblDediny, JLabel lblMesta, 
            JButton btnKupCestu, JButton btnKupDedinu, JButton btnKupMesto,
            JLabel lblPocetBodov) {
        
        this.hrac = hrac;
        this.hlavneOkno = (HlavneOkno)hlavneOkno;
        
        this.lblDrevo = lblDrevo;
        this.lblTehla = lblTehla;
        this.lblObilie = lblObilie;
        this.lblOvca = lblOvca;
        this.lblKamen = lblKamen;
        this.lblCesty = lblCesty;
        this.lblDediny = lblDediny;
        this.lblMesta = lblMesta;
        this.btnKupCestu = btnKupCestu;
        this.btnKupDedinu = btnKupDedinu;
        this.btnKupMesto = btnKupMesto;
        this.lblPocetBodov = lblPocetBodov;
        
        this.setBorder(BorderFactory.createTitledBorder(this.hrac.getMeno()));
        
        this.aktualizujPocetBodov();
    }

    /**
     * metoda aktualizuje pocet bodov a vypise to na prislusne pocitadlo
     */
    public void aktualizujPocetBodov() {
        this.lblPocetBodov.setText("Pocet bodov: " + this.hrac.getPocetBodov());
    }

    /**
     * metoda aktualizuje pocitadla surovin a vypise ich na prislusne pocitadla
     */
    public void aktualizujPocitadlaSurovin() {
        this.lblDrevo.setText(Integer.toString(this.hrac.getPocetSurovinDanehoDruhu(new Drevo())));
        this.lblTehla.setText(Integer.toString(this.hrac.getPocetSurovinDanehoDruhu(new Tehla())));
        this.lblObilie.setText(Integer.toString(this.hrac.getPocetSurovinDanehoDruhu(new Obilie())));
        this.lblOvca.setText(Integer.toString(this.hrac.getPocetSurovinDanehoDruhu(new Ovca())));
        this.lblKamen.setText(Integer.toString(this.hrac.getPocetSurovinDanehoDruhu(new Kamen())));
    }

    /**
     * metoda aktualizuje pocitadla prislusenstva (ciest, dedin a miest) a vypise ich na prislusne pocitadla
     */
    public void aktualizujPocitadlaPrislusenstva() {
        this.lblCesty.setText(Integer.toString(this.hrac.getPocetCiest()));
        this.lblDediny.setText(Integer.toString(this.hrac.getPocetDedin()));
        this.lblMesta.setText(Integer.toString(this.hrac.getPocetMiest()));
    }

    /**
     * metoda nastavi stlacitelnost tlacidiel na kupovanie ciest, dedin a miest
     * @param stlacitelnost ci maju byt tlacidla stlacitelne
     */
    public void setStlacitelnostKupovacichTlacidiel(boolean stlacitelnost) {
        this.btnKupCestu.setEnabled(stlacitelnost);
        this.btnKupDedinu.setEnabled(stlacitelnost);
        this.btnKupMesto.setEnabled(stlacitelnost);
    }

    /**
     * metoda "zneviditelni" pocitadla surovin hraca
     * vykresli namiesto poctov hviezdicku '*'
     */
    public void zneviditelniPocitadlaSurovin() {
        this.lblDrevo.setText("*");
        this.lblTehla.setText("*");
        this.lblObilie.setText("*");
        this.lblOvca.setText("*");
        this.lblKamen.setText("*");
    }

    /**
     * metoda "zneviditelni" pocitadla prislusenstva hraca (ciest, dedin a miest)
     * vykresli namiesto poctov hviezdicku '*'
     */
    public void zneviditelniPocitadlaPrislusenstva() {
        this.lblCesty.setText("*");
        this.lblDediny.setText("*");
        this.lblMesta.setText("*");
    }

    /**
     * metoda aktivuje tlacidlo pre kupenie cesty
     */
    public void aktivujTlacidloKupCestu() {
        this.btnKupCestu.setEnabled(true);
    }
    
    /**
     * metoda aktivuje tlacidlo pre kupenie dediny
     */
    public void aktivujTlacidloKupDedinu() {
        this.btnKupDedinu.setEnabled(true);
    }
    
    /**
     * metoda pre kupenie cesty, v metode sa overi, ci si hrac moze kupit cestu a vypise mu prislusne spravy
     */
    public void kupCestu() {
        this.setStlacitelnostKupovacichTlacidiel(false);
        
        if (this.hrac.maNaKupenieCesty() && this.hrac.maCestu()) {
            this.hrac.removeCesta();
            this.aktualizujPocitadlaPrislusenstva();
            this.aktualizujPocitadlaSurovin();
            this.hlavneOkno.setPlochaPreCesty(true);
            JOptionPane.showMessageDialog(this.hlavneOkno, "Umiestni cestu na hraciu plochu"); 
        } else if (!this.hrac.maCestu()) {
            JOptionPane.showMessageDialog(this.hlavneOkno, "Nemas cestu");
        } else {
            JOptionPane.showMessageDialog(this.hlavneOkno, "Nemas dostatok surovin");
            this.setStlacitelnostKupovacichTlacidiel(true);
        }
    }

    /**
     * metoda pre kupenie dediny, v metode sa overi, ci si hrac moze kupit dedinu a vypise mu prislusne spravy
     */
    public void kupDedinu() {
        this.setStlacitelnostKupovacichTlacidiel(false);
        
        if (this.hrac.maNaKupenieDediny() && this.hrac.maDedinu()) {
            this.hrac.pripocitajBody(1);
            this.hrac.removeDedina();
            this.aktualizujPocitadlaPrislusenstva();
            this.aktualizujPocitadlaSurovin();
            this.aktualizujPocetBodov();
            this.hlavneOkno.setPlochaPreDediny(true);
            JOptionPane.showMessageDialog(this.hlavneOkno, "Umiestni dedinu na hraciu plochu");
        } else if (!this.hrac.maDedinu()) {
            JOptionPane.showMessageDialog(this.hlavneOkno, "Nemas dedinu");
        } else {
            JOptionPane.showMessageDialog(this.hlavneOkno, "Nemas dostatok surovin");
            this.setStlacitelnostKupovacichTlacidiel(true);
        }
    }

    /**
     * metoda pre kupenie mesta, v metode sa overi, ci si hrac moze kupit mesto a vypise mu prislusne spravy
     */
    public void kupMesto() {
        this.setStlacitelnostKupovacichTlacidiel(false);
        
        if (this.hrac.maNaKupenieMesta() && this.hrac.maMesto() && this.hrac.mozePostavitMesto()) {
            this.hrac.pripocitajBody(2);
            this.hrac.removeMesto();
            this.hrac.pridajDedinu();
            this.aktualizujPocitadlaPrislusenstva();
            this.aktualizujPocitadlaSurovin();
            this.aktualizujPocetBodov();
            this.hlavneOkno.setPlochaPreMesta(true);
            JOptionPane.showMessageDialog(this.hlavneOkno, "Umiestni mesto na hraciu plochu.");  
        } else if (!this.hrac.mozePostavitMesto()) {
            JOptionPane.showMessageDialog(this.hlavneOkno, "Nemôžeš postaviť mesto. Mestom môžeš iba nahradiť dedinu.", "", JOptionPane.ERROR_MESSAGE);
            this.setStlacitelnostKupovacichTlacidiel(true);
        } else if (!this.hrac.maMesto()) {
            JOptionPane.showMessageDialog(this.hlavneOkno, "Nemáš mesto");
        } else {
            JOptionPane.showMessageDialog(this.hlavneOkno, "Nemáš dostatok surovín");
            this.setStlacitelnostKupovacichTlacidiel(true);
        }
    }
}
