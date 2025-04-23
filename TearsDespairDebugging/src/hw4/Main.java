package hw4;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

import hw4.game.Game;
import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.maze.Row;
import hw4.player.Movement;
import hw4.player.Player;

public class Main {
	
	private static Game game;
	private static Grid grid;
	private static Player player;
	
	public static void main(String[] args) {
		game = new Game(5);
		// set player at bottom right
		Row playerRowPosition = game.getGrid().getRows().getLast();
		Cell playerCellPosition = playerRowPosition.getCells().getLast();
		player = new Player(playerRowPosition, playerCellPosition);
		
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("You're stuck in an invisible maze!\nHow'd you get there? >;)");
		boolean escaped = false;
		boolean quit = false;
		while (!escaped && !quit) {
			game.visualizeGrid(player);
			System.out.println("'W'=Move UP, 'A'=Move Left, 'S'=Move Down, 'D'=Move Right, 'Q'=Give UP");
			if (player.getCurrentCell().getLeft() == CellComponents.EXIT) {System.out.println("You're at the exit! Move left to escape.");}
			String move = scanner.nextLine();
			switch (move.charAt(0)) {
				case 'W':
					if (game.play(Movement.UP, player)) {successfulMoveMessage();} 
					else {unsuccessfulMoveMessage();}
					break;
				case 'A':
					if (player.getCurrentCell().getLeft() == CellComponents.EXIT) {escaped=true;}
					else {
						if (game.play(Movement.LEFT, player)) {successfulMoveMessage();} 
						else {unsuccessfulMoveMessage();}
					}
					break;
				case 'S':
					if (game.play(Movement.DOWN, player)) {successfulMoveMessage();} 
					else {unsuccessfulMoveMessage();}
					break;
				case 'D':
					if (game.play(Movement.RIGHT, player)) {successfulMoveMessage();} 
					else {unsuccessfulMoveMessage();}
					break;
				case 'Q':
					quit = true;
					break;
				default:
					System.out.println("Invalid input");
			}
		}
		if (quit) {System.out.println("You have quit. "
				+ "You've given up on yourself and life. "
				+ "Your wife sits on your couch, in the newly renovated, blue painted home you financed in August."
				+ "She's sitting there, her knees to her chest, checking the time."
				+ "'Where's BaPa' says your 4 year old daughter."
				+ "How could your small, curly haired brunette wife answer when she's worrying the same thing.."
				+ "How could you leave them?"
				+ "She can't afford to pay for the house on her own."
				+ "You were her first love! No one will be the same!"
				+ "YOU'RE EVIL!"
				+ "WHY WOULD YOU GIVE IN!?"
				+ "DID YOU HAVE NO DREAMS?? NO ASPIRATIONS IN LIFE??"
				+ "DID YOUR DAUGHTER AND ALL THAT YOU'VE WORKED FOR MEAN NOTHING?!"
				+ "shame.."
				+ "shame on you.");}
		else {System.out.println("Congratulations!\nYou have escaped the invisible maze!\n...but you weren't invisible... we were watching you...\nCome again!");}
	}
	
	public static void successfulMoveMessage() {
		
		SecureRandom secureRandom = new SecureRandom();
		
		switch (secureRandom.nextInt(8)+1) {
			case 1:
				System.out.println("You found an opening! Impressive! 'o'");
				break;
			case 2:
				System.out.println("I guess you can go through there... -_-");
				break;
			case 3:
				System.out.println("Watch out! Something may be following you >:)");
				break;
			case 4:
				System.out.println("Quit making progress. >:(");
				break;
			case 5:
				System.out.println("You're really good at this! Or not. Nobody's counting. Only stalking");
				break;
			case 6:
				System.out.println("So close! Yet so far...");
				break;
			case 7:
				System.out.println("A cheerful message to keep you going: at least your grandma thinks you're handsome!");
				break;
			case 8:
				System.out.println("Some advice for more success: ");
				break;
		}
	}
	
	
	public static void unsuccessfulMoveMessage() {
		
		SecureRandom secureRandom = new SecureRandom();
		
		switch (secureRandom.nextInt(8)+1) {
		case 1:
			System.out.println("Ouch! Wall there!");
			break;
		case 2:
			System.out.println("BONK!");
			break;
		case 3:
			System.out.println("There's some sort of... mysterious blockage");
			break;
		case 4:
			System.out.println("Nuh uh uuuuhhhh");
			break;
		case 5:
			System.out.println("When did that wall get there!?");
			break;
		case 6:
			System.out.println("Almost! If only you could go that way!");
			break;
		case 7:
			System.out.println("'lOoK At mE i'M TrYinG To eScAPe A mAzE' next time don't walk into a wall, BUDDY");
			break;
		case 8:
			System.out.println("*side eye*");
			break;
		}
	}
	
	
//	// Did not finish implementing
//	public static boolean isExitable(Grid grid, Row currentRow, Cell currentCell) {
//		// find row index
//		int j = 0;
//		for (Row row : grid.getRows()) {
//			if (currentRow == row) {break;}
//			j++;
//		}
//		// find cell index
//		int i = 0;
//		for (Cell cell : currentRow.getCells()) {
//			if (currentCell == cell) {break;}
//			i++;
//		}
//		
//		// assuming edge of maze is always a wall
//		if (currentCell.getUp() == CellComponents.APERTURE) {
//			
//		}
//		return false;
//	}
	
}
