package edu.northeastern.ccs.cs5500.interfaces;

import java.util.List;

/**
 * An interface Pinochle that extends the Deck interface that consists of methods to play around with cards
 * @author Srijit
 */

public interface Euchre extends Deck {

    /**
     * Get the Euchre Deck card list
     * @return List : list of cards
     */
    List<Card> getEuchreDeckCardList();
}
