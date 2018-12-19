package edu.northeastern.ccs.cs5500.states;

import edu.northeastern.ccs.cs5500.interfaces.Game;
import edu.northeastern.ccs.cs5500.interfaces.GameState;

/**
 * A class to track the end round state
 * @author Srijit
 */
public class EndRoundState implements GameState {

    private Game game;

    /**
     * A constructor to set the game
     * @param game : A game of blackjack
     */
    public EndRoundState(Game game) {
        this.game = game;
    }

    /**
     * Method to start a game of blackjack
     * @param player : A hand
     */
    @Override
    public void startGame(int player) {
        return;
    }

    /**
     * Method to end the turn
     * @param player : A hand
     */
    @Override
    public void endPlayerTurn(int player) {
        return;
    }

    /**
     * Method to end the round of blackjack game
     * @param player : A hand
     */
    @Override
    public void endRound(int player) {
        game.setCurrentState(game.getEndRoundState(player), player);
    }

    /**
     * Method to display the state
     * @return String : A string denoting the state
     */
    @Override
    public String toString() {
        return "End Round State";
    }
}
