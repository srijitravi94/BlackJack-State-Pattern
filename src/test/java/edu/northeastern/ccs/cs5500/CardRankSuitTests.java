package edu.northeastern.ccs.cs5500;

import edu.northeastern.ccs.cs5500.classes.*;
import edu.northeastern.ccs.cs5500.enums.RankValues;
import edu.northeastern.ccs.cs5500.enums.SuitValues;
import edu.northeastern.ccs.cs5500.interfaces.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class that consists of unit tests to test the card, rank and suit interfaces and classes
 * @author Srijit
 */
public class CardRankSuitTests {

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

    /**
     * Tests to check the creation of individual cards (meaning test that a card has the right suit and rank)
     */
    @Test
    public void testCardCreation() {
        Rank rank = new RankClass(RANK_NAME_TWO, RANK_PIPS_TWO);
        Suit suit = new SuitClass(SUIT_NAME_DIAMONDS, SUIT_SYMBOL_DIAMONDS);
        Card card = new CardClass(rank, suit);

        // Test for Rank name
        assertEquals(RANK_NAME_TWO, card.getRank().getName());
        assertNotEquals(RANK_NAME_THREE, card.getRank().getName());

        // Test for Pips
        assertEquals(RANK_PIPS_TWO, card.getRank().getPips());
        assertNotEquals(RANK_PIPS_THREE, card.getRank().getPips());

        // Test for Suit name
        assertEquals(SUIT_NAME_DIAMONDS, card.getSuit().getName());
        assertNotEquals(SUIT_NAME_HEARTS, card.getSuit().getName());

        // Test for Suit symbol
        assertEquals(SUIT_SYMBOL_DIAMONDS, card.getSuit().getSymbol());
        assertNotEquals(SUIT_SYMBOL_HEARTS, card.getSuit().getSymbol());
    }

    /**
     * Test to check whether deck has the right cards in it and the right number of cards for a standard deck.
     */
    @Test
    public void testCardCreationForStandard() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);

        Rank rank1 = new RankClass(RANK_NAME_TWO, RANK_PIPS_TWO);
        Suit suit1 = new SuitClass(SUIT_NAME_SPADES, SUIT_SYMBOL_SPADES);
        Card card1 = new CardClass(rank1, suit1);

        Rank rank2 = new RankClass(RANK_NAME_NINE, RANK_PIPS_NINE);
        Suit suit2 = new SuitClass(SUIT_NAME_DIAMONDS, SUIT_SYMBOL_DIAMONDS);
        Card card2 = new CardClass(rank2, suit2);

        Rank rank3 = new RankClass(RANK_NAME_EIGHT, RANK_PIPS_EIGHT);
        Suit suit3 = new SuitClass(SUIT_NAME_HEARTS, SUIT_SYMBOL_HEARTS);
        Card card3 = new CardClass(rank3, suit3);

        Rank rank4 = new RankClass(RANK_NAME_ACE, RANK_PIPS_ACE);
        Suit suit4 = new SuitClass(SUIT_NAME_CLUBS, SUIT_SYMBOL_CLUBS);
        Card card4 = new CardClass(rank4, suit4);

        // Test for a Standard Deck size
        game.createDeck(STANDARD);
        Deck deck = game.getDeck();

        // Test to check if the Standard has the right cards in it
        assertTrue(deck.hasCard(card1));
        assertTrue(deck.hasCard(card2));
        assertTrue(deck.hasCard(card3));
        assertTrue(deck.hasCard(card4));
    }

    /**
     * Test to check whether deck has the right cards in it and the right number of cards for a pinochle deck.
     */
    @Test
    public void testCardCreationForPinochle() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);

        Rank rank1 = new RankClass(RANK_NAME_TWO, RANK_PIPS_TWO);
        Suit suit1 = new SuitClass(SUIT_NAME_SPADES, SUIT_SYMBOL_SPADES);
        Card card1 = new CardClass(rank1, suit1);

        Rank rank2 = new RankClass(RANK_NAME_NINE, RANK_PIPS_NINE);
        Suit suit2 = new SuitClass(SUIT_NAME_DIAMONDS, SUIT_SYMBOL_DIAMONDS);
        Card card2 = new CardClass(rank2, suit2);

        Rank rank3 = new RankClass(RANK_NAME_EIGHT, RANK_PIPS_EIGHT);
        Suit suit3 = new SuitClass(SUIT_NAME_HEARTS, SUIT_SYMBOL_HEARTS);
        Card card3 = new CardClass(rank3, suit3);

        Rank rank4 = new RankClass(RANK_NAME_ACE, RANK_PIPS_ACE);
        Suit suit4 = new SuitClass(SUIT_NAME_CLUBS, SUIT_SYMBOL_CLUBS);
        Card card4 = new CardClass(rank4, suit4);

        // Test for a Pinochle Deck Size
        game.createDeck(PINOCHLE);
        Deck deck = game.getDeck();

        // Test to check if the Pinochle has the right cards in it
        assertFalse(deck.hasCard(card1));
        assertTrue(deck.hasCard(card2));
        assertFalse(deck.hasCard(card3));
        assertTrue(deck.hasCard(card4));
    }

    /**
     * Test to check whether deck has the right cards in it and the right number of cards for a euchre deck.
     */
    @Test
    public void testCardCreationForEuchre() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);

        Rank rank1 = new RankClass(RANK_NAME_TWO, RANK_PIPS_TWO);
        Suit suit1 = new SuitClass(SUIT_NAME_SPADES, SUIT_SYMBOL_SPADES);
        Card card1 = new CardClass(rank1, suit1);

        Rank rank2 = new RankClass(RANK_NAME_NINE, RANK_PIPS_NINE);
        Suit suit2 = new SuitClass(SUIT_NAME_DIAMONDS, SUIT_SYMBOL_DIAMONDS);
        Card card2 = new CardClass(rank2, suit2);

        Rank rank3 = new RankClass(RANK_NAME_EIGHT, RANK_PIPS_EIGHT);
        Suit suit3 = new SuitClass(SUIT_NAME_HEARTS, SUIT_SYMBOL_HEARTS);
        Card card3 = new CardClass(rank3, suit3);

        Rank rank4 = new RankClass(RANK_NAME_ACE, RANK_PIPS_ACE);
        Suit suit4 = new SuitClass(SUIT_NAME_CLUBS, SUIT_SYMBOL_CLUBS);
        Card card4 = new CardClass(rank4, suit4);


        // Test for Euchre Deck Size
        game.createDeck(EUCHRE);
        Deck deck = game.getDeck();

        // Test to check if the Euchre has the right cards in it
        assertFalse(deck.hasCard(card1));
        assertTrue(deck.hasCard(card2));
        assertFalse(deck.hasCard(card3));
        assertTrue(deck.hasCard(card4));
    }

    /**
     * Test to check whether deck has the right cards in it and the right number of cards for a vegas deck.
     */
    @Test
    public void testCardCreationForVegas() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);

        Rank rank1 = new RankClass(RANK_NAME_TWO, RANK_PIPS_TWO);
        Suit suit1 = new SuitClass(SUIT_NAME_SPADES, SUIT_SYMBOL_SPADES);
        Card card1 = new CardClass(rank1, suit1);

        Rank rank2 = new RankClass(RANK_NAME_NINE, RANK_PIPS_NINE);
        Suit suit2 = new SuitClass(SUIT_NAME_DIAMONDS, SUIT_SYMBOL_DIAMONDS);
        Card card2 = new CardClass(rank2, suit2);

        Rank rank3 = new RankClass(RANK_NAME_EIGHT, RANK_PIPS_EIGHT);
        Suit suit3 = new SuitClass(SUIT_NAME_HEARTS, SUIT_SYMBOL_HEARTS);
        Card card3 = new CardClass(rank3, suit3);

        Rank rank4 = new RankClass(RANK_NAME_ACE, RANK_PIPS_ACE);
        Suit suit4 = new SuitClass(SUIT_NAME_CLUBS, SUIT_SYMBOL_CLUBS);
        Card card4 = new CardClass(rank4, suit4);


        // Test for Vegas Deck Size
        game.createDeck(VEGAS);
        Deck deck = game.getDeck();
        assertEquals(deck.getCardList().size(), 6*OFFICIAL_SIZE_STANDARD);

        // Test to check if the Vegas has the right cards in it
        assertTrue(deck.hasCard(card1));
        assertTrue(deck.hasCard(card2));
        assertTrue(deck.hasCard(card3));
        assertTrue(deck.hasCard(card4));

    }

    /**
     * Test to check whether deck has the right cards in it and the right number of cards for a vegas deck.
     */
    @Test
    public void testCardCreationForVegasWithNumberOfDecks() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);

        Rank rank1 = new RankClass(RANK_NAME_TWO, RANK_PIPS_TWO);
        Suit suit1 = new SuitClass(SUIT_NAME_SPADES, SUIT_SYMBOL_SPADES);
        Card card1 = new CardClass(rank1, suit1);

        Rank rank2 = new RankClass(RANK_NAME_NINE, RANK_PIPS_NINE);
        Suit suit2 = new SuitClass(SUIT_NAME_DIAMONDS, SUIT_SYMBOL_DIAMONDS);
        Card card2 = new CardClass(rank2, suit2);

        Rank rank3 = new RankClass(RANK_NAME_EIGHT, RANK_PIPS_EIGHT);
        Suit suit3 = new SuitClass(SUIT_NAME_HEARTS, SUIT_SYMBOL_HEARTS);
        Card card3 = new CardClass(rank3, suit3);

        Rank rank4 = new RankClass(RANK_NAME_ACE, RANK_PIPS_ACE);
        Suit suit4 = new SuitClass(SUIT_NAME_CLUBS, SUIT_SYMBOL_CLUBS);
        Card card4 = new CardClass(rank4, suit4);


        // Test for Vegas Deck Size
        game.createDeck(VEGAS, 8);
        Deck deck = game.getDeck();
        assertEquals(deck.getCardList().size(), 8*OFFICIAL_SIZE_STANDARD);

        // Test to check if the Vegas has the right cards in it
        assertTrue(deck.hasCard(card1));
        assertTrue(deck.hasCard(card2));
        assertTrue(deck.hasCard(card3));
        assertTrue(deck.hasCard(card4));
    }

    /**
     * Check if the card is faced up or down
     */
    @Test
    public void testCardFaceUp() {
        Rank rank1 = new RankClass(RANK_NAME_TWO, RANK_PIPS_TWO);
        Suit suit1 = new SuitClass(SUIT_NAME_SPADES, SUIT_SYMBOL_SPADES);
        Card card1 = new CardClass(rank1, suit1);

        assertTrue(card1.isFaceUp());
        card1.setCardFaceDown();
        assertFalse(card1.isFaceUp());
        card1.setCardFaceUp();
        assertTrue(card1.isFaceUp());
    }

    /**
     * Create cards only if the input is valid
     */
    @Test
    public void testMakeCards() {
        MakeCards cards = new MakeCards();
        assertEquals(6* OFFICIAL_SIZE_STANDARD, cards.createCards("Vegas", 6).size());
    }

    /**
     * Create cards only if the input is valid
     */
    @Test
    public void testMakeCardsIllegalArgument() {
        MakeCards cards = new MakeCards();
        assertEquals(0, cards.createCards("dard", 1).size());
    }

}