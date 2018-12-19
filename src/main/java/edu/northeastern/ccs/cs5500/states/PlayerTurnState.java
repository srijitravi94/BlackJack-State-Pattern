package edu.northeastern.ccs.cs5500.states;

import edu.northeastern.ccs.cs5500.interfaces.Game;
import edu.northeastern.ccs.cs5500.interfaces.GameState;

/**
 * A class to track the player state
 * @author Srijit
 */
public class PlayerTurnState implements GameState {

    private Game game;

    /**
     * A constructor to set the game
     * @param game : A game of blackjack
     */
    public PlayerTurnState(Game game) {
        this.game = game;
    }

    /**
     * Method to start a game
     * @param player : A hand
     */
    @Override
    public void startGame(int player) {
        return;
    }

    /**
     * Method to end the turn of a player
     * @param player : A hand
     */
    @Override
    public void endPlayerTurn(int player) {
        game.setCurrentState(game.getDealerTurnState(player), player);
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
        return "Player Turn State";
    }
}
