import java.util.ArrayList;

public class BattleShipGameLogic {

    private ArrayList<String>  locationCells;
    int numOfHits = 0;

    public void setLocationCells(ArrayList<String> loc){
        locationCells = loc;
    }

    public String checkUserGuess(String userGuess) {

        String result = "Miss";
        int index = locationCells.indexOf(userGuess);
        if (index >= 0){
         locationCells.remove(index);

         if(locationCells.isEmpty()){
             result = "Dead";
         } else {
             result = "Hit";
         }
        }

        System.out.println(result);

        return result;
    }
}
