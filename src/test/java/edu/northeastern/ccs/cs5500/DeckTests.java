package edu.northeastern.ccs.cs5500;

import edu.northeastern.ccs.cs5500.classes.*;
import edu.northeastern.ccs.cs5500.enums.RankValues;
import edu.northeastern.ccs.cs5500.enums.SuitValues;
import edu.northeastern.ccs.cs5500.interfaces.Card;
import edu.northeastern.ccs.cs5500.interfaces.Deck;
import edu.northeastern.ccs.cs5500.interfaces.Game;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Class that consists of unit tests to test the deck interfaces and classes
 * @author Srijit
 */
public class DeckTests {

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

    private String STANDARD = "Standard";
    private String PINOCHLE = "Pinochle";
    private String EUCHRE = "Euchre";
    private String VEGAS = "Vegas";

    private int OFFICIAL_SIZE_STANDARD = 52;
    private int OFFICIAL_SIZE_PINOCHLE = 48;
    private int OFFICIAL_SIZE_EUCHRE = 24;

    private String SORT_BY_RANK = "byRank";
    private String SORT_BY_SUIT = "bySuit";
    private String SORT_BY_BOTH = "both";


    /**
     * Test to check whether deck has the right cards in it and the right number of cards for a standard deck.
     */
    @Test
    public void testDeckCreationForStandard() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);

        // Test for a Standard Deck size
        game.createDeck(STANDARD);
        Deck deck = game.getDeck();
        assertNotEquals(51, deck.officialSize());
        assertNotEquals(0, deck.officialSize());
        assertEquals(OFFICIAL_SIZE_STANDARD, deck.officialSize());
    }

    /**
     * Test to check whether deck has the right cards in it and the right number of cards for a pinochle deck.
     */
    @Test
    public void testDeckCreationForPinochle() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);

        // Test for a Pinochle Deck Size
        game.createDeck(PINOCHLE);
        Deck deck = game.getDeck();

        assertNotEquals(49, deck.officialSize());
        assertNotEquals(0, deck.officialSize());
        assertEquals(OFFICIAL_SIZE_PINOCHLE, deck.officialSize());
    }

    /**
     * Test to check whether deck has the right cards in it and the right number of cards for a euchre deck.
     */
    @Test
    public void testDeckCreationForEuchre() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);

        // Test for Euchre Deck Size
        game.createDeck(EUCHRE);
        Deck deck = game.getDeck();

        assertNotEquals(23, deck.officialSize());
        assertNotEquals(0, deck.officialSize());
        assertEquals(OFFICIAL_SIZE_EUCHRE, deck.officialSize());
    }

    /**
     * Test to check whether deck has the right cards in it and the right number of cards for a vegas deck.
     */
    @Test
    public void testDeckCreationForVegas() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);

        // Test for Vegas Deck Size
        game.createDeck(VEGAS);
        Deck deck = game.getDeck();

        assertNotEquals(52, deck.officialSize());
        assertNotEquals(0, deck.officialSize());
        assertEquals(6*OFFICIAL_SIZE_STANDARD, deck.officialSize());
    }

    /**
     * Test to check whether deck has the right cards in it and the right number of cards for a vegas deck.
     */
    @Test
    public void testDeckCreationForVegasWithNumberOfDecks() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);

        // Test for Vegas Deck Size
        game.createDeck(VEGAS, 8);
        Deck deck = game.getDeck();

        assertNotEquals(52, deck.officialSize());
        assertNotEquals(0, deck.officialSize());
        assertEquals(8*OFFICIAL_SIZE_STANDARD, deck.officialSize());
    }

    /**
     * Test to check whether whether the deck is empty if an illegal argument is passed
     */
    @Test
    public void testDeckCreationIllegalArgument() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);

        game.createDeck("dard");

        assertEquals(0, game.getDeck().getCardList().size());
    }

    /**
     * Method to check if two card lists are same
     * @param cardList1 : card list to compare
     * @param cardList2 : card list to compare
     * @return return true if two card lists are not same
     */
    private Boolean compareTwoCardList(List<Card> cardList1, List<Card> cardList2){
        Deck deck = new DeckClass();

        if(cardList1.size() != cardList2.size()) {
            return false;
        }

        for(int i=0; i<cardList1.size(); i++) {
            if(!deck.checkIfEqual(cardList1.get(i), cardList2.get(i))) {
                return true;
            }
        }

        return false;
    }

    /**
     * A deck after being shuffled has a different order than before.
     */
    @Test
    public void testDeckShuffling() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);
        game.createDeck(VEGAS);

        List<Card> cardListBeforeShuffling = new ArrayList<>();
        List<Card> cardList = game.getDeck().getCardList();

        for(Card card : cardList) {
            cardListBeforeShuffling.add(card);
        }

        // Shuffling the deck of cards
        game.getDeck().shuffle();
        List<Card> cardListAfterShuffling = game.getDeck().getCardList();


        // Test to check whether the list of cards is shuffled
        assertTrue(compareTwoCardList(cardListBeforeShuffling, cardListAfterShuffling));
        assertFalse(compareTwoCardList(cardListBeforeShuffling, cardListBeforeShuffling));
    }

    /**
     * A deck after being sorted by rank for vegas card is in the expected order.
     */
    @Test
    public void testSortByRankForVegas() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);
        game.createDeck(VEGAS);

        Deck deck = game.getDeck();

        // Shuffling the deck of cards
        deck.shuffle();

        // Sorting the deck by rank
        deck.sort(SORT_BY_RANK);

        Card topCard = deck.getCardList().get(0);

        assertNotEquals(RANK_NAME_NINE, topCard.getRank().getName());
        assertNotEquals(RANK_PIPS_NINE, topCard.getRank().getPips());

        // Checking if the first card's rank is NINE
        assertEquals(RANK_NAME_TWO, topCard.getRank().getName());
        assertEquals(RANK_PIPS_TWO, topCard.getRank().getPips());

        Card bottomCard = deck.getCardList().get(deck.getCardList().size()-1);

        assertNotEquals(RANK_NAME_NINE, topCard.getRank().getName());
        assertNotEquals(RANK_PIPS_NINE, topCard.getRank().getPips());

        // Checking if the bottom card's rank is ACE
        assertEquals(RANK_NAME_ACE, bottomCard.getRank().getName());
        assertEquals(RANK_PIPS_ACE, bottomCard.getRank().getPips());
    }

    /**
     * A deck after being sorted by suit is in the expected order.
     */
    @Test
    public void testSortBySuit() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);

        game.createDeck(VEGAS);

        Deck deck = game.getDeck();

        // Shuffling the deck of cards
        deck.shuffle();

        // Sorting the deck by suit
        deck.sort(SORT_BY_SUIT);

        // Checking if the first card's suit is CLUBS
        Card clubsCard = deck.getCardList().get(0);

        assertEquals(SUIT_NAME_CLUBS, clubsCard.getSuit().getName());
        assertEquals(SUIT_SYMBOL_CLUBS, clubsCard.getSuit().getSymbol());

        // Checking if the last set of card's suit is SPADES
        Card spadesCard = deck.getCardList().get(deck.getCardList().size()-1);

        assertEquals(SUIT_NAME_SPADES, spadesCard.getSuit().getName());
        assertEquals(SUIT_SYMBOL_SPADES, spadesCard.getSuit().getSymbol());
    }

    /**
     * A deck after being sorted by both rank and suit for vegas deck is in the expected order.
     */
    @Test
    public void testSortByBothForVegas() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);
        game.createDeck(VEGAS);

        Deck deck = game.getDeck();

        // Shuffling the deck of cards
        deck.shuffle();

        // Sorting the deck by both
        deck.sort(SORT_BY_BOTH);

        Card topCard = deck.getCardList().get(0);

        assertNotEquals(SUIT_NAME_SPADES, topCard.getSuit().getName());
        assertNotEquals(SUIT_SYMBOL_SPADES, topCard.getSuit().getSymbol());
        assertNotEquals(RANK_NAME_NINE, topCard.getRank().getName());
        assertNotEquals(RANK_PIPS_NINE, topCard.getRank().getPips());

        // Checking if the first card's rank is TWO and suit is CLUBS
        assertEquals(SUIT_NAME_CLUBS, topCard.getSuit().getName());
        assertEquals(SUIT_SYMBOL_CLUBS, topCard.getSuit().getSymbol());
        assertEquals(RANK_NAME_TWO, topCard.getRank().getName());
        assertEquals(RANK_PIPS_TWO, topCard.getRank().getPips());


        Card bottomCard = deck.getCardList().get(deck.getCardList().size()-1);

        assertNotEquals(SUIT_NAME_CLUBS, bottomCard.getSuit().getName());
        assertNotEquals(SUIT_SYMBOL_CLUBS, bottomCard.getSuit().getSymbol());
        assertNotEquals(RANK_NAME_TWO, bottomCard.getRank().getName());
        assertNotEquals(RANK_PIPS_TWO, bottomCard.getRank().getPips());

        // Checking if the bottom card's rank is ACE and suit is SPADES
        assertEquals(SUIT_NAME_SPADES, bottomCard.getSuit().getName());
        assertEquals(SUIT_SYMBOL_SPADES, bottomCard.getSuit().getSymbol());
        assertEquals(RANK_NAME_ACE, bottomCard.getRank().getName());
        assertEquals(RANK_PIPS_ACE, bottomCard.getRank().getPips());
    }

    /**
     * Test a deck after being cut is in the right order.
     */
    @Test
    public void testDeckCut() {

        // initialize the cut point
        int CUT_POINT = 20;

        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);
        game.createDeck(VEGAS);

        Deck deck = game.getDeck();

        // append the cards that are before the cut point
        List<Card> cardsBeforeCutPoint = new ArrayList<>();

        for(int i=0; i<CUT_POINT-1; i++) {
            cardsBeforeCutPoint.add(deck.getCardList().get(i));
        }

        // make the cut
        deck.cut(CUT_POINT);
        int size = deck.getCardList().size();

        // check if the cut cards are placed at the bottom of the deck
        for(int i=size-CUT_POINT+1, j=0; i<size; i++, j++) {
            assertTrue(deck.checkIfEqual(deck.getCardList().get(i), cardsBeforeCutPoint.get(j)));
        }
    }

    /**
     * Test a deck after being cut is in the right order.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeckCutException() {

        // initialize the cut point
        int CUT_POINT = 6*OFFICIAL_SIZE_STANDARD + 5;

        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);
        game.createDeck(VEGAS);

        Deck deck = game.getDeck();

        // append the cards that are before the cut point
        List<Card> cardsBeforeCutPoint = new ArrayList<>();

        for(int i=0; i<CUT_POINT-1; i++) {
            cardsBeforeCutPoint.add(deck.getCardList().get(i));
        }

        // make the cut
        deck.cut(CUT_POINT);
        int size = deck.getCardList().size();

        // check if the cut cards are placed at the bottom of the deck
        for(int i=size-CUT_POINT+1, j=0; i<size; i++, j++) {
            assertTrue(deck.checkIfEqual(deck.getCardList().get(i), cardsBeforeCutPoint.get(j)));
        }
    }

    /**
     * A deck after a card is pulled has one less card than before that card was pulled (and that card is no longer in the deck).
     */
    @Test
    public void testPullCardForVegas() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);
        game.createDeck(VEGAS);

        Deck deck = game.getDeck();
        deck.sort(SORT_BY_BOTH);

        Card pulledCard1 = deck.pullCard();

        // should return true since vegas has more than one set of cards
        assertTrue(deck.hasCard(pulledCard1));
        assertEquals(deck.getCardList().size(), deck.officialSize()-1);
    }

    /**
     * A deck after a card is pulled has one less card than before that card was pulled (and that card is no longer in the deck).
     */
    @Test
    public void testPullCard() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);
        game.createDeck(VEGAS);

        Deck deck = game.getDeck();
        deck.sort(SORT_BY_BOTH);

        Card pulledCard1 = deck.pullCard();
        deck.pullCard();
        deck.pullCard();
        deck.pullCard();
        deck.pullCard();
        deck.pullCard();

        // should return true since vegas has more than one set of cards
        assertFalse(deck.hasCard(pulledCard1));
    }

    /**
     * A deck after a card is pulled has one less card than before that card was pulled (and that card is no longer in the deck).
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testPullCardException() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);
        game.createDeck(VEGAS);

        Deck deck = game.getDeck();

        int size = deck.getCardList().size();
        Card pulledCard;

        for(int i=0; i<size; i++) {
            pulledCard = deck.pullCard();
        }

        // testing the pull card after all the cards are removed from the deck should throw exception
        deck.pullCard();
    }

    /**
     * An empty deck is indeed empty. A deck with cards in it is indeed not empty.
     */
    @Test
    public void testEmptyDeck() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);
        game.createDeck(VEGAS);

        Deck deck = game.getDeck();

        assertFalse(deck.emptyDeck());

        for(int i=0; i<deck.officialSize(); i++) {
            deck.pullCard();
        }

        assertTrue(deck.emptyDeck());
    }

    /**
     * Check deck instance of the game interface
     */
    @Test
    public void testGetDeck() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);
        game.createDeck(VEGAS);

        assertTrue(game.getDeck() instanceof Deck);
        assertTrue(game.getDeck() != null);

        game.createDeck(VEGAS);

        assertTrue(game.getDeck() instanceof Deck);
        assertTrue(game.getDeck() != null);
    }

    /**
     * Vegas Deck class constructor
     */
    @Test
    public void vegasDeckConstructor() {
        VegasDeckClass vegas = new VegasDeckClass(8);
        assertEquals(8*OFFICIAL_SIZE_STANDARD, vegas.getCardList().size());
    }

}
