import java.io.*;
import java.util.Scanner;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    //static Scanner input = new Scanner(System.in);
    public static void main(String[] args)throws IOException{
        String in;
        while ((in = input.readLine()) != null){
            String[] aAndB = in.split(" ");
            //Extended Euclidean Algorithm
            int a = Integer.parseInt(aAndB[0]);
            int b = Integer.parseInt(aAndB[1]);
            //int a = input.nextInt();
            //int b = input.nextInt();
            if (b == 0){
                output.write("0 1 " + a);
                output.newLine();
                continue;
            }
            if (a == 0){
                output.write("0 1 " + b);
                output.newLine();
                continue;
            }
            int x = 0, y = 1, x_prev = 1, y_prev = 0, temp, q, r;
            while (b != 0){
                q = a/b;
                r = a%b;
                a = b;
                b = r;

                temp = x;
                x = x_prev - q*x;
                x_prev = temp;

                temp = y;
                y = y_prev - q*y;
                y_prev = temp;
            }

            output.write(x_prev + " " + y_prev + " " + a);
            output.newLine();
            if (!input.ready()) break;
        }
        output.close();
    }
}
