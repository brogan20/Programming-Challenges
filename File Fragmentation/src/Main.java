import java.io.BufferedReader;
import java.io.FileReader;
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

            int fragsSize = 0;
            int low = Integer.MAX_VALUE;
            int high = 0;

            //Get all the inputs
            while (!(in = input.readLine()).equals("")){
                if(in.length() < low){
                    low = in.length();
                }else if(in.length() > high){
                    high = in.length();
                }
                frags[fragsSize] = in;
                fragsSize++;
            }

            //Create a matrix of the fragments
            int length = low + high;
            char[][] charMap = new char[fragsSize*2][length];
            int currRow = 0;
            for (int i = 0; i < fragsSize; i++) {
                for (int j = 0; j < frags[i].length(); j++){
                    charMap[currRow][j] = frags[i].charAt(j);
                    charMap[currRow+1][length-frags[i].length()+j] = frags[i].charAt(j);
                }
                currRow += 2;
            }
            //Sum up each column
            int[] output = new int[length];
            int ones = 0;
            int zeros = 0;
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < charMap.length; j++) {
                    if(charMap[j][i] == '0'){
                        zeros++;
                    } else {
                        ones++;
                    }
                }
                if (zeros >= ones){
                    output[i] = 0;
                } else {
                    output[i] = 1;
                }
            }


            //Output the findings
            for (int i : output) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
