import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        //1st line is the case number
        int cases = Integer.parseInt(input.readLine());
        input.readLine();
        for (int caseNum = 0; caseNum < cases; caseNum++) {
            //Get all fragments and find the longest and shortest lengths
            //The sum of those is the size the output has to be
            String in;
            ArrayList<String> frags = new ArrayList<>();
            int longest = -1;
            int shortest = 300;
            while ((in = input.readLine()) != null && !in.equals("")) {
                frags.add(in);
                if (in.length() > longest) longest = in.length();
                if (in.length() < shortest) shortest = in.length();
            }
            int size = longest + shortest;

            //Find all possible combinations of valid length
            Map<String, Integer> combinations = new HashMap<>();
            for (int i = 0; i < frags.size(); i++) {
                for (int j = i+1; j < frags.size(); j++) {
                    if(frags.get(i).length() + frags.get(j).length() == size){
                        String comboOne = frags.get(i) + frags.get(j);
                        String comboTwo = frags.get(j) + frags.get(i);
                        if (combinations.containsKey(comboOne)){
                            combinations.replace(comboOne, combinations.get(comboOne) + 1);
                        } else {
                            combinations.put(comboOne, 1);
                        }
                        if (combinations.containsKey(comboTwo)){
                            combinations.replace(comboTwo, combinations.get(comboTwo) + 1);
                        } else {
                            combinations.put(comboTwo, 1);
                        }
                    }
                }
            }

            //The combination that occurred most frequently is the solution
            String commonCombo = "";
            int frequency = 0;
            for (String key : combinations.keySet()){
                if (!key.equals(commonCombo) && combinations.get(key) > frequency){
                    frequency = combinations.get(key);
                    commonCombo = key;
                }
            }

            if (caseNum > 0) System.out.println("\n"+commonCombo.trim());
            else System.out.println(commonCombo.trim());
        }
    }
}