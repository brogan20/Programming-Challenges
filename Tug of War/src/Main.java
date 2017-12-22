import java.io.*;


public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        int cases = Integer.parseUnsignedInt(input.readLine());

        while (cases--  > 0) {
            input.readLine();
            int people = Integer.parseInt(input.readLine());

            int maxWeight = 0;
            int[] weights = new int[people];

            for (int i = 0; i < people; i++) {
                weights[i] = Integer.parseInt(input.readLine());
                maxWeight += weights[i];
            }

            long[] weightDistribution = new long[maxWeight / 2 + 1];
            weightDistribution[0] = 1;

            for (int i = 0; i < people; i++) {
                int weight = weights[i];
                for (int j = maxWeight/2; j >= weight; j--) {
                    weightDistribution[j] |= weightDistribution[j - weight] << 1L;
                }
            }

            boolean notSolved = true;
            int solution = 0;
            for(int i = maxWeight / 2; notSolved; i--) {
                long weight = weightDistribution[i];
                notSolved = (weight & (1L << (people / 2))) == 0;
                if (notSolved && ((people % 2) == 1) && (weight & (1L << (people / 2 + 1))) != 0){
                    notSolved = false;
                }
                solution = i;
            }

            output.write(solution + " " + (maxWeight - solution));
            output.newLine();
            if(cases != 0) output.newLine();
        }
        output.close();
    }
}
