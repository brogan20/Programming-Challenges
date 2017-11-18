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

            //Will either find the f(n) through the mid or the highest number will be what is closest
            //Thanks stack overflow for the basic binary search algorithm.
            //Slight difference as we always want to get the higher of the options closest to n
            //Has to be the higher option since the array stores the highest position for each number
            int low = 0;
            int high = sequence.length-1;
            int mid;
            boolean broke = false;
            while (low <= high){
                mid = (low + high)/2;

                if(n < sequence[mid]){
                    high = mid-1;
                } else if(n > sequence[mid]){
                    low = mid+1;
                } else {
                    System.out.println(mid+1);
                    broke = true;
                    break;
                }
            }
            //+1 since zero indexed
            //Need to make sure nothing was previously printed
            if(!broke) {
                System.out.println(high+1);
            }
        }
    }
}
