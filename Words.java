/**
 * Importing libraries 
 */
import java.util.*;
public class Words{

   /**
    * Declaring instance variable and set object. Set object stores distinct words in a level
    */ 
   private int level;
   private String chain;
   Set <String> worldLevel;
   boolean visted;
   
   /**
    * A no argument constructor that initializes instance variable and set object
    */ 
   public Words (boolean visted){
    level = 1; 
     worldLevel = new TreeSet <String>(); 
    chain = "";
    this.visted = visted;
    
   }

   /**
    * An argument constructor that initializes instance variable and set object
    * @param level, the level at which the word is found in the graph
    * @param chain, a string that is the chain of the parent element
    * @param parent, a string that is the name of the parent element
    */ 
   public Words (int level, String chain, String parent){
   this.level = level; 
   worldLevel = new TreeSet <String>();
   this.chain = chain + parent +"," ;
   visted = true;
   }
 
    /**
    * An argument constructor that initializes the set object and adds the word to the set
    * @param word, a string that is the name of the distinct word in a level
    */   
   public Words(String word){
     worldLevel = new TreeSet <String>();
     worldLevel.add(word);
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
   return chain;
   }
   
  /**
  * A getWordLevel method that returns a string array that is the elements of a particular level
  * @return a string array that is the elements of a particular level
  */   
   public String [] getWordLevel(){
   return worldLevel.toArray(new String[worldLevel.size()]);
   }
 
   /**
    * An addWord method that add a word to the set object
    * @param word, a string that is the name of the distinct word in a level
    */     
   public void addWord (String word){
     worldLevel.add(word);
   }
  

}