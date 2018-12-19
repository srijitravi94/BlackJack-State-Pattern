package edu.northeastern.ccs.cs5500.interfaces;

import java.util.List;

/**
 * An interface Hand with methods to play with cards
 * @author Srijit
 */

public interface Hand {
    /**
     * Show the cards in a hand
     * @return List : a list of cards
     */
    List<Card> showCards();

    /**
     * Accept a given card
     * @param card : A card from the deck
     */
    void accept(Card card);

    /**
     * Get a card from the top of the hand
     * @return Card : card from the hand
     */
    Card pullCard();

    /**
     * Check whether a hand has the given card
     * @param card : a card
     * @return Boolean : true if the given card is in the hand
     */
    Boolean hasCard(Card card);

    /**
     * Check whether a hand has the given rank
     * @param rank : rank of the card
     * @return Boolean : true if the given rank is in the hand
     */
    Boolean hasRank(Rank rank);

    /**
     * Check whether a hand has the given suit
     * @param suit : suit of the card
     * @return Boolean : true if the given suit is in the hand
     */
    Boolean hasSuit(Suit suit);

    /**
     * Sort the cards in a hand
     * @param order : Order by which cards are to be sorted (typically by suit, rank or both)
     */
    void sort(String order);

    /**
     * Method to shuffle the deck of cards
     */
    void shuffle();
}
