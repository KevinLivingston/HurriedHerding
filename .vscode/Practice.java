//test
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import mypackage.Cow;


public class Practice {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("C:\\Users\\kevin\\Desktop\\cowData.txt");//Grabs a file to read
        BufferedReader read = new BufferedReader(fr);//Stores the file into a buffer
        String line;// variable to focus on single line at a time
        ArrayList<Cow> cowlist=new ArrayList<Cow>();
        while ((line = read.readLine()) != null) {
            String[] pieces = line.split(" ");//breaks up the string with each space
            if(pieces.length == 4){// makes sure that the record contains 4 values
                System.out.println("GOOD RECORD");
                int id = Integer.parseInt(pieces[0]);//saves the first value of the line which is the ID
                String action = pieces[1];//saves the second value of a line to decide what to do with current record
                Cow newcow = new Cow(id);//creates a new cow using the id
                int value = listcheck(cowlist,id); //NEED TO IMPROVE THIS FIND FUNCTION !!!!!!!!!!!!!!!!!
                if(value != -1){//if the cow does not already exist in the list
                    int amount;
                    switch(action){
                        case "W":// cow was wieghed
                            amount = Integer.parseInt(pieces[2]);//store cow weight amount third value 
                            cowlist.get(value).setlatest_weight(amount);//set the cow weight, can be one line
                            break;
                        case "M":// cow was Milked
                            amount = Integer.parseInt(pieces[2]);//store the amount milked , third value in a record
                            cowlist.get(value).setgal_milk(amount);//set the lates milk recording
                            break;
                        case "T"://cow temp was taken
                            amount = Integer.parseInt(pieces[2]);// store the temperature
                            cowlist.get(value).settemp(amount);//set the cow's latest temp
                            break;
                    }
                }
            
                else{
                    int amount;
                    switch(action){
                        case "W":// cow was wieghed
                            amount = Integer.parseInt(pieces[2]);//store cow weight amount third value 
                            newcow.setlatest_weight(amount);//set the cow weight, can be one line
                            break;
                        case "M":// cow was Milked
                            amount = Integer.parseInt(pieces[2]);//store the amount milked , third value in a record
                            newcow.setgal_milk(amount);//set the lates milk recording
                            break;
                        case "T"://cow temp was taken
                            amount = Integer.parseInt(pieces[2]);// store the temperature
                            newcow.settemp(amount);//set the cow's latest temp
                            break;
                    }
                    cowlist.add(newcow);//add a new cow
                    System.out.println("ADDED");
                }
            }
            else{
                System.out.println("BAD RECORD");// record does not have the correct amount of values
            }
        }
        for(int i = 0;i < cowlist.size(); i++){
            System.out.println(cowlist.get(i));
        }
        System.out.print(cowlist.size());

        fr.close();// closes the file reader
    }

    public static int listcheck(ArrayList<Cow> cowlist,  int id){//method to check a list and see if it exists
        for(int i = 0; i < cowlist.size(); i++){
            if (cowlist.get(i).getid() == id){
                return i;
            }
        }
        return -1;
    }
}
