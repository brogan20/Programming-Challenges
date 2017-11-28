import java.io.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        String in;
        double num;
        while (!(in = input.readLine()).equals("0")){
            num = Math.sqrt(Long.parseUnsignedLong(in, 10));
            if (num == (int)num){
                output.write("yes\n");
            } else {
                output.write("no\n");
            }
        }
        output.flush();
    }
}
