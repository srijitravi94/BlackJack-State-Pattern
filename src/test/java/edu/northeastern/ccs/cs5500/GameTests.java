package edu.northeastern.ccs.cs5500;

import edu.northeastern.ccs.cs5500.classes.*;
import edu.northeastern.ccs.cs5500.interfaces.*;
import edu.northeastern.ccs.cs5500.enums.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static sun.audio.AudioPlayer.player;

/**
 * Class that consists of unit tests to test the game interfaces and classes
 * @author Srijit
 */
public class GameTests {

    private String RANK_NAME_TWO = RankValues.TWO.toString();
    private String RANK_NAME_THREE = RankValues.THREE.toString();
    private String RANK_NAME_FOUR = RankValues.FOUR.toString();
    private String RANK_NAME_FIVE = RankValues.FIVE.toString();
    private String RANK_NAME_SIX = RankValues.SIX.toString();
    private String RANK_NAME_SEVEN = RankValues.SEVEN.toString();
    private String RANK_NAME_EIGHT = RankValues.EIGHT.toString();
    private String RANK_NAME_NINE = RankValues.NINE.toString();
    private String RANK_NAME_TEN = RankValues.TEN.toString();
    private String RANK_NAME_JACK = RankValues.JACK.toString();
    private String RANK_NAME_QUEEN = RankValues.QUEEN.toString();
    private String RANK_NAME_KING = RankValues.KING.toString();
    private String RANK_NAME_ACE = RankValues.ACE.toString();

    private int RANK_PIPS_TWO = RankValues.TWO.getValue();
    private int RANK_PIPS_THREE = RankValues.THREE.getValue();
    private int RANK_PIPS_FOUR = RankValues.FOUR.getValue();
    private int RANK_PIPS_FIVE = RankValues.FIVE.getValue();
    private int RANK_PIPS_SIX = RankValues.SIX.getValue();
    private int RANK_PIPS_SEVEN = RankValues.SEVEN.getValue();
    private int RANK_PIPS_EIGHT = RankValues.EIGHT.getValue();
    private int RANK_PIPS_NINE = RankValues.NINE.getValue();
    private int RANK_PIPS_TEN = RankValues.TEN.getValue();
    private int RANK_PIPS_JACK = RankValues.JACK.getValue();
    private int RANK_PIPS_QUEEN = RankValues.QUEEN.getValue();
    private int RANK_PIPS_KING = RankValues.KING.getValue();
    private int RANK_PIPS_ACE = RankValues.ACE.getValue();

    private String SUIT_NAME_CLUBS = SuitValues.CLUBS.toString();
    private String SUIT_NAME_DIAMONDS = SuitValues.DIAMONDS.toString();
    private String SUIT_NAME_HEARTS = SuitValues.HEARTS.toString();
    private String SUIT_NAME_SPADES = SuitValues.SPADES.toString();

    private char SUIT_SYMBOL_CLUBS = SuitValues.CLUBS.toString().charAt(0);
    private char SUIT_SYMBOL_DIAMONDS = SuitValues.DIAMONDS.toString().charAt(0);;
    private char SUIT_SYMBOL_HEARTS = SuitValues.HEARTS.toString().charAt(0);
    private char SUIT_SYMBOL_SPADES = SuitValues.SPADES.toString().charAt(0);

    private String VEGAS = "Vegas";
    private String STANDARD = "Standard";
    private String PINOCHLE = "Pinochle";
    private String EUCHRE = "Euchre";

    private int OFFICIAL_SIZE_STANDARD = 52;
    private int BLACKJACK = 21;

    private GameClass game;

    private Card card2;
    private Card card3;
    private Card card4;
    private Card card5;
    private Card card6;
    private Card card7;
    private Card card8;
    private Card card9;
    private Card card10;
    private Card cardJack;
    private Card cardQueen;
    private Card cardKing;
    private Card cardAce;

    private String START_GAME_STATE = "Start Game State";

    /**
     * Create a game factory and game before each test case
     */
    @Before
    public void setGameFactoryAndClass() {
        GameFactory factory = new GameFactory();
        game = new GameClass(factory);
        game.createDeck(VEGAS);

        Rank rankTwo = new RankClass(RANK_NAME_TWO, RANK_PIPS_TWO);
        Rank rankThree = new RankClass(RANK_NAME_THREE, RANK_PIPS_THREE);
        Rank rankFour = new RankClass(RANK_NAME_FOUR, RANK_PIPS_FOUR);
        Rank rankFive = new RankClass(RANK_NAME_FIVE, RANK_PIPS_FIVE);
        Rank rankSix = new RankClass(RANK_NAME_SIX, RANK_PIPS_SIX);
        Rank rankSeven = new RankClass(RANK_NAME_SEVEN, RANK_PIPS_SEVEN);
        Rank rankEight = new RankClass(RANK_NAME_EIGHT, RANK_PIPS_EIGHT);
        Rank rankNine = new RankClass(RANK_NAME_NINE, RANK_PIPS_NINE);
        Rank rankTen = new RankClass(RANK_NAME_TEN, RANK_PIPS_TEN);
        Rank rankJack = new RankClass(RANK_NAME_JACK, RANK_PIPS_JACK);
        Rank rankQueen = new RankClass(RANK_NAME_QUEEN, RANK_PIPS_QUEEN);
        Rank rankKing = new RankClass(RANK_NAME_KING, RANK_PIPS_KING);
        Rank rankAce = new RankClass(RANK_NAME_ACE, RANK_PIPS_ACE);

        Suit suitHearts = new SuitClass(SUIT_NAME_HEARTS, SUIT_SYMBOL_HEARTS);
        Suit suitClubs = new SuitClass(SUIT_NAME_CLUBS, SUIT_SYMBOL_CLUBS);
        Suit suitSpades = new SuitClass(SUIT_NAME_SPADES, SUIT_SYMBOL_SPADES);
        Suit suitDiamonds = new SuitClass(SUIT_NAME_DIAMONDS, SUIT_SYMBOL_DIAMONDS);

        card2 = new CardClass(rankTwo, suitHearts);
        card3 = new CardClass(rankThree, suitClubs);
        card4 = new CardClass(rankFour, suitSpades);
        card5 = new CardClass(rankFive, suitDiamonds);
        card6 = new CardClass(rankSix, suitHearts);
        card7 = new CardClass(rankSeven, suitClubs);
        card8 = new CardClass(rankEight, suitSpades);
        card9 = new CardClass(rankNine, suitDiamonds);
        card10 = new CardClass(rankTen, suitHearts);
        cardJack = new CardClass(rankJack, suitClubs);
        cardQueen = new CardClass(rankQueen, suitSpades);
        cardKing = new CardClass(rankKing, suitDiamonds);
        cardAce = new CardClass(rankAce, suitHearts);
    }

    /**
     * Check after dealing each player has 2 cards each
     */
    @Test
    public void testNumberOfCardsForPlayerBeforePlaying() {
        game.setNumberOfHands(6);
        game.getDeck().shuffle();
        game.deal();

        List<NewHand> players = game.getPlayerHands();
        NewHand dealer = game.getDealerHand();

        for(NewHand player : players) {
            assertEquals(2, player.showCards().size());
        }

        assertEquals(2, dealer.showCards().size());
    }

    /**
     * After the cards are distributed, each player
     * should be either busted(end game state), have blackjack or get to dealer round state
     */
    @Test
    public void testStateAfterPlayBlackJack() {
        game.setNumberOfHands(5);
        game.getDeck().shuffle();
        game.deal();

        List<NewHand> players = game.getPlayerHands();
        game.playBlackJack();

        for(int i=0; i<players.size(); i++) {
            assertTrue(game.getCurrentState(i).equals(game.getEndRoundState(i)) ||
                       game.getCurrentState(i).equals(game.getDealerTurnState(i)));
        }
    }

    /**
     * After the cards are distributed,check the conditions for the player to be in end round state
     */
    @Test
    public void testPlayerStateForEndRound() {
        game.setNumberOfHands(7);
        game.getDeck().shuffle();
        game.deal();

        List<NewHand> players = game.getPlayerHands();
        NewHand dealer = game.getDealerHand();
        game.playBlackJack();

        for(int i=0; i<players.size(); i++) {
            NewHand player = players.get(i);
            if(game.getCurrentState(i).equals(game.getEndRoundState(i))) {
                assertTrue(player.isBusted() || player.hasBlackJack() || game.shouldSurrender(player, dealer));
            }
        }
    }

    /**
     * After the cards are distributed,check the conditions for the player in dealer turn state
     */
    @Test
    public void testPlayerStateForDealerTurnState() {
        game.setNumberOfHands(7);
        game.getDeck().shuffle();
        game.deal();

        List<NewHand> players = game.getPlayerHands();
        game.playBlackJack();

        for(int i=0; i<players.size(); i++) {
            NewHand player = players.get(i);
            if(game.getCurrentState(i).equals(game.getDealerTurnState(i))) {
                assertTrue(player.calculateHandValue() < BLACKJACK);
            }
        }
    }

    /**
     * Make decisions for players in different scenarios
     */
    @Test
    public void testMakeDecisionForSplitForAce() {
        NewHand player = new NewHandClass();
        NewHand dealer = new NewHandClass();

        player.accept(cardAce);
        player.accept(cardAce);

        dealer.accept(cardAce);

        assertTrue(game.shouldSplit(player, dealer));
    }

    /**
     * Make decisions for players in different scenarios
     */
    @Test
    public void testMakeDecisionForSplitForTen() {
        NewHand player = new NewHandClass();
        NewHand dealer = new NewHandClass();

        player.accept(card10);
        player.accept(card10);

        dealer.accept(card10);

        assertFalse(game.shouldSplit(player, dealer));
    }

    /**
     * Make decisions for players in different scenarios
     */
    @Test
    public void testMakeDecisionForSplitForNine() {
        NewHand player = new NewHandClass();
        NewHand dealer = new NewHandClass();
        NewHand dealer1 = new NewHandClass();

        player.accept(card9);
        player.accept(card9);

        dealer.accept(card4);
        dealer1.accept(card7);

        assertTrue(game.shouldSplit(player, dealer));
        assertFalse(game.shouldSplit(player, dealer1));
    }

    /**
     * Make decisions for players in different scenarios
     */
    @Test
    public void testMakeDecisionForSplitForSix() {
        NewHand player = new NewHandClass();
        NewHand dealer = new NewHandClass();
        NewHand dealer1 = new NewHandClass();

        player.accept(card6);
        player.accept(card6);

        dealer.accept(card2);
        dealer1.accept(cardAce);

        assertTrue(game.shouldSplit(player, dealer));
        assertFalse(game.shouldSplit(player, dealer1));
    }

    /**
     * Make decisions for players in different scenarios
     */
    @Test
    public void testMakeDecisionForSplitFalseCase() {
        NewHand player = new NewHandClass();
        NewHand dealer = new NewHandClass();
        NewHand dealer1 = new NewHandClass();

        player.accept(cardAce);
        player.accept(card5);

        dealer.accept(card2);
        dealer1.accept(cardAce);

        assertFalse(game.shouldSplit(player, dealer));
        assertFalse(game.shouldSplit(player, dealer1));
    }

    /**
     * Make decisions for players in different scenarios
     */
    @Test
    public void testSplitIntroducesNewHandWithSameParent() {
        game.setNumberOfHands(1);
        List<NewHand> players = game.getPlayerHands();
        NewHand dealer = game.getDealerHand();
        NewHand player = players.get(0);
        player.accept(cardAce);
        player.accept(cardAce);

        dealer.accept(card4);

        assertEquals(1, game.getPlayerHands().size());
        game.playBlackJack();
        assertEquals(2, game.getPlayerHands().size());
        assertEquals(0, game.getPlayerHands().get(1).getParent());

    }

    /**
     * Make decisions for players in different scenarios
     */
    @Test
    public void testShouldSurrender() {
        game.setNumberOfHands(1);
        List<NewHand> players = game.getPlayerHands();
        NewHand dealer = game.getDealerHand();
        NewHand player = players.get(0);
        player.accept(card10);
        player.accept(card6);

        dealer.accept(card9);

        game.playBlackJack();
        assertTrue(game.getCurrentState(0).equals(game.getEndRoundState(0)));
        assertFalse(game.shouldStand(player, dealer));
        assertFalse(game.shouldSplit(player, dealer));
        assertFalse(game.shouldHit(player, dealer));
        assertTrue(game.shouldSurrender(player, dealer));
    }

    /**
     * Make decisions for players in different scenarios
     */
    @Test
    public void testShouldStand() {
        game.setNumberOfHands(1);
        List<NewHand> players = game.getPlayerHands();
        NewHand dealer = game.getDealerHand();
        NewHand player = players.get(0);
        player.accept(cardAce);
        player.accept(card7);

        dealer.accept(card9);

        assertTrue(game.shouldStand(player, dealer));
        assertFalse(game.shouldSplit(player, dealer));
        assertFalse(game.shouldHit(player, dealer));
        assertFalse(game.shouldSurrender(player, dealer));
    }

    /**
     * Make decisions for players in different scenarios
     */
    @Test
    public void testShouldHit() {
        game.setNumberOfHands(1);
        List<NewHand> players = game.getPlayerHands();
        NewHand dealer = game.getDealerHand();
        NewHand player = players.get(0);
        player.accept(card7);
        player.accept(card6);

        dealer.accept(card7);

        assertFalse(game.shouldStand(player, dealer));
        assertFalse(game.shouldSplit(player, dealer));
        assertTrue(game.shouldHit(player, dealer));
        assertFalse(game.shouldSurrender(player, dealer));
    }

    /**
     * Deal to dealer
     */
    @Test
    public void testDealToDealer() {
        game.setNumberOfHands(5);
        game.deal();
        int initialSize = game.getDealerHand().showCards().size();
        game.dealToDealer(true);
        assertTrue(game.getDealerHand().showCards().size() == initialSize+1);

    }

    /**
     * Deal to player
     */
    @Test
    public void testDealToPlayer() {
        game.setNumberOfHands(5);
        game.deal();
        List<NewHand> players = game.getPlayerHands();
        int initialSize = players.get(0).showCards().size();

        game.dealToPlayer(players.get(0));

        assertTrue(game.getPlayerHands().get(0).showCards().size() == initialSize+1);

    }

    /**
     * Deal to player
     */
    @Test
    public void testDealForPlayer() {
        game.setNumberOfHands(5);
        game.deal();

        List<NewHand> players = game.getPlayerHands();

        for(NewHand player : players) {
            assertEquals(2, player.showCards().size());
            for(int i=0; i<player.showCards().size(); i++) {
                assertTrue(player.showCards().get(i).isFaceUp());
            }
        }
    }

    /**
     * Deal to dealer
     */
    @Test
    public void testDealForDealer() {
        game.setNumberOfHands(5);
        game.deal();

        NewHand dealer = game.getDealerHand();

        assertEquals(2, dealer.showCards().size());
        for(int i=0; i<dealer.showCards().size(); i++) {
            if(i != 1) {
                assertTrue(dealer.showCards().get(i).isFaceUp());
            } else {
                assertFalse(dealer.showCards().get(i).isFaceUp());
            }
        }
    }

    /**
     * Turn the face card up for the dealer after the players have completed their round
     */
    @Test
    public void testEvaluateDealerSituation() {
        game.setNumberOfHands(5);
        game.deal();
        NewHand dealer = game.getDealerHand();

        game.playBlackJack();
        assertFalse(dealer.showCards().get(1).isFaceUp());

        game.evaluateDealerSituation();
        assertTrue(dealer.showCards().get(1).isFaceUp());
    }

    /**
     * Dealer's turn after the players completed their turn
     */
    @Test
    public void testCheckIfDealerShouldEndHand() {
        game.setNumberOfHands(5);

        NewHand dealer = game.getDealerHand();

        dealer.accept(card10);
        dealer.accept(card6);
        dealer.accept(card4);

        assertTrue(game.checkIfDealerShouldEndHand());
    }

    /**
     * Dealer's turn after the players completed their turn
     */
    @Test
    public void testDealerHandIfAbove21() {
        game.setNumberOfHands(5);

        NewHand dealer = game.getDealerHand();

        dealer.accept(card10);
        dealer.accept(card6);
        dealer.accept(card4);
        dealer.accept(card4);

        assertTrue(game.checkIfDealerShouldEndHand());
    }

    /**
     * Dealer's turn after the players completed their turn
     */
    @Test
    public void testDealerHandIfBelow17() {
        game.setNumberOfHands(5);

        NewHand dealer = game.getDealerHand();

        dealer.accept(card10);
        assertFalse(game.checkIfDealerShouldEndHand());
        dealer.accept(card6);
        assertFalse(game.checkIfDealerShouldEndHand());
        dealer.accept(card4);
        dealer.accept(card4);

        assertTrue(game.checkIfDealerShouldEndHand());
    }

    /**
     * Evaluate winners in game
     */
    @Test
    public void testEvaluateWinners() {
        game.setNumberOfHands(1);

        NewHand player = game.getPlayerHands().get(0);
        NewHand dealer = game.getDealerHand();

        player.accept(cardAce);
        player.accept(card4);
        player.accept(cardAce);
        player.accept(cardAce);

        dealer.accept(cardJack);
        dealer.accept(cardKing);

        game.evaluateWinnersInGame();

        assertEquals(-1, game.getPlayerHands().get(0).getWinner());
    }

    /**
     * Evaluate winners in game
     */
    @Test
    public void testEvaluateWinnerPlayerBlackJack() {
        game.setNumberOfHands(1);

        NewHand player = game.getPlayerHands().get(0);
        NewHand dealer = game.getDealerHand();

        player.accept(cardAce);
        player.accept(cardKing);

        dealer.accept(cardJack);
        dealer.accept(cardKing);

        game.evaluateWinnersInGame();

        assertEquals(1, game.getPlayerHands().get(0).getWinner());
    }

    /**
     * Evaluate winners in game
     */
    @Test
    public void testEvaluateWinnerPlayerWins() {
        game.setNumberOfHands(1);

        NewHand player = game.getPlayerHands().get(0);
        NewHand dealer = game.getDealerHand();

        player.accept(cardKing);
        player.accept(cardKing);

        dealer.accept(card8);
        dealer.accept(cardKing);

        game.evaluateWinnersInGame();

        assertEquals(1, game.getPlayerHands().get(0).getWinner());
    }

    /**
     * Evaluate winners in game
     */
    @Test
    public void testEvaluateWinnerGameDraw() {
        game.setNumberOfHands(1);

        NewHand player = game.getPlayerHands().get(0);
        NewHand dealer = game.getDealerHand();

        player.accept(cardAce);
        player.accept(cardKing);

        dealer.accept(cardAce);
        dealer.accept(cardKing);

        game.evaluateWinnersInGame();

        assertEquals(0, game.getPlayerHands().get(0).getWinner());
    }

    /**
     * Evaluate winners in game
     */
    @Test
    public void testEvaluateWinnerPlayerBusted() {
        game.setNumberOfHands(1);

        NewHand player = game.getPlayerHands().get(0);
        NewHand dealer = game.getDealerHand();

        player.accept(card2);
        player.accept(cardKing);
        player.accept(cardKing);

        dealer.accept(cardAce);
        dealer.accept(cardKing);

        game.evaluateWinnersInGame();

        assertEquals(-1, game.getPlayerHands().get(0).getWinner());
        assertTrue(player.isBusted());
    }

    /**
     * Evaluate winners in game
     */
    @Test
    public void testEvaluateWinnerDealerBusted() {
        game.setNumberOfHands(1);

        NewHand player = game.getPlayerHands().get(0);
        NewHand dealer = game.getDealerHand();

        dealer.accept(card2);
        dealer.accept(cardKing);
        dealer.accept(cardKing);

        player.accept(cardAce);
        player.accept(cardKing);

        game.evaluateWinnersInGame();

        assertEquals(1, game.getPlayerHands().get(0).getWinner());
        assertTrue(dealer.isBusted());
        assertTrue(player.hasBlackJack());
    }

    /**
     * Evaluate winners in game
     */
    @Test
    public void testEvaluateWinnerPlayerBustedAndDealerBusted() {
        game.setNumberOfHands(1);

        NewHand player = game.getPlayerHands().get(0);
        NewHand dealer = game.getDealerHand();

        dealer.accept(card2);
        dealer.accept(cardKing);
        dealer.accept(cardKing);

        player.accept(card2);
        player.accept(cardKing);
        player.accept(cardKing);

        game.evaluateWinnersInGame();

        assertEquals(-1, game.getPlayerHands().get(0).getWinner());
        assertTrue(player.isBusted());
        assertTrue(dealer.isBusted());
    }

    /**
     * Evaluate winners in game
     */
    @Test
    public void testWinnerEarningsWin() {
        game.setNumberOfHands(1);

        NewHand player = game.getPlayerHands().get(0);
        player.setWinner(1);

        game.setPlayerWinnings();

        assertEquals(2,player.getAmount());
    }

    /**
     * Evaluate winners in game
     */
    @Test
    public void testWinnerEarningsLoss() {
        game.setNumberOfHands(1);

        NewHand player = game.getPlayerHands().get(0);
        player.setWinner(-1);

        game.setPlayerWinnings();

        assertEquals(0,player.getAmount());
    }

    /**
     * Evaluate winners in game
     */
    @Test
    public void testWinnerEarnings() {
        game.setNumberOfHands(1);

        NewHand player = game.getPlayerHands().get(0);
        player.setWinner(0);

        game.setPlayerWinnings();

        assertEquals(1,player.getAmount());
    }

    /**
     * Reset table
     */
    @Test
    public void testReset() {
        game.setNumberOfHands(5);
        game.deal();
        game.playBlackJack();
        game.evaluateDealerSituation();
        game.evaluateWinnersInGame();
        game.setPlayerWinnings();
        game.reset();

        for(int i=0; i<game.getPlayerHands().size(); i++) {
            NewHand player = game.getPlayerHands().get(i);
            assertTrue(game.getCurrentState(i).toString().equals(START_GAME_STATE));
            assertEquals(2, player.showCards().size());
        }
    }

    /**
     * Reset table
     */
    @Test
    public void testPlay() {
        game.setNumberOfHands(5);
        game.deal();
        game.play();

        for(int i=0; i<game.getPlayerHands().size(); i++) {
            NewHand player = game.getPlayerHands().get(i);
            assertTrue(game.getCurrentState(i).toString().equals(START_GAME_STATE));
            assertEquals(2, player.showCards().size());
        }
    }
}
