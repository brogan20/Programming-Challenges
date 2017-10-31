import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String in;
        //credit to mathblog.dk
        //Basically the only algorithm that would be fast enough in Java
        while ((in = input.readLine()) != null){
            int num = Integer.parseInt(in);
            int current = 1;
            int count = 1;
            while (current%num != 0){
                current = (current*10 + 1) % num;
                count++;
            }
            System.out.println(count);
        }
    }
}
