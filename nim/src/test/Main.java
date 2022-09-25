package test;
import java.util.Scanner;

import static java.lang.System.*;

/**
 * @author party
 *
 */
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Scanner kb = new Scanner(System.in);
		
		
		out.print("Enter player 1 name: ");
		String player1 = kb.nextLine();
		
		out.print("Play Aganist computer? (yes/no): ");
		String computer = kb.nextLine();

		
		if(computer.equals("no"))
		{
		out.print("Enter player 2 name: ");
		String player2 = kb.nextLine();
		
		
		Nim game1 = new Nim(player1, player2);
		
		
		out.println(game1.returnCounters());
		
		
		
		while( game1.isWinner(2) )
		{	
			
			//start of player 1 turn 
			out.print(player1 + " choose a pile: ");
			String pileChoose = kb.next();
			out.print(game1.cheatPileChecker(pileChoose));
			

			while(game1.checkCheating())
			{
				 pileChoose = kb.next();
				out.print(game1.cheatPileChecker(pileChoose));
			}
			
			
			out.print("How many to remove from pile " + pileChoose + ": ");
			int howManyCounters = kb.nextInt();
			out.print(game1.cheatNumberCheck(howManyCounters, pileChoose, 1));
			
			while(game1.checkCheating())
			{
				 howManyCounters = kb.nextInt();
				out.print(game1.cheatNumberCheck(howManyCounters, pileChoose, 1));
			}
			
			
			game1.removeCounters(howManyCounters, pileChoose);
			
			
			out.println(game1.returnCounters());
			
			if(game1.isWinner(1) == false)
				break;
			
			
			
			//start of player2 turn
			out.print(player2 + " choose a pile: ");
			String pileChoose2 = kb.next();
			out.print(game1.cheatPileChecker(pileChoose2));
			
			while(game1.checkCheating())
			{
				 pileChoose2 = kb.next();
				out.print(game1.cheatPileChecker(pileChoose2));
			}
			

			
			out.print("How many to remove from pile " + pileChoose2 + ": ");
			int howManyCounters2 = kb.nextInt();
			out.println(game1.cheatNumberCheck(howManyCounters2, pileChoose2, 2));
			
			while(game1.checkCheating())
			{
				 howManyCounters2 = kb.nextInt();
				out.print(game1.cheatNumberCheck(howManyCounters2, pileChoose2, 2));
			}
			
		
			game1.removeCounters(howManyCounters2, pileChoose2);
			
			out.println(game1.returnCounters());
			
			if(game1.isWinner(2) == false)
				break;
			

		}
		
		out.println(game1.returnWinner());
		}
		
		
		
		else
		{
			Nim game1 = new Nim(player1, "Computer");
			
			out.println(game1.returnCounters());
			
			while(game1.isWinner(1))
			{
			
			out.print(player1 + " choose a pile: ");
			String pileChoose = kb.next();
			out.print(game1.cheatPileChecker(pileChoose));
			

			while(game1.checkCheating())
			{
				 pileChoose = kb.next();
				out.print(game1.cheatPileChecker(pileChoose));
			}
			
			
			out.print("How many to remove from pile " + pileChoose + ": ");
			int howManyCounters = kb.nextInt();
			out.print(game1.cheatNumberCheck(howManyCounters, pileChoose, 1));
			
			while(game1.checkCheating())
			{
				 howManyCounters = kb.nextInt();
				out.print(game1.cheatNumberCheck(howManyCounters, pileChoose, 1));
			}
			
			
			game1.removeCounters(howManyCounters, pileChoose);
			
			
			out.println(game1.returnCounters());
			
			if(game1.isWinner(1) == false)
				break;
			
			out.println(game1.computerEnemy());
			
			if(game1.isWinner(2) == false)
				break;
		}

		
		out.println(game1.returnWinner());

		}
		
}
}


