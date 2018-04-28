import java.util.*;
public class Words
{

   private int level;
   private String chain;
   Set <String> worldLevel;
   
   public Words (){
    level = 1; 
     worldLevel = new TreeSet <String>(); 
    chain = "";
   }

   public Words (int level, String chain, String parent){
   this.level = level; 
   worldLevel = new TreeSet <String>();
   this.chain = chain + parent +"," ;
   }
   
   public Words(String word){
     worldLevel = new TreeSet <String>();
     worldLevel.add(word);
   }

   public int getLevel(){
   return level;  
   }
   
   public String getChain(){
   return chain;
   }
   
   
   public String [] getWordLevel(){
   return worldLevel.toArray(new String[worldLevel.size()]);
   }
   
   public void addWord (String word){
  
     worldLevel.add(word);
   }
  

}