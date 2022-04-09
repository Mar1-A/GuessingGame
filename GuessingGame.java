import java.util.Scanner;
/**
 * Number Gussing Game, where the player has to guess the number within 10 trys.
 * the number is between 1 and a hundred when the number entered is incorecct the script will give the player a hint
 *
 */

public class GuessingGame {
	private static final int ACTUAL = 1 + (int)(100 * Math.random()); // randomly selected number between 1 and 100
	private int guessNumber;  
	private String gameStatus;  
	
	GuessingGame(){  			 
		guessNumber = 10;
		gameStatus  = "";
	} 

	public int getGuessNumber() {
		return guessNumber;
	}

	public String getGameStatus(){
		return gameStatus;
	}

	//sets game statu
	public void setGameStatus(String gameStatus) {
		this.gameStatus = gameStatus;
	}

	//check if player guess equals to ACTUAL
	public void GuessTheNumber() {
		System.out.println("A number is chosen between 1 to 100. Guess the number within 10 trials.");
		System.out.println("Guess the number:");
		
		for (int i = guessNumber; i > 0; i--) {
			System.out.println("you have " + i + " trials left");
			setGameStatus("<<ongoing>>");
			System.out.println(getGameStatus());
			Scanner scanner = new Scanner(System.in);
			try {
				int userInput = scanner.nextInt();

				if(userInput == ACTUAL) {
					setGameStatus("<<Game Over>>");
					System.out.println(gameStatus);
					System.out.println("You have Won, you guessed the right number");
					
					break;
				} else if (ACTUAL != userInput && i !=1){
					System.out.println("Incorrect, Hint:");
					if (ACTUAL > userInput) {
					System.out.println("The number is greater than " + userInput);
						
					} else if (ACTUAL < userInput){
						System.out.println("The number is less than " + userInput);
					}
					System.out.println("Try again:");

				} else if (i == 1) {
					System.out.println("<<Game Over>>");
					setGameStatus("You have lost.");
					System.out.println(getGameStatus());
					System.out.println("The number was " + ACTUAL);

				} else {
					System.out.println("invaled input Choose Number between 1 and 100");

				}
			} catch (Exception e){
				i++;
				System.out.println("Pleas enter a number");
			}
		}
		
	}

	public static void main(String[] args) {
		GuessingGame game = new GuessingGame();
		game.GuessTheNumber();
	}
}

