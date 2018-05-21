package Blackjack;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;

public class BlackjackMain
{
	public Hand player;
	public Hand dealer;
	public Deck deck;
	private int play = 0;
	private int hit = 0;
	public BlackjackGUI GUI;
	private int stand = 0;
	
	public BlackjackMain()
	{
		GUI =  new BlackjackGUI();
		GUI.setPlayAction(new PlayAction());
		GUI.setHitAction(new HitAction());
		GUI.setStandAction(new StandAction());
		GUI.enablePlayButton();
	}
	
	class PlayAction implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			deck = new Deck();
			deck.shuffle();
			player = new Hand();
			dealer = new Hand();
			player.add(deck.nextCard());
			dealer.add(deck.nextCard());
			player.add(deck.nextCard());
			dealer.add(deck.nextCard());
			GUI.displayPlayer(player);
			GUI.displayDealerCard(dealer.getTopCard());
			if(!player.hasBlackJack() && !dealer.hasBlackJack() && !player.isBusted())
			{
				GUI.enableHitAndStandButtons();
			}
			if(player.hasBlackJack() || dealer.hasBlackJack() || player.isBusted())
			{
				finishGame();
			}
		}
	}

	class HitAction implements ActionListener
	{ 
		public void actionPerformed (ActionEvent e)
		{
			if(!player.isBusted() && player.valueOf() != 21)
			{
				player.add(deck.nextCard());
				GUI.displayPlayer(player);
			}
			if(player.isBusted() || player.valueOf() == 21)
			{
				finishGame();
			}
		}
	}
	
	class StandAction implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			finishGame();
		}
	}
	
	private void finishGame()
	{
		if(player.hasBlackJack())
		{
			GUI.displayDealer(dealer);
			GUI.displayPlayer(player);
			GUI.displayOutcome("Win");
		}
		else if (dealer.hasBlackJack() && player.hasBlackJack())
		{
			GUI.displayDealer(dealer);
			GUI.displayPlayer(player);
			GUI.displayOutcome("Push");
		}
		else if(dealer.hasBlackJack())
		{
			GUI.displayDealer(dealer);
			GUI.displayPlayer(player);
			GUI.displayOutcome("Lose");
		}
		else if (player.isBusted())
		{
			GUI.displayDealer(dealer);
			GUI.displayPlayer(player);
			GUI.displayOutcome("Lose");
		}
		else
		{
			while(dealer.valueOf() < 17 && !dealer.isBusted())
			{
				dealer.add(deck.nextCard());
			}
			if(dealer.isBusted())
			{
				GUI.displayDealer(dealer);
		        GUI.displayPlayer(player);
		        GUI.displayOutcome("Win");
		    }
            else if (dealer.hasBlackJack())
            {
			   GUI.displayDealer(dealer);
		       GUI.displayPlayer(player);
		       GUI.displayOutcome("Lose");
			} 
            else if (dealer.valueOf() == player.valueOf())
			{
            	GUI.displayDealer(dealer);
            	GUI.displayPlayer(player);
            	GUI.displayOutcome("Push");
			}
            else if (dealer.valueOf() > player.valueOf())
            {
            	GUI.displayDealer(dealer);
	            GUI.displayPlayer(player);
		   	   	GUI.displayOutcome("Lose");
		   	}
            else if (player.valueOf() > dealer.valueOf())
            {
            	GUI.displayDealer(dealer);
		        GUI.displayPlayer(player);
		        GUI.displayOutcome("Win");
		    }
		}
		GUI.enablePlayButton();
	}	
	
	public static void main(String[] args){
		new BlackjackMain();
	}

}
