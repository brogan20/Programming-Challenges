import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        BigInteger[] n = new BigInteger[1000];
        n[0] = new BigInteger("2");
        n[1] = new BigInteger("5");
        n[2] = new BigInteger("13");
        for (int i = 3; i < n.length; i++) {
            n[i] = n[i-1].add(n[i-1].add(n[i-2].add(n[i-3])));
        }
        String in;
        while ((in = input.readLine()) != null && !in.equals("")){
            int num = Integer.parseInt(in);
            System.out.println(n[num-1]);
        }
    }
}
