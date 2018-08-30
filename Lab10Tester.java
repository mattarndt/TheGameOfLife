package lab10;
import java.util.Scanner;


public class Lab10Tester {
	public static void main(String[] args){
		GameOfLifeBoard g = new GameOfLifeBoard();
		Scanner kb = new Scanner(System.in);
		g.createInitialBoard();
		
		//glider
	
		g.addLiveCell(0, 1);
		g.addLiveCell(1, 2);
		g.addLiveCell(2,0);
		g.addLiveCell(2,1);
		g.addLiveCell(2,2);
		
		
		//g.addLiveCell(3, 3);
		//g.addLiveCell(3, 4);
		//g.addLiveCell(3, 5);
		
		
		
		/*
		System.out.println("This is your initial board:");
		g.printBoard();
		
		g.generateNextStep();
		g.printBoard();
		g.generateNextStep();
		g.printBoard();
		*/
		
		System.out.println("This is your initial board:");
		System.out.println("Press Spacebar to go to next step, press 'q' to quit");
		System.out.println();
		g.printBoard();
		
		boolean done = false;
		
		
		while(!done){
			String input = kb.nextLine();
			String donzo = "q";
			String keepGoing = " ";
			if(input.equals(donzo)){
				done = true;
			}
			if (input.equals(keepGoing)){
				g.generateNextStep();
				g.printBoard();
			} 
		}
		
		kb.close();
	}
}
