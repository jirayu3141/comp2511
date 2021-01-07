//package example;

import java.util.Scanner;


public class Splitter {

    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter a sentence specified by spaces only: ");

        String strInput = myObj.nextLine();  // Read user input
        String[] strSplitted = strInput.split("\\s+");  // Split sentence and store in array
        
        for (int i = 0; i < strSplitted.length; i++) {
            System.out.println(strSplitted[i]);
        
        }
        myObj.close();
    }
}
 
