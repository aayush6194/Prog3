/**
 * Importing libraries 
 */
import java.util.*;


/**
 * A words class that is instanciated to store the node level and node's word chain(word pairs) for each word.
 *   
 * Also, to find of the nodes in a certain level a Level map is used that takes int (level of the word) and word class object to store nodes (alphabetically) in a set 
 * per the level of the node.
 */

public class Words{

   /**
    * Declaring instance variable and set object. Set object stores distinct words in a level
    */ 
   private int level;
   private String wordChain;
   Set <String> wordsOfLevel;

   
   /**
    * A no argument constructor that initializes instance variable and set object
    */ 
   public Words (){
    level = 1; 
    wordsOfLevel = new TreeSet <String>(); 
    wordChain = "";

   }

   /**
    * An argument constructor that initializes instance variable and set object
    * @param level, the level at which the word is found in the graph
    * @param chain, a string that is the chain of the parent element
    * @param parent, a string that is the name of the parent element
    */ 
   public Words (int level, String  wordChain){
   this.level = level; 
   wordsOfLevel = new TreeSet <String>();
   this. wordChain =  wordChain +"," ;
   }
 
    /**
    * An argument constructor that initializes the set object and adds the word to the set
    * @param word, a string that is the name of the distinct word in a level
    */   
   public Words(String word){
     wordsOfLevel = new TreeSet <String>();
     wordsOfLevel.add(word);
   }

   
 /**
  * A getLevel method that returns the level at which the certain word is found in the Digraph object 
  * @return an int the level at which the word is found in the graph  
  */  
   public int getLevel(){
   return level;  
   }
 
 /**
  * A getLevel method that returns a string that is the chain of the element the word is associated to
  * @return a string that is the chain of the element
  */    
   public String getChain(){
   return  wordChain;
   }
   
  /**
  * A getWordLevel method that returns a string array that is the elements of a particular level
  * @return a string array that is the elements of a particular level
  */   
   public String [] getWordsOfLevel(){
   return wordsOfLevel.toArray(new String[wordsOfLevel.size()]);
   }
 
   /**
    * An addWord method that add a word to the set object
    * @param word, a string that is the name of the distinct word in a level
    */     
   public void addWord (String word){
     wordsOfLevel.add(word);
   }

}