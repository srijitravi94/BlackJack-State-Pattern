package edu.northeastern.ccs.cs5500.classes;

import edu.northeastern.ccs.cs5500.interfaces.Suit;

/**
 * Class that implements Suit interface to get and set the name and symbol of a suit
 * @author Srijit
 */

public class SuitClass implements Suit {

    private String name;
    private char symbol;

    /**
     * Constructor to set the name and symbol of a suit
     * @param name : name of the suite
     * @param symbol : symbol of the suite
     */
    public SuitClass(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    /**
     * Method to return the name of the suit
     * @return String : suit name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Method to return the symbol of the suit
     * @return Char : symbol (typically first character of the suit name)
     */
    @Override
    public char getSymbol() {
        return symbol;
    }
}
