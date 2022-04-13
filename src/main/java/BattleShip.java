import java.util.ArrayList;

public class BattleShip {

    private ArrayList<String>  locationCells;
    private String name;

    public void setName(String name){
        this.name = name;
    }

    public void setLocationCells(ArrayList<String> loc){
        locationCells = loc;
    }

    public String checkUserGuess(String userGuess) {

        String result = "Miss :(";
        int index = locationCells.indexOf(userGuess);
        if (index >= 0) {
            locationCells.remove(index);

            if (locationCells.isEmpty()) {
                result = "U got it!";
                System.out.println("Now " + name + " sank...");
            } else {
                result = "Hit!";
            }
        }
        return result;
    }
}
