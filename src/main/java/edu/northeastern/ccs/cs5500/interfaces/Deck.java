package edu.northeastern.ccs.cs5500.interfaces;

import java.util.List;

/**
 * An interface deck consisting of methods to play around with cards.
 * @author Srijit
 */

public interface Deck {

    /**
     * Shuffle a deck of cards
     */
    void shuffle();

    /**
     * Sort a deck of cards based on order (suit, rank or both)
     * @param order : Order by which cards are to be sorted (typically by suit, rank or both)
     */
    void sort(String order);

    /**
     * Cut a deck of cards after the specified number of cards
     * @param cutPoint : the number of cards at which a deck of cards is to be cut.
     */
    void cut(int cutPoint);

    /**
     * Get card from the top of the deck.
     * @return Card: a card object from top of the deck
     */
    Card pullCard();

    /**
     * Checks if the deck is empty or not
     * @return Boolean : deck is empty or not
     */
    Boolean emptyDeck();

    /**
     * Get the official number of cards in a deck
     * @return int: official size of a deck
     */
    int officialSize();

    /**
     * Set the official number of cards in a deck
     * @param officialSize : official size of the deck
     */
    void setOfficialSize(int officialSize);

    /**
     * Get the list of cards
     * @return List : a list of cards
     */
    List<Card> getCardList();

    /**
     * Set the card list to the given card list
     * @param cardList : list of cards
     */
    void setCardList(List<Card> cardList);

    /**
     * Create a deck of cards based on the decktype and number of decks
     * @param deckType : type of deck
     * @param numberOfDecks : number of decks
     */
    void createCards(String deckType, int numberOfDecks);

    /**
     * Check if a given card is present in the deck
     * @param card : a card
     * @return Boolean : true if the given card is in the deck
     */
    Boolean hasCard(Card card);

    /**
     * Check whether two card objects are same
     * @param card1 : card to compare
     * @param card2 : card to compare
     * @return Boolean : true if two cards are same
     */
     Boolean checkIfEqual(Card card1, Card card2);
}
