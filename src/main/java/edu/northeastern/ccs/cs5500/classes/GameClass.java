package edu.northeastern.ccs.cs5500.classes;

import edu.northeastern.ccs.cs5500.interfaces.*;
import edu.northeastern.ccs.cs5500.states.DealerTurnState;
import edu.northeastern.ccs.cs5500.states.EndRoundState;
import edu.northeastern.ccs.cs5500.states.PlayerTurnState;
import edu.northeastern.ccs.cs5500.states.StartGameState;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that implements the Game interface and start playing the card game based on the deck type
 * @author Srijit
 */

public class GameClass implements Game {

    private int NUMBER_OF_CARDS_PER_HAND = 2;
    private int DEFAULT_NUMBER_OF_DECKS = 1;
    private int DEFAULT_NUMBER_OF_DECKS_VEGAS = 6;
    private String PINOCHLE_DECK = "Pinochle";
    private String STANDARD_DECK = "Standard";
    private String EUCHRE_DECK = "Euchre";
    private String VEGAS_DECK = "Vegas";
    private String ACE_CARD = "ACE";
    private int DEALER_LIMIT = 17;

    private int numberOfHands = -1;
    private List<Card> cardList;

    private DeckClass deck;
    private GameFactory gameFactory;

    private GameState startGameState;
    private List<GameState> playerTurnStates;
    private List<GameState> dealerTurnState;
    private List<GameState> endRoundState;
    private List<GameState> currentState;

    private List<NewHand> players;
    private NewHand dealer;

    /**
     * Constructor to set game factory
     * @param gameFactory : an object of GameFactory
     */
    public GameClass(GameFactory gameFactory){
        this.gameFactory = gameFactory;
        cardList = new ArrayList<>();
        deck = new DeckClass();

        this.startGameState = new StartGameState(this);
        this.playerTurnStates = new ArrayList<>();
        this.endRoundState = new ArrayList<>();
        this.currentState = new ArrayList<>();
        this.dealerTurnState = new ArrayList<>();
    }

    /**
     * Method to get the current turn state
     * @param player : index of player
     * @return GameState: current turn state
     */
    @Override
    public GameState getCurrentState(int player) {
        return currentState.get(player);
    }

    /**
     * Method to set the current state of the game
     * @param currentState : current game state
     * @param player : index of player
     */
    @Override
    public void setCurrentState(GameState currentState, int player) {
        this.currentState.set(player, currentState);
    }

    /**
     * Method to get the player turn state
     * @param player : index of player
     * @return GameState: player turn state
     */
    @Override
    public GameState getPlayerTurnState(int player) {
        return playerTurnStates.get(player);
    }

    /**
     * Method to get the dealer turn state
     * @param player : index of player
     * @return GameState: dealer turn state
     */
    @Override
    public GameState getDealerTurnState(int player) {
        return dealerTurnState.get(player);
    }

    /**
     * Method to get the end round turn state
     * @param player : index of player
     * @return GameState: end round turn state
     */
    @Override
    public GameState getEndRoundState(int player) {
        return endRoundState.get(player);
    }

    /**
     * Method to create deck
     * @param deckType : type of deck
     */
    @Override
    public void createDeck(String deckType) {
        if(deckType.equals(VEGAS_DECK)) {
            createGame(deckType, DEFAULT_NUMBER_OF_DECKS_VEGAS);
        } else {
            createGame(deckType, DEFAULT_NUMBER_OF_DECKS);
        }
    }

    /**
     * Method to create deck with the number of decks given.
     * @param deckType : type of deck
     * @param numberOfDecks : number of decks
     */
    @Override
    public void createDeck(String deckType, int numberOfDecks) {
        createGame(deckType, numberOfDecks);
    }

    /**
     * Method to set the number of hands
     * @param numberOfHands : number of hands
     */
    @Override
    public void setNumberOfHands(int numberOfHands) {
        if(numberOfHands <= deck.getCardList().size()) {
            this.numberOfHands = numberOfHands;
            players = gameFactory.makeHands(numberOfHands);
            dealer = new NewHandClass();
            initializeStates();
        }
    }

    /**
     * Method to deal the deck of cards
     */
    @Override
    public void deal() {
        if (numberOfHands != -1) {
            for (int i = 0; i < NUMBER_OF_CARDS_PER_HAND; i++) {
                for (int j = 0; j < numberOfHands + 1; j++) {
                    if (i == 0 && j == 0) {
                        dealToDealer(true);
                    } else if (i == 1 && j == 0) {
                        dealToDealer(false);
                    } else {
                        dealToPlayer(players.get(j - 1));
                    }
                }
            }
        }
    }

    /**
     * Method to return the instance of Deck class
     * @return DeckClass : a deck of cards
     */
    @Override
    public DeckClass getDeck() {
        return deck;
    }

    /**
     * Method to get the hands created from the deck
     * @return NewHandClass[] : an array of hands
     */
    @Override
    public List<NewHand> getPlayerHands(){
        return players;
    }

    /**
     * Method to get the dealer hand
     * @return NewHand : a dealer hand
     */
    @Override
    public NewHand getDealerHand(){
        return dealer;
    }

    /**
     * Method to start playing
     */
    @Override
    public void play() {
        playBlackJack();
        evaluateDealerSituation();
        evaluateWinnersInGame();
        setPlayerWinnings();
        reset();
    }

    /**
     * Method to create a game of given deck type and number of decks using game factory
     * @param deckType : type of deck
     * @param numberOfDecks : number of decks
     */
    private void createGame(String deckType, int numberOfDecks){
        switch (deckType){
            case "Standard":
                Standard standardDeck = gameFactory.makeStandardDeck();
                cardList = standardDeck.getStandardDeckCardList();
                break;

            case "Pinochle":
                PinochleDeckClass pinochleDeck = gameFactory.makePinochleDeck();
                cardList = pinochleDeck.getPinochleDeckCardList();
                break;

            case "Euchre":
                EuchreDeckClass euchreDeck = gameFactory.makeEuchreDeck();
                cardList = euchreDeck.getEuchreDeckCardList();
                break;

            case "Vegas":
                VegasDeckClass vegasDeck = gameFactory.makeVegasDeck(numberOfDecks);
                cardList = vegasDeck.getVegasDeckCardList();
                break;

            default:
                break;
        }

        deck.setCardList(cardList);
        deck.setOfficialSize(cardList.size());
    }

    /**
     * Method to initialize all the states
     */
    private void initializeStates(){
        for(int i=0; i<this.numberOfHands; i++){
            this.playerTurnStates.add(i, new PlayerTurnState(this));
            this.endRoundState.add(i, new EndRoundState(this));
            this.dealerTurnState.add(i, new DealerTurnState(this));
            this.currentState.add(i, startGameState);
        }
    }

    /**
     * Method to draw a card and give to dealer
     * @param isCardUp : true if we want the card to face up
     */
    public void dealToDealer(Boolean isCardUp) {
        Card card = cardList.get(0);
        if(!isCardUp) {
            card.setCardFaceDown();
        }
        dealer.accept(card);
        cardList.remove(0);
    }

    /**
     * Method to draw a card and give to the given player
     * @param player : the hand of the player
     */
    public void dealToPlayer(NewHand player) {
        player.accept(cardList.get(0));
        cardList.remove(0);
    }


    /**
     * Method to play the game of blackjack for each player
     */
    public void playBlackJack(){
        for(int i=0; i<players.size(); i++) {
            NewHand player = players.get(i);
            currentState.get(i).startGame(i);

            while (!currentState.get(i).equals(getEndRoundState(i)) &&
                    !currentState.get(i).equals(getDealerTurnState(i))) {
                if (currentState.get(i).equals(getPlayerTurnState(i))) {
                    if (player.isBusted() || player.hasBlackJack()) {
                        getCurrentState(i).endRound(i);
                    } else {
                        makeDecision(player, i);
                    }
                }
            }
        }
    }

    /**
     * Method to make decision
     * @param player : hand of the player
     * @param playerID : id of the player
     */
    public void makeDecision(NewHand player, int playerID){
        if(shouldSplit(player, dealer)){
            splitCards(player, playerID);
        }
        else if(shouldSurrender(player, dealer)) {
            getCurrentState(playerID).endRound(playerID);
        }
        else if(shouldStand(player, dealer)){
            getCurrentState(playerID).endPlayerTurn(playerID);
        }
        else if(shouldHit(player, dealer)){
            dealToPlayer(player);
        }
    }

    /**
     * Method to split the cards of a player into two separate hands and add to the players list
     * @param player : hand of a player
     * @param parent : parent of the player
     */
    private void splitCards(NewHand player, int parent){
        Card card = player.showCards().get(0);

        player.pullCard();
        dealToPlayer(player);

        NewHand playersSplit = new NewHandClass();
        playersSplit.setParent(parent);
        playersSplit.accept(card);
        dealToPlayer(playersSplit);

        players.add(parent+1, playersSplit);

        this.playerTurnStates.add(parent+1, new PlayerTurnState(this));
        this.endRoundState.add(parent+1, new EndRoundState(this));
        this.dealerTurnState.add(parent+1, new DealerTurnState(this));
        this.currentState.add(parent+1, getPlayerTurnState(parent+1));
    }

    /**
     * Method to check if dealer should end hand
     * @return Boolean : true if conditions for dealer to end the round are satisfied
     */
    public Boolean checkIfDealerShouldEndHand() {
        return dealer.hasBlackJack() || dealer.isBusted() || (dealer.calculateHandValue() >= DEALER_LIMIT && !dealer.isBusted());
    }

    /**
     * Method to check if a hand has the card "ACE"
     * @param hand : hand of a player
     * @return Boolean : true if a hand has the card "ACE"
     */
    private Boolean hasAce(NewHand hand){
        Rank rank = new RankClass(ACE_CARD, -1);
        return hand.occurrencesInHand(rank) > 0;
    }

    /**
     * Method to check if the conditions are satisfied for the decision to split
     * @param player : hand of a player
     * @param dealer : hand of the dealer
     * @return Boolean : true if conditions are satisfied
     */
    public Boolean shouldSplit(NewHand player, NewHand dealer) {
        int dealerHandSum = dealer.calculateHandValue();

        if(player.showCards().size() == 2) {
            if (player.occurrencesInHand(new RankClass("ACE", -1)) == 2) {
                return true;
            }
            else if (player.occurrencesInHand(new RankClass("NINE", 9)) == 2 &&
                    ((dealerHandSum >= 2 && dealerHandSum <= 6) || (dealerHandSum >= 8 && dealerHandSum <= 9))) {
                return true;
            }
            else if (player.occurrencesInHand(new RankClass("EIGHT", 8)) == 2) {
                return true;
            }
            else if(player.occurrencesInHand(new RankClass("SEVEN", 7)) == 2 &&
                    (dealerHandSum >= 2 && dealerHandSum <= 7)) {
                return true;
            }
            else if(player.occurrencesInHand(new RankClass("SIX", 6)) == 2 &&
                    (dealerHandSum >= 2 && dealerHandSum <= 6)) {
                return true;
            }
            else if(player.occurrencesInHand(new RankClass("FOUR", 4)) == 2 &&
                    (dealerHandSum >= 5 && dealerHandSum <= 6)) {
                return true;
            }
            else if((player.occurrencesInHand(new RankClass("THREE", 3)) == 2 ||
                    player.occurrencesInHand(new RankClass("TWO", 2)) == 2 ) &&
                    (dealerHandSum >= 2 && dealerHandSum <= 7)) {
                return true;
            }
            else {
                return false;
            }
        }
        else{
            return false;
        }
    }

    /**
     * Method to check if the conditions are satisfied for the decision to stand
     * @param player : hand of a player
     * @param dealer : hand of the dealer
     * @return Boolean : true if conditions are satisfied
     */
    public Boolean shouldStand(NewHand player, NewHand dealer) {
        return checkHardTotalsForStand(player, dealer) ||
                checkSoftTotalsForStand(player, dealer) ||
                checkPairTotalsForStand(player, dealer);
    }

    /**
     * Method to check if the conditions for hard totals are satisfied for the decision to stand
     * @param player : hand of a player
     * @param dealer : hand of the dealer
     * @return Boolean : true if conditions for hard totals are satisfied
     */
    private Boolean checkHardTotalsForStand(NewHand player, NewHand dealer){
        int playerHandSum = player.calculateHandValue();
        int dealerHandSum = dealer.calculateHandValue();

        if(playerHandSum <= 20 && playerHandSum >= 17) {
            return true;
        }
        else if((playerHandSum <= 16 && playerHandSum >= 13) &&
                (dealerHandSum >= 2 && dealerHandSum <= 6)) {
            return true;
        }
        else if(playerHandSum == 12 && (dealerHandSum >= 4 && dealerHandSum <= 6)) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Method to check if the conditions for soft totals are satisfied for the decision to stand
     * @param player : hand of a player
     * @param dealer : hand of the dealer
     * @return Boolean : true if conditions for soft totals are satisfied
     */
    private Boolean checkSoftTotalsForStand(NewHand player, NewHand dealer){
        int playerHandSum = player.calculateHandValue();
        int dealerHandSum = dealer.calculateHandValue();

        if((playerHandSum <= 10 && playerHandSum >= 9) && hasAce(player)) {
            return true;
        }
        else if((playerHandSum == 7) && (dealerHandSum >= 2 && dealerHandSum <= 8) && hasAce(player)){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Method to check if the conditions for pair totals are satisfied for the decision to stand
     * @param player : hand of a player
     * @param dealer : hand of the dealer
     * @return Boolean : true if conditions for pair totals are satisfied
     */
    private Boolean checkPairTotalsForStand(NewHand player, NewHand dealer){
        int dealerHandSum = dealer.calculateHandValue();

        if(player.calculateHandValue() == 20) {
            return true;
        }
        else if(player.occurrencesInHand(new RankClass("NINE", 9)) == 2 &&
                (dealerHandSum == 7 || dealerHandSum == 10 || dealerHandSum == 11)){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Method to check if the conditions are satisfied for the decision to surrender
     * @param player : hand of a player
     * @param dealer : hand of the dealer
     * @return Boolean : true if conditions are satisfied
     */
    public Boolean shouldSurrender(NewHand player, NewHand dealer) {
        int playerHandSum = player.calculateHandValue();
        int dealerHandSum = dealer.calculateHandValue();

        if(playerHandSum == 16 && (dealerHandSum >= 9 && dealerHandSum <= 11)) {
            return true;
        }
        else if(playerHandSum == 15 && dealerHandSum == 10) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Method to check if a player should ask for a hit
     * @param player : hand of a player
     * @param dealer : hand of the dealer
     * @return Boolean : true if the player should hit, which is evaluated based on preset conditions
     */
    public Boolean shouldHit(NewHand player, NewHand dealer) {
        return checkHardTotalsForHit(player, dealer) ||
               checkSoftTotalsForHit(player, dealer) ||
               checkPairTotalsForHit(player, dealer);
    }

    /**
     * Method to check if the conditions for hard totals are satisfied for the decision to hit
     * @param player : hand of a player
     * @param dealer : hand of the dealer
     * @return Boolean : true if conditions for hard totals are satisfied
     */
    private Boolean checkHardTotalsForHit(NewHand player, NewHand dealer){
        int playerHandSum = player.calculateHandValue();
        int dealerHandSum = dealer.calculateHandValue();

        if(playerHandSum == 16 &&
           (dealerHandSum >= 7 && dealerHandSum <= 8)) {
            return true;
        }
        else if(playerHandSum == 15 &&
               ((dealerHandSum >= 7 && dealerHandSum <= 9) || dealerHandSum == 11)) {
            return true;
        }
        else if((playerHandSum == 14 || playerHandSum == 13) &&
                (dealerHandSum >= 7 && dealerHandSum <= 11)) {
            return true;
        }
        else if(playerHandSum == 12  &&
                ((dealerHandSum >= 2 && dealerHandSum <= 3) || (dealerHandSum >= 7 && dealerHandSum <= 11))) {
            return true;
        }
        else if(playerHandSum <=11 && playerHandSum >= 5 && !hasAce(player)) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Method to check if the conditions for soft totals are satisfied for the decision to hit
     * @param player : hand of a player
     * @param dealer : hand of the dealer
     * @return Boolean : true if conditions for soft totals are satisfied
     */
    private Boolean checkSoftTotalsForHit(NewHand player, NewHand dealer) {
        int playerHandSum = player.calculateHandValue();
        int dealerHandSum = dealer.calculateHandValue();

        if(playerHandSum == 8 && (dealerHandSum >= 9 && dealerHandSum <= 11) && hasAce(player)) {
            return true;
        }
        else if(playerHandSum <= 7 && playerHandSum >= 3 && hasAce(player)) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Method to check if the conditions for pair totals are satisfied for the decision to hit
     * @param player : hand of a player
     * @param dealer : hand of the dealer
     * @return Boolean : true if conditions for pair totals are satisfied
     */
    private Boolean checkPairTotalsForHit(NewHand player, NewHand dealer) {
        int dealerHandSum = dealer.calculateHandValue();

        if((player.occurrencesInHand(new RankClass("SEVEN", 7)) == 2) &&
           (dealerHandSum >= 8 && dealerHandSum <= 11)){
            return true;
        }
        else if((player.occurrencesInHand(new RankClass("SIX", 6)) == 2) &&
                (dealerHandSum >= 7 && dealerHandSum <= 11)) {
            return true;
        }
        else if(player.occurrencesInHand(new RankClass("FIVE", 5)) == 2) {
            return true;
        }
        else if(player.occurrencesInHand(new RankClass("FOUR", 4)) == 2 &&
               ((dealerHandSum >= 2 && dealerHandSum <= 4) || (dealerHandSum >= 7 && dealerHandSum <= 11))) {
            return true;
        }
        else if((player.occurrencesInHand(new RankClass("THREE", 3)) == 2 ||
                player.occurrencesInHand(new RankClass("TWO", 2)) == 2) &&
                (dealerHandSum >= 8 && dealerHandSum <= 11)){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Method to evaluate the win status of the dealer
     */
    public void evaluateDealerSituation(){
        dealer.showCards().get(1).setCardFaceUp();

        while(!checkIfDealerShouldEndHand()){
            dealToDealer(true);
        }
    }

    /**
     * Method to evaluate winners in a game
     */
    public void evaluateWinnersInGame(){
        for(int i=0; i<players.size(); i++){
            NewHand player = players.get(i);

            if(player.isBusted()) {
                player.setWinner(-1);
            }
            else if(player.hasBlackJack() && !dealer.hasBlackJack()){
                player.setWinner(1);
            }
            else if ((dealer.isBusted() && !player.isBusted()) ||
                    ((dealer.calculateHandValue() < player.calculateHandValue()) &&
                     !player.isBusted() && !dealer.isBusted())) {
                player.setWinner(1);
            }
            else if (dealer.calculateHandValue() == player.calculateHandValue()) {
                player.setWinner(0);
            }
            else if((player.calculateHandValue() < dealer.calculateHandValue()) &&
                    !player.isBusted() &&
                    !dealer.isBusted()) {
                player.setWinner(-1);
            }
            currentState.get(i).endRound(i);
        }
    }

    /**
     * Method to set the winnings amount to each player based on their winning status
     */
    public void setPlayerWinnings() {
        for(int i=0; i<players.size(); i++) {
            int parent = players.get(i).getParent();
            int amount = players.get(parent).getAmount();

            if(players.get(i).getWinner() == 1){
                players.get(parent).setAmount(amount+1);
            }
            else if(players.get(i).getWinner() == -1){
                players.get(parent).setAmount(amount-1);
            }
        }
    }

    /**
     * Method to reset the game
     */
    public void reset() {
        setNumberOfHands(numberOfHands);
        createDeck(VEGAS_DECK);
        getDeck().shuffle();
        deal();
    }
}
