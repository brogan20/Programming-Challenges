import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static int primeNums = 0;
    static int[] primes = new int[664579];

    static boolean[] prime = new boolean[10000001];
    public static void main(String[] args) throws IOException{
        //Sieve of Eratosthenes
        for (int i = 2; i < 10000001; i++) {
            if (!prime[i]){
                primes[primeNums] = i;
                primeNums++;
                for (int j = (int)Math.pow(i, 2); j < 10000001; j += i) {
                    prime[j] = true;
                }
            }
        }

        String in;
        while (!(in = input.readLine()).equals("")){
            int num = Integer.parseInt(in);
            if (num < 8){
                output.write("Impossible.\n");
            } else if (num%2 == 0){
                //Break it down so it's still an even number that will work with Goldbach's Conjecture
                //Credit to geeksforgeeks
                num -= 4;
                for (int i = 0; primes[i] <= num/2; i++) {
                    int diff = num - primes[i];
                    if (Arrays.binarySearch(primes, diff) > -1){
                        output.write("2 2 " + primes[i] + " " + diff);
                        output.newLine();
                        break;
                    }
                }
            } else if (num%2 == 1){
                //Break it down so it's an even number that will work with Goldbach's Conjecture
                num -= 5;
                for (int i = 0; primes[i] <= num/2; i++) {
                    int diff = num - primes[i];
                    if (Arrays.binarySearch(primes, diff) > -1){
                        output.write("2 3 " + primes[i] + " " + diff);
                        output.newLine();
                        break;
                    }
                }
            }
            if (!input.ready()) break;
        }
        output.close();
    }
}
