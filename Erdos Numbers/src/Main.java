import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private final static String erdos = "Erdos, P.";

    public static void main(String[] args) throws IOException {
        int scenarios = Integer.parseInt(input.readLine().trim());

        for (int scenario = 1; scenario <= scenarios; scenario++) {
            //Get number of papers and names
            String[] temp = input.readLine().trim().split(" ");
            int papers = Integer.parseInt(temp[0]);
            int nameNum = Integer.parseInt(temp[1]);

            //Get the inputs and split off the excess
            String[][] paperDatabase = new String[papers][];
            for (int i = 0; i < papers; i++) {
                paperDatabase[i] = input.readLine().split(":");
            }

            //Get all the authors in a map
            HashMap<String, HashSet<String>> coauthors = new HashMap<>();
            for (String[] aPaperDatabase : paperDatabase) {
                //Get a set of all the current paper's authors
                HashSet<String> authors = new HashSet<>();
                String[] names = aPaperDatabase[0].split(",");
                for (int j = 0; j < names.length; j += 2) {
                    if (j + 1 > names.length) {
                        authors.add(names[j].trim());
                    } else {
                        authors.add(names[j].trim() + ", " + names[j + 1].trim());
                    }
                }

                //Associate authors with each other
                HashSet<String> tempSet;
                for (String author : authors) {
                    if (coauthors.containsKey(author)) {
                        coauthors.get(author).addAll(authors);
                        coauthors.get(author).remove(author);
                    } else {
                        tempSet = new HashSet<>();
                        tempSet.addAll(authors);
                        tempSet.remove(author);
                        coauthors.put(author, tempSet);
                    }
                }
            }

            //Find Erdos Nums
            //Credit to whoever the person who led to this was
            HashMap<String, Integer> erdosNums = new HashMap<>();
            //Current authors being worked with
            HashSet<String> working = new HashSet<>();
            //The next ones - gotten from the previous
            HashSet<String> nextWorking = new HashSet<>();
            //Those who we have a erdos number for
            HashSet<String> finished = new HashSet<>();
            //Temporary set for to pass up to nextWorking eventually
            HashSet<String> nextWork = new HashSet<>();

            working.add(erdos);
            finished.add(erdos);
            erdosNums.put(erdos, 0);
            int currNum = 1;
            while (working.size() > 0) {
                for (String s : working) {
                    HashSet<String> finding = coauthors.get(s);
                    if (finding == null) continue;

                    for (String find : finding) {
                        if (!finished.contains(find)) {
                            finished.add(find);
                            erdosNums.put(find, currNum);
                            nextWork.add(find);
                        }
                    }
                    nextWorking.addAll(nextWork);
                    nextWork.clear();
                }
                working = nextWorking;
                nextWorking = new HashSet<>();
                currNum++;
            }

            //Get names to find erdos num for
            String[] results = new String[nameNum];
            for (int i = 0; i < nameNum; i++) {
                results[i] = input.readLine().trim();
            }

            //Finally give a result
            System.out.println("Scenario " + scenario);
            for (String current : results) {
                if (erdosNums.containsKey(current)) {
                    System.out.println(current + " " + erdosNums.get(current));
                } else {
                    System.out.println(current + " infinity");
                }
            }
        }
        input.close();
    }
}
