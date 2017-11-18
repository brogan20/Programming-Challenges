import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int[] sequence = new int[673469];
    public static void main (String[] args) throws IOException{
        sequence[0] = 1;
        sequence[1] = 2;
        sequence[2] = 4;

        for (int i = 1; sequence[sequence[i]-1] < 2000000000; i++) {
            for (int j = sequence[i]; j < sequence[i+1]; j++) {
                sequence[j] = sequence[j-1] + i + 1;
            }
        }

        //Needed this to find how small the array can be
        //Can't have any extra numbers at the end or else binary search later will fail
//        for (int i = 0; i < sequence.length; i++) {
//            if (sequence[i] == 0) sequence = Arrays.copyOf(sequence, i);
//            System.out.println(sequence.length);
//        }

        //Solve the cases
        String in;
        while (!(in = input.readLine()).equals("0")){
            int n = Integer.parseInt(in);
            System.out.println(Math.abs(Arrays.binarySearch(sequence, n)+1));
        }
    }
}
