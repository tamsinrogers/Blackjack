/**
 * File: Deck.java
 * Author: Tamsin Rogers
 * Date: 2/17/20
 */	

import java.util.ArrayList;
import java.util.Random;

/* holds a set of cards, shuffles and deals the cards */
public class Deck
{
	Random ran = new Random();									//creates a new random instance
	ArrayList<Card> deck = new ArrayList<Card>();				//initializes the deck as an ArrayList of type card
		
	/* builds a 52 card deck that has 4 cards with the values 2-9 and 1, and 16 cards with the value 10 */
	public Deck()
	{
		build();												//call the build function
	}

	/* builds a 52 card deck that has 4 cards with the values 2-9 and 1, and 16 cards with the value 10 */
	public void build()
	{
	
		for (int i=0; i<4; i++) 								//add 4 cards of value 2 to the deck
		{
			Card card = new Card(2);	
			deck.add(card);
		}
		
		for (int i=0; i<4; i++)									//add 4 cards of value 3 to the deck
		{	
			Card card = new Card(3);	
			deck.add(card);
		}
		
		for (int i=0; i<4; i++)									//add 4 cards of value 4 to the deck
		{
			Card card = new Card(4);	
			deck.add(card);
		}
		
		for (int i=0; i<4; i++)									//add 4 cards of value 5 to the deck
		{
			Card card = new Card(5);	
			deck.add(card);
		}
		
		for (int i=0; i<4; i++)									//add 4 cards of value 6 to the deck
		{
			Card card = new Card(6);	
			deck.add(card);
		}
		
		for (int i=0; i<4; i++)									//add 4 cards of value 7 to the deck
		{
			Card card = new Card(7);	
			deck.add(card);
		}
		
		for (int i=0; i<4; i++)									//add 4 cards of value 8 to the deck
		{
			Card card = new Card(8);	
			deck.add(card);
		}
		
		for (int i=0; i<4; i++)									//add 4 cards of value 9 to the deck
		{
			Card card = new Card(9);	
			deck.add(card);
		}
		
		for (int i=0; i<4; i++)									//add 4 cards of value 1 to the deck
		{
			Card card = new Card(1);	
			deck.add(card);
		}
	
		for (int i=0; i<16; i++)								//add 16 cards of value 10 to the deck
		{
			Card card = new Card(10);
			deck.add(card);
		}
	}

	/* returns the total number of cards in the deck */
	public int size()
	{
		return deck.size();										//return the size of the deck (number of cards in it)
	}

	/* returns the top card and removes it from the deck */
	public Card deal()
	{
		Card x = deck.get(0);									//retrieve the first card in the deck, save it to x
		deck.remove(0);											//remove the first card in the deck
		return x;												//return the first card in the deck
	}

	/* returns the card at position i and removes it from the deck */
	public Card pick (int i)
	{
		Card x = deck.get(i);									//retrieve the card at index i in the deck, save it to x
		deck.remove(x);											//remove the selected card
		return x;												//return the selected card
	}

	/* shuffles the deck */
	public void shuffle()
	{
		for (int x=0; x<52; x++)								//repeat 52 times
		{
			int length = deck.size();							//update the new size of the deck, save value to the variable length
			for (int i = 0; i<length; i++)						//repeat for the size of the deck
			{
				Card current = deck.get(i);						//save the card at index i to "current"
				int randomIndex = i + ran.nextInt(length-i);	//generate a random index
				deck.set(i, deck.get(randomIndex));				//retrieve a randomindex for the card at position i
				deck.set(randomIndex, current);					//set the selected card to the randomly generated position
			}
		}
	}

	/* returns a string holding what is in the deck */
	public String toString()
	{
		return ("contents of the deck: " + deck + ", ");
	}
	
	/* the main function */
	public static void main ( String[] args )					//tests the methods
	{ 
		Deck deck = new Deck();									//build a new deck
		System.out.println("ORIGINAL DECK: " + deck);			//original deck
		System.out.println("SIZE OF THE DECK: " + deck.size());	//original deck size
		deck.shuffle();											//shuffle the deck
		System.out.println("SHUFFLED DECK: " + deck);			//shuffled deck
		System.out.println("SIZE OF THE DECK: " + deck.size());	//shuffled deck size (make sure it is the same)
		System.out.println("DEALT CARD: " + deck.deal());		//deal the first card out of the deck
	}
}