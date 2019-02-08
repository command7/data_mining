import java.util.*;
/**
 * LBE04 Positional Index
 * Prof JK
 */
 
public class PositionalIndex {
   //attributes
   private String[] myDocs;
   private ArrayList<String> termList;
   private ArrayList<ArrayList<Doc>> docLists;
   
   //constructor
   public PositionalIndex(String[] docs) {
      myDocs = docs;
   }
   
   //Two-term phrase query
   public ArrayList<Integer> intersect(String phrase) {
      
      return null;
   }
   
   public String toString() {
      String outString = new String();
      for(int i=0;i<termList.size();i++) {
         outString += String.format("%-15s", termList.get(i));
         ArrayList<Doc> docList = docLists.get(i);
         for(int j=0;j<docList.size();j++) {
            outString += docList.get(j) + "\t";
         }
         outString += "\n";
      }
      return outString;
   }
   
   public static void main(String[] args) {
      String[] docs = {"text warehousing over big data",
                       "dimensional data warehouse over big data",
                       "nlp before text mining",
                       "nlp before text classification"};
                       
      PositionalIndex pi = new PositionalIndex(docs);
      System.out.println(pi);
      
      String query = "big data";
      
   }
}
//Doc class
class Doc {
   int docId;
   ArrayList<Integer> positionList;
   
   public Doc(int did, int position) {
      docId = did;
      positionList = new ArrayList<Integer>();
      positionList.add(position);
   }
   
   public void insertPosition(int position) {
      positionList.add(new Integer(position));
   }
   
   public String toString() {
      String docIdString = docId + ":<";
      for(Integer pos:positionList) {
         docIdString += pos + ",";
      }
      docIdString = docIdString.substring(0,docIdString.length()-1) + ">";
      return docIdString;
   }
}