import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    static int primeNums = 0;
    static int[] primes = new int[664579];

    static boolean[] prime = new boolean[10000001];
    public static void main(String[] args) throws IOException{
        //Sieve of Eratosthenes
        for (int i = 2; i < prime.length; i++) {
            if (!prime[i]){
                primes[primeNums] = i;
                primeNums++;
                for (int j = (int)Math.pow(i, 2); j < prime.length; j += i) {
                    prime[j] = true;
                }
            }
        }

        String in;
        while (!(in = input.readLine()).equals("") && in != null){
            int num = Integer.parseInt(in);
            if (num < 8){
                System.out.println("Impossible.");
            } else if (num%2 == 0){
                //Break it down so it's still an even number that will work with Goldbach's Conjecture
                //Credit to geeksforgeeks
                num -= 4;
                for (int i = 0; primes[i] <= num/2; i++) {
                    int diff = num - primes[i];
                    if (Arrays.binarySearch(primes, diff) >= 0){
                        System.out.println("2 2 " + primes[i] + " " + diff);
                        break;
                    }
                }
            } else if (num%2 == 1){
                //Break it down so it's still an even number that will work with Goldbach's Conjecture
                num -= 5;
                for (int i = 0; primes[i] <= num/2; i++) {
                    int diff = num - primes[i];
                    if (Arrays.binarySearch(primes, diff) >= 0){
                        System.out.println("2 3 " + primes[i] + " " + diff);
                        break;
                    }
                }
            }
            if (!input.ready()) break;
        }
    }
}
