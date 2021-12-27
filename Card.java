/**
 * File: Card.java
 * Author: Tamsin Rogers
 * Date: 2/17/20
 */	

import java.util.ArrayList;
import java.util.Random;

/* holds card information (value of the card) */
public class Card
{
	int value;									//initializes the value integer variable
	Random ran = new Random();					//creates a new random instance

	/* constructor (holds value of card and does range checking) */
	public Card(int v)			
	{ 
		this.value = v;							//hold the value of the card
		if ((v<1) || (v>11))					//if the value is out of range
		{
			System.out.println("error: card value out of range - must be within range 1-11.");
		}
	}

	/* returns the numeric value of the card */
	public int getValue()
	{
		return this.value;						//return the numeric value of the card
	}

	/* returns a string representing the card object & overrides the toString method */
	public String toString()
	{
		return value + " ";						//return the value of the card separated by a space
	}
	
	public static void main(String[] args)		//tests the methods
	{
		Random ran = new Random();				//creates a new random instance
		Card card = new Card(ran.nextInt(11));	//creates a card object with a value between 0 and 10
		System.out.println(card.getValue());	//print the value of the card
		System.out.println(card.toString());	//print the value of the card as a string using the toString method
	}
	
}