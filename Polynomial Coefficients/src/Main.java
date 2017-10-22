import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static int[] factorials = {1,1,2,6,24,120,720,5040,40320,362880,3628800,39916800,479001600};

    public static void main(String[] args) throws IOException{
        String line;
        String[] nk;
        String[] coeffs;
        int n,k;
        while ((line = in.readLine()) != null){
            nk = line.split(" ");
            n = Integer.parseInt(nk[0]);
            k = Integer.parseInt(nk[1]);

            int answer = factorials[n];
            coeffs = in.readLine().split(" ");
            while (k-- > 0){
                answer /= factorials[Integer.parseInt(coeffs[k])];
            }
            System.out.println(answer);
        }
    }
}
