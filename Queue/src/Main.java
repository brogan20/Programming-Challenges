import java.io.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    //N->P->R
    static int precalculation[][][] = new int[17][17][17];
    public static void main(String[] args) throws IOException{
        //https://stackoverflow.com/questions/44984008/arranging-people-in-queue-uva-10128
        precalculation[1][1][1] = 1;
        for (int N = 1; N <= 13; N++) {
            for (int P = 1; P < N; P++) {
                for (int R = 1; R < N; R++) {
                    precalculation[N][P][R] = precalculation[N-1][P][R]*(N-2) + precalculation[N-1][P-1][R] + precalculation[N-1][P][R-1];       
                }
            }
        }
        short cases = Short.parseShort(input.readLine());
        for (int i = 0; i < cases; i++) {
            String[] nums = input.readLine().split(" ");
            output.write(precalculation[Integer.parseUnsignedInt(nums[0])][Integer.parseUnsignedInt(nums[1])][Integer.parseUnsignedInt(nums[2])]);
            output.newLine();
        }
        output.flush();
    }
}
