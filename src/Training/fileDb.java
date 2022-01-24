package Training;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;

public class fileDb extends bank_details{
        static void FileReadDb() {

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
