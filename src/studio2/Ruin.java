package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		int totalSimulations = 500;
		int startAmount = 2;
		double winChance = 0.7;
		int winLimit = 500;
		int wins = 0;
		int losses = 0;
		double alpha = (1-winChance)/winChance; 
		double expectedRuinRate;
		if(winChance == 0.5)
			expectedRuinRate = (1.0-startAmount)/winLimit;
		else
			expectedRuinRate = (Math.pow(alpha, startAmount) - Math.pow(alpha, winLimit))/(1-Math.pow(alpha, winLimit));
			
		
		for(int i = 1; i <= totalSimulations; i++) {
				
			int newAmount = startAmount;
			while(newAmount > 0 && newAmount < winLimit) {
				double chance = Math.random();
				if(chance <= winChance)
					newAmount++;
				else
					newAmount--;
			}
			if(newAmount >= winLimit) {
				wins++;
				System.out.println("Simulation " + i + ": WIN");
			}
			else {
				losses++;
				System.out.println("Simulation " + i + ": LOSE");
			}
		}
		System.out.println("Losses: " + losses + " Simulations: " + totalSimulations);
		double ruinRateSimulation = (double)losses/totalSimulations;
		System.out.println("Ruin Rate from Simulation: "  + ruinRateSimulation + " Expected Ruin Rate: " + expectedRuinRate);
		
	}
}