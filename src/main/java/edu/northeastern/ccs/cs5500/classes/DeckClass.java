package edu.northeastern.ccs.cs5500.classes;

import edu.northeastern.ccs.cs5500.interfaces.Card;
import edu.northeastern.ccs.cs5500.interfaces.Deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class that implements deck interface with methods to play around with cards.
 * @author Srijit
 */

public class DeckClass implements Deck {

    private List<Card> cardList = new ArrayList<>();
    private int officialSize;

    /**
     * Method to shuffle the deck of cards
     */
    @Override
    public void shuffle() {
        Collections.shuffle(cardList);
    }

    /**
     * Method to sort the deck of cards
     * @param order : Order by which cards are to be sorted (typically by suit, rank or both)
     */
    @Override
    public void sort(String order) {
        SortCards sortCards = new SortCards(cardList);
        cardList = sortCards.sort(order);
    }

    /**
     * Method to cut the deck of cards from the cards and insert at the end of the deck
     * @param cutPoint : the number of cards at which a deck of cards is to be cut
     * @throws IndexOutOfBoundsException : when cut point is greater than card list's size
     */
    @Override
    public void cut(int cutPoint) {
        for(int i=0; i<cutPoint-1; i++) {
            cardList.add(cardList.get(0));
            cardList.remove(0);
        }
    }

    /**
     * Method to get a card from the top of the deck
     * @return Card : a card from the top of the deck
     * @throws IndexOutOfBoundsException : when the card list is empty
     */
    @Override
    public Card pullCard() {
        return cardList.remove(0);
    }

    /**
     * Method to check if the deck of cards is empty.
     * @return Boolean : true if deck is empty
     */
    @Override
    public Boolean emptyDeck() {
        return cardList.isEmpty();
    }

    /**
     * Method to return the official size of the deck
     * @return int : the size of deck
     */
    @Override
    public int officialSize() {
        return officialSize;
    }

    /**
     * Method to set the official size of the card list
     * @param officialSize : official size of the deck
     */
    @Override
    public void setOfficialSize(int officialSize) {
        this.officialSize = officialSize;
    }

    /**
     * Method to return the list of cards
     * @return List : a list of cards
     */
    @Override
    public List<Card> getCardList() {
        return cardList;
    }

    /**
     * Method to set the card list to the given card list
     * @param cardList : list of cards
     */
    @Override
    public void setCardList(List<Card> cardList){
        this.cardList = cardList;
    }

    /**
     * Method to create a deck of cards based on the decktype and number of decks
     * @param deckType : type of deck
     * @param numberOfDecks : number of decks
     */
    @Override
    public void createCards(String deckType, int numberOfDecks) {
        MakeCards makeCards = new MakeCards();
        cardList = makeCards.createCards(deckType, numberOfDecks);
    }

    /**
     * Method to check if a given card is present in the deck
     * @param card : a card
     * @return Boolean : true if the given card is in the deck
     */
    @Override
    public Boolean hasCard(Card card) {
        for(Card card1 : cardList){
            if(checkIfEqual(card1, card)){
                return true;
            }
        }
        return false;
    }

    /**
     * method to check whether two card objects are same
     * @param card1 : card to compare
     * @param card2 : card to compare
     * @return Boolean : true if two cards are same
     */
    @Override
    public Boolean checkIfEqual(Card card1, Card card2) {
        Boolean suitNameCheck = card1.getSuit().getName().equals(card2.getSuit().getName());
        Boolean suitSymbolCheck = card1.getSuit().getSymbol() == card2.getSuit().getSymbol();
        Boolean rankNameCheck = card1.getRank().getName().equals(card2.getRank().getName());
        Boolean rankPipsCheck = card1.getRank().getPips() == card2.getRank().getPips();

        return suitNameCheck && suitSymbolCheck && rankNameCheck && rankPipsCheck;
    }
}
