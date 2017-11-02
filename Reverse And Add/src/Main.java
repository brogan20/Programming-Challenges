import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        byte cases = Byte.parseByte(input.readLine());

        for (byte case_ = 0; case_ < cases; case_++) {
            long iterations = 0;
            String current = input.readLine().trim();
            String reverse = new StringBuilder(current).reverse().toString();
            do {
                iterations++;
                long currentInt = Long.parseLong(current);
                long reverseInt = Long.parseLong(reverse);
                current = Long.toString(currentInt + reverseInt);
            } while ((!current.equals(reverse = new StringBuilder(current).reverse().toString())));
            System.out.println(iterations + " " + current);
        }
    }
}
