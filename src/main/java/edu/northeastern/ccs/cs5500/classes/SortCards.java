package edu.northeastern.ccs.cs5500.classes;

import edu.northeastern.ccs.cs5500.enums.RankValues;
import edu.northeastern.ccs.cs5500.enums.SuitValues;
import edu.northeastern.ccs.cs5500.interfaces.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Class with methods to sort cards based on the given order (typically - by suit, rank or both)
 * @author Srijit
 */

public class SortCards {

    private List<Card> cardList = new ArrayList<>();
    private SuitComparator suitComparator = new SuitComparator();
    private RankComparator rankComparator = new RankComparator();
    private RankAndSuitComparator rankAndSuitComparator = new RankAndSuitComparator();

    /**
     * Constructor to set the deck of cards to card list
     * @param cardList : a list of cards
     */
    SortCards(List<Card> cardList){
        this.cardList = cardList;
    }

    /**
     * Method that calls corresponding sort functions based on the given order
     * @param order : order by which the deck of cards has to be sorted.
     * @return List : a list of cards sorted based on given order
     */
    public List<Card> sort(String order) {
        switch (order) {
            case "bySuit":
                sortBySuits();
                break;

            case "byRank":
                sortByRank();
                break;

            case "both":
                sortByBoth();
                break;

            default:
                break;
        }
        return cardList;
    }

    /**
     * Method to compare two cards based on rank or suit
     * @param card1Name : Name of card 1
     * @param card2Name : Name of card 2
     * @param order : order by which the deck of cards has to be sorted
     * @return int : comparator value
     */
    private int compareValues(String card1Name, String card2Name, String order){
        List<String> compare = new ArrayList<>();

        if(order.equals("Rank")){
            for (RankValues rank : RankValues.values()){
                compare.add(rank.toString());
            }
        }
        else if(order.equals("Suit")) {
            for (SuitValues suit : SuitValues.values()){
                compare.add(suit.toString());
            }
        }

        if (compare.indexOf(card1Name) > compare.indexOf(card2Name)){
            return 1;
        }
        else if (compare.indexOf(card1Name) < compare.indexOf(card2Name)){
            return -1;
        }
        else {
            return 0;
        }
    }

    /**
     * Method to sort the deck of cards by suit
     */
    private void sortBySuits() {
        Collections.sort(cardList, suitComparator);
    }

    /**
     * A comparator class that implements comparator interface for sort by suit
     */
    private class SuitComparator implements Comparator<Card> {

        /**
         * Method to compare two cards based on suit
         * @param card1 : Card to be compared
         * @param card2 : Card to be compared
         * @return comparator value
         */
        @Override
        public int compare(Card card1, Card card2) {
            return compareValues(card1.getSuit().getName(), card2.getSuit().getName(), "Suit");
        }
    }

    /**
     * Method to sort the deck of cards by rank
     */
    private void sortByRank() {
        Collections.sort(cardList, rankComparator);
    }

    /**
     * A comparator class that implements comparator interface for sort by rank
     */
    private class RankComparator implements Comparator<Card> {

        /**
         * Method to compare two cards based on rank
         * @param card1 : Card to be compared
         * @param card2 : Card to be compared
         * @return comparator value
         */
        @Override
        public int compare(Card card1, Card card2) {
            return compareValues(card1.getRank().getName(), card2.getRank().getName(), "Rank");
        }
    }

    /**
     * Method to sort the deck of cards by both Rank and Suit
     */
    private void sortByBoth() {
        Collections.sort(cardList, rankAndSuitComparator);
    }

    /**
     * A comparator class that implements comparator interface for sort by rank and suit
     */
    private class RankAndSuitComparator implements Comparator<Card> {

        /**
         * Method to compare two cards based on rank and suit
         * @param card1 : Card to be compared
         * @param card2 : Card to be compared
         * @return comparator value
         */
        @Override
        public int compare(Card card1, Card card2) {
            if(card1.getRank().getName().equals(card2.getRank().getName())) {
                return compareValues(card1.getSuit().getName(), card2.getSuit().getName(), "Suit");
            }
            return compareValues(card1.getRank().getName(), card2.getRank().getName(), "Rank");
        }
    }
}
