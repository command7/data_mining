import java.util.*;
/**
 * 612 LBE01 IncidenceMatrix
 * Prof. Kang
 */

public class IncidenceMatrixA {
    //attributes
    private String[] myDocs;               //input docs
    private ArrayList<String> termList;    //dictionary
    private ArrayList<int[]> docLists;

    //Constructor
    public IncidenceMatrixA(String[] docs) {
        myDocs = docs;
        termList = new ArrayList<String>();
        docLists = new ArrayList<int[]>();

        for (int i = 0; i<myDocs.length; i++) {
            
        }

    }

    public ArrayList<Integer> search(String query) {
        return null;
    }

    public String toString() {
        String outputString = new String();
        for(int i=0;i<termList.size();i++) {
            outputString += String.format("%-15s", termList.get(i));
            int[] docList = docLists.get(i);
            for(int j=0;j<docList.length;j++) {
                outputString += docList[j] + "\t";
            }
            outputString += "\n";
        }
        return outputString;
    }

    public static void main(String[] args) {
        //a document collection: corpus
        String[] docs = {"text data warehousing over big data",
                "dimensional data warehousing over big data",
                "nlp before text mining",
                "nlp before text classification"};
    }
}