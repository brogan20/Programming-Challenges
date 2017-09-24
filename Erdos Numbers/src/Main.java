import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static Map<String, Integer> erdosNums;
    static Map<String, TreeSet<String>> authorMap;
    final static String erdos = "Erdos, P.";

    public static void main(String[] args) throws IOException {
        int scenarios = Integer.parseInt(input.readLine().trim());
        for (int scenario = 1; scenario <= scenarios; scenario++) {
            //Get number of papers and names
            String[] temp = input.readLine().trim().split(" ");
            int papers = Integer.parseInt(temp[0]);
            int nameNum = Integer.parseInt(temp[1]);


            //INPUT
            //Create array of all authors
            List<List<String>> authors = new ArrayList<>();
            for (int i = 0; i < papers; i++) {
                authors.add(extractAuthors(input.readLine()));
            }
//            for (int i = 0; i < authors.size(); i++) {
//                for (int j = 0; j < authors[i].length; j++) {
//                    authors[i][j] = authors[i][j].trim() + ".";
//                }
//            }
            //Get names to find erdos num for
            String[] names = new String[nameNum];
            for (int i = 0; i < nameNum; i++) {
                names[i] = input.readLine().trim();
            }
            //END INPUT


            //Connect all coauthors with each other.
            authorMap = new TreeMap<>();
            authorMap.put(erdos, new TreeSet<>());
            for (int i = 0; i < authors.size(); i++) {
                int authorSize = authors.get(i).size();
                for (int j = 0; j < authorSize; j++) {
                    String currentAuthor = authors.get(i).get(j);
                    if (authorMap.containsKey(currentAuthor)) {
                        for (int k = 0; k < authorSize; k++) {
                            authorMap.get(currentAuthor).add(authors.get(i).get(k));
                        }
                    } else {
                        authorMap.put(currentAuthor, new TreeSet<>());
                        for (int k = 0; k < authorSize; k++) {
                            authorMap.get(currentAuthor).add(authors.get(i).get(k));
                        }
                    }
                }
            }

            //Start finding erdos numbers
            erdosNums = new HashMap<>();
            for (int i = 0; i < authorMap.get(erdos).size(); i++) {
                erdosNumFinder(0, erdos);
            }

            //Finally give a result
            System.out.println("Scenario " + scenario);
            for (int i = 0; i < names.length; i++) {
                if (erdosNums.containsKey(names[i])) {
                    System.out.println(names[i] + " " + erdosNums.get(names[i]));
                } else {
                    System.out.println(names[i] + " infinity");
                }
            }
        }
    }
    //Credit to helvidios.blogspot.com for this method
    private static List<String> extractAuthors(String paperDesc){
        paperDesc = paperDesc.substring(0, paperDesc.indexOf(":"));
        List< String > names = new ArrayList< String >();
        int begin = 0;
        int end = paperDesc.indexOf(".,", begin);

        while(end != -1){
            names.add(paperDesc.substring(begin, end + 1));
            begin = end + 3;
            end = paperDesc.indexOf(".,", begin);
        }

        if(begin < (paperDesc.length() - 1))
            names.add(paperDesc.substring(begin));

        return names;
    }

    private static void erdosNumFinder(int num, String name) {
        if (!erdosNums.containsKey(name) || (erdosNums.get(name) > num)) {
            for (int i = 0; i < authorMap.get(name).size(); i++) {
                erdosNums.put(name, num);
                Iterator<String> iterator = authorMap.get(name).iterator();
                String s;
                while (iterator.hasNext()) {
                    erdosNumFinder(num + 1, iterator.next());
                }
            }
        }
    }
}
