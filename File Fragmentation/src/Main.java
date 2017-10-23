import java.util.*;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args){
        int cases = Integer.parseInt(input.nextLine());

        for (int caseNum = 0; caseNum < cases; caseNum++) {
            ArrayList<String> frags = new ArrayList<>();
            String in;
            int high = -1;
            int low = Integer.MAX_VALUE;
            while (!(in = input.nextLine()).equals("")){
                if(in.length() > high) high = in.length();
                if(in.length() < low) low = in.length();
                frags.add(in);
            }

            int maxLength = high + low;
            Map<String, Integer> combos = new HashMap<>();
            for (String fragOne : frags) {
                for (String fragTwo : frags) {
                    int length = fragOne.length() + fragTwo.length();
                    if (fragOne != fragTwo && length == maxLength) {
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
                if (combo.getValue() > highNum){
                    highNum = combo.getValue();
                    value = combo.getKey();
                }
            }
            if (caseNum > 0) {
                System.out.println();
            }
            System.out.println(value.trim());

        }
    }
}