package edu.northeastern.ccs.cs5500.classes;

import edu.northeastern.ccs.cs5500.interfaces.Card;
import edu.northeastern.ccs.cs5500.interfaces.Pinochle;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that implements the Pinochle interface and extends the deck class that consists of methods to play with cards specific to deck type of pinochle
 * @author Srijit
 */

public class PinochleDeckClass extends DeckClass implements Pinochle {
    private List<Card> pinochleDeckCardList = new ArrayList<>();
    private int NUMBER_OF_PINOCHLE_DECKS = 1;
    private String PINOCHLE = "Pinochle";

    /**
     * Constructor to create the pinochle deck of cards
     */
    public PinochleDeckClass(){
        createCards(PINOCHLE, NUMBER_OF_PINOCHLE_DECKS);
        this.pinochleDeckCardList = getCardList();
    }

    /**
     * Method to get the pinochle deck card list
     * @return List : a list of cards
     */
    public List<Card> getPinochleDeckCardList(){
        return pinochleDeckCardList;
    }
}