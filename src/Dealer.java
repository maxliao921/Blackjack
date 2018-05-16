package Blackjack;
import java.util.ArrayList;
import java.util.Arrays;

// Creates the dealer
class Dealer {
    // Variables
    ArrayList<Card> hand; // The dealer's hand
    private int handvalue = 0; // Value of dealer's hand
    private Card[] aHand; // Convert the dealer's hand to an array
    private int AceCounter; // Counts aces in dealer's hand

    Dealer(Deck deck)
    {
        hand = new ArrayList<>();
        aHand = new Card[]{};
        int AceCounter = 0;
        for (int i = 0; i < 2; i++)
        {
            hand.add(deck.drawCard());
        }
        aHand = hand.toArray(aHand);
        for(int i = 0; i < aHand.length; i++)
        {
            handvalue += aHand[i].getValue();
            if(aHand[i].getValue() == 11)
            {
                AceCounter++;
            }
            while(AceCounter > 0 && handvalue > 21)
            {
                handvalue -= 10;
                AceCounter--;
            }
        }
    }

    // Prints out dealer's first card
    public void showFirstCard()
    {
        Card[] firstCard = new Card[]{};
        firstCard = hand.toArray(firstCard);
        System.out.println("["+firstCard[0]+"]");
    }

    // Gives dealer another card, updates value
    public void Hit(Deck deck)
    {
        hand.add(deck.drawCard());
        aHand = hand.toArray(aHand);
        handvalue = 0;
        for(int i = 0; i < aHand.length; i++)
        {
            handvalue += aHand[i].getValue();
            if(aHand[i].getValue() == 11)
            {
                AceCounter++;
            }
            while(AceCounter > 0 && handvalue > 21)
            {
                handvalue -= 10;
                AceCounter--;
            }
        }
    }

    // Determines whether dealer wants to hit or not
    public boolean wantsToHit()
    {
        if(handvalue < 17)
        {
            return true;
        }
        return false;
    }

    // Message when dealer has 21
    public boolean hasBlackJack()
    {
        if(hand.size() == 2 && handvalue == 21)
        {
            System.out.println("The dealer has blackjack!");
            return true;
        }
        return false;
    }

    // Print dealer's hand
public void showHand()
{
    System.out.println(hand);
}
/*
 * Returns the value of the dealer's hand.
 */
public int getHandValue()
{
    return handvalue;
}
/*
 * Determines if a dealer has busted.
 */
public boolean busted(int handvalue)
{
    if(handvalue>21)
    {
        System.out.println("The dealer busted!");
        return true;
    }
    return false;
}
/*
 * Takes the turn for the dealer and returns the value of his hand.
 */
public int takeTurn(Deck deck)
{
    while(wantsToHit())
    {
        System.out.println("The dealer hits");
        Hit(deck);
        if(busted(handvalue))
        {
            break;
        }
    }
    if(handvalue<=21)
    {
        System.out.print("The dealer stands.");
    }
    return handvalue;
}
}
