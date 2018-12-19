package edu.northeastern.ccs.cs5500.interfaces;

import edu.northeastern.ccs.cs5500.classes.DeckClass;

import java.util.List;

/**
 * An interface to initiate a game of cards based on the deck type
 * @author Srijit
 */

public interface Game {
    /**
     * Create a deck of cards based on the deck type.
     * @param deckType : type of deck
     */
    void createDeck(String deckType);

    /**
     * Create a deck of cards based on the deck type and number of decks
     * @param deckType : type of deck
     * @param numberOfDecks : number of decks
     */
    void createDeck(String deckType, int numberOfDecks);

    /**
     * Set the number of hands
     * @param numberOfHands : number of hands
     */
    void setNumberOfHands(int numberOfHands);

    /**
     * Deal the deck of cards
     */
    void deal();

    /**
     * Get the instance of Deck class
     * @return DeckClass : a deck of cards
     */
    DeckClass getDeck();

    /**
     * Get the hands created from the deck
     * @return NewHandClass[] : an array of hands
     */
    List<NewHand> getPlayerHands();

    /**
     * Get the dealer hand
     * @return NewHand : a hand
     */
    NewHand getDealerHand();

    /**
     * Start playing
     */
    void play();

    /**
     * Get the current turn state
     * @param player : index of player
     * @return GameState: current turn state
     */
    GameState getCurrentState(int player);

    /**
     * Set the current state of the game
     * @param currentState : current game state
     * @param player : index of player
     */
    void setCurrentState(GameState currentState, int player);

    /**
     * Get the player turn state
     * @param player : index of player
     * @return GameState: player turn state
     */
    GameState getPlayerTurnState(int player);

    /**
     * Get the dealer turn state
     * @param player : index of player
     * @return GameState: dealer turn state
     */
    GameState getDealerTurnState(int player);

    /**
     * Get the end round turn state
     * @param player : index of player
     * @return GameState: end round turn state
     */
    GameState getEndRoundState(int player);

}
