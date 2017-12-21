import java.io.*;


public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        int cases = Integer.parseUnsignedInt(input.readLine());
        //Pass blank line
        input.readLine();
        while (cases-- > 0){
            int numPeeps = Integer.parseUnsignedInt(input.readLine());
            int[] weights = new int[numPeeps];
            int maxWeight = 0;
            for (int i = 0; i < weights.length; i++) {
                int currWeight = Integer.parseUnsignedInt(input.readLine());
                weights[i] = currWeight;
                maxWeight += currWeight;
            }

            long[] solutions = new long[maxWeight +1];
            solutions[0] = 1;
            for (int i = 0; i < numPeeps; i++) {
                for (int j = 0; j < maxWeight; j++) {
                    solutions[j] |= (solutions[j - weights[i]]) << 1;
                }
            }
        }
    }
}
