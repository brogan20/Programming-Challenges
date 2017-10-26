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
            Queue<String> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            Map<String, ArrayList<String>> pathInfo = new HashMap<>();
            
            String start = pair[0];
            pathInfo.put(start, new ArrayList<>());
            pathInfo.get(start).add(start);
            String end = pair[1];

            queue.add(start);
            while (queue.size() > 0){
                
                //Find doublets here.
                //To be implemented

                String parent = queue.poll();

                for (String child : graph.get(parent)) {
                    if (visited.contains(child)) continue;

                    if (!queue.contains(child)){
                        if(!pathInfo.containsKey(child)){
                            pathInfo.put(child, pathInfo.get(parent));
                        }
                        pathInfo.get(child).add(child);

                        if(child.equals(end)){
                            for (String word : pathInfo.get(child)) {
                                System.out.println(word);
                            }
                            System.out.println();
                        }

                        queue.add(child);
                    }
                }
                visited.add(parent);
            }
        }
    }
}
