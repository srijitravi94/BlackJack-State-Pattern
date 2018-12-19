package edu.northeastern.ccs.cs5500;

import edu.northeastern.ccs.cs5500.classes.*;
import edu.northeastern.ccs.cs5500.enums.RankValues;
import edu.northeastern.ccs.cs5500.enums.SuitValues;
import edu.northeastern.ccs.cs5500.interfaces.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Class that consists of unit tests to test the hand interfaces and classes
 * @author Srijit
 */
public class HandTests {

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

    private String SORT_BY_RANK = "byRank";
    private String SORT_BY_SUIT = "bySuit";
    private String SORT_BY_BOTH = "both";

    private int ONE_NUMBER_OF_HANDS = 1;
    private int THREE_NUMBER_OF_HANDS = 3;
    private int FIVE_NUMBER_OF_HANDS = 5;
    private int TEN_NUMBER_OF_HANDS = 10;
    private int HUNDRED_NUMBER_OF_HANDS = 100;

    private int NUMBER_OF_CARDS_PER_HAND = 2;

    private int OFFICIAL_SIZE_STANDARD = 52;
    private int OFFICIAL_SIZE_PINOCHLE = 48;
    private int OFFICIAL_SIZE_EUCHRE = 24;

    private HashMap<String, Integer> rankNameMap = new HashMap<>();
    private HashMap<String, Integer> suitNameMap = new HashMap<>();
    private HashMap<Character, Integer> suitSymbolMap = new HashMap<>();

    private Rank rank1 = new RankClass(RANK_NAME_TWO, RANK_PIPS_TWO);
    private Suit suit1 = new SuitClass(SUIT_NAME_SPADES, SUIT_SYMBOL_SPADES);
    private Card card1 = new CardClass(rank1, suit1);

    private Rank rank2 = new RankClass(RANK_NAME_NINE, RANK_PIPS_NINE);
    private Suit suit2 = new SuitClass(SUIT_NAME_DIAMONDS, SUIT_SYMBOL_DIAMONDS);
    private Card card2 = new CardClass(rank2, suit2);

    private Rank rank3 = new RankClass(RANK_NAME_EIGHT, RANK_PIPS_EIGHT);
    private Suit suit3 = new SuitClass(SUIT_NAME_HEARTS, SUIT_SYMBOL_HEARTS);
    private Card card3 = new CardClass(rank3, suit3);

    private Rank rank4 = new RankClass(RANK_NAME_ACE, RANK_PIPS_ACE);
    private Suit suit4 = new SuitClass(SUIT_NAME_CLUBS, SUIT_SYMBOL_CLUBS);
    private Card card4 = new CardClass(rank4, suit4);

    /**
     * A hand properly accepts a card.
     */
    @Test
    public void testHandAcceptsCard() {

        NewHand hand = new NewHandClass();
        hand.accept(card1);
        hand.accept(card2);
        hand.accept(card3);

        assertTrue(hand.hasCard(card1));
        assertTrue(hand.hasCard(card2));
        assertTrue(hand.hasCard(card3));
        assertFalse(hand.hasCard(card4));
    }

    /**
     * A hand properly accepts a card.
     */
    @Test
    public void testHandAcceptsCardAfterShuffling() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);
        game.createDeck(VEGAS);
        game.setNumberOfHands(FIVE_NUMBER_OF_HANDS);
        game.getDeck().shuffle();

        List<Card> cards = game.getDeck().getCardList();

        NewHand hand = new NewHandClass();
        hand.accept(cards.get(0));
        hand.accept(cards.get(1));
        hand.accept(cards.get(2));

        assertTrue(hand.hasCard(cards.get(0)));
        assertTrue(hand.hasCard(cards.get(1)));
        assertTrue(hand.hasCard(cards.get(2)));
        assertFalse(hand.hasCard(cards.get(3)));
    }

    /**
     * Check pull card and size of the cards in the hand
     */
    @Test
    public void testPullCardFromHand() {
        NewHand hand = new NewHandClass();
        hand.accept(card1);
        hand.accept(card2);
        hand.accept(card3);

        List<Card> showCards = hand.showCards();
        int size = showCards.size();
        int k=size;

        for(int i=0; i<size; i++) {
            assertEquals(showCards.size(), k--);
            hand.pullCard();
            assertEquals(showCards.size(), k);
        }
    }

    /**
     * When a card is pulled from the hand, the hand now has one less card and that card is no longer in the deck.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testPullCardFromHandException() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);
        game.createDeck(VEGAS);
        game.setNumberOfHands(ONE_NUMBER_OF_HANDS);
        game.deal();

        List<NewHand> players = game.getPlayerHands();

        //throws exception when we pull the card from an empty card list
        for(NewHand hand : players) {
            for(int i=0; i<NUMBER_OF_CARDS_PER_HAND+1; i++) {
                hand.pullCard();
            }
        }
    }

    /**
     * A hand properly shows the card list.
     */
    @Test
    public void testHandShowsCardList() {

        NewHand hand = new NewHandClass();
        hand.accept(card1);
        hand.accept(card2);
        hand.accept(card3);

        List<Card> cardList = new ArrayList<>();
        cardList.add(card1);
        cardList.add(card2);
        cardList.add(card3);

        List<Card> showCards = hand.showCards();

        for(int i=0; i<showCards.size(); i++) {
            assertEquals(showCards.get(i), cardList.get(i));
        }

    }

    /**
     * The hand tells accurately whether a particular card is present.
     */
    @Test
    public void testHandForACardToBePresent() {
        NewHand hand = new NewHandClass();
        hand.accept(card1);
        hand.accept(card2);
        hand.accept(card3);

        assertTrue(hand.hasCard(card1));
        assertTrue(hand.hasCard(card2));
        assertTrue(hand.hasCard(card3));
        assertFalse(hand.hasCard(card4));

        Hand hand1 = new HandClass();
        hand1.accept(card1);
        hand1.accept(card2);
        hand1.accept(card3);

        assertTrue(hand1.hasCard(card1));
        assertTrue(hand1.hasCard(card2));
        assertTrue(hand1.hasCard(card3));
        assertFalse(hand.hasCard(card4));
    }

    /**
     * The hand tells accurately whether a particular rank is present.
     */
    @Test
    public void testHandForARankToBePresent() {
        NewHand hand = new NewHandClass();

        hand.accept(card1);
        hand.accept(card2);
        hand.accept(card3);
        hand.accept(card4);

        Rank rank = new RankClass(RANK_NAME_TWO, RANK_PIPS_TWO);
        Rank rank1 = new RankClass(RANK_NAME_KING, RANK_PIPS_KING);
        Rank rank2 = new RankClass(RANK_NAME_ACE, RANK_PIPS_ACE);
        Rank rank3 = new RankClass(RANK_NAME_TWO, RANK_PIPS_ACE);

        assertTrue(hand.hasRank(rank));
        assertFalse(hand.hasRank(rank1));
        assertTrue(hand.hasRank(rank2));
        assertFalse(hand.hasRank(rank3));
    }

    /**
     * The hand tells accurately whether a particular rank is present.
     */
    @Test
    public void testHandForASuitToBePresent() {
        NewHand hand = new NewHandClass();

        hand.accept(card1);
        hand.accept(card2);
        hand.accept(card3);
        hand.accept(card4);

        Suit suit = new SuitClass(SUIT_NAME_CLUBS, SUIT_SYMBOL_CLUBS);
        Suit suit1 = new SuitClass(SUIT_NAME_SPADES, SUIT_SYMBOL_SPADES);
        Suit suit2 = new SuitClass(SUIT_NAME_CLUBS, SUIT_SYMBOL_DIAMONDS);
        Suit suit3 = new SuitClass(SUIT_NAME_DIAMONDS, SUIT_SYMBOL_CLUBS);

        assertTrue(hand.hasSuit(suit));
        assertTrue(hand.hasSuit(suit1));
        assertFalse(hand.hasSuit(suit2));
        assertFalse(hand.hasSuit(suit3));
    }

    /**
     * Method to add suit values to it's map according to it's preference
     */
    private void addSuitValuesToTheMap() {
        suitNameMap.put(SUIT_NAME_CLUBS, 1);
        suitNameMap.put(SUIT_NAME_DIAMONDS, 2);
        suitNameMap.put(SUIT_NAME_HEARTS, 3);
        suitNameMap.put(SUIT_NAME_SPADES, 4);

        suitSymbolMap.put(SUIT_SYMBOL_CLUBS, 1);
        suitSymbolMap.put(SUIT_SYMBOL_DIAMONDS, 2);
        suitSymbolMap.put(SUIT_SYMBOL_HEARTS, 3);
        suitSymbolMap.put(SUIT_SYMBOL_SPADES, 4);
    }

    /**
     * The hand properly sorts the card by suit
     */
    @Test
    public void testSortBySuitForHand() {

        addSuitValuesToTheMap();

        NewHand hand = new NewHandClass();
        hand.accept(card1);
        hand.accept(card2);
        hand.accept(card3);
        hand.accept(card4);

        hand.shuffle();
        hand.sort(SORT_BY_SUIT);


        for (int i = 0; i < hand.showCards().size() - 1; i++) {
            Boolean checkSuitName = suitNameMap.get(hand.showCards().get(i).getSuit().getName()) <= suitNameMap.get(hand.showCards().get(i + 1).getSuit().getName());
            Boolean checkSuitSymbol = suitSymbolMap.get(hand.showCards().get(i).getSuit().getSymbol()) <= suitSymbolMap.get(hand.showCards().get(i + 1).getSuit().getSymbol());
            assertTrue(checkSuitName && checkSuitSymbol);
        }
    }

    /**
     * Method to add rank values to it's map according to it's preference
     */
    private void addRankValuesToTheMap() {
        rankNameMap.put(RANK_NAME_TWO, 2);
        rankNameMap.put(RANK_NAME_THREE, 3);
        rankNameMap.put(RANK_NAME_FOUR, 4);
        rankNameMap.put(RANK_NAME_FIVE, 5);
        rankNameMap.put(RANK_NAME_SIX, 6);
        rankNameMap.put(RANK_NAME_SEVEN, 7);
        rankNameMap.put(RANK_NAME_EIGHT, 8);
        rankNameMap.put(RANK_NAME_NINE, 9);
        rankNameMap.put(RANK_NAME_TEN, 10);
        rankNameMap.put(RANK_NAME_JACK, 11);
        rankNameMap.put(RANK_NAME_QUEEN, 12);
        rankNameMap.put(RANK_NAME_KING, 13);
        rankNameMap.put(RANK_NAME_ACE, 14);
    }

    /**
     * The hand properly sorts the card by rank
     */
    @Test
    public void testSortByRankForHand() {
        NewHand hand = new NewHandClass();

        addRankValuesToTheMap();

        hand.accept(card1);
        hand.accept(card2);
        hand.accept(card3);
        hand.accept(card4);

        hand.shuffle();
        hand.sort(SORT_BY_RANK);

        for(int i=0; i<hand.showCards().size()-1; i++) {
            Boolean checkRankName = rankNameMap.get(hand.showCards().get(i).getRank().getName()) <= rankNameMap.get(hand.showCards().get(i+1).getRank().getName());
            assertTrue(checkRankName);
        }
    }

    /**
     * The hand properly sorts the card by both
     */
    @Test
    public void testSortByBothForHand() {
        NewHand hand = new NewHandClass();

        addRankValuesToTheMap();
        addSuitValuesToTheMap();

        hand.accept(card1);
        hand.accept(card2);
        hand.accept(card3);
        hand.accept(card4);

        hand.shuffle();
        hand.sort(SORT_BY_BOTH);

        for(int i=0; i<hand.showCards().size()-1; i++) {
            Boolean checkSuitName = suitNameMap.get(hand.showCards().get(i).getSuit().getName()) <= suitNameMap.get(hand.showCards().get(i+1).getSuit().getName());
            Boolean checkSuitSymbol = suitSymbolMap.get(hand.showCards().get(i).getSuit().getSymbol()) <= suitSymbolMap.get(hand.showCards().get(i+1).getSuit().getSymbol());
            Boolean checkRankName = rankNameMap.get(hand.showCards().get(i).getRank().getName()) < rankNameMap.get(hand.showCards().get(i+1).getRank().getName());
            Boolean checkRankNameIfEqual = rankNameMap.get(hand.showCards().get(i).getRank().getName()) == rankNameMap.get(hand.showCards().get(i+1).getRank().getName());

            if(checkRankNameIfEqual) {
                assertTrue(checkSuitName && checkSuitSymbol);
            } else {
                assertTrue(checkRankName);
            }
        }
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
     * The hand properly shuffles the cards in it.
     */
    @Test
    public void testHandShuffling() {

        NewHand hand = new NewHandClass();

        hand.accept(card1);
        hand.accept(card2);
        hand.accept(card3);
        hand.accept(card4);
        hand.accept(card1);
        hand.accept(card2);
        hand.accept(card3);
        hand.accept(card4);
        hand.accept(card1);
        hand.accept(card2);
        hand.accept(card3);
        hand.accept(card4);

        List<Card> cardListBeforeShuffling = new ArrayList<>();
        List<Card> cardList = hand.showCards();

        for(Card card : cardList) {
            cardListBeforeShuffling.add(card);
        }

        // Shuffling the cards in hands
        hand.shuffle();
        List<Card> cardListAfterShuffling = hand.showCards();

        // Test to check whether the list of cards is shuffled
        assertTrue(compareTwoCardList(cardListBeforeShuffling, cardListAfterShuffling));
        assertFalse(compareTwoCardList(cardListBeforeShuffling, cardListBeforeShuffling));
    }

    /**
     * Check hand instance of the game interface
     */
    @Test
    public void testGetHands() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);
        game.createDeck(VEGAS);
        game.setNumberOfHands(THREE_NUMBER_OF_HANDS);
        game.getDeck().shuffle();
        game.deal();

        assertTrue(game.getDealerHand() instanceof NewHand);
        assertTrue(game.getPlayerHands().get(0) instanceof NewHand);
        assertTrue(game.getDealerHand() != null);
        assertTrue(game.getPlayerHands() != null);

        game.createDeck(VEGAS);
        game.setNumberOfHands(THREE_NUMBER_OF_HANDS);
        game.getDeck().shuffle();
        game.deal();

        assertTrue(game.getDealerHand() instanceof NewHand);
        assertTrue(game.getPlayerHands().get(0) instanceof NewHand);
        assertTrue(game.getDealerHand() != null);
        assertTrue(game.getPlayerHands() != null);
    }

    /**
     * Deal before setting the number of hands
     */
    @Test(expected = NullPointerException.class)
    public void testDealBeforeSettingHands() {
        GameFactory factory = new GameFactory();
        Game game = new GameClass(factory);
        game.createDeck(VEGAS);
        game.deal();

        List<NewHand> hands = game.getPlayerHands();

        for(NewHand hand : hands) {
            assertTrue(hand.showCards().size() > 0);
        }
    }

    /**
     * Check whether hand has the card
     */
    @Test
    public void testHasHandCard() {
        Rank rank = new RankClass(RANK_NAME_TWO, RANK_PIPS_TWO);
        Suit suit = new SuitClass(SUIT_NAME_DIAMONDS, SUIT_SYMBOL_DIAMONDS);
        Card card = new CardClass(rank, suit);

        Rank rank1 = new RankClass(RANK_NAME_THREE, RANK_PIPS_THREE);
        Suit suit1 = new SuitClass(SUIT_NAME_DIAMONDS, SUIT_SYMBOL_DIAMONDS);
        Card card1 = new CardClass(rank1, suit1);

        Hand hand = new HandClass();
        hand.accept(card);
        assertTrue(hand.hasCard(card));
        assertFalse(hand.hasCard(card1));
    }

    /**
     * Number of card occurrences in hand
     */
    @Test
    public void testNumberOfCardOccurrences() {
        Rank rank = new RankClass(RANK_NAME_TWO, RANK_PIPS_TWO);
        Suit suit = new SuitClass(SUIT_NAME_DIAMONDS, SUIT_SYMBOL_DIAMONDS);
        Card card = new CardClass(rank, suit);

        Rank rank1 = new RankClass(RANK_NAME_THREE, RANK_PIPS_THREE);
        Suit suit1 = new SuitClass(SUIT_NAME_DIAMONDS, SUIT_SYMBOL_DIAMONDS);
        Card card1 = new CardClass(rank1, suit1);

        NewHand hand = new NewHandClass();
        hand.accept(card);
        hand.accept(card);
        hand.accept(card);
        hand.accept(card1);
        hand.accept(card1);

        assertNotEquals(5, hand.occurrencesInHand(card));
        assertNotEquals(0, hand.occurrencesInHand(card));
        assertNotEquals(2, hand.occurrencesInHand(card));
        assertEquals(3, hand.occurrencesInHand(card));
    }

    /**
     * Number of card occurrences in hand
     */
    @Test
    public void testNumberOfRankOccurrences() {
        Rank rank = new RankClass(RANK_NAME_TWO, RANK_PIPS_TWO);
        Suit suit = new SuitClass(SUIT_NAME_DIAMONDS, SUIT_SYMBOL_DIAMONDS);
        Card card = new CardClass(rank, suit);

        Rank rank1 = new RankClass(RANK_NAME_TWO, RANK_PIPS_TWO);
        Suit suit1 = new SuitClass(SUIT_NAME_HEARTS, SUIT_SYMBOL_HEARTS);
        Card card1 = new CardClass(rank1, suit1);

        NewHand hand = new NewHandClass();
        hand.accept(card);
        hand.accept(card);
        hand.accept(card);
        hand.accept(card1);
        hand.accept(card1);

        assertNotEquals(3, hand.occurrencesInHand(rank));
        assertNotEquals(0, hand.occurrencesInHand(rank));
        assertNotEquals(2, hand.occurrencesInHand(rank));
        assertEquals(5, hand.occurrencesInHand(rank));
    }

    /**
     * Number of card occurrences in hand
     */
    @Test
    public void testNumberOfRankOccurrencesWithPipsDifferent() {
        Rank rank = new RankClass(RANK_NAME_TWO, RANK_PIPS_TWO);
        Suit suit = new SuitClass(SUIT_NAME_DIAMONDS, SUIT_SYMBOL_DIAMONDS);
        Card card = new CardClass(rank, suit);

        Rank rank1 = new RankClass(RANK_NAME_TWO, RANK_PIPS_THREE);
        Suit suit1 = new SuitClass(SUIT_NAME_HEARTS, SUIT_SYMBOL_HEARTS);
        Card card1 = new CardClass(rank1, suit1);

        NewHand hand = new NewHandClass();
        hand.accept(card);
        hand.accept(card);
        hand.accept(card);
        hand.accept(card1);
        hand.accept(card1);

        assertNotEquals(5, hand.occurrencesInHand(rank));
        assertNotEquals(0, hand.occurrencesInHand(rank));
        assertNotEquals(2, hand.occurrencesInHand(rank));
        assertEquals(3, hand.occurrencesInHand(rank));
    }

    /**
     * Setting and getting the status of the winner
     */
    @Test
    public void testSettingAndGettingWinnerStatus() {
        NewHand hand = new NewHandClass();
        assertEquals(0, hand.getWinner());
        hand.setWinner(1);
        assertEquals(1, hand.getWinner());
        hand.setWinner(-1);
        assertEquals(-1, hand.getWinner());
    }

    /**
     * Setting and getting the amount of the winner
     */
    @Test
    public void testSettingAndGettingAmount() {
        NewHand hand = new NewHandClass();
        assertEquals(1, hand.getAmount());
        hand.setAmount(100);
        assertEquals(100, hand.getAmount());
        hand.setAmount(-1);
        assertEquals(-1, hand.getAmount());
    }

    /**
     * Setting and getting the parent
     */
    @Test
    public void testSettingAndGettingParent() {
        NewHand hand = new NewHandClass();
        hand.setParent(0);
        assertEquals(0, hand.getParent());
        hand.setParent(6);
        assertEquals(6, hand.getParent());
    }

    /**
     * Calculating the sum of values of card from the hand
     */
    @Test
    public void testCalculateSum() {
        NewHand hand = new NewHandClass();
        hand.accept(card1);
        hand.accept(card2);

        assertEquals(11, hand.calculateHandValue());

        hand.accept(card3);

        assertEquals(19, hand.calculateHandValue());

        hand.accept(card4);

        assertNotEquals(30, hand.calculateHandValue());
        assertEquals(20, hand.calculateHandValue());
    }

    /**
     * Calculating the sum of values of card from the hand
     */
    @Test
    public void testCalculateSumForSplitsAndAcesCombination() {

        Suit suit = new SuitClass(SUIT_NAME_SPADES, SUIT_SYMBOL_SPADES);
        Rank rank1 = new RankClass(RANK_NAME_ACE, RANK_PIPS_ACE);
        Rank rank2 = new RankClass(RANK_NAME_ACE, RANK_PIPS_ACE);
        Rank rank3 = new RankClass(RANK_NAME_NINE, RANK_PIPS_NINE);
        Rank rank4 = new RankClass(RANK_NAME_TEN, RANK_PIPS_TEN);
        Rank rank5 = new RankClass(RANK_NAME_JACK, RANK_PIPS_JACK);
        Card card1 = new CardClass(rank1, suit);
        Card card2 = new CardClass(rank2, suit);
        Card card3 = new CardClass(rank3, suit);
        Card card4 = new CardClass(rank4, suit);
        Card card5 = new CardClass(rank5, suit);

        NewHand hand = new NewHandClass();

        hand.accept(card1);
        hand.accept(card2);

        assertEquals(12, hand.calculateHandValue());

        NewHand hand1 = new NewHandClass();

        hand1.accept(card1);
        hand1.accept(card3);

        assertEquals(20, hand1.calculateHandValue());

        NewHand hand2 = new NewHandClass();

        hand2.accept(card1);
        hand2.accept(card3);

        assertEquals(20, hand2.calculateHandValue());

        NewHand hand3 = new NewHandClass();

        hand3.accept(card4);
        hand3.accept(card5);

        assertEquals(20, hand3.calculateHandValue());

        NewHand hand4 = new NewHandClass();

        hand4.accept(card4);
        hand4.accept(card1);

        assertEquals(21, hand4.calculateHandValue());
    }

    /**
     * Calculating the sum of values of card from the hand
     */
    @Test
    public void testForBlackjackAndBusted() {

        Suit suit = new SuitClass(SUIT_NAME_SPADES, SUIT_SYMBOL_SPADES);
        Rank rank1 = new RankClass(RANK_NAME_ACE, RANK_PIPS_ACE);
        Rank rank2 = new RankClass(RANK_NAME_ACE, RANK_PIPS_ACE);
        Rank rank3 = new RankClass(RANK_NAME_NINE, RANK_PIPS_NINE);
        Rank rank4 = new RankClass(RANK_NAME_TEN, RANK_PIPS_TEN);
        Rank rank5 = new RankClass(RANK_NAME_JACK, RANK_PIPS_JACK);
        Rank rank6 = new RankClass(RANK_NAME_KING, RANK_PIPS_KING);
        Card card1 = new CardClass(rank1, suit);
        Card card2 = new CardClass(rank2, suit);
        Card card3 = new CardClass(rank3, suit);
        Card card4 = new CardClass(rank4, suit);
        Card card5 = new CardClass(rank5, suit);
        Card card6 = new CardClass(rank6, suit);

        NewHand hand = new NewHandClass();

        hand.accept(card1);
        hand.accept(card2);

        assertEquals(12, hand.calculateHandValue());
        assertFalse(hand.hasBlackJack());
        assertFalse(hand.isBusted());

        NewHand hand1 = new NewHandClass();

        hand1.accept(card1);
        hand1.accept(card3);

        assertEquals(20, hand1.calculateHandValue());
        assertFalse(hand1.hasBlackJack());
        assertFalse(hand1.isBusted());

        NewHand hand2 = new NewHandClass();

        hand2.accept(card1);
        hand2.accept(card3);

        assertEquals(20, hand2.calculateHandValue());
        assertFalse(hand2.hasBlackJack());
        assertFalse(hand2.isBusted());

        NewHand hand3 = new NewHandClass();

        hand3.accept(card4);
        hand3.accept(card5);

        assertEquals(20, hand3.calculateHandValue());
        assertFalse(hand3.hasBlackJack());
        assertFalse(hand3.isBusted());

        NewHand hand4 = new NewHandClass();

        hand4.accept(card4);
        hand4.accept(card1);

        assertEquals(21, hand4.calculateHandValue());
        assertTrue(hand4.hasBlackJack());
        assertFalse(hand4.isBusted());

        NewHand hand5 = new NewHandClass();

        hand5.accept(card6);
        hand5.accept(card6);

        assertEquals(20, hand5.calculateHandValue());
        assertFalse(hand5.hasBlackJack());
        assertFalse(hand5.isBusted());

        hand5.accept(card1);
        assertTrue(hand5.hasBlackJack());
        assertFalse(hand5.isBusted());

        hand5.accept(card1);
        assertFalse(hand5.hasBlackJack());
        assertTrue(hand5.isBusted());

    }
}
