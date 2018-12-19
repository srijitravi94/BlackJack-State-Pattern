package edu.northeastern.ccs.cs5500.classes;

import edu.northeastern.ccs.cs5500.interfaces.Card;
import edu.northeastern.ccs.cs5500.interfaces.Euchre;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that implements Euchre interface and extends the deck class that consists of methods to play with cards specific to deck type of euchre
 * @author Srijit
 */

public class EuchreDeckClass extends DeckClass implements Euchre {

    private List<Card> euchreDeckCardList = new ArrayList<>();
    private int NUMBER_OF_EUCHRE_DECKS = 1;
    private String EUCHRE = "Euchre";

    /**
     * Constructor to create the euchre card list
     */
    public EuchreDeckClass(){
        createCards(EUCHRE, NUMBER_OF_EUCHRE_DECKS);
        this.euchreDeckCardList = getCardList();
    }

    /**
     * Method to get the Euchre Deck card list
     * @return List : list of cards
     */
    @Override
    public List<Card> getEuchreDeckCardList(){
        return euchreDeckCardList;
    }
}
