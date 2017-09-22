import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int scenarios = Integer.parseInt(input.readLine());
        for(int scenario = 1; scenario <= scenarios; scenario++){
            String[] temp = input.readLine().trim().split(" ");
            int papers = Integer.parseInt(temp[0]);
            int nameNum = Integer.parseInt(temp[1]);

            String[][] paper = new String[papers][];
            for (int i = 0; i < papers; i++){
                String line = input.readLine().trim();
                paper[i] = line.substring(0, line.indexOf(":")).split(",");
            }
            String[] names = new String[nameNum];
            for (int i = 0; i < nameNum; i++){
                names[i] = input.readLine().trim();
            }
        }
    }
}
