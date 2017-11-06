import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        String in;
        while (!(in = input.readLine()).equals("0 0")){
            String[] splitIn = in.split(" ");
            BigInteger low = new BigInteger(splitIn[0]);
            BigInteger high = new BigInteger(splitIn[1]);
            //Credit to geeksforgeeks
            BigInteger f1 = new BigInteger("1"),
                       f2 = new BigInteger("1"),
                       f3 = new BigInteger("2");
            int result = 0;
            while (f1.compareTo(high) <= 0){
                if(f1.compareTo(low) >= 0) result++;
                f1 = f2;
                f2 = f3;
                f3 = f1.add(f2);
            }
            System.out.println(result);
        }
    }
}
