package lab10;

import java.util.Arrays;
import java.util.Scanner;


public class GameOfLifeBoard {

	char[][] board;
	private char[][] nextBoard;
	public static final char LIVE = 'X';
	public static final char DEAD = '^';
	
	
	public GameOfLifeBoard(){
		this.board = new char[10][10];
		this.nextBoard = new char[10][10];
	}
	
	public void createInitialBoard(){
		for(int rowb = 0; rowb <= 9; rowb++){
			for (int colb = 0; colb <= 9; colb++){
				board[rowb][colb] = DEAD;	
				
				}
			}
	}
	public boolean isLive(int row, int col){
		if(board[row][col] == LIVE){
			return true;
		}
		return false;
	}
	
	public int getNeighborCount(int row, int col){
		int numNeighbors = 0;
		try{
			if(board[row - 1][col - 1] == LIVE){
				numNeighbors++;}
		}
		catch(IndexOutOfBoundsException e) {	
		}
		
		try{
			if (board[row - 1][col] == LIVE){
				numNeighbors++;}
		}
		catch(IndexOutOfBoundsException e) {
		}

		try{
			if (board[row - 1][col + 1] == LIVE){
				numNeighbors++;}
		}
		catch(IndexOutOfBoundsException e) {
		}
		
		try{
			if (board[row][col - 1] == LIVE){
				numNeighbors++;}
		}
		catch(IndexOutOfBoundsException e) {
		}
		
		try{
			if (board[row][col + 1] == LIVE){
				numNeighbors++;}
		}
		catch(IndexOutOfBoundsException e) {
		}
			
		try{
			if (board[row + 1][col - 1] == LIVE){
				numNeighbors++;}
		}
		catch(IndexOutOfBoundsException e) {
		}
		
		try{
			if (board[row + 1][col] == LIVE){
				numNeighbors++;}
		}
		catch(IndexOutOfBoundsException e) {
		}
		
		try{
			if (board[row + 1][col + 1] == LIVE){
				numNeighbors++;
			}
		}
		catch(IndexOutOfBoundsException e) {
		}
		 
		return numNeighbors;
	}
	
	public void generateNextStep(){
		this.nextBoard = new char[10][10];
		int a;
		boolean isCellLive;
		for(int rowa = 0; rowa <= 9; rowa++){
			for (int cola = 0; cola <= 9; cola++){
				isCellLive = isLive(rowa,cola);
				a = getNeighborCount(rowa,cola);
				if(a == 1 || a == 0 || a == 4 || a == 5 || a == 6 || a == 7 || a == 8){
					
					nextBoard[rowa][cola] = DEAD;
				}
				else if(isCellLive == true && (a == 2 || a == 3)){
					nextBoard[rowa][cola] = LIVE;
				}
				else if (isCellLive == false && a == 3){
					nextBoard[rowa][cola] = LIVE;
				}
				else {
					nextBoard[rowa][cola] = DEAD;
				}
				
				
			}
		}
		board = nextBoard;

	}
	
	public void addLiveCell(int row, int col){
		board[row][col] = LIVE;
	}
	
	public void printBoard(){
		
		for(int i = 0; i <= 9; i++){
			String display = Arrays.toString(board[i]);
			display = display.replace(",", "");
			display = display.replace("[", "");
			display = display.replace("]", "");
			System.out.println(display);
		}
		System.out.println();
	}


}