package edu.northeastern.ccs.cs5500.classes;

import edu.northeastern.ccs.cs5500.classes.SortCards;
import edu.northeastern.ccs.cs5500.interfaces.Card;
import edu.northeastern.ccs.cs5500.interfaces.Hand;
import edu.northeastern.ccs.cs5500.interfaces.Rank;
import edu.northeastern.ccs.cs5500.interfaces.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A class that implements the hand interface that consists of methods to play with the cards
 * @author Srijit
 */

public class HandClass implements Hand {

    private List<Card> cardList;

    /**
     * An empty constructor
     */
    public HandClass(){
        cardList = new ArrayList<>();
    }

    /**
     * Method to get the cards in hand
     * @return List : a list of cards
     */
    @Override
    public List<Card> showCards() {
        return cardList;
    }

    /**
     * Method to accept a card to the hand
     * @param card : A card from the deck
     */
    @Override
    public void accept(Card card) {
        cardList.add(card);
    }

    /**
     * Method to get a card from the top of the hand
     * @return Card : a card from the top of the hand
     * @throws IndexOutOfBoundsException : when the card list in a hand is empty
     */
    @Override
    public Card pullCard() {
        return cardList.remove(0);
    }


    /**
     * Method to check if a given card is present in the hand
     * @param card : a card
     * @return Boolean : true if the given card is in the hand
     */
    @Override
    public Boolean hasCard(Card card) {
        for(Card card1 : cardList){
            if(checkIfCardsAreEqual(card1, card)){
                return true;
            }
        }
        return false;
    }

    /**
     * Method to check whether a hand has the given rank
     * @param rank : rank of the card
     * @return Boolean : true if the given rank is in the hand
     */
    @Override
    public Boolean hasRank(Rank rank) {
        for(Card card : cardList){
            if(checkIfRanksAreEqual(card.getRank(), rank)){
                return true;
            }
        }
        return false;
    }

    /**
     * Method to check whether a hand has the given suit
     * @param suit : suit of the card
     * @return Boolean : true if the given suit is in the hand
     */
    @Override
    public Boolean hasSuit(Suit suit) {
        for(Card card : cardList){
            if(checkIfSuitsAreEqual(card.getSuit(), suit)){
                return true;
            }
        }
        return false;
    }

    /**
     * Method to sort the cards in the hand based on the given order
     * @param order : Order by which cards are to be sorted (typically by suit, rank or both)
     */
    @Override
    public void sort(String order) {
        SortCards sortCards = new SortCards(cardList);
        cardList = sortCards.sort(order);
    }

    /**
     * Method to shuffle the cards in hand
     */
    @Override
    public void shuffle() {
        Collections.shuffle(cardList);
    }

    /**
     * method to check whether two card are same
     * @param card1 : card to compare
     * @param card2 : card to compare
     * @return Boolean : true if two cards are same
     */
    public boolean checkIfCardsAreEqual(Card card1, Card card2) {
        Boolean suitNameCheck = card1.getSuit().getName().equals(card2.getSuit().getName());
        Boolean suitSymbolCheck = card1.getSuit().getSymbol() == card2.getSuit().getSymbol();
        Boolean rankNameCheck = card1.getRank().getName().equals(card2.getRank().getName());
        Boolean rankPipsCheck = card1.getRank().getPips() == card2.getRank().getPips();

        return suitNameCheck && suitSymbolCheck && rankNameCheck && rankPipsCheck;
    }

    /**
     * method to check whether two ranks are same
     * @param rank1 : rank to compare
     * @param rank2 : rank to compare
     * @return Boolean : true if two ranks are same
     */
    public boolean checkIfRanksAreEqual(Rank rank1, Rank rank2) {
        Boolean rankNameCheck = rank1.getName().equals(rank2.getName());
        Boolean rankPipsCheck = rank1.getPips() == rank2.getPips();

        return rankNameCheck && rankPipsCheck;
    }

    /**
     * method to check whether two suits are same
     * @param suit1 : suit to compare
     * @param suit2 : suit to compare
     * @return Boolean : true if two suits are same
     */
    private boolean checkIfSuitsAreEqual(Suit suit1, Suit suit2) {
        Boolean suitNameCheck = suit1.getName().equals(suit2.getName());
        Boolean suitSymbolCheck = suit1.getSymbol() == suit2.getSymbol();

        return suitNameCheck && suitSymbolCheck;
    }

}
