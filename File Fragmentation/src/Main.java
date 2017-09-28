import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    static String[] frags;

    public static void main(String[] args) throws IOException{
        int cases = Integer.parseInt(input.readLine());
        input.readLine();

        for (int caseNum = 0; caseNum < cases; caseNum++) {
            frags = new String[288];
            String in;

            int low = Integer.MAX_VALUE;
            int high = 0;

            for (int j = 0; j < 288; j++) {
                in = input.readLine();
                if(!in.equals("")){
                    if(in.length() < low){
                        low = in.length();
                    }else if(in.length() > high){
                        high = in.length();
                    }
                    frags[caseNum] = in;
                } else {
                    break;
                }
            }

            int length = low + high;
            int[] output = new int[length];

            for (int i = 0; i < length; i++) {
                int zeroes = 0;
                int ones = 0;
                for (int j = 0; j < length; j++) {

                }
                if(zeroes > ones){
                    output[i] = zeroes;
                } else {
                    output[i] = ones;
                }
            }

        }
    }
}
