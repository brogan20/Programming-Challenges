import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException{
        int cases = Integer.parseInt(input.nextLine());

        for (int caseNum = 0; caseNum < cases; caseNum++) {
            ArrayList<String> frags = new ArrayList<>();
            String in;
            while (!(in = input.nextLine()).equals("")){
                frags.add(in);
            }

            Map<String, Integer> combos = new HashMap<>();
            for (String fragOne : frags) {
                for (String fragTwo : frags) {
                    if (fragOne != fragTwo) {
                        String concat = fragOne + fragTwo;
                        if (combos.containsKey(concat)) {
                            combos.replace(concat, combos.get(concat) + 1);
                        } else {
                            combos.put(concat, 1);
                        }
                    }
                }
            }

            int highNum = -1;
            String value = "";
            for (Map.Entry<String, Integer> combo : combos.entrySet()) {
                if (combo.getValue() >= highNum){
                    highNum = combo.getValue();
                    value = combo.getKey();
                }
            }
            System.out.println(value + "\n");
        }
    }
}
