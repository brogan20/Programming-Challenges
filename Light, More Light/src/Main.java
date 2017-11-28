import java.io.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        double num;
        while ((num = Math.sqrt(Long.parseLong(input.readLine()))) != 0){
            if (num == (int)num){
                output.write("yes\n");
            } else {
                output.write("no\n");
            }
        }
        output.flush();
    }
}
