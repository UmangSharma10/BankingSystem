package Training;

import java.util.ArrayList;
import java.util.HashMap;

public class bank_details{
    String AccID;
    String Name;
    String Type;
    int Amount;
    int Number;
    String Password;

    static HashMap<String, HashMap<String, Integer>> bank = new HashMap<>();
    ArrayList<String> details = new ArrayList<>();
    ArrayList<String> Date = new ArrayList<>();

    public static int generateTicketNumber(int min, int max){
        int range = (max - min) +1;
        return (int)(Math.random()* range) + min;
    }

    public static void createAccountID(String name, String accID){

        String id = name.concat(String.valueOf(generateTicketNumber(200,300)));
        accID = id;
        System.out.println("Your Account ID is: " + accID);
    }
}
