/**
 * File: Blackjack.java
 * Author: Tamsin Rogers
 * Date: 2/17/20
 */	

import java.util.ArrayList;
import java.util.Random;

/* implements the card game */
public class Blackjack
{
	Deck deck = new Deck();												//initialize a new deck
	Hand playerHand = new Hand();										//initialize a new hand for the player
	Hand dealerHand = new Hand();										//initialize a new hand for the dealer
	int reshuffleCutoff;												//initialize the reshuffleCutoff integer variable

	/* constructor: store the reshuffleCutoff and sets up a game */
	public Blackjack(int reshuffleCutoff)
	{
		this.reshuffleCutoff = reshuffleCutoff;							//store the reshuffleCutoff variable
		deck.shuffle();													//shuffle the deck
		reset();														//reset the game to set it up
	}

	/* resets the game */
	public void reset()
	{
		playerHand.reset();												//reset (clear) the player's hand
		dealerHand.reset();												//reset (clear) the dealer's hand
		
		if (deck.size() < reshuffleCutoff)								//if the size of the deck goes below the reshuffleCutoff (26)
		{
			Deck newDeck = new Deck();									//build a new deck
			newDeck.shuffle();											//shuffle the new deck
			this.deck = newDeck;										//set the contents of newDeck to the deck
		}
	}

	/* deals out two cards to both players from the deck */
	public void deal()
	{
		for (int i = 0; i<2; i++)										//repeat 2 times
		{								
			Card playerCard = deck.pick(i);								//pick a card out of the deck
			playerHand.add(playerCard);									//add the card to the dealer's hand
		}
		for (int i = 0; i<2; i++)										//repeat 2 times
		{
			Card dealerCard = deck.pick(i);								//pick a card out of the deck
			dealerHand.add(dealerCard);									//add the card to the dealer's hand
		}
	}

	/* player draws cards until the total value of the player's hand >= 16
		returns false if the value of the player's hand goes over 21 (bust) */
	public boolean playerTurn()
	{
		if (playerHand.getTotalValue() < 17)							
		{
			return true;
		}
		
		if (playerHand.getTotalValue() > 21)							
		{
			return false;
		}
		
		else
		{
			return false;
		}
	}

	/* dealer draws cards until the total value of the dealer's hand is >= 17
		returns false if the dealer's hand goes over 21 (bust) */
	public boolean dealerTurn()
	{
		if (dealerHand.getTotalValue() < 17)
		{
			return true;
		}
	
		if (dealerHand.getTotalValue() > 21)							
		{
			return false;
		}
		
		else
		{
			return false;
		}
	}

	/* assigns the new cutoff value to the internal reshuffle cutoff field */
	public void setReshuffleCutoff(int reshuffleCutoff)
	{
		reshuffleCutoff = this.reshuffleCutoff;
	}

	/* returns the current value of the reshuffle cutoff field */
	public int getReshuffleCutoff()
	{
		return this.reshuffleCutoff;
	}

	/* returns a string holding the current player and dealer hands, along with the current total value of each hand */
	public String toString()
	{
		return ("player hand: " + playerHand.toString() + "(total value = " + playerHand.getTotalValue() + ") " + "dealer hand: " + dealerHand.toString() + "(total value = " + dealerHand.getTotalValue() + ")");
	}
	
	/*  plays a single game of Blackjack
		calls the reset method at the start of each game
		returns: -1 (if dealer wins), 1 (if player wins), 0 (if tie) */
	public int game(boolean verbose)
	{
		reset();														//call the reset method at the start of each game

		playerHand.add(deck.deal());									//deal 2 cards to each hand
		dealerHand.add(deck.deal());
		playerHand.add(deck.deal());
		dealerHand.add(deck.deal());
		
		//INITIAL VALUES
		Hand initialPlayerHand = playerHand;							//save the player's initial hand
		int intialPlayerHandValue = playerHand.getTotalValue();			//calculate the initial value of the player's hand
		Hand initialDealerHand = dealerHand;							//save the dealer's initial hand
		int initialDealerHandValue = dealerHand.getTotalValue();		//calculate the initial value of the dealer's hand
		
		if(verbose)
		{
			System.out.println("INITIAL game state: " + this.toString());//print the initial state of the game
		}
		
		while(playerTurn() == true)										//choose whether to take a card or stop at the current value
		{
			playerHand.add(deck.deal());
		}
		
		while(dealerTurn() == true)										//choose whether to take a card or stop at the current value
		{
			dealerHand.add(deck.deal());
		}
		
		//FINAL VALUES
		Hand finalPlayerHand = playerHand;								//save the player's final hand
		int finalPlayerHandValue = playerHand.getTotalValue();			//calculate the final value of the player's hand
		Hand finalDealerHand = dealerHand;								//save the dealer's final hand
		int finalDealerHandValue = dealerHand.getTotalValue();			//calculate the final value of the dealer's hand
		
		if(verbose)
		{
			System.out.println("FINAL game state: " + this.toString());	//print the final state of the game
		}
		
		int result = 0;
		
		// GAME RESULTS
		if (finalPlayerHandValue>21)									//dealer wins (player busts)
			{
				if(verbose)
				{
					System.out.println("Dealer wins.");					//print the winner
				}
				result = -1;
				return result;											//return the appropriate value for a dealer win
			}
		 
		 else if (finalDealerHandValue>21)								//player wins (dealer busts)
			{
				if(verbose)
				{
					System.out.println("Player wins.");					//print the winner
				}
				result = 1;
				return result;											//return the appropriate value for a player win
			}
		
		else if (finalPlayerHandValue == finalDealerHandValue)  		//push (tie)
			{
				if(verbose)
				{
					System.out.println("It's a tie!");
				}
				result = 0;
				return result;											//return the appropriate value for a dealer win
			}
		
		else 															//if values are between 17 and 21
		{
			if (finalPlayerHandValue > finalDealerHandValue)			//if the player's hand value is higher
			{
				if(verbose)
				{
					System.out.println("Player wins.");					//print the winner
				}
				result = 1;												//return the appropriate value for a player win
				return result;
			}
			
			else														//if the dealer's hand value is higher
			{
				if(verbose)
					{
						System.out.println("Dealer wins.");				//print the winner
					}
					result = -1;
					return result;										//return the appropriate value for a dealer win
			}
		}
	}
			
	/* the main function */
	public static void main ( String[] args )							//test the methods
	{ 
		Blackjack blackjack = new Blackjack(26);						//set up a new game
		for(int i=0; i<3; i++)											//run 3 games
		{
			blackjack.game(true);
		}
	}
}