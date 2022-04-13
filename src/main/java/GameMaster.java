import java.util.ArrayList;
import java.util.Scanner;

public class GameMaster {

    private GameHelper helper = new GameHelper();
    private ArrayList<BattleShip> shipsList = new ArrayList<>();
    private int numOfGuesses = 0;

    private void setUpGame(){
        BattleShip ship1 = new BattleShip();
        ship1.setName("Hope");
        BattleShip ship2 = new BattleShip();
        ship2.setName("Faith");
        BattleShip ship3 = new BattleShip();
        ship3.setName("Love");
        this.shipsList.add(ship1);
        this.shipsList.add(ship2);
        this.shipsList.add(ship3);

        System.out.println("Your goal is to sink three ships!");
        System.out.println("Hope, Faith and Love");
        System.out.println("Try to do your best!");

        for (BattleShip shipToSet : shipsList){
            ArrayList<String> newLocation = helper.placeBattleShip(3);
            shipToSet.setLocationCells(newLocation);
        }
    }

    private void startPlaying(){
        while(!shipsList.isEmpty()){
            String userGuess = helper.getUserInput("Your turn.");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    public void checkUserGuess(String userGuess){
        this.numOfGuesses++;
        String result = "Miss :(";

        for (BattleShip shipToTest : shipsList){
            result = shipToTest.checkUserGuess(userGuess);
            if (result.equals("Hit!")){ break; }
            if (result.equals("U got it!")) {
                shipsList.remove(shipToTest);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame(){
        System.out.println("U got all of this ships.");
        System.out.println("U got it in " + this.numOfGuesses + " tries.");

        if (numOfGuesses <= 18) {
            System.out.println("Are u cheating?!");
        } else {
            System.out.println("Next time u should got it faster. I really tiered after this game.");
        }
    }

    public static void main(String[] args) {
        GameMaster master = new GameMaster();
        master.setUpGame();
        master.startPlaying();

//        BattleShip theBattleShip = new BattleShip();
//
//        int randomNum = (int) (Math.random() * 5);
//        int[] locationInNums = {randomNum, randomNum+1, randomNum+2};
//        ArrayList<String> locations = new ArrayList<>();
//        for (int i : locationInNums){
//            locations.add(String.valueOf(i));
//        }
//        theBattleShip.setLocationCells(locations);
//
//        boolean isAlive = true;
//
//        while (isAlive){
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Put your number.");
//            String guess = scanner.nextLine();
//            String result = theBattleShip.checkUserGuess(guess);
//            numOfGuesses++;
//            if (result.equals("Dead")){
//                isAlive = false;
//                System.out.println("You got it in "+ numOfGuesses + " tries.");
//            }
//        }
    }
}
