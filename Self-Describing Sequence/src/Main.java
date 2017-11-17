import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int[] sequence = new int[1000000];
    public static void main (String[] args) throws IOException{
        sequence[1] = 1;
        sequence[2] = 3;
        int currentNum = 2;
        int repetitions = 2;
        int fOfCurrentNum;
        int previousNumPos = 0;

        //Create the array of what point the numbers change
        for (int i = 3; i < 2000000000; i++) {
            fOfCurrentNum = currentNum;
            repetitions--;
            if (i == currentNum){
                previousNumPos = fOfCurrentNum;
            }
            if (repetitions == 0){
                repetitions = previousNumPos;
                currentNum++;
                sequence[currentNum] = i;
            }
        }
        for (int i : sequence) {
            System.out.println(i);
        }
        //Solve the cases
        String in;
        while (!(in = input.readLine()).equals("0")){
            int current = Integer.parseInt(in);

        }
    }
}
