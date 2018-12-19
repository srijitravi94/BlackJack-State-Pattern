package edu.northeastern.ccs.cs5500.interfaces;

import java.util.List;

/**
 * An interface Pinochle that extends the Deck interface that consists of methods to play around with cards
 * @author Srijit
 */

public interface Pinochle extends Deck {
    /**
     * Get the pinochle deck card list
     * @return List : a list of cards
     */
    List<Card> getPinochleDeckCardList();
}
