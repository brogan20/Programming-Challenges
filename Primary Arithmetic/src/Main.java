import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        String in;
        String[] nums;
        while (!(in = input.readLine()).equals("0 0")){
            nums = in.split(" ");
            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);
            int carries = 0;
            boolean carry = false;
            int lastPlaceAdd;
            while (a != 0 || b != 0){
                if (carry) {
                    lastPlaceAdd = a % 10 + b % 10 + 1;
                    carry = false;
                } else {
                    lastPlaceAdd = a % 10 + b % 10;

                }
                a /= 10;
                b /= 10;
                if (lastPlaceAdd >= 10){
                    carries++;
                    carry = true;
                }
            }
            if(carries > 1) System.out.println(carries + " carry operations.");
            else if(carries == 0) System.out.println("No carry operation.");
            else if(carries == 1) System.out.println("1 carry operation.");
        }
    }
}
