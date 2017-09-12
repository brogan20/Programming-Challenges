import java.io.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    private static int[] register;
    private static int[] ram ;

    public static void main(String[] args) throws IOException, NumberFormatException{
        int cases = Integer.parseInt(input.readLine());
        //No more blank line
        input.readLine();

        for (int i = 1; i <= cases; i++){
            register = new int[10];
            ram = new int[1000];

            String in;
            int current = 0;
            while ((in = input.readLine()) != null && !in.equals("")){
                ram[current] = Integer.parseInt(in);
                current++;
            }
            solveCase();
            if (i < cases){
                System.out.println();
            }
        }
    }
    private static void solveCase() throws IOException{
        int pointer = 0;
        int exec = 0;
        while (true){
            int first = ram[pointer]/100;
            int two = (ram[pointer]/10)%10;
            int three = ram[pointer]%10;
            switch (first){
                case 1:
                    exec++;
                    System.out.println(exec);
                    return;
                case 2:
                    exec++;
                    register[two] = (three);
                    break;
                case 3:
                    exec++;
                    register[two] = (register[two] +three)%1000;
                    break;
                case 4:
                    exec++;
                    register[two] = (register[two] *three)%1000;
                    break;
                case 5:
                    exec++;
                    register[two] = (register[three]);
                    break;
                case 6:
                    exec++;
                    register[two] = (register[two] + register[three])%1000;
                    break;
                case 7:
                    exec++;
                    register[two] = (register[two] * register[three])%1000;
                    break;
                case 8:
                    exec++;
                    register[two] = (ram[register[three]]);
                    break;
                case 9:
                    exec++;
                    ram[register[three]] = register[two];
                    break;
                case 0:
                    exec++;
                    if (register[three] != 0){
                        pointer = register[two]-1;
                    }
                    break;
            }
            pointer++;
        }
    }
}
