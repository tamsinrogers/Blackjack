/**
 * File: Simulation.java
 * Author: Tamsin Rogers
 * Date: 2/17/20
 */

import java.util.ArrayList;
import java.util.Random;

/* simulates 1000 games */
public class Simulation
{
	/* the main function */
	public static void main ( String[] args )	
	{ 

		Blackjack blackjack = new Blackjack(26);	//set up a new game
	
		Double dealerWins = 0.0;					//initialize the counter variables
		Double playerWins = 0.0;
		Double ties = 0.0;
	
		Double playerWinPercentage = 0.0;			//initialize the percentage variables
		Double dealerWinPercentage = 0.0;
		Double tiePercentage = 0.0;
		
		for(int i=0; i<1000; i++)					//repeat 1000 times
		{
			int theGame = blackjack.game(true);
			
			if (theGame == -1)						//if the dealer wins a game
			{
				dealerWins = dealerWins + 1;		//increment the number of dealer wins
			}
			else if (theGame == 1)					//if the player wins a game
			{
				playerWins = playerWins + 1;		//increment the number of player wins
			}
			else									//if a tie occurs (theGame==0)
			{
				ties = ties + 1;					//increment the tie counter
			}
		}
		
		dealerWinPercentage = dealerWins/10;		//calculate the percentage that the dealer won
		playerWinPercentage = playerWins/10;		//calculate the percentage that the player won
		tiePercentage = ties/10;					//calculate the tie percentage
	
		//print the resulting raw numbers and percentages 
		System.out.println("The dealer won " + dealerWins + " times.");
		System.out.println("The dealer's win percentage is: " + dealerWinPercentage + "%.");
		System.out.println("The player won " + playerWins + " times.");
		System.out.println("The player's win percentage is: " + playerWinPercentage + "%.");
		System.out.println("The game resulted in a tie " + ties + " times.");
		System.out.println("The tie percentage is: " + tiePercentage + "%.");
	}
}