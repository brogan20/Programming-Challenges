import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static Map<String, HashSet<String>> graph = new HashMap<>();

    public static void main(String[] args) throws IOException{
        //Get input dictionary
        String in;
        while (!(in = input.readLine()).equals("")) {
            graph.put(in, new HashSet<>());
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
            //BFS courtesy of wikipedia pseudocode
            Queue<String> open_set = new LinkedList<>();
            Set<String> closed_set = new HashSet<>();
            Map<String, ArrayList<String>> dict = new HashMap<>();
            
            String start = pair[0];
            dict.put(start, new ArrayList<>());
            dict.get(start).add(start);
            String end = pair[1];

            char[] parentArr;
            char[] wordArr;
            open_set.add(start);
            while (open_set.size() > 0){
                String parent_state = open_set.poll();
                parentArr = parent_state.toCharArray();
                //Find doublets here.
                Set parentSet = graph.get(parent_state);
                for (String word : graph.keySet()) {
                    if(word.length() != parent_state.length() || parentSet.contains(word) || word.equals(parent_state)) continue;
                    wordArr = word.toCharArray();
                    int diff = 0;
                    for (int i = 0; i < parentArr.length; i++) {
                        if(parentArr[i] != wordArr[i]){
                            diff++;
                        }
                        if(diff > 1)  break;
                    }
                    if (diff <= 1){
                        graph.get(parent_state).add(word);
                        graph.get(word).add(parent_state);
                    }
                }
                if(parent_state.equals(end)){
                    for (String word : dict.get(parent_state)) {
                        System.out.println(word);
                    }
                    System.out.println();
                }

                for (String child : graph.get(parent_state)) {
                    if (closed_set.contains(child)) continue;

                    if (!open_set.contains(child)){
                        if(!dict.containsKey(child)){
                            dict.put(child, dict.get(parent_state));
                        }
                        dict.get(child).add(child);
                        open_set.add(child);
                    }
                }
                closed_set.add(parent_state);
            }
        }
    }
}
