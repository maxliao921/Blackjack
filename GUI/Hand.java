package Blackjack;
import java.awt.*;
import java.util.*;

public class Hand{
	public int count = 0;
	private Card[] Hand;
	
	public Hand()
	{
		Hand = new Card[20];
	}
	
	public void setname()
	{
		Scanner reader = new Scanner (System.in);
		String name = reader .next();
	}
	
	public void add(Card card)
	{
		Hand[count++] = card;
	}
	
	public Card getTopCard()
	{
		return Hand[0];
	}
	
	public int valueOf()
	{
		int sum = 0;
		int rank = 0;
		int count2 = count;
		int aces = 0;
		for(int i = 0; i < count2; i++)
		{
			rank = Hand[i].valueOf();
			sum += rank;
			if( rank == 11)
			{
				aces++;
			}
		}
		while (aces > 0 && sum > 21)
		{
			sum -= 10;
			aces--;
		}		
		return sum;
	}
	
	public int bet()
	{
		int amount = 1000;
		return amount;
	}
	
	public boolean hasBlackJack()
	{
		int total = Hand[0].valueOf() + Hand[1].valueOf();
		return total == 21;
	}

	public boolean isBusted()
	{
		return valueOf() > 21;
	}
	
	public String toString()
	{
		String string ="";
		int count3 = count;
		for(int i = 0; i < count3; i++)
		{
			string += Hand[i].toString();
			string += "\n";
		}
		if(isBusted())
		{
			string += "\n\n";
			string += "Bust";
		}
		if(hasBlackJack())
		{
			string += "\n\n";
			string += "Blackjack";
		}
		return string;
	}
	
	public static void main(String[] args){
		Deck deck = new Deck();
		deck.shuffle();
		Hand a = new Hand();
		a.add(deck.nextCard());
		a.add(deck.nextCard());
		a.add(deck.nextCard());
		System.out.println(a.toString());
		System.out.println(a.valueOf());
	}
}
