package ticTacToe;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	
	//260762008, Tianze Lin
	
	public static char[][] createBoard(int n){
		char[][] a = new char [n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = ' ';
			}
		}
		return a;
	}
	//A method for creating the board
	
	public static void displayBoard(char[][] a) {
		int i = a.length;
		int j = a[i-1].length;
		for (int m = 0; m < i; m++) {
			for (int n = 0; n < j; n++) {
				System.out.print("+-");
				if(n == j-1) {
					System.out.println("+");
				}
			}
			for (int n = 0; n < j; n++) {
				System.out.print("|"+a[m][n]);
				if(n == j-1) {
					System.out.println("|");
				}
			}
			if(m == i-1) {
				for (int n = 0; n < j; n++) {
					System.out.print("+-");
					if(n == j-1) {
						System.out.println("+");
					}
				}
			}
		}	
	}
	//A method that prints out the board
	
	public static void writeOnBoard(char[][] a, char b, int x, int y) {
		if(x >= a.length || y >= a[x].length||x < 0||y < 0) {
			throw new IllegalArgumentException("Invalid. The position does not represent a cell on the board.");
		}else if(a[x][y] != ' ') {
			throw new IllegalArgumentException("Invalid. This cell contains a character other than the space character.");
		}else {
			a[x][y] = b;
		}
	}
	//A method that adds a character on the board
	
	public static void getUserMove(char[][]a) {
		int row;
		int column;
		for(;;) {
			try {
				Scanner input = new Scanner(System.in);
				row = input.nextInt();
				column = input.nextInt();
				writeOnBoard(a, 'x', row, column);
				break;
			}
			catch(Exception e) {
				System.out.println("Invalid move. Please input a new move.");
			}
		}
	}
	//A method that shows the move of the user
	
	public static boolean checkForObviousMove(char[][] a) {
		int m = a.length;
		int n = a[m-1].length;
		int counterO = 0;
		int counterX = 0;
		//Check if there is a move that can make AI win
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(a[i][j] == 'x') {
					counterX++;
				}
				if(a[i][j] == 'o') {
					counterO++;
				}
			}
			if(counterO == n-1 && counterX == 0) {
				for (int j = 0; j < n; j++) {
					if (a[i][j] == ' ') {
						writeOnBoard(a, 'o', i, j);
					}
				}
				return true;
			}
			counterO = 0;
			counterX = 0;
		}
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < m; i++) {
				if(a[i][j] == 'x') {
					counterX++;
				}
				if(a[i][j] == 'o') {
					counterO++;
				}
			}
			if(counterO == n-1 && counterX == 0) {
				for (int i = 0; i < m; i++) {
					if (a[i][j] == ' ') {
						writeOnBoard(a, 'o', i, j);
					}
				}
				return true;
			}
			counterO = 0;
			counterX = 0;
		}
		for(int i = 0, j = 0; i < m; i++, j++) {
			if(a[i][j] == 'x') {
				counterX++;
			}
			if(a[i][j] == 'o') {
				counterO++;
			}
		}
		if(counterO == m-1 && counterX == 0) {
			for(int i = 0, j = 0; i < m; i++, j++) {
				if(a[i][j] == ' ') {
					writeOnBoard(a, 'o', i, j);
				}
			}
			return true;
		}
		counterO = 0;
		counterX = 0;
		for(int i = m-1, j = 0; j < n; i--, j++) {
			if(a[i][j] == 'x') {
				counterX++;
			}
			if(a[i][j] == 'o') {
				counterO++;
			}
		}
		if(counterO == m-1 && counterX == 0) {
			for(int i = m-1, j = 0; j < n; i--, j++) {
				if(a[i][j] == ' ') {
					writeOnBoard(a, 'o', i, j);
				}
			}
			return true;
		}
		counterO = 0;
		counterX = 0;
		//Check if there is a move that can avoid the win for the user 
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(a[i][j] == 'x') {
					counterX++;
				}
				if(a[i][j] == 'o') {
					counterO++;
				}
			}
			if(counterO == 0 && counterX == n-1) {
				for (int j = 0; j < n; j++) {
					if (a[i][j] == ' ') {
						writeOnBoard(a, 'o', i, j);
					}
				}
				return true;
			}
			counterO = 0;
			counterX = 0;
		}
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < m; i++) {
				if(a[i][j] == 'x') {
					counterX++;
				}
				if(a[i][j] == 'o') {
					counterO++;
				}
			}
			if(counterO == 0 && counterX == n-1) {
				for (int i = 0; i < m; i++) {
					if (a[i][j] == ' ') {
						writeOnBoard(a, 'o', i, j);
					}
				}
				return true;
			}
			counterO = 0;
			counterX = 0;
		}
		for(int i = 0, j = 0; i < m; i++, j++) {
			if(a[i][j] == 'x') {
				counterX++;
			}
			if(a[i][j] == 'o') {
				counterO++;
			}
		}
		if(counterO == 0 && counterX == m-1) {
			for(int i = 0, j = 0; i < m; i++, j++) {
				if(a[i][j] == ' ') {
					writeOnBoard(a, 'o', i, j);
				}
			}
			return true;
		}
		counterO = 0;
		counterX = 0;
		for(int i = m-1, j = 0; j < n; i--, j++) {
			if(a[i][j] == 'x') {
				counterX++;
			}
			if(a[i][j] == 'o') {
				counterO++;
			}
		}
		if(counterO == 0 && counterX == m-1) {
			for(int i = m-1, j = 0; j < n; i--, j++) {
				if(a[i][j] == ' ') {
					writeOnBoard(a, 'o', i, j);
				}
			}
			return true;
		}
		counterO = 0;
		counterX = 0;
		//If there is no obvious move
		return false;
	}
	
	public static void getAIMove(char[][] a) {
		if(checkForObviousMove(a) == false) {
			Random randomGenerator1 = new Random();
			Random randomGenerator2 = new Random();
			int n=a.length;
			int m=a[n-1].length;
			int x = randomGenerator1.nextInt(n);
			int y = randomGenerator2.nextInt(m);
			for(;a[x][y] != ' ';) {
				x = randomGenerator1.nextInt(n);
				y = randomGenerator2.nextInt(m);
			}
			writeOnBoard(a, 'o', x, y);
		}
	}
	//A method that makes AI move
	
	public static char checkForWinner(char[][] a) {
		int m = a.length;
		int n = a[m-1].length;
		int counterO = 0;
		int counterX = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(a[i][j] == 'x') {
					counterX++;
				}
				if(a[i][j] == 'o') {
					counterO++;
				}
			}
			if(counterX == n) {
				return 'x';
			}
			if(counterO == n) {
				return 'o';
			}
			counterO = 0;
			counterX = 0;
		}
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < m; i++) {
				if(a[i][j] == 'x') {
					counterX++;
				}
				if(a[i][j] == 'o') {
					counterO++;
				}
			}
			if(counterX == m) {
				return 'x';
			}
			if(counterO == m) {
				return 'o';
			}
			counterO = 0;
			counterX = 0;
		}
		for(int i = 0, j = 0; i < m; i++, j++) {
			if(a[i][j] == 'x') {
				counterX++;
			}
			if(a[i][j] == 'o') {
				counterO++;
			}
		}
		if(counterX == m) {
			return 'x';
		}
		if(counterO == m) {
			return 'o';
		}
		counterO = 0;
		counterX = 0;
		for(int i = m-1, j = 0; j < n; i--, j++) {
			if(a[i][j] == 'x') {
				counterX++;
			}
			if(a[i][j] == 'o') {
				counterO++;
			}
		}
		if(counterX == m) {
			return 'x';
		}
		if(counterO == m) {
			return 'o';
		}
		return ' ';
	}
	//A method that checks for the winner
	
	public static void play() {
		System.out.println("Please enter your name:");
		Scanner name = new Scanner(System.in);
		String nameOfUser = name.nextLine();
		System.out.println("Welcome, "+nameOfUser+"! Are you ready to play?");
		System.out.println("Please enter the size of your board:");
		int sizeOfBoard;
		for(;;) {
			try {
				Scanner size = new Scanner(System.in);
				sizeOfBoard = size.nextInt();
				if (sizeOfBoard <= 0) {
					throw new Exception();
				}
				break;
			}catch(Exception e) {
				System.out.println("Please input a positive integer indicating dimension of the board");
			}
		}
		char[][] board = createBoard(sizeOfBoard);
		double a = Math.random();
		if(a<0.5) {
			System.out.println("The result of the coin toss is: 0");
			System.out.println("You have the first move");
			displayBoard(board);
			for(;;) {
				System.out.println("Please enter your move");
				getUserMove(board);
				displayBoard(board);
				if(checkForWinner(board) == 'x') {
					System.out.println("GAME OVER!");
					System.out.println("You won");
					break;
				}
				if(checkForWinner(board) != 'x' && checkBoard(board) == false) {
					System.out.println("GAME OVER!");
					System.out.println("It is a tie");
					break;
				}
				System.out.println("The AI made its move:");
				getAIMove(board);
				displayBoard(board);
				if(checkForWinner(board) == 'o') {
					System.out.println("GAME OVER!");
					System.out.println("You lost");
					break;
				}
				if(checkForWinner(board) != 'o' && checkBoard(board) == false) {
					System.out.println("GAME OVER!");
					System.out.println("It is a tie");
					break;
				}
			}
		}else{
			System.out.println("The result of the coin toss is: 1");
			System.out.println("The AI has the first move");
			for(;;) {
				System.out.println("The AI made its move:");
				getAIMove(board);
				displayBoard(board);
				if(checkForWinner(board) == 'o') {
					System.out.println("GAME OVER!");
					System.out.println("You lost");
					break;
				}
				if(checkForWinner(board) != 'o' && checkBoard(board) == false) {
					System.out.println("GAME OVER!");
					System.out.println("It is a tie");
					break;
				}
				System.out.println("Please enter your move");
				getUserMove(board);
				displayBoard(board);
				if(checkForWinner(board) == 'x') {
					System.out.println("GAME OVER!");
					System.out.println("You won");
					break;
				}
				if(checkForWinner(board) != 'x' && checkBoard(board) == false) {
					System.out.println("GAME OVER!");
					System.out.println("It is a tie");
					break;
				}
			}	
		}
	}
	//A method that plays the game
	
	public static boolean checkBoard(char[][] a) {
		int i = a.length;
		int j = a[i-1].length;
		for (int m = 0; m < i; m++) {
			for (int n = 0; n < j; n++) {
				if(a[m][n] == ' ') {
					return true;
				}
			}
		}
		return false;
	}
	//A method that checks if there is empty space on the board

	public static void main(String args[]) {
		play();
	}	
}
