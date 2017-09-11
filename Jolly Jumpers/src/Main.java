import java.io.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    static String[] lineIn;
    static int[] currentInts;

    static boolean[] jollys;
    public static void main(String[] args) throws IOException{
        String in;
        while((in = input.readLine()) != null && !in.equals("")){
            lineIn = in.split(" ");
            currentInts = new int[Integer.valueOf(lineIn[0])];

            for (int i = 0; i < currentInts.length; i++){
                currentInts[i] = Integer.valueOf(lineIn[i+1]);
            }
            jollys = new boolean[Integer.valueOf(lineIn[0])-1];
            for(int i = -1; i < jollys.length-1; i++){
                int difference = Math.abs(currentInts[i+1] - currentInts[i+2])-1;

                if (difference >= 0 && difference < jollys.length){
                    jollys[difference] = true;
                }

            }
            boolean isJolly = true;
            for(int i = 0; i < jollys.length; i++){
                if (!jollys[i]){
                    isJolly = false;
                    break;
                }
            }
            if(isJolly){
                System.out.println("Jolly");
            } else {
                System.out.println("Not jolly");
            }
        }
    }
}