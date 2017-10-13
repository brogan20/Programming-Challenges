import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static Map<String, HashSet<String>> graph = new HashMap<>();

    public static void main(String[] args) throws IOException{
        //Get input dictionary
        String in;
        while (!(in = input.readLine()).equals("")) {
            graph.put(in, new HashSet<>());
        }

        //Make graph of words linked to words with a char difference of 1.
        //Do not connect words of different lengths
        for (String word : graph.keySet()) {
            for (String compareWord : graph.keySet()) {
                //Make sure it isn't the same word
                //And that they aren't different lengths
                if (word.equals(compareWord)) continue;
                if (word.length() != compareWord.length()) continue;
                //Find the number of chars different
                int diff = 0;
                for (int pos = 0; pos < word.length(); pos++){
                    if(word.charAt(pos) != compareWord.charAt(pos)) diff++;
                }
                if (diff == 1) graph.get(word).add(compareWord);
            }
        }

        //Get pairs and solve
        while (!(in = input.readLine()).equals("")){
            String[] pair = in.split(" ");

        }
    }
}
