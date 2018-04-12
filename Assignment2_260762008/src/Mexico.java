import java.util.Scanner;

public class Mexico {
	//Tianze Lin 260762008
	
	public static int diceRoll(){
		double a=6*Math.random()+1;
		int b=(int) a;
		return b;
	}//A method to simulate a dice roll
	
	public static int getScore(int a, int b){
		int c;
		if (a>=b) {
			c=10*a+b;
		}else{
			c=10*b+a;
		}
		return c;
	}//A method to compute the score of a Player
	
	public static int playOneRound(String playerName) {
		int a=diceRoll();
		int b=diceRoll();
		int c=getScore(a,b);
		System.out.println(playerName+" rolled:  "+a+" "+b);
		System.out.println(playerName+"'s score is "+c);
		return c;
	}//A method to simulate one round of Mexico
	
	public static String getWinner(int davidScore, int giuliaScore) {
		String a ="David";
		String b= "Giulia";
		String c="tie";
		int davidFirstDigit=davidScore%10;
		int davidSecondDigit=davidScore/10%10;
		int giuliaFirstDigit=giuliaScore%10;
		int giuliaSecondDigit=giuliaScore/10%10;
		//Case tie
		if (davidScore==giuliaScore) {
			return c; 
		}//Case "21"
		else if (davidScore==21&&giuliaScore!=21) {
			return a;
		}else if(giuliaScore==21&&davidScore!=21){
			return b;
		}//Case Double
		else if(davidFirstDigit==davidSecondDigit) {
			if(giuliaFirstDigit!=giuliaSecondDigit) {
				return a;
			}else {
				if (giuliaFirstDigit>davidFirstDigit) {
					return b;
				}else {
					return a;
				}
			}
		}else if(giuliaFirstDigit==giuliaSecondDigit) {
			if(davidFirstDigit!=davidSecondDigit) {
				return b;
			}else {
				if (davidFirstDigit>giuliaFirstDigit) {
					return a;
				}else {
					return b;
				}
			}
		}//Regular Case
		else{
			if (davidScore>giuliaScore) {
				return a;
			}else {
				return b;
			}
		}
	}//A method to determine the winner of one round
	
	public static boolean canPlay(double buyIn, double bet) {
		if (buyIn>bet&&buyIn%bet==0) {
			return true;
		}else {
			return false;
		}
	}//A method to check if the buy in and the base bet are set correctly
	
	public static void playMexico(double buyIn, double bet) {
		if (canPlay(buyIn,bet)==false) {
			System.out.println("Insufficient funds. The game cannot be played.");
		}else {
			double davidBuyIn=buyIn;
			double giuliaBuyIn=buyIn;
			for(int round=1;davidBuyIn!=0&&giuliaBuyIn!=0;round++) {
				System.out.println();
				System.out.println("Round "+round);
				System.out.println();
				int davidScore=playOneRound("David");
				int giuliaScore=playOneRound("Giulia");
				String winnerOfOneRound=getWinner(davidScore, giuliaScore);
				if (winnerOfOneRound=="Giulia") {
					System.out.println("Giulia wins this round");
					davidBuyIn=davidBuyIn-bet;
					//the loser will lose an amount of money equal to the base bet.
					if (davidBuyIn==0) {
						System.out.println();
						System.out.println("Giulia won the game!");
					}//David is left with no money, and Giulia wins the game.
				}else if(winnerOfOneRound=="David"){
					System.out.println("David wins this round");
					giuliaBuyIn=giuliaBuyIn-bet;
					//the loser will lose an amount of money equal to the base bet.
					if (giuliaBuyIn==0) {
						System.out.println();
						System.out.println("David won the game!");
					}//Giulia is left with no money, and David wins the game.
				}else {
					System.out.println("It's a tie. Roll again!");
				}
			}

		}
	}//A method to simulate a game of Mexico
	
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		Scanner input2=new Scanner(System.in);
		double buyIn=input.nextDouble();
		double bet=input2.nextDouble();
		playMexico(buyIn, bet);
	}
}
