/**
 * File: Hand.java
 * Author: Tamsin Rogers
 * Date: 2/17/20
 */

import java.util.ArrayList;
import java.util.Random;

/* holds a set of cards */
public class Hand
{
	ArrayList<Card> hand = new ArrayList<Card>();		//initializes the hand as an ArrayList of type card
	Random ran = new Random();							//creates a new random instance

	/* initializes the ArrayList */
	public Hand()
	{
		this.hand = hand;								//builds an integer array list for the hand
	}

	/* resets the hand to be empty */
	public void reset()
	{
		hand.clear();									//clears the ArrayList
	}

	/* adds the card object to the hand */
	public void add(Card card)
	{
		hand.add(card);									//add the card object to the hand ArrayList
	}

	/* returns the number of cards in the hand */
	public int size()
	{
		return hand.size();							
	}

	/* returns the card located at the index i */
	public Card getCard(int i)
	{
		return hand.get(i);
	}

	/* returns the total sum of the values of the current cards in the hand */
	public int getTotalValue()
	{
		int sum = 0;									//initialize the sum variable integer
		int length = hand.size();						//initialize the length variable integer to be the size of the hand ArrayList
		Card get;										//initialize the card object get
	
		for (int i=0; i<length; i++)					//loops through the hand
		{
			get = hand.get(i);							//set the card object get to be the card at index i
			int x = get.getValue();						//set the variable integer x to be the value of the card get
			sum = sum + x;								//add the value of each card to the sum
		}
	
		return sum; 									//return the total sum of the values of the current cards in the hand
	}

	/* returns a string holding what is in the hand */
	public String toString()
	{
		int length = hand.size();						//set the variable integer length to be the size of the hand ArrayList
		String total = "";								//initialize the string total
	
		for (int i=0; i<length; i++)					//loop through the hand
		{
			int theValue = this.hand.get(i).getValue();	//set the variable integer to be the value of the card at index i
			
			total = (total + theValue + ", ");			//update the string
		}
	
		return total;									//return the total value of the hand as a string
	}	
	
	/* the main function */
	public static void main ( String[] args )			//tests the methods
	{ 
		Hand hand = new Hand();							//initialize a new hand
		for (int i=0; i<10; i++)						//add 10 cards to the hand
		{
			Random ran = new Random();					//creates a new random instance
			Card card = new Card(ran.nextInt(11));		//creates a card object with a value between 0 and 10
			hand.add(card);								//add the card object to the hand
		}
		System.out.println(hand.toString());
		System.out.println("SIZE OF HAND: " + hand.size());
		System.out.println("CARD AT INDEX 5: " + hand.getCard(5));
		System.out.println("TOTAL VALUE OF HAND: " + hand.getTotalValue());								
	}

}