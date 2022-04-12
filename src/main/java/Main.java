import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BattleShipGameLogic theBattleShip = new BattleShipGameLogic();

        int randomNum = (int) (Math.random() * 5);
        int[] locations = {randomNum, randomNum+1, randomNum+2};
        theBattleShip.setLocationCells(locations);

        int numOfGuesses = 0;
        boolean isAlive = true;

        while (isAlive){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Put your number.");
            String guess = scanner.nextLine();
            String result = theBattleShip.checkUserGuess(guess);
            numOfGuesses++;
            if (result.equals("Dead")){
                isAlive = false;
                System.out.println("You got it in "+ numOfGuesses + " tries.");
            }
        }
    }
}
