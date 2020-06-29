
//test
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import mypackage.Cow;

public class Practice {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("cowData.txt");// Grabs a file to read
        BufferedReader read = new BufferedReader(fr);// Stores the file into a buffer
        String line;// variable to focus on single line at a time
        ArrayList<Cow> cowlist = new ArrayList<Cow>();// CHANGE TO A LINKED LIST, BETTER FOR ADD/REMOVE
        while ((line = read.readLine()) != null) {
            String[] pieces = line.split(" ");// breaks up the string with each space
            if (pieces.length == 4) {// makes sure that the record contains 4 values
                int id = Integer.parseInt(pieces[0]);// saves the first value of the line which is the ID
                String action = pieces[1];// saves the second value of a line to decide what to do with current record
                Cow newcow = new Cow(id);// creates a new cow using the id
                int value = listcheck(cowlist, id); // NEED TO IMPROVE THIS FIND FUNCTION !!!!!!!!!!!!!!!!!
                if (value != -1) {// if the cow does not already exist in the list
                    int amount;
                    switch (action) {
                        case "W":// cow was wieghed
                            amount = Integer.parseInt(pieces[2]);// store cow weight amount third value
                            cowlist.get(value).setlatest_weight(amount);// set the cow weight, can be one line
                            break;
                        case "M":// cow was Milked
                            amount = Integer.parseInt(pieces[2]);// store the amount milked , third value in a record
                            cowlist.get(value).setgal_milk(amount);// set the lates milk recording
                            break;
                        case "T":// cow temp was taken
                            amount = Integer.parseInt(pieces[2]);// store the temperature
                            cowlist.get(value).settemp(amount);// set the cow's latest temp
                            break;
                    }
                }

                else {
                    int amount;
                    switch (action) {
                        case "W":// cow was wieghed
                            amount = Integer.parseInt(pieces[2]);// store cow weight amount third value
                            newcow.setlatest_weight(amount);// set the cow weight, can be one line
                            break;
                        case "M":// cow was Milked
                            amount = Integer.parseInt(pieces[2]);// store the amount milked , third value in a record
                            newcow.setgal_milk(amount);// set the lates milk recording
                            break;
                        case "T":// cow temp was taken
                            amount = Integer.parseInt(pieces[2]);// store the temperature
                            newcow.settemp(amount);// set the cow's latest temp
                            break;
                    }
                    cowlist.add(newcow);// add a new cow
                    System.out.println("ADDED");
                }
            } else {
                System.out.println("BAD RECORD");// record does not have the correct amount of values
            }

        }
        boolean flag = true;

        Scanner sc = new Scanner(System.in);// creates a new Scanner for input
        while (flag == true) {// NEED TO CREATE A INPUT READER TO MATCH THE OPTIONS BELOW
            System.out.println("PLEASE CHOOSE FROM THE OPTIONS BELOW");
            System.out.println("1. ADD A NEW COW RECORD");
            System.out.println("2. EDIT AN EXISTING COW");
            System.out.println("3. REMOVE AN EXISTING COW");
            System.out.println("4. READ STORED RECORDS");
            int input;
            input = sc.nextInt();// HANDLE INPUT MISMATCH EXCEPTION
            if (input > 0) {// if input is a number
                switch (input) {// HANDLE THE
                    case 1:
                        // ADD A NEW COW
                        System.out.println("ADDING A NEW COW, ENTER A NEW ID");// NEED TO CHECK IF COW ALREADY EXISTS
                        Scanner cowcreate = new Scanner(System.in);// create object for input stream
                        String inputid = cowcreate.nextLine();// collect input
                        int newid = Integer.parseInt(inputid);// Converted inputted value to int
                        Cow newCow = new Cow(newid);// CREATE NEW COW
                        cowlist.add(newCow);// ADD NEW COW TO LIST
                        break;
                    case 2:
                        // EDIT AN EXISTING COW
                        System.out.println("PLEASE ENTER A COW ID FOR EDITING");
                        Iterator<Cow> iter = cowlist.iterator();
                        Scanner cowedit = new Scanner(System.in);// have to close this after its done
                        int editid = cowedit.nextInt();
                        while (iter.hasNext()) {// traverse through list
                            Cow current = iter.next();// set current object
                            if (current.getid() == editid) {// Check if current object matches input id
                                System.out.println("MATCH!!!");
                                System.out.println("Please enter a single character to edit a specific value");
                                System.out.println("W for a new weighing");
                                System.out.println("M for a new milking");
                                System.out.println("T for a new Temperature");
                                Scanner edittype = new Scanner(System.in);// Create an input stream for type of edit
                                String type = edittype.nextLine();// collect type input data
                                if (type.length() == 1) {// make sure input is only one character
                                    switch (type) {
                                        case "W":// cow was wieghed
                                            System.out.println("Please Enter a new weight for the cow");
                                            Scanner weightedit = new Scanner(System.in);// create input stream for
                                                                                        // weight edit
                                            String editweight = weightedit.nextLine();// collect new cow weight
                                            int weightvalue = (Integer.parseInt(editweight));// convert it to an int
                                            if (weightvalue > 0) {// make sure value is not negative
                                                current.setlatest_weight(weightvalue);// set the cow's latest weight
                                            } else {
                                                System.out.println("INVALID WEIGHT INPUTTED");
                                            }
                                            break;
                                        case "M":// cow was Milked
                                            System.out.println("Please Enter a new Milking value for the cow");
                                            Scanner milkedit = new Scanner(System.in);// create inpput stream for milk
                                                                                      // edits
                                            String editmilk = milkedit.nextLine();// take in input for new milk data
                                            int milkvalue = (Integer.parseInt(editmilk));// convert input to int
                                            if (milkvalue > 0) {// check input is not negative
                                                current.setgal_milk(milkvalue);// update the cow's milking info
                                            } else {
                                                System.out.println("INVALID Milk Value INPUTTED");
                                            }
                                            break;
                                        case "T":// cow temp was taken
                                            System.out.println("Please Enter a new Temperature value for the cow");
                                            Scanner tempedit = new Scanner(System.in);// create input stream for new
                                                                                      // tempedit
                                            String edittemp = tempedit.nextLine();// collect new temperature data
                                            int tempvalue = (Integer.parseInt(edittemp));// convert data to an int
                                            if (tempvalue > 0) {// check to make sure input is not negative
                                                current.settemp(tempvalue);// set the cow's new temperature
                                            } else {
                                                System.out.println("INVALID Temperature Value INPUTTED");
                                            }
                                            break;
                                        default:// Input does not match any edit option
                                            System.out.println("UNKNOWN REFERENCE TO TYPE OF EDIT");
                                    }
                                } else {
                                    System.out.println("INVALID INPUT");
                                }

                            } // BREAK THE LOOP AND ASK FOR VALUES

                        }

                        break;
                    case 3:
                        // REMOVE A COW
                        System.out.println("Please enter the ID of the cow you wish to remove from the record");
                        Scanner removeid = new Scanner(System.in);
                        int idremove = removeid.nextInt();
                        for (Cow c : cowlist) {
                            if (c.getid() == idremove) {
                                System.out.println("FOUND COW TO REMOVE");
                            } else {
                                System.out.println("No Cow in records with that ID");
                            }
                        }

                        break;
                    case 4:
                        // print the current list of cow records
                        for (int i = 0; i < cowlist.size(); i++) {
                            System.out.println(cowlist.get(i));
                        }

                        break;
                    case 5:
                        // Exit Program
                        System.out.println(5);
                        flag = false;
                        break;
                    default:
                        // NOT A VALID CHOICE
                        System.out.println("INVALID NUMBER");
                }
            } else {
                System.out.println("NUMBER UNDER ZERO");
            }

        }
        sc.close();

        System.out.print(cowlist.size());

        fr.close();// closes the file reader
    }

    public static int listcheck(ArrayList<Cow> cowlist, int id) {// method to check a list and see if it exists
        for (int i = 0; i < cowlist.size(); i++) {
            if (cowlist.get(i).getid() == id) {
                return i;
            }
        }
        return -1;
    }

    /*
     * public static boolean inputcheck(int input) { try{ Integer.parseInt(input); }
     * catch(NumberFormatException exception){ return false; } return true; }
     */
}