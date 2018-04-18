/**
  * Name: Aayush Shrestha 
  * Course:  CSCI 3005
  * Date Due:  January 2018   
  * Instructor: Dr. Cordova              
  * File name: AnimalTransport         
  *
  * Program Description: This program  that a given a list of animals to be transported, finds the smallest
  *                      number of containers needed to complete the shipment. 
 
                         
  * Plagiarism Statement:
  * I swear that I have not received or given aid on this program
  * beyond guidelines of the course including giving or receiving
  * specific code content.
  */
  
/**
 * Importing libraries 
 */
import java.util.*;
import java.io.*;

public class wordPairs
{

   /**
    * A constructor that initializes containers and animallist, and calls a createList method
    * @param filename, a string that is the name of file to be opened
    */
   public wordPairs (String name)
   {
     createList(name);           
   
   }
   
   /**
    * A createList method that reads from a file and stores the animal in the map
    * @param filename, a string that is the name of file to be opened
    */  
   public void createList(String filename)
   {
    /**
     * Using try catch to catch any exceptions
     */  
      try{
      
        /**
         * Creating file and scanner objects
         */ 
         File infile = new File(filename);
         Scanner read = new Scanner(infile);
         
        /**
         * A while loop that loops through the lines in the file
         */ 
         while (read.hasNext()){
            /**
             * converting to lowercase and storing it in an array
             */ 
            String line =   read.nextLine().toLowerCase();
            String [] array = line.split(",");
            
            /**
             * Declaring variables and storing the words
             */ 
            String first = array[0];
            String second = array[1];                     
         }
      }
      catch(Exception x){
        /**
         * Runs incase of any exception
         */
         System.out.println("An Exception occured :"+ x);
      }
   }





}