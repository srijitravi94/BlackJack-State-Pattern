package edu.northeastern.ccs.cs5500.enums;

/**
 * Enumeration declaration for Rank
 * @author Srijit
 */

public enum RankValues {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10),
    ACE(-1);

    private int value;

    RankValues(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }


}
