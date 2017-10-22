import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int cases = Integer.parseInt(in.readLine());
        String[] inArr;
        int[] streets;
        for (int case_ = 0; case_ < cases; case_++) {
            inArr = in.readLine().split(" ");
            streets = new int[inArr.length-1];

            //Get all the streets to ints
            //Wouldn't need to do this, but Arrays.sort doesn't handle 100 very well and puts it before 1...
            //¯\_(ツ)_/¯
            for (int i = 1; i < inArr.length; i++) {
                streets[i-1] = Integer.parseInt(inArr[i]);
            }

            //Find median
            Arrays.sort(streets);
            int mid = streets.length/2;
            int location;
            if (streets.length % 2 != 0){
                location = streets[mid];
            } else {
                location = Math.round((streets[mid] + streets[mid-1])/2);
            }

            //Calculate distances
            int dist = 0;
            for (int street : streets) {
                dist += Math.abs(street - location);
            }
            System.out.println(dist);
        }
    }
}
