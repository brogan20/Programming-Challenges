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

            int low = Integer.MAX_VALUE;
            int high = 0;

            while (!(in = input.readLine()).equals("")){
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
            char[][] thing = new char[576][length];
            int[] output = new int[length];



            //Outputs
            for (int i : output) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
