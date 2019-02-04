import java.io.*;
import java.util.*;
/**
 * ISTE-612 LBE03 Text processing
 * Prof Kang
 */

public class ParserA {
    private String[] myDocs;

    String[] stopWords = {"a","is","in","so","of", "at", "the","to","and","it","as",
            "be","are","on","into","if","it's"};

    public ParserA() {
        Arrays.sort(stopWords);
        String sortedStopWords = new String();
        for (String stopWord: stopWords) {
            sortedStopWords += stopWord + " ";
        }
        System.out.println(sortedStopWords);
    }

    //Binary search for a stop word
    //Return -1 if stop word found else return +1
    public int searchStopWord(String key) {
        int lowerIndex = 0;
        int higherIndex = stopWords.length-1;

        while(lowerIndex < higherIndex) {
            int mid = lowerIndex + higherIndex-lowerIndex / 2;
            int result = key.compareTo(stopWords[mid]);
            if(result < 0) {
                higherIndex = mid -1;
            }
            else if (result > 0) {
                lowerIndex = mid+1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }

    //Tokenization
    public ArrayList<String> parse(File fileName) throws IOException {
        String tokens [] = null; //original tokens
        ArrayList<String> dirtyTokens = new ArrayList<String>(); //stop words removed tokens
        ArrayList<String> stemmedTokens = new ArrayList<String>(); //stemmed tokens
        Scanner scan = new Scanner(fileName);
        String stringifiedDocument = new String();

        // Case folding  - all text to lowercase
        while (scan.hasNextLine()) {
            allLines += scan.nextLine().toLowerCase();
        }

        tokens = allLines.split("[ '.,?!:;$%+()\\-\\*]");

        //remove stop words
        for (String token: tokens) {
            if (searchStopWord(token) == -1) {
                dirtyTokens.add(token);
            }
        }

        //stem words
        for (String dirtyToken: dirtyTokens) {
            Stemmer stemmer = new Stemmer();
            stemmer.add(dirtyToken.toCharArray(), dirtyToken.length());
            stemmer.stem();
            stemmedTokens.add(stemmer.toString());
        }

        return stemmedTokens;
    }

    public static void main(String[] args) {
        ParserA test = new ParserA();
        System.out.println("Stop word index: " + test.searchStopWord("are"));

        Stemmer stemTest = new Stemmer();
        String stemTestWord = "replacement";
        stemTest.add(stemTestWord.toCharArray(), stemTestWord.length());
        stemTest.stem();
        System.out.println("Stemmed word: " + stemTest.toString());
    }
}