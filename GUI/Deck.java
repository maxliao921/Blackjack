package Blackjack;
import java.awt.*;
import java.util.*;

public class Deck{
	private Card[] DeckArray = new Card[52];
	private int index = 0;
	
	// Set up deck
	public Deck()
	{
		int index2 = 0;
		for(int i =0; i<4; i++)
		{
			for(int j=0; j<13; j++)
			{
				Card a = new Card(i,j);
				DeckArray[index2] = a;
				index2++;
			}
		}
	}
	
	// Shuffle deck
	public void shuffle(){
		index = 0;
		int counter = 0;
		while (counter < 1000)
		{
			Random rand = new Random();
			int x = rand.nextInt(52);
			int y = rand.nextInt(52);
			Card temp = DeckArray[x];
			DeckArray[x] = DeckArray[y];
			DeckArray[y] = temp;
			counter++;
		}
	}
	
	public boolean hasNextCard()
	{
		return index < 52;
	}
	
	public Card nextCard()
	{
		if(index < 52)
		{
			index++;
			return DeckArray[index-1];
		}
		else
		{
			return null;
		}
	}
	
	public static void main(String[] args){
		Deck a = new Deck();
		System.out.println(a.toString());
		while(a.hasNextCard())
		{
			System.out.println(a.nextCard());
		}
		a.shuffle();
		System.out.println(a.toString());
		int counter = 0;
		while(a.hasNextCard())
		{
			System.out.println(a.nextCard());
		}
	}
}
