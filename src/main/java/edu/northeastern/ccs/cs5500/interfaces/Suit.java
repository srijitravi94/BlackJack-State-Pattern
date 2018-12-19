package edu.northeastern.ccs.cs5500.interfaces;

/**
 * An interface suit to get name and symbol of a card
 * @author Srijit
 */

public interface Suit {
    /**
     * Get the suit name of the card
     * @return String : suit name
     */
    String getName();

    /**
     * Get the symbol of the card
     * @return Char : symbol (typically first character of the suit name)
     */
    char getSymbol();
}
