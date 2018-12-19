package edu.northeastern.ccs.cs5500;

import edu.northeastern.ccs.cs5500.classes.GameClass;
import edu.northeastern.ccs.cs5500.classes.*;
import edu.northeastern.ccs.cs5500.interfaces.Game;
import edu.northeastern.ccs.cs5500.interfaces.NewHand;
import org.junit.Test;

import java.util.List;
import static org.junit.Assert.*;

/**
 * Class that consists of unit tests to test the state interfaces and classes
 * @author Srijit
 */
public class StateTests {

    private int NUMBER_OF_HANDS = 5;
    private String VEGAS = "Vegas";
    private String START_GAME_STATE = "Start Game State";
    private String PLAYER_TURN_STATE = "Player Turn State";
    private String DEALER_TURN_STATE = "Dealer Turn State";
    private String END_ROUND_STATE = "End Round State";

    /**
     * Check whether all the players have the start state
     */
    @Test
    public void testStartStateForPlayersBeforePlaying() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);
        game.createDeck(VEGAS);
        game.setNumberOfHands(NUMBER_OF_HANDS);
        game.deal();
        List<NewHand> players = game.getPlayerHands();

        for(int i=0; i<players.size(); i++) {
            assertTrue(game.getCurrentState(i).toString().equals(START_GAME_STATE));
        }
    }

    /**
     * Check whether all the players have the player turn state after the game is started to play
     */
    @Test
    public void testStartGameStateToPlayerTurnState() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);
        game.createDeck(VEGAS);
        game.setNumberOfHands(NUMBER_OF_HANDS);
        game.deal();

        List<NewHand> players = game.getPlayerHands();

        for(int i=0; i<players.size(); i++) {
            game.getCurrentState(i).startGame(i);
            assertTrue(game.getCurrentState(i).equals(game.getPlayerTurnState(i)));
            assertTrue(game.getCurrentState(i).toString().equals(PLAYER_TURN_STATE));
        }
    }

    /**
     * Check whether all the players have the start turn state after calling the end round
     * since the transition must be start -> player turn -> end
     */
    @Test
    public void testStartGameStateToEndRoundState() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);
        game.createDeck(VEGAS);
        game.setNumberOfHands(NUMBER_OF_HANDS);
        game.deal();

        List<NewHand> players = game.getPlayerHands();

        for(int i=0; i<players.size(); i++) {
            game.getCurrentState(i).endRound(i);
            assertTrue(game.getCurrentState(i).toString().equals(START_GAME_STATE));
        }
    }

    /**
     * Check whether all the players have the start turn state after calling the end player turn
     * since the transition must be start -> player turn -> end
     */
    @Test
    public void testStartGameStateToEndPlayerTurnState() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);
        game.createDeck(VEGAS);
        game.setNumberOfHands(NUMBER_OF_HANDS);
        game.deal();

        List<NewHand> players = game.getPlayerHands();

        for(int i=0; i<players.size(); i++) {
            game.getCurrentState(i).endPlayerTurn(i);
            assertTrue(game.getCurrentState(i).toString().equals(START_GAME_STATE));
        }
    }

    /**
     * Check whether all the players have the dealer turn state after the game starts
     * and whether it is changed from player turn state
     */
    @Test
    public void testPlayerTurnStateToDealerTurnState() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);
        game.createDeck(VEGAS);
        game.setNumberOfHands(NUMBER_OF_HANDS);
        game.deal();

        List<NewHand> players = game.getPlayerHands();

        for(int i=0; i<players.size(); i++) {
            game.getCurrentState(i).startGame(i);
            game.getCurrentState(i).endPlayerTurn(i);
            assertTrue(game.getCurrentState(i).equals(game.getDealerTurnState(i)));
            assertTrue(game.getCurrentState(i).toString().equals(DEALER_TURN_STATE));
        }
    }

    /**
     * Check whether all the players have the end round state after the game starts
     * and whether it is changed from player turn state
     */
    @Test
    public void testPlayerTurnStateToEndRoundState() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);
        game.createDeck(VEGAS);
        game.setNumberOfHands(NUMBER_OF_HANDS);
        game.deal();

        List<NewHand> players = game.getPlayerHands();

        for(int i=0; i<players.size(); i++) {
            game.getCurrentState(i).startGame(i);
            game.getCurrentState(i).endRound(i);
            assertTrue(game.getCurrentState(i).equals(game.getEndRoundState(i)));
            assertTrue(game.getCurrentState(i).toString().equals(END_ROUND_STATE));
        }
    }

    /**
     * Check whether all the players are still in end round state after the game starts
     * and whether it is not changed to start game state
     */
    @Test
    public void testPlayerTurnStateToStartRoundState() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);
        game.createDeck(VEGAS);
        game.setNumberOfHands(NUMBER_OF_HANDS);
        game.deal();

        List<NewHand> players = game.getPlayerHands();

        for(int i=0; i<players.size(); i++) {
            game.getCurrentState(i).startGame(i);
            game.getCurrentState(i).startGame(i);
            assertTrue(game.getCurrentState(i).equals(game.getPlayerTurnState(i)));
            assertTrue(game.getCurrentState(i).toString().equals(PLAYER_TURN_STATE));
        }
    }

    /**
     * Check whether all the players are in end round state after the game ends
     */
    @Test
    public void testEndRoundState() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);
        game.createDeck(VEGAS);
        game.setNumberOfHands(NUMBER_OF_HANDS);
        game.deal();

        List<NewHand> players = game.getPlayerHands();

        for(int i=0; i<players.size(); i++) {
            game.getCurrentState(i).startGame(i);
            game.getCurrentState(i).endRound(i);
            assertTrue(game.getCurrentState(i).equals(game.getEndRoundState(i)));
            assertTrue(game.getCurrentState(i).toString().equals(END_ROUND_STATE));
        }
    }

    /**
     * Check whether all the players are in end round state after the game calls the start state from end state
     */
    @Test
    public void testEndRoundStateToStartState() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);
        game.createDeck(VEGAS);
        game.setNumberOfHands(NUMBER_OF_HANDS);
        game.deal();

        List<NewHand> players = game.getPlayerHands();

        for(int i=0; i<players.size(); i++) {
            game.getCurrentState(i).startGame(i);
            game.getCurrentState(i).endRound(i);
            game.getCurrentState(i).startGame(i);
            assertTrue(game.getCurrentState(i).equals(game.getEndRoundState(i)));
            assertTrue(game.getCurrentState(i).toString().equals(END_ROUND_STATE));
        }
    }

    /**
     * Check whether all the players are in end round state after the game calls
     * the end player turn state from end round state
     */
    @Test
    public void testEndRoundStateToEndPlayerTurnState() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);
        game.createDeck(VEGAS);
        game.setNumberOfHands(NUMBER_OF_HANDS);
        game.deal();

        List<NewHand> players = game.getPlayerHands();

        for(int i=0; i<players.size(); i++) {
            game.getCurrentState(i).startGame(i);
            game.getCurrentState(i).endRound(i);
            game.getCurrentState(i).endPlayerTurn(i);
            assertTrue(game.getCurrentState(i).equals(game.getEndRoundState(i)));
            assertTrue(game.getCurrentState(i).toString().equals(END_ROUND_STATE));
        }
    }

    /**
     * Check whether all the players are in end round state after the game calls
     * the end player turn state from end round state
     */
    @Test
    public void testEndRoundStateToEndRoundState() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);
        game.createDeck(VEGAS);
        game.setNumberOfHands(NUMBER_OF_HANDS);
        game.deal();

        List<NewHand> players = game.getPlayerHands();

        for(int i=0; i<players.size(); i++) {
            game.getCurrentState(i).startGame(i);
            game.getCurrentState(i).endRound(i);
            game.getCurrentState(i).endRound(i);
            assertTrue(game.getCurrentState(i).equals(game.getEndRoundState(i)));
            assertTrue(game.getCurrentState(i).toString().equals(END_ROUND_STATE));
        }
    }

    /**
     * Check whether all the players are in dealer turn state
     */
    @Test
    public void testDealerState() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);
        game.createDeck(VEGAS);
        game.setNumberOfHands(NUMBER_OF_HANDS);
        game.deal();

        List<NewHand> players = game.getPlayerHands();

        for(int i=0; i<players.size(); i++) {
            game.getCurrentState(i).startGame(i);
            game.getCurrentState(i).endPlayerTurn(i);
            assertTrue(game.getCurrentState(i).equals(game.getDealerTurnState(i)));
            assertTrue(game.getCurrentState(i).toString().equals(DEALER_TURN_STATE));
        }
    }

    /**
     * Check whether all the players are in dealer turn state after calling the start state from dealer state
     */
    @Test
    public void testDealerStateToStartState() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);
        game.createDeck(VEGAS);
        game.setNumberOfHands(NUMBER_OF_HANDS);
        game.deal();

        List<NewHand> players = game.getPlayerHands();

        for(int i=0; i<players.size(); i++) {
            game.getCurrentState(i).startGame(i);
            game.getCurrentState(i).endPlayerTurn(i);
            game.getCurrentState(i).startGame(i);
            assertTrue(game.getCurrentState(i).equals(game.getDealerTurnState(i)));
            assertTrue(game.getCurrentState(i).toString().equals(DEALER_TURN_STATE));
        }
    }

    /**
     * Check whether all the players are in dealer turn state after calling the end state from dealer state
     */
    @Test
    public void testDealerStateToEndPlayerState() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);
        game.createDeck(VEGAS);
        game.setNumberOfHands(NUMBER_OF_HANDS);
        game.deal();

        List<NewHand> players = game.getPlayerHands();

        for(int i=0; i<players.size(); i++) {
            game.getCurrentState(i).startGame(i);
            game.getCurrentState(i).endPlayerTurn(i);
            game.getCurrentState(i).endPlayerTurn(i);
            assertTrue(game.getCurrentState(i).equals(game.getDealerTurnState(i)));
            assertTrue(game.getCurrentState(i).toString().equals(DEALER_TURN_STATE));
        }
    }

    /**
     * Check whether all the players are in end round state after calling the end state from dealer state
     */
    @Test
    public void testDealerStateToEndRoundState() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);
        game.createDeck(VEGAS);
        game.setNumberOfHands(NUMBER_OF_HANDS);
        game.deal();

        List<NewHand> players = game.getPlayerHands();

        for(int i=0; i<players.size(); i++) {
            game.getCurrentState(i).startGame(i);
            game.getCurrentState(i).endPlayerTurn(i);
            game.getCurrentState(i).endRound(i);
            assertTrue(game.getCurrentState(i).equals(game.getEndRoundState(i)));
            assertTrue(game.getCurrentState(i).toString().equals(END_ROUND_STATE));
        }
    }

    /**
     * Check whether all the players are in end round state after calling the end state from dealer state
     */
    @Test
    public void testPlayerStateForEndRoundState() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);
        game.createDeck(VEGAS);
        game.setNumberOfHands(NUMBER_OF_HANDS);
        game.deal();

        List<NewHand> players = game.getPlayerHands();

        for(int i=0; i<players.size(); i++) {
            game.getCurrentState(i).startGame(i);
            game.getCurrentState(i).endPlayerTurn(i);
            game.getCurrentState(i).endRound(i);
            assertTrue(game.getCurrentState(i).equals(game.getEndRoundState(i)));
            assertTrue(game.getCurrentState(i).toString().equals(END_ROUND_STATE));
        }
    }
}
