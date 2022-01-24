package Training;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;

public class fileDb extends bank_details{
        static void FileReadDb() {
                HashMap<String,bank_details> map = new HashMap<>();
//ArrayList<String,String> data = new ArrayList<>();

            String filePath_password = "password.txt";
            String filePath_details = "details.txt";
            String filePath_history = "history.txt";

            BufferedReader br1 = null;
            BufferedReader br2 = null;
            BufferedReader br3 = null;

            try {

                File file1 = new File(filePath_password);
                File file2 = new File(filePath_details);
                File file3 = new File(filePath_history);

                // create BufferedReader object from the File
                br1 = new BufferedReader(new FileReader(file1));
                br2 = new BufferedReader(new FileReader(file2));
                br3 = new BufferedReader(new FileReader(file3));

                String line1 = null;
                String line2 = null;
                String line3 = null;

// read file line by line
                while ((line1 = br1.readLine() ) != null) {
                    line2 = br2.readLine();
                    line3 = br3.readLine();
                    bank_details tempVariable = new bank_details();

                    String[] parts1 = line1.split(",");
                    String[] parts2 = line2.split(",");
                    String[] parts3 = line3.split(",");

                    String userName = parts1[0].trim();
                    tempVariable.Password = parts1[1].trim();

                    tempVariable.Name = parts2[1].trim();
                    tempVariable.Type = parts2[2].trim();
                    tempVariable.Amount = parseInt(parts2[3].trim());
                    tempVariable.AccID = String.valueOf(parseInt(parts2[4].trim()));


                    int arry_size = parseInt(parts3[1].trim());
                    ArrayList<String> dummyDetails = new ArrayList<>();
                    ArrayList<String> dummyDate = new ArrayList<>();
                    int i;
                    for(i=2; i<( 2+ arry_size); i++)
                    {
                        dummyDetails.add(parts3[i].trim());
                    }
                    System.out.println(dummyDate);
                    for(;i<parts3.length;i++)
                    {
                        dummyDate.add(parts3[i].trim());
                    }

                    tempVariable.details =dummyDetails;
                    tempVariable.Date = dummyDate;
                    if (!userName.equals(""))
                        map.put(userName, tempVariable);

                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        }

        static void FildWriteDb(){
            HashMap<String, bank_details> map = new HashMap<>();
            String outputFilePath_password = "password.txt";
            String outputFilePath_details = "details.txt";
            String outputFilePath_history = "history.txt";

            File file1 = new File(outputFilePath_password);
            File file2 = new File(outputFilePath_details);
            File file3 = new File(outputFilePath_history);

            BufferedWriter bf1 = null;
            BufferedWriter bf2 = null;
            BufferedWriter bf3 = null;

            try {

                bf1 = new BufferedWriter(new FileWriter(file1));
                bf2 = new BufferedWriter(new FileWriter(file2));
                bf3 = new BufferedWriter(new FileWriter(file3));

                for (Map.Entry<String, bank_details> entry : map.entrySet()) {

                    bf1.write(entry.getKey() + ":" + entry.getValue().Password);
                    bf1.newLine();

                    bf2.write(entry.getKey() + ":" + entry.getValue().Name + ":" + entry.getValue().Type + ":" + entry.getValue().Amount + ":" + entry.getValue().AccID + ":" );
                    bf2.newLine();

                    bf3.write(entry.getKey() + ":");
                    bf3.write(entry.getValue().details.size() + ":");
                    for(String n : entry.getValue().details)
                    {
                        bf3.write(n + ": ");
                    }
                    for(String k : entry.getValue().Date)
                    {
                        bf3.write(k + ":");
                    }
                    bf3.newLine();

                }

                //bf1.flush();
                bf1.close();

// bf2.flush();
                bf2.close();

                //bf3.flush();
                bf3.close();

            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

}
