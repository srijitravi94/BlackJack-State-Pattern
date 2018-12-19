package edu.northeastern.ccs.cs5500.interfaces;

/**
 * An interface Iterator to mimic the functionality of a default iterator
 * @author Srijit
 */
public interface Iterator<T> {

    /**
     * Get the card count
     * @return int : card count
     */
    int getCardCount();

    /**
     * Set to first
     */
    void first();

    /**
     * Advance to next
     */
    void next();

    /**
     * Check if list is fully iterated through
     * @return boolean : true if list if fully iterated through
     */
    boolean isDone();

    /**
     * Get the current object
     * @return T : current object of kind T
     */
    T current();
}


