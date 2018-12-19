package edu.northeastern.ccs.cs5500.interfaces;

import java.util.List;

/**
 * An interface Standard that extends the deck interface that consists of methods to play around with cards
 * @author Srijit
 */

public interface Standard extends Deck {
    /**
     * Get the standard deck card list
     * @return List : a list of cards
     */
    List<Card> getStandardDeckCardList();
}

