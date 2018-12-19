package edu.northeastern.ccs.cs5500.interfaces;

/**
 * An interface to define methods for each state
 * @author Srijit
 */
public interface GameState {
    /**
     * Start the game for a given player
     * @param player : A hand
     */
    void startGame(int player);

    /**
     * End the turn for a given player
     * @param player : A hand
     */
    void endPlayerTurn(int player);

    /**
     * End the round/game for a given player
     * @param player : A hand
     */
    void endRound(int player);
}
