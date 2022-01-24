package Training;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static bank_details bankdetailsObject = new bank_details();

    public static void main(String[] args) throws ParseException {
        fileDb.FildWriteDb();
        HashMap<String,bank_details> map = new HashMap<>();
        
        int temp1;
        do {
            System.out.println("**************************** Welcome to Motadata Smart Online Banking System ****************");
            System.out.println("Please Select from the options : ");
            System.out.println("1) Direct Login ");
            System.out.println("2) Register for an account");
            System.out.println("3) Forget Password");
            System.out.println("4) EXIT ");
            Scanner sc = new Scanner(System.in);
            temp1 = sc.nextInt();
            if (temp1 == 1) {
                System.out.println("please enter your password");
                String password_User = sc.next();
                if (map.containsKey(password_User)) {
                    bank_details usergetpassword;
                    usergetpassword = map.get(password_User);
                    int choice;
                    do {
                        System.out.println("Welcome " + usergetpassword.Name);
                        System.out.println("1. Account details");
                        System.out.println("2. Deposit the amount");
                        System.out.println("3. Withdraw the amount");
                        System.out.println("4. History");
                        System.out.println("5. Search for Transaction");
                        System.out.println("6. Delete Account");
                        System.out.println("7. Exit");
                        System.out.println("Enter your choice: ");
                        choice = sc.nextInt();
                        if (choice > 7)
                            System.out.println("It is not a valid choice, Please enter number from 1 to 6.");
                        switch (choice) {
                            case 1:
                                System.out.println("Account Details:");
                                System.out.println("Name: " + usergetpassword.Name);
                                System.out.println("Type of Account: " + usergetpassword.Type);
                                System.out.println("Amount: " + usergetpassword.Amount);
                                break;
                            case 2: //deposit Account
                                System.out.println("Please enter the amount you want to enter: ");
                                int depositAmount = sc.nextInt();
                                usergetpassword.Amount += depositAmount;
                                System.out.println(depositAmount + "are added to your bank account successfully");
                                System.out.println("Your Current bank Balance is: " + usergetpassword.Amount);
                                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH-mm");
                                String mytime = LocalTime.now().format(dtf);
                                LocalDate mydate = LocalDate.now();
                                usergetpassword.details.add("Date- " + mydate + ", Time- " + mytime +", + " + depositAmount + ", Total balance is- " + usergetpassword.Amount);
                                String mydate_string = mydate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                                usergetpassword.Date.add(mydate_string);

                                break;
                            case 3: //Withdraw Account
                                System.out.println("Your current Bank Balance is: " + usergetpassword.Amount);
                                System.out.println("Please enter the amount you want to Withdraw: ");
                                int withdrawAmount = sc.nextInt();
                                while (withdrawAmount >= usergetpassword.Amount) {
                                    System.out.println("Invalid amount, Please enter valid amount");
                                    System.out.println("Please enter the amount you want to Withdraw: ");
                                    withdrawAmount = sc.nextInt();
                                }
                                usergetpassword.Amount -= withdrawAmount;
                                System.out.println("Please Take " + withdrawAmount);
                                System.out.println("Your current Bank balance is: " + usergetpassword.Amount);
                                DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("HH-mm");
                                String mytimeW = LocalTime.now().format(dtf1);
                                LocalDate mydateW = LocalDate.now();
                                String mydateW_string = mydateW.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                                usergetpassword.Date.add(mydateW_string);
                                usergetpassword.details.add("Date- " + mydateW + ", Time- " + mytimeW + ", - " + withdrawAmount + ", Total balance is- " + usergetpassword.Amount);
                                break;
                            case 4:
                                System.out.println("History of all your transaction: " );
                                ArrayList<String> historyDetails = new ArrayList<>(usergetpassword.details);
                                for (String hd : historyDetails){
                                    System.out.println(hd);
                                }
                                break;
                            case 5:
                                System.out.println("starting date(in yyyy-mm-dd): ");
                                String startDate = sc.next();
                                Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
                                System.out.println("ending date(in yyyy-mm-dd): ");
                                String endDate = sc.next();
                                Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(endDate);

                                for(int i = 0; i< usergetpassword.Date.size(); i++)
                                {
                                    Date dateTemp=new SimpleDateFormat("dd/MM/yyyy").parse(usergetpassword.Date.get(i));
                                    if(dateTemp.after(date1) && dateTemp.before(date2))
                                    {
                                        System.out.println(usergetpassword.details.get(i));
                                    }
                                }
                                break;
                            case 6:
                                System.out.println("Enter name");
                                String name = sc.next();
                                System.out.println("Enter Paasword");
                                String pass = sc.next();
                                deleteAccount.deleteAccount(name,pass);
                                break;



                        }
                    } while (choice != 7);
                } else {
                    System.out.println("Sorry there is no account for this password ");
                    System.out.println("Try again or open new account");
                }
            } else if(temp1==2){
                System.out.print("Please enter your Name: ");
                String name = sc.next();
                System.out.println("please enter your password");
                String password = sc.next();
                System.out.print("Please enter your current bank amount: ");
                int amount = sc.nextInt();
                System.out.println("Please enter your account type");
                String acctype = sc.next();
               // System.out.println("Please enter your Mobile No : ");
              //  int number = sc.nextInt();
                //int password = (int) (Math.random() * 1001);
                String accID = "";
                bank_details.createAccountID(name , accID);

                bankdetailsObject.Amount = amount;
                bankdetailsObject.Name = name;
                bankdetailsObject.Type = acctype;
                bankdetailsObject.AccID = accID;
                bankdetailsObject.Password=password;
              //  bank_details_object.Number=number;
                map.put(password, bankdetailsObject);
            }
            else if(temp1 == 3){

            }
            else if(temp1 == 4){
                fileDb.FildWriteDb();
            }
        }while (temp1 != 4);
    }
}

