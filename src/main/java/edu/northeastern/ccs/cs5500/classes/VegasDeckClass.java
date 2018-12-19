package edu.northeastern.ccs.cs5500.classes;

import edu.northeastern.ccs.cs5500.interfaces.Card;
import edu.northeastern.ccs.cs5500.interfaces.Vegas;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that implements the Vegas interface and extends the deck class that consists of methods to play with cards specific to deck type of vegas
 * @author Srijit
 */

public class VegasDeckClass extends DeckClass implements Vegas {

    private List<Card> vegasDeckCardList = new ArrayList<>();
    private String VEGAS = "Vegas";

    /**
     * Constructor to create the vegas deck of cards
     * @param numberOfDecks : number of decks to be created
     */
    public VegasDeckClass(int numberOfDecks){
        createCards(VEGAS, numberOfDecks);
        this.vegasDeckCardList = getCardList();
    }

    /**
     * Method to get the vegas deck card list
     * @return List : a list of cards
     */
    public List<Card> getVegasDeckCardList(){
        return vegasDeckCardList;
    }
}