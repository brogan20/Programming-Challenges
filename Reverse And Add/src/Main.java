import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.StringBuilder;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        short cases = Short.parseShort(input.readLine());

        for (short case_ = 0; case_ < cases; case_++) {
            long iterations = 0;
            String current = input.readLine();
            String reverse = new StringBuilder(current).reverse().toString();
            do {
                iterations++;
                current = Long.toString(Long.parseLong(current) + Long.parseLong(reverse));
            } while (!current.equals(reverse = new StringBuilder(current).reverse().toString()));
            System.out.println(iterations + " " + current);
        }
    }
}
