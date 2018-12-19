package edu.northeastern.ccs.cs5500;

import edu.northeastern.ccs.cs5500.classes.CardClass;
import edu.northeastern.ccs.cs5500.classes.NewHandClass;
import edu.northeastern.ccs.cs5500.classes.RankClass;
import edu.northeastern.ccs.cs5500.classes.SuitClass;
import edu.northeastern.ccs.cs5500.enums.RankValues;
import edu.northeastern.ccs.cs5500.enums.SuitValues;
import edu.northeastern.ccs.cs5500.interfaces.Card;
import edu.northeastern.ccs.cs5500.interfaces.Iterator;
import edu.northeastern.ccs.cs5500.interfaces.Rank;
import edu.northeastern.ccs.cs5500.interfaces.Suit;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Class that consists of unit tests to test the iterator interfaces and classes
 * @author Srijit
 */
public class IteratorTests {

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

    private List<Card> cards;
    private NewHandClass hand;
    private Iterator<Card> it;

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

    private Rank rank5 = new RankClass(RANK_NAME_THREE, RANK_PIPS_THREE);
    private Suit suit5 = new SuitClass(SUIT_NAME_CLUBS, SUIT_SYMBOL_CLUBS);
    private Card card5 = new CardClass(rank5, suit5);

    @Before
    public void addToCardList() {
        cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);

        hand = new NewHandClass();

        for(Card card : cards){
            hand.accept(card);
        }

        it = hand.iterator();
    }

    @Test
    public void checkCurrentUsingIterator() {
        it.first();
        assertTrue(hand.checkIfCardsAreEqual(it.current(), card1));
    }

    @Test
    public void checkFirstUsingIterator() {
        it.first();
        assertEquals(it.getCardCount(), 0);
    }

    @Test
    public void checkNextUsingIterator() {
        it.first();
        it.next();
        assertEquals(it.getCardCount(), 1);
    }

    @Test
    public void checkGetCardCountUsingIterator() {
        int cardCount=0;
        for(it.first(); !it.isDone(); it.next()){
            cardCount++;
        }
        assertEquals(cardCount, it.getCardCount());
    }

    @Test
    public void checkIsDoneUsingIterator() {
        int cardCount=0;
        for(it.first(); !it.isDone(); it.next()){
            cardCount++;
        }
        assertTrue(it.isDone());
    }
}
