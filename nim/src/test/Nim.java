package test;
import static java.lang.System.out;

import java.util.Scanner;

public class Nim {

	//initialization
	private String player1;
	private String player2;
	
	//random stuff
	private String curPlayer;
	private String otherPlayer;
	private String winner;
	private String loser;
	private boolean cheating;
	private boolean womp;
	
	//returnCount
	private int aNumber;
	private int bNumber;
	private int cNumber;
	private int largestNum;
	private String asteriskCount;
	private String aAsterisk;
	private String bAsterisk;
	private String cAsterisk;
	private String image;

	
	
	
	
	public Nim (String name1, String name2)
	{
		player1 = name1;
		player2 = name2;
		aNumber = (int)(Math.random() * 9) + 1;
		bNumber = (int)(Math.random() * 9) + 1;
		cNumber = (int)(Math.random() * 9) + 1;
		cheating = false;
	}
	
	
	public String cheatPileChecker(String pile)
	{
		if(pile.equals("a") && aNumber == 0)
		{
			cheating = true;
			return "Nice try " + curPlayer + " that pile was empty choose again: ";
		}
		
		if(pile.equals("b")&& bNumber == 0)
		{
			cheating = true;
			return "Nice try " + curPlayer + " that pile was empty choose again: ";
		}
		
		if(pile.equals("c")&& cNumber == 0)
		{
			cheating = true;
			return "Nice try " + curPlayer + " that pile was empty choose again: ";
		}
		
		cheating = false;
		
		return "";
	}
	
	
	public String cheatNumberCheck(int number, String pile, int playerNum)
	{
		if(playerNum == 2)
			curPlayer = player1;
		
		else
			curPlayer = player2;
		
		
		if(number <= 0)
		{
			cheating = true;
			return "Nice try " + curPlayer + " You must choose at least one. How Many? ";
		}
		
		if(pile.equals("a") && number > aNumber)
		{
			cheating = true;
			return "Pile A doesn't have that many. Try again: ";		
		}
	
		if(pile.equals("b") && number > bNumber )
		{
			cheating = true;
			return "Pile B doesn't have that many. Try again: ";		
		}
	
		if(pile.equals("c") && number > cNumber)
		{
			cheating = true;
			return "Pile C doesn't have that many. Try again: ";		
		}
		
		cheating = false;
		
		return "";
	}
	
	public boolean checkCheating()
	{
		return cheating;
	}
	
	public String removeCounters (int number, String pile)
	{
		//actual game	
		if(pile.equals("a") && number > 0 && number <= aNumber)
		{
			cheating = false;
			aNumber -= number;
		}
		
		if(pile.equals("b") && number > 0 && number <= bNumber )
		{
			cheating = false;
			bNumber -= number;
		}
		
		if(pile.equals("c") && number > 0 && number <= cNumber)
		{
			cheating = false;
			cNumber -= number;
		}
			
		
		return "";
		
	}
	
	
	public boolean isWinner(int playerNum)
	{
		if(playerNum == 2)
			{
				curPlayer = player1;
				otherPlayer = player2;
			}
		
		else
			{
				curPlayer = player2;
				otherPlayer = player1;
			}
		
		
		
		if(aNumber == 1 && bNumber == 0 && cNumber == 0)
			{
				womp = false;
				winner = otherPlayer;
				loser = curPlayer;
				return false;
			}
		
		else if(aNumber == 0 && bNumber == 1 && cNumber == 0)
			{
				womp = false;
				winner = otherPlayer;
				loser = curPlayer;
				return false;
			}
		
		if(aNumber == 0 && bNumber == 0 && cNumber == 1)
			{
				womp = false;
				winner = otherPlayer;
				loser = curPlayer;
				return false;
			}
		
		if(aNumber == 0 && bNumber == 0 && cNumber == 0)
			{
				womp = true;
				loser = otherPlayer;
				winner = curPlayer;
				return false;
			}
		
		else
			return true;
	}
	
	public String returnWinner()
	{
		if(womp)
		{
			return winner + ", there are no counters left, so you WIN!";
		}
		
		else
			return loser + ", you must take the last remaining counter, so you lose. " + winner + " WINS!!";
	}
	
	
	
	public String returnCounters()
	{
		image = "";
		
		if(aNumber >= bNumber && aNumber > cNumber)
			largestNum = aNumber;
		
		else if(bNumber > aNumber && bNumber > cNumber)
			largestNum = bNumber;
		
		else
	
			largestNum = cNumber;
		
		for(int i = largestNum; i > 0; i--)
		{
				aAsterisk = " ";

				bAsterisk = " ";
			
				cAsterisk = " ";
			
			//yes asterisk
			if(i <= aNumber)
			{
				aAsterisk = "*";
			}
			
			if(i <= bNumber)
			{
				bAsterisk = "*";
			}
			
			if(i <= cNumber)
			{
				cAsterisk = "*";
			}
			
			image = image + "    " + aAsterisk + " " + bAsterisk + " " + cAsterisk + "\n";
			
		}
		
		image = image + "    " + "A " + "B " + "C" + "\n" + "  " + "(" + aNumber + ")(" + bNumber + ")(" + cNumber + ")";
		
		
		return "\n" + image + "\n";
		
		
		
		//horizontal view
		/*asteriskCount = "";
		
		for(int i = 0; i < aNumber; i++)
		{
			asteriskCount = asteriskCount + "*";
		}	
		
			aAsterisk = "A: " + asteriskCount + " (" + aNumber + ")";
			asteriskCount = "";

		for(int i = 0; i < bNumber; i++)
		{
			asteriskCount = asteriskCount + "*";
		}
			
			bAsterisk = "B: " + asteriskCount + " (" + bNumber + ")";
			asteriskCount = "";
			
		for(int i = 0; i < cNumber; i++)
		{
			asteriskCount = asteriskCount + "*";
		}
			
			cAsterisk = "C: " + asteriskCount + "(" + cNumber + ")";
			
			
			return aAsterisk + "\n" + bAsterisk + "\n" + cAsterisk;*/
		
		
	
		
		//return "\n" + "A: " + aNumber + "\t" + "B: " + bNumber + "\t" + "C: " + cNumber; //just numbers
		
	}
	
	
	public String computerEnemy()
	{
		int howMany = 0;
		int choosePile = 0;
		int randomCounters = 0;
		String pileName = "";
		
		if(aNumber > 0)
			howMany++;
		
		if(bNumber > 0)
			howMany++;
		
		if(cNumber > 0)
			howMany++;
		
		choosePile = (int)(Math.random() * howMany) + 1;

		
		
		if(aNumber > 0 && choosePile == 1)
			{
				randomCounters = (int)(Math.random() * aNumber) + 1;
				
				if(bNumber == 0 && cNumber == 0)
					randomCounters = aNumber - 1;
				
				aNumber -= randomCounters;
				pileName = "A";
			}
		
		else if(bNumber > 0 && choosePile == 1 || bNumber > 0 && choosePile == 2)
			{
				randomCounters = (int)(Math.random() * bNumber) + 1;
				
				if(aNumber == 0 && cNumber == 0)
					randomCounters = bNumber - 1;
				
				bNumber -= randomCounters;
				pileName = "B";
			}
		
		else if(cNumber > 0 && choosePile == 1 || cNumber > 0 && choosePile == 2 || cNumber > 0 && choosePile == 3)
			{			
				randomCounters = (int)(Math.random() * cNumber) + 1;
				
				if(aNumber == 0 && bNumber == 0)
					randomCounters = cNumber - 1;
				
				cNumber -= randomCounters;
				pileName = "C";
			}
		
		
		
		return returnCounters() + "\n" + "Computer choose pile " + pileName + " and took away " +  randomCounters + "\n";
	}
	
	
}
