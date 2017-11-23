import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
//    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args)throws IOException{
        String in;
        while (input.hasNextInt()){
//            String[] aAndB = in.split(" ");
//            //Extended Euclidean Algorithm
//            int a = Integer.parseInt(aAndB[0]);
//            int b = Integer.parseInt(aAndB[1]);
            int a = input.nextInt();
            int b = input.nextInt();
            if (b == 0){
                System.out.printf("%d %d %d\n", 1, 0, a);
                continue;
            }
            if (a == 0){
                System.out.printf("%d %d %d\n", 0, 1, b);
                continue;
            }
            int x2 = 1, x1 = 0, y2 = 0, y1 = 1, q, r, x, y;
            while (b > 0){
                q = a/b;
                r = a - q*b;
                x = x2 - q*x1;
                y = y2 - q*y1;
                a = b;
                b = r;
                x2 = x1;
                x1 = x;
                y2 = y1;
                y1 = y;
            }
            System.out.printf("%d %d %d\n", x2, y2, a);
        }
    }
}
