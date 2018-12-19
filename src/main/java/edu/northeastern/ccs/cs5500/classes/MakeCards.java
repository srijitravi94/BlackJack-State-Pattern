package edu.northeastern.ccs.cs5500.classes;

import edu.northeastern.ccs.cs5500.enums.RankValues;
import edu.northeastern.ccs.cs5500.enums.SuitValues;
import edu.northeastern.ccs.cs5500.interfaces.Card;
import edu.northeastern.ccs.cs5500.interfaces.Rank;
import edu.northeastern.ccs.cs5500.interfaces.Suit;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that has methods to create cards based on the given type and number of decks
 * @author Srijit
 */

public class MakeCards {

    private int STANDARD_DECK_START = 0;
    private int EUCHRE_DECK_START = 7;
    private int PINOCHLE_DECK_START = 7;
    private int VEGAS_DECK_START = 0;
    private int END = 13;

    private int NUMBER_OF_DECKS_PINOCHLE = 2;

    private List<Card> cardList = new ArrayList<>();

    /**
     * Method to create a deck of cards based on the given deck type and number of decks
     * @param deckType : type of deck
     * @param numberOfDecks : number of decks
     * @return List : List of cards in the deck created
     */
    public List<Card> createCards(String deckType, int numberOfDecks) {
        switch (deckType) {
            case "Standard":
                getCards(STANDARD_DECK_START, END);
                break;

            case "Pinochle":
                for(int i=0; i<NUMBER_OF_DECKS_PINOCHLE; i++) {
                    getCards(PINOCHLE_DECK_START, END);
                }
                break;

            case "Euchre":
                getCards(EUCHRE_DECK_START, END);
                break;

            case "Vegas":
                for(int i=0; i<numberOfDecks; i++) {
                    getCards(VEGAS_DECK_START, END);
                }
                break;

            default:
                break;
        }

        return cardList;
    }

    /**
     * Method to get cards based on the start and end value given
     * @param start : start of the deck based on deck type
     * @param end : end of the deck based on deck type
     * @return List : a list of cards
     */
    private List<Card> getCards(int start, int end) {

        for(SuitValues suitName : SuitValues.values()){
            for(int i=start; i<end; i++) {

                String rankName = RankValues.values()[i].toString();
                int pips = RankValues.valueOf(rankName).getValue();
                Rank rank = new RankClass(rankName, pips);

                String suitname = suitName.toString();
                char symbol = suitname.charAt(0);
                Suit suit = new SuitClass(suitname, symbol);

                Card card = new CardClass(rank, suit);

                cardList.add(card);
            }
        }

        return cardList;
    }
}
