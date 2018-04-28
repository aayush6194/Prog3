/**
  * Name: Aayush Shrestha 
  * Course:  CSCI 3005
  * Date Due:  January 2018   
  * Instructor: Dr. Cordova              
  * File name: WordPairs         
  *
                      
  * Plagiarism Statement:
  * I swear that I have not received or given aid on this program
  * beyond guidelines of the course including giving or receiving
  * specific code content.
  */
  
/**
 * This program  that a given a list of words and it's edges, finds the 
 */
import java.util.*;
import java.io.*;



/**
 * Program header and description:
 *
 * A wordPairs class that a given a list of words and following words (vertex and edges connection) reads the file and uses DiGraph class for a
 * adjecency list representation of a graph. Also additonal Word class objects are used to store the node level and node's word chain(word pairs) for each word.
 *   
 * WordPair class uses breadth for search algorithm to reach a required node or a required level of nodes as per the method that calls the bfs method.
 * Also, to find of the nodes in a certain level a Level map is used that takes int (level of the word) and word class object to store nodes (alphabetically) in a set 
 * per the level of the node. Map key is traversed by a for loop to retrive elements in each level.
 * To find of the stortest word chain or chain length till a certain node is traversed, a wordMap map is used that takes string (name of the word) and word class object to store chain  in as a string.
 * Chain is stored as string and not array to aviod passing an array per every word(node) as argument(because of java's type checking).
 * Additonally, a visted set is used to keep track of the visted node. 
 * The chain string is retrived by updating a globalChain varible by bfs method, it is reset before each use to aviod any stale data.
 * To use a common bfs method for each method, it uses diffrent arguments to target a required data.
 * String last is pass as null if the method does not require finding an element
 * int maxLevel is pass as -1 if the method does not require reaching a certain level in the graph
 */
public class WordPairs
{
   /**
    * Declaring instance variable and DiGraph object
    */ 
   DiGraph graph;
   private String globalChain;

   /**
    * A constructor that initializes variable and DiGraph object and calls a createList method
    * @param filename, a string that is the name of file to be opened
    */
   public WordPairs (String name){
     /**
      * initilizing the object and variables and call to createList method
      */
      graph = new DiGraph();
      globalChain = "";
      createList(name);            
   }
   
   /**
    * A createList method that reads from a file and stores the word in the DiGraph object as vertices and creates
    * edges.
    * @param filename, a string that is the name of file to be opened
    */  
   public void createList(String filename){
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
            String [] array = (read.nextLine().toLowerCase()).split(" ");
            
            /**
             * Declaring variables and storing the words
             */ 
            String first = array[0];
            String second = array[1];   
            
            /**
             * Adding the vertices and connecting the edges
             */ 
            graph.addVertex(first);
            graph.addVertex(second);
            graph.addEdge(first, second);                               
         }     
      }
      catch(Exception x){
        /**
         * Runs incase of any exception
         */
         System.out.println("An Exception occured :"+ x);
      }
   }
   
 /**
  * A wordChain method that takes first and last word and returns the shortest sequence of word chain 
  * that begins with first and ends with last.
  * @param first, a string that first starting node (word) or the root for the traversal 
  * @param last, a string that last node (word) or the last child for the traversal 
  * @return a string that is  shortest chain of word that begins with first and ends with last,using a certain format.
  */    
   public String wordChain(String first, String last){ 
     /**
      * Reseting the chain and call to breadth for search algorithm.
      */    
      globalChain = "";
      bfs(first, last, -1);
      return globalChain;
   }
     

 /**
  * A chainLength method that takes first and last word and returns number of words in the shortest sequence of word chain 
  * that begins with first and ends with last.
  * @param first, a string that first starting node (word) or the root for the traversal 
  * @param last, a string that last node (word) or the last child for the traversal 
  * @return an int, that is the number of words pairs in the shortest chain that begins with first and ends with last.
  */
   public int chainLength(String first, String last){
      return  bfs(first, last, -1);
   } 
   
 /**
  * A reachableForm method that takes word and returns number of distinct words in the chain from the traversal that begins with word. 
  * that begins with first and ends with last.
  * @param word, a string that first starting node (word) or the root for the traversal 
  * @return an int, that is the number of  distinct words  in the chain from the traversal that begins with word.
  */   
   public int reachableFrom(String word){
      return reachableFrom(word, -1);
   }

 /**
  * A reachableForm method that takes word and max number of distinct words in the chain from the traversal that 
  * begins with word and returns number of distinct words in the chain from the traversal that begins with word.
  * that begins with first and ends with last.
  * @param word, a string that first starting node (word) or the root for the traversal
  * @param maxLength, an int that is max number of distinct words in the chain
  * @return an int, that is the number of  distinct words  in the chain from the traversal that begins with word.
  */   
   public int reachableFrom(String word, int maxLength){
      return bfs(word, null, maxLength);
   }

/**
  * A reachableForm method that takes word and max number of distinct words in the chain from the traversal that 
  * begins with word and returns distinct words in the chain from the traversal that begins with word that begins with first and ends with last.
  * @param word, a string that first starting node (word) or the root for the traversal
  * @param maxLength, an int that is max number of distinct words in the chain
  * @return a string, that is the distinct words  in the chain from the traversal that begins with word.
  */ 
   public String reachableWords(String word, int maxLength){
     /**
      * Reseting the chain and call to breadth for search algorithm.
      */
      globalChain = "";
      bfs(word, "-1", maxLength);
      return globalChain;
   }

 /**
  * A cycle method that takes  word and returns the shortest sequence of word chain 
  * that begins with word and also ends with word.
  * @param word, a string that first starting node (word) or the root for the traversal, also the last node (word) or the last child for the traversal  
  * @return a string, that is  shortest chain of word pairs that begins with word and ends with word,using a certain format.
  */ 
   public String cycle(String word){
     /**
      * Reseting the chain and call to breadth for search algorithm.
      */
      globalChain = "";
      bfs(word, word, 0);
      return globalChain;
   }
     
 /**
  * A bfs method that takes first and last word and returns number of words in the shortest sequence of word chain 
  * that begins with first and ends with last.
  * @param first, a string that first starting node (word) or the root for the traversal 
  * @param last, a string that last node (word) or the last child for the traversal 
  * @param maxLevel, number of level till which the nodes are traversed
  * @return an int, that is the number of distint words or wordpairs in the shortest chain that begins with first and ends with last (if last exist)
  * return int values depends on the value of last and maxLevel
  */       
   private int bfs(String vertex, String last, int maxLevel){
   /**
    * Declaring and initilizing variables and data structures objects
    */       
      String parent;
      int reachedLevel = 1;
      boolean reached = false, found = false, first = true;  
      LinkedList <String> q = new LinkedList <String>();
   /**
    * wordMap stores each word as string and it's length and chain. Level stores words in each level
    */   
      Map <String, Words> wordMap = new HashMap <String, Words>();
      Map <Integer, Words> level = new HashMap <Integer, Words>(); 
      //visted
      Set <String> visted = new HashSet<String>();
   /**
    * Addting the first node to the data structures objects
    */      
      q.add(vertex);
      if(!vertex.equals(last))
         visted.add(vertex);
      wordMap.put(vertex, new Words());
      level.put(1, new Words(vertex));
         
   /**
    * while loop iterates till the queue is empty or the last node is found or the desire level is reached
    */   
      while(!q.isEmpty() && !reached){      
        /**
         * Declaring and initilizing variables
         */   
         parent = q.poll();
         String currentChain = wordMap.get(parent).getChain();
         int currentLevel = wordMap.get(parent).getLevel();
      
         /**
         * checking for the end condition and setting the flags
         */           
         if( (currentLevel -1 == maxLevel || (parent.equals(last)) && (!first))){ 
            reachedLevel = currentLevel -1 ;
            reached = true;
            found = parent.equals(last);
         }
         else  {
         
           /**
            * iterates the nearest child node
            */           
            for(String each: graph.getAdjacent(parent)){            
               /**
                * checking if the node has been visted
                */  
               if(!visted.contains(each) ){
               
               /**
                * adding the node to the queue, visted set, level and wordMap
                */   
                  q.add(each);          
                  wordMap.put(each, new Words(currentLevel +1, currentChain, parent +" " +each));
                  visted.add(each);    
                /**
                 * checking if level map has the key
                 */                          
                  if(!level.containsKey(currentLevel+1))
                     level.put(currentLevel+1, new Words(each));   
                  else 
                     level.get(currentLevel+1).addWord(each);               
               }
            }
            first = false;
         }         
      }
      
     /**
      * last string is null when the end word is indefined and number of distinct word is returned
      */      
      if (last == (null))      
         return wordMap.size();
      
     /**
      * last string is "-1" when the end word is indefined and globalChain is updated with distint words as each level and 0 is returned
      * It is done to  aviod unnecessarily updating the globalChain if the method does not require it
      */  
      else if(last.equals("-1")){
         globalChain = "";      
      /**
       * iterates the each level of the map
       */   
         for(int i = 1; i <= maxLevel+1; i++){
          /**
           * if a level in a map isnt empty
           */
            if(level.containsKey(i))
               globalChain +=(Arrays.toString(level.get(i).getWordLevel())) +"\n";
            else
               globalChain += "[]\n"; 
         }
         return 0;
      }
     /**
      * last string is not -1 or null the globalChain is updated with distint words pairs and number of word pairs is returned
      */
      else if(found){
      /**
       * globalChain is updated with the chain of the last element and return the reachedLevel
       */ 
         globalChain = wordMap.get(last).getChain(); 
         if(globalChain.length() > 0)
            globalChain = "[" + globalChain.substring(0, globalChain.length()-1) + "]";
            
         return reachedLevel;
      }
      
      /**
       * globalChain is updated with the "[]" if there is no link and returns max integer
       */ 
      globalChain = "[]";
      return Integer.MAX_VALUE;
   }
}