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

public class WordPairs
{

   DiGraph graph;
   private int globalCount;

   /**
    * A constructor that initializes containers and animallist, and calls a createList method
    * @param filename, a string that is the name of file to be opened
    */
   public WordPairs (String name)
   {
      graph = new DiGraph();
      globalCount = 0;
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
         while (read.hasNextLine()){
            /**
             * converting to lowercase and storing it in an array
             */ 
            String line =   read.nextLine().toLowerCase();
            String [] array = line.split(" ");
            
            /**
             * Declaring variables and storing the words
             */ 
            String first = array[0];
            String second = array[1];   
            
            
            graph.addVertex(first);
            graph.addVertex(second);
            graph.addEdge(first, second);          
                              
         }
         //  System.out.println(graph); 
      
      }
      catch(Exception x){
        /**
         * Runs incase of any exception
         */
         System.out.println("An Exception occured :"+ x);
      }
   }
   
 /**
  * returns the shortest sequence of word pairs that begins with first and ends with last
  */
   public String wordChain(String first, String last){
   
   
      bfs (first, last);
      
      return "[]";
   }
  
   /**
  *  returns the number of word pairs in theshortest chain that begins with first and ends with last. 
  */
   public int chainLength(String first, String last)
   {
      return 0;
   } 
   
   public int reachableFrom(String word){
      return bfs(word);
   
   }

   public int reachableFrom(String word, int maxLength){
      return bfs(word, maxLength);
   
   }

   public String reachableWords(String word, int maxLength)
   {
      return bfss(word, maxLength);
   }

   public String cycle(String word){
      return "[]";
   }


   public void bfs(String vertex, String last){
      int a = 0;
      String removed;
   
      Set <String> visted = new HashSet<String>();
      Set <String> vertices;
      LinkedList <String> list = new LinkedList <String>();
      
      //words
   //   Map <String, Set<String>> = new hashMap(); 
      list.add(vertex);
      visted.add(vertex);    
      a++;
      
      while(!list.isEmpty())
      {
         removed = list.poll();
         vertices = graph.getAdjacent(removed);
         graph2.addVertex(removed);

      
         for(String each: vertices)
         {
            if(!visted.contains(each))
            {
               list.add(each);
               visted.add(each);
                 graph2.addVertex(each);
               graph2.addEdge(removed, each); 
              // System.out.println((a++)+". "+removed+" to "+each);
            
            }
            if(each.equals(last))
            {
               list =  new LinkedList <String>();
               break;
            }
          }     
      }
      
     
   }
   
   
   public int bfs(String vertex){
      int a = 0;
      String removed;
   
      Set <String> visted = new HashSet<String>();
      Set <String> vertices;
      LinkedList <String> list = new LinkedList <String>();
      
      list.add(vertex);
      visted.add(vertex);
      a++;
      
      while(!list.isEmpty())
      {
         removed = list.poll();
         vertices = graph.getAdjacent(removed);
      
         for(String each: vertices)
         {
            if(!visted.contains(each))
            {
               list.add(each);
               visted.add(each);
               a++;
            }
         
         }     
      
      } 
      return a;
   }
   
   public int bfs(String vertex, int i){
      int a = 0;
      String removed;
   
      Set <String> visted = new HashSet<String>();
      Set <String> vertices;
      LinkedList <String> list = new LinkedList <String>();
      
      list.add(vertex);
      visted.add(vertex);
      a++;
      
      while(!list.isEmpty() && i >= 0)
      {
         removed = list.poll();
         vertices = graph.getAdjacent(removed);
         i--;
         for(String each: vertices)
         {
            if(!visted.contains(each))
            {
               list.add(each);
               visted.add(each);
               a++;
          }
         }     
      
      } 
      return a;
   }
   
   public String bfss(String vertex, int i){
      int a = 0;
      String removed;
      boolean child;
      String word = "";
      Set <String> visted = new HashSet<String>();
      Set <String> vertices;
      LinkedList <String> list = new LinkedList <String>();
      
      list.add(vertex);
      visted.add(vertex);
      a++;
      word = "[" + vertex + "]";
      
      while(!list.isEmpty() && i >= 0)
      {
         removed = list.poll();
         vertices = graph.getAdjacent(removed);
         i--;
         word += "\n[";
         child = false;
         for(String each: vertices)
         {
          
            if(!visted.contains(each))
            {
               list.add(each);
               visted.add(each);
               a++;
               word += each +", ";
               child = true;
            }
          
         } 
         word = word.substring(0, word.length()-2);    
         if(child)
            word += "]";
      } 
      
      
      return word;
   }
   
   
   
   
   

}