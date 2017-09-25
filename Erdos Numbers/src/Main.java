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
            int paperNum = Integer.parseInt(temp[0]);
            int nameNum = Integer.parseInt(temp[1]);

            HashMap<String, HashSet<String>> coauthors = new HashMap<>();

            //INPUT
            for (int i = 0; i < paperNum; i++) {
                String[] paper = input.readLine().trim().split(":");
                String[] nameParts = paper[0].split(",");

                //Break the input into little pieces and put the names back together
                HashSet<String> authors = new HashSet<>();
                for (int j = 0; j < nameParts.length; j += 2) {
                    if(j + 1 >= nameParts.length){
                        authors.add(nameParts[j].trim());
                    } else {
                        authors.add(nameParts[j].trim() + ", " + nameParts[j + 1].trim());
                    }
                }
                //Sort all the coauthors together
                HashSet<String> tempSet;
                for (String author : authors) {
                    if (coauthors.containsKey(author)){
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

            //Start with Erdos, but also prevents his number from being overwritten in the future
            working.add(erdos);
            finished.add(erdos);
            erdosNums.put(erdos, 0);
            int currNum = 1;
            while (working.size() > 0) {
                for (String s : working) {
                    HashSet<String> finding = coauthors.get(s);
                    //Nonexistant authors can't have a number
                    if (finding == null) continue;

                    //Get coauthors for the next iteration. Works because anyone who would be on this tier
                    //Has been run before the next tier goes
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

            //Get names to find erdos numbers for
            String[] results = new String[nameNum];
            for (int i = 0; i < nameNum; i++) {
                results[i] = input.readLine().trim();
            }

            //Finally give a result for the judge
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

