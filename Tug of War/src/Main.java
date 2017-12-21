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
                for (int j = maxWeight; j >= weights[i]; j--) {
                    solutions[j] |= (solutions[j - weights[i]]) << 1;
                }
            }
            
            int half = numPeeps/2 + 1;
            int min = 0;
            int max = Integer.MAX_VALUE;
            for (int i = 0; i < solutions.length; i++){
                for (int j = 0; j < half; j++){
                    if ((solutions[i] & (1 << j)) != 0 && Math.abs(2*j-numPeeps) <= 1){
                        if (Math.abs(maxWeight-2*i) < (max-min)){
                            max = Math.max(maxWeight-i, i);
                            min = Math.min(maxWeight-i, i);
                        }
                    }
                }
            }
            
            output.write(min + " " + max);
            output.newLine();
            if(cases != 0) output.newLine();
        }
    }
}
