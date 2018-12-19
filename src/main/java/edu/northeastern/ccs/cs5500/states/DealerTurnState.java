package edu.northeastern.ccs.cs5500.states;

import edu.northeastern.ccs.cs5500.interfaces.Game;
import edu.northeastern.ccs.cs5500.interfaces.GameState;

/**
 * A Class to track the state of the Dealer
 * @author Srijit
 */
public class DealerTurnState implements GameState {

    private Game game;

    /**
     * A constructor to set the game for the dealer's state
     * @param game : A game of blackjack
     */
    public DealerTurnState(Game game) {
        this.game = game;
    }

    /**
     * Method to start the game
     * @param player : A hand
     */
    @Override
    public void startGame(int player) {
        return;
    }

    /**
     * Method to end turn
     * @param player : A hand
     */
    @Override
    public void endPlayerTurn(int player) {
        return;
    }

    /**
     * Method to end the blackjack game round
     * @param player : A hand
     */
    @Override
    public void endRound(int player) {
        game.setCurrentState(game.getEndRoundState(player), player);
    }

    /**
     * Method to print the state
     * @return String : A string denoting the state
     */
    @Override
    public String toString() {
        return "Dealer Turn State";
    }
}
