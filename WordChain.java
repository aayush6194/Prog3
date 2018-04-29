
/**
 * Importing required libraries 
 */
import java.util.*;
import java.io.*;

public class WordChain {

   Map <String, Words> wordMap; 
   Map <Integer, Words> levelMap;   
   LinkedList <String> q = new LinkedList <String>();


   public WordChain (String word){
      wordMap = new HashMap <String, Words>();
      levelMap = new HashMap <Integer, Words>();
      q = new LinkedList <String>();
      add(word, 1, "");
    
   }
   
   public void add(String word, int level, String chain){
      q.add(word);
      wordMap.put(word, new Words(level, chain));
      if(!levelMap.containsKey(level))
         levelMap.put(level, new Words(word));   
      else 
         levelMap.get(level).addWord(word);      
   
   }

   public String poll(){
      return q.poll();
   }
   
   public boolean isEmpty(){
      return q.isEmpty();
   }
   

   public String getAllLevelsWords(int maxLevel)
   {
   String chain = "";
      for(int i = 1; i <= maxLevel+1; i++){
          /**
           * if a level in a map isnt empty
           */
         if(levelMap.containsKey(i))
            chain += (Arrays.toString((levelMap.get(i)).getWordsOfLevel())) +"\n";
         else
            chain += "[]\n"; 
      }
   
      return chain;
   }
   
   public boolean containsKey(int i){
      return levelMap.containsKey(i);
   }
   public int getLevel (String word){
   
      return wordMap.get(word).getLevel();
   }
   
   public String getChain (String word){
      return wordMap.get(word).getChain();
   }

   public int size(){
      return wordMap.size();
   }

}