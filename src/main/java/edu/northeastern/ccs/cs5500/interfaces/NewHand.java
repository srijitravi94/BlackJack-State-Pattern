package edu.northeastern.ccs.cs5500.interfaces;

/**
 * An interface NewHand that extends the Hand interface and consists of additional methods that uses the iterator interface
 * @author Srijit
 */
public interface NewHand extends Hand {

    /**
     * Check whether a hand has the given card
     * @param card : a card
     * @return Boolean : true if the given card is in the hand
     */
    @Override
    Boolean hasCard(Card card);

    /**
     * Find number of occurrences of a particular card in a hand
     * @param cardToFind : a card
     * @return int : number of occurrences of the given card
     */
    int occurrencesInHand(Card cardToFind);

    /**
     * Find number of occurrences of a particular rank in a hand
     * @param rankToFind : a rank
     * @return int : number of occurrences of the given rank
     */
    int occurrencesInHand(Rank rankToFind);

    /**
     * Get the sum of values of all the cards in hand
     * @return int : hand value
     */
    int calculateHandValue();

    /**
     * Check if hand is busted
     * @return Boolean : true if busted
     */
    Boolean isBusted();

    /**
     * Check if a hand is a blackjack
     * @return Boolean : true if blackjack
     */
    Boolean hasBlackJack();

    /**
     * Get the winner status
     * @return int : the winner status
     */
    int getWinner();

    /**
     * Set the the winner status
     * @param winner : the winner status
     */
    void setWinner(int winner);

    /**
     * Get the id of the parent
     * @return int : id of the parent
     */
    int getParent();

    /**
     * Set the id of the parent
     * @param parent : id of the parent
     */
    void setParent(int parent);

    /**
     * Get the winning amount
     * @return int : winning amount
     */
    int getAmount();

    /**
     * Set the winning amount
     * @param amount : winning amount
     */
    void setAmount(int amount);
}
