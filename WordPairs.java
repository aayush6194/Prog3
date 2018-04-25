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
   
   
          
      return   bfs (first, last);
   
   }
  
   /**
  *  returns the number of word pairs in theshortest chain that begins with first and ends with last. 
  */
   public int chainLength(String first, String last)
   {
      return  bfsi(first,  last);
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
      return bfsc(word);
   }


   public String bfs(String vertex, String last){
      int a = 0, child = 0, base = 0;
      String removed;
      boolean found = false;
      String f = vertex;
      
      Set <String> visted = new HashSet<String>();
      Set <String> vertices;
      LinkedList <String> list = new LinkedList <String>();
      
      //words
      Map <String, String> amap = new HashMap <String, String>(); 
      list.add(vertex);
      visted.add(vertex);    
      a++;
      
      
      while(!list.isEmpty())
      {
         removed = list.poll();
         vertices = graph.getAdjacent(removed);
         child = 0;
      
         for(String each: vertices)
         {
            if(!visted.contains(each))
            {
               list.add(each);
               visted.add(each);
               amap.put(each, removed);
               child ++;
            
            
            }
            if(each.equals(last))
            {
               list =  new LinkedList <String>();
               found = true;
               break;
            }
         }     
      }
      
      if(found)
      {
         String word = last;
         String prev = "";
         String total ="";
         int count = 0;
         while(found && !word.equals(f))
         {
            prev = word;
            word = amap.get(word);
            total =  word + " "+ prev  +"," +total; 
            count++;     
         
         }
      
         total = "[" + total.substring(0, total.length()-1)+"]";
      //    System.out.println(base);
         return total; 
        
      }
      else
         return "[]";
     
   }
   
   public int bfsi(String vertex, String last){
      int a = 0, base = 0;
      String removed;
      boolean found = false;
      String f = vertex;
   
      Set <String> visted = new HashSet<String>();
      Set <String> vertices;
      LinkedList <String> list = new LinkedList <String>();
      
      //words
      Map <String, String> amap = new HashMap <String, String>(); 
      list.add(vertex);
      visted.add(vertex);    
      a++;
      
      while(!list.isEmpty())
      {
         removed = list.poll();
         vertices = graph.getAdjacent(removed);
                    // base++;
      
         for(String each: vertices)
         {
            if(!visted.contains(each))
            {
               list.add(each);
               visted.add(each);
               amap.put(each, removed);
            
            }
            if(each.equals(last))
            {
               list =  new LinkedList <String>();
               found = true;
               break;
            }
         }     
      }
      String word = last;
      String prev = "";
      String total ="";
      int count = 0;
      while(found && !word.equals(f))
      {
         prev = word;
         word = amap.get(word);
         total =  word + ", "+ prev  +", " +total; 
         count++;     
      
      }
      
      total = "[" + total.substring(0, total.length()-2)+"]";
      //System.out.println(count);
      return count;      
     
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
      int a = 0, level = 0;
     if (i == 1)
      return graph.getAdjacent(vertex).size()+1;
      String removed;
      boolean reached = false;
   
      Set <String> visted = new HashSet<String>();
      Set <String> vertices;
      LinkedList <String> list = new LinkedList <String>();
      Map <String, String> amap = new HashMap <String, String>(); 
   
      
      list.add(vertex);
      visted.add(vertex);
      a++;
      
      while(!list.isEmpty() && !reached)
      {
         removed = list.poll();
         vertices = graph.getAdjacent(removed);
         String last = "s";
       
         for(String each: vertices)
         {
            
            if(!visted.contains(each))
            {
               list.add(each);
               visted.add(each);
               a++;
               amap.put(each, removed);
               last = each;
            }
             
             
         }   
         int count = 0;
         if ( level > 0 && visted.contains(last))
         {
            while (!last.equals(vertex))
            {
            
               last = amap.get(last);
               count++;
            }
         
            reached = count == i;
         }
         level++;
         
         // System.out.println(count);
      
      } 
      return a;
   }
   
   public String bfss(String vertex, int i){
      int a = 0,level = 0;
      String removed;
      boolean child, reached = false;
      String word = "";
      Set <String> visted = new HashSet<String>();
      Set <String> vertices;
      LinkedList <String> list = new LinkedList <String>();
      Map <String, String> amap = new HashMap <String, String>(); 
   
      
      list.add(vertex);
      visted.add(vertex);
      a++;
      word = "[" + vertex + "]";
      
      while(!list.isEmpty()&& !reached)
      {
         removed = list.poll();
         vertices = graph.getAdjacent(removed);
           String last = "s";

         if (vertices.size() > 0)
            word += "\n[";
         child = false;
         
         
              Iterator<String> it = vertices.iterator();
     while(it.hasNext()){
      String each = it.next();
            if(!visted.contains(each))
            {
               list.add(each);
               visted.add(each);
               a++;
               if(it.hasNext())
                  word += each +", ";
               else
                  word += each;
              amap.put(each, removed);
               last = each;
            
            }

     }
         
      
          int count = 0;
         if ( level > 0 && visted.contains(last))
         {
            while (!last.equals(vertex))
            {
            
               last = amap.get(last);
               count++;
            }
         
            reached = count == i;
         }
         level++;
  
        //word = word.substring(0, word.length()-1);    
        if(vertices.size() > 0)
            word += "]";
      } 
      
      
      return word;
   }
   
   
   public String bfsc(String vertex){
      int a = 0, base = 0;
      String removed;
      boolean found = false;
      String f = vertex;
   
      Set <String> visted = new HashSet<String>();
      Set <String> vertices;
      LinkedList <String> list = new LinkedList <String>();
      
      //words
      Map <String, String> amap = new HashMap <String, String>(); 
      list.add(vertex);
      visted.add(vertex);    
      a++;
      
      while(!list.isEmpty())
      {
         removed = list.poll();
         vertices = graph.getAdjacent(removed);
                    // base++;
      
         for(String each: vertices)
         {
            if(!visted.contains(each) || each.equals(f))
            {
               list.add(each);
               visted.add(each);
               amap.put(each, removed);
            //     System.out.println(each);
            
            }
            if(each.equals(vertex) )
            {
               list =  new LinkedList <String>();
               found = true;
               break;
            }
         }     
      }
      
      if(found){
         String word = vertex;
         String prev = "";
         String total ="";
         int count = 0;
         boolean done = false;
         boolean first = true;
         while(found && !done)
         {
            prev = word;
         
            word = amap.get(word);
            done = word.equals(f);
            if(!first)
               total =  word + " "+ prev  +"," +total; 
            else
               total =  word + " "+ prev  ;
         
            first = false;    
            count++;     
         
         }
      
         total = "[" + total+"]";
         return total;   
      }
      else
         return "[]";   
     
   }

   
   

}