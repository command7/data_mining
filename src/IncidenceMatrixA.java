import java.util.*;
/**
 * 612 LBE01 IncidenceMatrix
 * Prof. Kang
 */

public class IncidenceMatrixA {
    //attributes
    private String[] documents;               //input docs
    private ArrayList<String> terms;    //dictionary
    private ArrayList<ArrayList<Integer>> mineInfos;
    private ArrayList<Integer> mineIndivInfo;

    //Constructor
    public IncidenceMatrixA(String[] _documents) {
        documents = _documents;
        terms = new ArrayList<String>();
        mineInfos = new ArrayList<ArrayList<Integer>>();
        mineIndivInfo = new ArrayList<Integer>();

        for (int doc = 0; doc<documents.length; doc++) {
            String[] words = documents[doc].split(" ");
            for(String word: words) {
                if(!terms.contains(word)) {
                    terms.add(word);
                    int[] mineInfo = new int[documents.length];
                    mineInfo[doc] = 1;
                    mineInfos.add(mineInfo);
                }
                else {
                    int termIndex = terms.indexOf(word);
                    int [] mineInfo = mineInfos.remove(termIndex);
                    mineInfo[doc] = 1;
                    mineInfos.add(termIndex, mineInfo);

                }
            }

        }

    }

    public ArrayList<String> search(String query) {
        ArrayList resultDocs = new ArrayList<String>();
        for(String term: terms) {
            if(query.equals(term)) {
                int termIndex = terms.indexOf(term);
                int [] termMineInfo = mineInfos.get(termIndex);
                for (int docIndex = 0; docIndex < termMineInfo.length; docIndex++) {
                  if(termMineInfo[docIndex] == 1) {
                     resultDocs.add(documents[docIndex]);
                    
                    }
                }

            }
        }
        return resultDocs;

    }

    public String toString() {
        String outputString = new String();
        for(int termIndex=0;termIndex<terms.size();termIndex++) {
            outputString += String.format("%-15s", terms.get(termIndex));
            int[] mineInfo = mineInfos.get(termIndex);
            for(int mineInfoIndex=0; mineInfoIndex<mineInfo.length; mineInfoIndex++) {
                outputString += mineInfo[mineInfoIndex] + "\t";
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
        IncidenceMatrixA test = new IncidenceMatrixA(docs);
        System.out.println(test);
        if(args.length >0) {
            ArrayList dataDocuments = test.search(args[0]);
            System.out.println(dataDocuments);
        }
    }
}