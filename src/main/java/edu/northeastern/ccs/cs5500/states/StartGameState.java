package edu.northeastern.ccs.cs5500.states;

import edu.northeastern.ccs.cs5500.interfaces.Game;
import edu.northeastern.ccs.cs5500.interfaces.GameState;

/**
 * A class to track the start state
 * @author Srijit
 */
public class StartGameState implements GameState {

    private Game game;

    /**
     * A constructor to set the game
     * @param game
     */
    public StartGameState(Game game) {
        this.game = game;
    }

    /**
     * Method to start a game of blackjack
     * @param player : A hand
     */
    @Override
    public void startGame(int player) {
        game.setCurrentState(game.getPlayerTurnState(player), player);
    }

    /**
     * Method to end the turn of a player
     * @param player : A hand
     */
    @Override
    public void endPlayerTurn(int player) {
        return;
    }

    /**
     * Method to end a round of the blackjack game
     * @param player : A hand
     */
    @Override
    public void endRound(int player) {
        return;
    }

    /**
     * Method to display the state
     * @return String : A string denoting the state
     */
    @Override
    public String toString() {
        return "Start Game State";
    }
}
