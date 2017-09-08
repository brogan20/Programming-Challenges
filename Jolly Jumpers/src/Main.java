import java.io.*;

public class Main {
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    static String[] lineIn;
    static int[] currentInts;

    static boolean[] jollys;
    public static void main(String[] args) throws IOException{
        String in;
        while((in = input.readLine()) != null && !in.equals("")){
            lineIn = in.split(" ");
            currentInts = new int[lineIn.length];
            for (int i = 0; i < currentInts.length; i++){
                currentInts[i] = Integer.valueOf(lineIn[i]);
            }
            jollys = new boolean[currentInts.length-1];
            boolean isJolly = false;
            for(int i = 0; i < jollys.length; i++){
                int difference = Math.abs(currentInts[i] - currentInts[i+1]);
            }
        }
    }
}
