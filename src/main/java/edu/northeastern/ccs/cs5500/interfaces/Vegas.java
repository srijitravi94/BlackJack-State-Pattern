package edu.northeastern.ccs.cs5500.interfaces;

import java.util.List;

/**
 * An interface Vegas that extends the Deck interface that consists of methods to play with cards
 * @author Srijit
 */
public interface Vegas extends Deck {
    /**
     * Get the vegas deck card list
     * @return List : a list of cards
     */
    List<Card> getVegasDeckCardList();
}
