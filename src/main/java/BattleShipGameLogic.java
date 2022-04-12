public class BattleShipGameLogic {

    int[] locationCells;
    int numOfHits = 0;

    public void setLocationCells(int[] loc){
        locationCells = loc;
    }

    public String checkUserGuess(String userGuess) {

        int guess = Integer.parseInt(userGuess);
        String result = "Miss";

        for (int cell : locationCells) {
            if (guess == cell) {
                result = "Hit";
                numOfHits++;
                break;
            }
        }

        if (numOfHits == locationCells.length) {
            result = "Dead";
        }

        System.out.println(result);

        return result;
    }
}
