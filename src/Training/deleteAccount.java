package Training;

import java.util.HashMap;

public class deleteAccount extends bank_details{
    static void deleteAccount(String name, String pass){
        HashMap<String,Integer> temp = bank.get(name);
        if(bank.containsKey(name) && temp.containsKey(pass))
        {
            bank.remove(name);
        }
        else{
            System.out.println("Your data is not in the database");
        }
    }
}

