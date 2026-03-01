package commands;

import game.Hrac;

/**
 * Základní rozhraní pro všechny příkazy ve hře.
 * Každý příkaz má název a metodu proved().
 */
public interface Prikaz {

    /**
     * @return název příkazu (např. "jdi", "seber")
     */
    String getNazev();

    /**
     * Provede příkaz.
     *
     * @param hrac hráč
     * @param parametry parametry příkazu
     * @return textová odpověď
     */
    String proved(Hrac hrac, String[] parametry);
}
