package model;

/**
 * Reprezentuje postavu v místnosti.
 * Postava má jméno a větu, kterou hráči řekne.
 */
public class Postava {

    private final String jmeno;
    private final String rec;

    /**
     * Vytvoří novou postavu.
     *
     * @param jmeno jméno postavy
     * @param rec text, který postava říká hráči
     */
    public Postava(String jmeno, String rec) {
        this.jmeno = jmeno;
        this.rec = rec;
    }

    /** @return jméno postavy */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * Vrátí větu, kterou postava říká hráči.
     *
     * @return text řeči
     */
    public String mluv() {
        return rec;
    }
}
