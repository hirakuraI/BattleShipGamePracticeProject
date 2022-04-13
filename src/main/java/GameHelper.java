import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameHelper {
    private static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int [] grid = new int[gridSize];
    private int shipCount = 0;

    public String getUserInput(String promt){
        String inputLine = null;
        System.out.println(promt + " ");
        try{
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if(inputLine.length() == 0) return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine.toLowerCase();
    }

    public ArrayList<String> placeBattleShip(int shipLength){
        ArrayList<String> alphaCells = new ArrayList<>();
        String temp;
        int [] coords = new int[shipLength];
        int attempts = 0;
        boolean success = false;
        int location;

        this.shipCount++;
        int incr = 1;
        if ((shipCount % 2) == 1) { incr = gridLength; }

        while (!success & attempts++ < 200){
            location = (int) (Math.random() * gridSize);
            int x = 0;
            success = true;
            while(success && x < shipLength){
                if (grid[location] == 0) {
                    coords[x++] = location;
                    location += incr;
                    if (location >= gridSize){
                        success = false;
                    }
                    if (x > 0 && (location % gridLength == 0)){
                        success = false;
                    }
                } else{
                    success = false;
                }
            }
        }
        int x = 0;
        int row;
        int column;
        while(x < shipLength) {
            grid[coords[x]] = 1;
            row = coords[x] / gridLength;
            column = coords[x] % gridLength;
            temp = String.valueOf(alphabet.charAt(column));

            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
        }
        return alphaCells;
    }
}
