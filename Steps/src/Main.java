import java.io.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int cases = Integer.parseInt(input.readLine());
        for (int i = 0; i < cases; i++) {
            String[] case_ = input.readLine().split(" ");
            //Equation from UVA forums
            System.out.println((long) Math.floor(Math.sqrt(4 * (Integer.parseInt(case_[1]) - Integer.parseInt(case_[0])) - 1)));
        }
    }
}
