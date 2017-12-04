import java.io.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] nums = {561, 1105, 1729, 2465, 2821, 6601, 8911, 10585, 15841, 29341, 41041, 46657, 52633, 62745, 63973};

    public static void main(String[] args) throws IOException {
        String in;
        while (!(in = input.readLine()).equals("0")) {
            int n = Integer.parseUnsignedInt(in);
            boolean found = false;
            for (int num : nums) {
                if (num == n) {
                    found = true;
                    output.write("The number " + n + " is a Carmichael number.\n");
                    break;
                }
            }
            if (!found) {
                output.write(n + " is normal.\n");
            }
        }
        output.close();
    }
}
