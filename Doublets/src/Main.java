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
            //Ensures the pair is valid.
            //If it isn't a valid pair, then print no solution
            if ((!graph.containsKey(pair[0]) && !graph.containsKey(pair[1])) || (pair[0].length() != pair[1].length())){
                System.out.println("No solution.\n");
                continue;
            }
            //Start finding the path
            //Implementing Dijkstra's algorithm
            Set<String> processed = new HashSet<>();
            Map<String, Integer> discovered = new HashMap<>();
            Queue<String> queue = new LinkedList<>();
            String current;
            int distance = 1;


            queue.add(pair[0]);
            discovered.put(pair[0],0);
            while (queue.size() > 0){
                current = queue.poll();
                //Process the current word and continue down the graph
                if(!processed.contains(current)){

                    processed.add(current);
                }

            }
        }
    }
}
