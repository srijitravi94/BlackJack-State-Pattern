package edu.northeastern.ccs.cs5500.classes;

import edu.northeastern.ccs.cs5500.interfaces.Rank;

/**
 * Class that implements Rank interface to get and set the name and pips of a card
 * @author Srijit
 */

public class RankClass implements Rank {
    private String name;
    private int pips;

    /**
     * Constructor to set the name and pips of a card
     * @param name : name of the card
     * @param pips : pips of the card
     */
    public RankClass(String name, int pips){
        this.name = name;
        this.pips = pips;
    }

    /**
     * Method to return name of the card
     * @return String: name of the card
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Method to return number of pips of the card
     * @return int: pips of the card
     */
    @Override
    public int getPips() {
        return pips;
    }
}
