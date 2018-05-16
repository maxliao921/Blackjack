package Blackjack;
import java.util.*;

// Creates playing card
class Card {
    // Variables
    private int rank;//represents the rank of a card
    private int suit;//represents the suit of a card
    private int value;//represents the value of a card
    private static String[] ranks = {"Joker","Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
    private static String[] suits = {"Clubs","Diamonds","Hearts","Spades"};

    // Constructor
    Card(int suit, int values)
    {
        this.rank = values;
        this.suit = suit;
    }

    // Returns card as string
    public String toString()
    {
        return ranks[rank] + " of " + suits[suit];
    }
    
    // Returns card rank
    public int getRank()
    {
        return rank;
    }
    
    // Returns card suit
    public int getSuit()
    {
        return suit;
    }

    // Returns value of card, 11 for jack, queen, king, or ace
    public int getValue()
    {
        if (rank > 10)
        {
            value = 10;
        }
        else if (rank == 1)
        {
            value = 11;
        }
        else
        {
            value = rank;
        }
        return value;
    }

    // Sets card value
    public void setValue(int set)
    {
        value = set;
    }

}
