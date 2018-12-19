package edu.northeastern.ccs.cs5500.interfaces;

/**
 * An interface Rank to get name and pips of a card
 * @author Srijit
 */

public interface Rank {
    /**
     * Get the name of the card
     * @return String: name
     */
    String getName();

    /**
     * Get the number of pips of the card
     * @return int: pips
     */
    int getPips();
}
