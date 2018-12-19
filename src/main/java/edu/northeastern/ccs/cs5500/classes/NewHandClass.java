package edu.northeastern.ccs.cs5500.classes;

import edu.northeastern.ccs.cs5500.interfaces.Card;
import edu.northeastern.ccs.cs5500.interfaces.Iterator;
import edu.northeastern.ccs.cs5500.interfaces.NewHand;
import edu.northeastern.ccs.cs5500.interfaces.Rank;

import java.util.List;


/**
 * A Class that extends HandClass and implements interface newHand
 * @author Srijit
 */
public class NewHandClass extends HandClass implements NewHand {

    private int BLACKJACK = 21;

    private int isWinner = 0;
    private int amount = 1;
    private int parent;


    /**
     * Method to get the winning amount
     * @return int : winning amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Method to set the winning amount
     * @param amount : winning amount
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * Method to get the winner status
     * @return int : the winner status
     */
    public int getWinner() {
        return this.isWinner;
    }

    /**
     * Method to set the winner status
     * @param winner : the winner status
     */
    public void setWinner(int winner) {
        isWinner = winner;
    }

    /**
     * Method to get the id of the parent
     * @return int : id of the parent
     */
    public int getParent() {
        return parent;
    }

    /**
     * Method to set the id of the parent
     * @param parent : id of the parent
     */
    public void setParent(int parent) {
        this.parent = parent;
    }

    /**
     * Method to check if a given card is present in the hand using the bespoke iterator
     * @param card : a card
     * @return Boolean : true if the given card is in the hand
     */
    @Override
    public Boolean hasCard(Card card) {
        Iterator<Card> cardIterator = iterator();
        for(cardIterator.first(); !cardIterator.isDone(); cardIterator.next()){
            if(checkIfCardsAreEqual(card, cardIterator.current())){
                return true;
            }
        }
        return false;
    }

    /**
     * Method to find number of occurrences of a particular card in a hand
     * @param cardToFind : a card
     * @return int : number of occurrences of the given card
     */
    @Override
    public int occurrencesInHand(Card cardToFind) {
        int cardOccurrences = 0;
        Iterator<Card> cardIterator = iterator();
        for(cardIterator.first(); !cardIterator.isDone(); cardIterator.next()){
            if(checkIfCardsAreEqual(cardToFind, cardIterator.current())){
                cardOccurrences++;
            }
        }
        return cardOccurrences;
    }

    /**
     * Method to find number of occurrences of a particular rank in a hand
     * @param rankToFind : a rank
     * @return int : number of occurrences of the given rank
     */
    @Override
    public int occurrencesInHand(Rank rankToFind) {
        int rankOccurrences = 0;
        Iterator<Card> cardIterator = iterator();
        for(cardIterator.first(); !cardIterator.isDone(); cardIterator.next()){
            if(checkIfRanksAreEqual(rankToFind, cardIterator.current().getRank())){
                rankOccurrences++;
            }
        }
        return rankOccurrences;
    }

    /**
     * Method to calculate the hand value
     * @return int : value of the hand
     */
    @Override
    public int calculateHandValue() {
        int sum = 0;
        int numberOfAces = 0;
        Iterator<Card> it = iterator();
        for (it.first(); !it.isDone() && it.current().isFaceUp(); it.next()) {
            int pips = it.current().getRank().getPips();
            if (pips == -1) {
                numberOfAces++;
            } else {
                sum += pips;
            }
        }
        for (int i = 0; i < numberOfAces; i++) {
            if (sum + 11 > BLACKJACK) {
                sum ++;
            } else {
                sum += 11;
            }
        }
        return sum;
    }

    /**
     * Method to check if busted
     * @return int : true if hand is busted
     */
    @Override
    public Boolean isBusted(){
        return calculateHandValue() > BLACKJACK;
    }

    /**
     * Method to check if hand is a blackjack
     * @return int : true if hand is a blackjack
     */
    @Override
    public Boolean hasBlackJack(){
        return calculateHandValue() == BLACKJACK;
    }

    /**
     * Method to get a new hand iterator instance
     * @return HandIterator : a hand iterator
     */
    public Iterator<Card> iterator(){
        return new HandIterator(this);
    }

    /**
     * A Class that implements Iterator interface that consists of set of methods to iterate through the hand
     */
    private class HandIterator implements Iterator<Card> {

        private List<Card> cardList;
        private int cardCount;

        /**
         * Constructor to set the card list and initiate the card count
         * @param newHand : hand for which iterator function should be implemented
         */
        HandIterator(NewHandClass newHand) {
            cardList = newHand.showCards();
            cardCount = 0;
        }

        /**
         * Method to get the card count
         * @return int : card count
         */
        @Override
        public int getCardCount() {
            return cardCount;
        }

        /**
         * Method to set to first
         */
        @Override
        public void first() {
            cardCount = 0;
        }

        /**
         * Method to advance to next
         */
        @Override
        public void next() {
            cardCount++;
        }

        /**
         * Method to check if list is fully iterated through
         * @return boolean : true if list if fully iterated through
         */
        @Override
        public boolean isDone() {
            return cardCount == cardList.size();
        }

        /**
         * Get the current object
         * @return Card : card
         */
        @Override
        public Card current() {
            return cardList.get(cardCount);
        }
    }
}
