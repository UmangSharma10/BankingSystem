package Training;

import java.util.HashMap;

public class Withdraw extends bank_details{
        public void Withdraw(String name, String password, int balance){
                HashMap<String, Integer> temp = bank.get(name);
                if(bank.containsKey(name) && temp.containsKey(password)){

                }
        }
}
