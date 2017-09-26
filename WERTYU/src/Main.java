import java.io.*;

public class Main {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        String in;
        while ((in = input.readLine()) != null && !in.equals("")){
            char[] inArr = in.toCharArray();
            for (char inChar : inArr) {
                switch (inChar) {
                    case '1':
                        output.write('`');
                        break;
                    case '2':
                        output.write('1');
                        break;
                    case '3':
                        output.write('2');
                        break;
                    case '4':
                        output.write('3');
                        break;
                    case '5':
                        output.write('4');
                        break;
                    case '6':
                        output.write('5');
                        break;
                    case '7':
                        output.write('6');
                        break;
                    case '8':
                        output.write('7');
                        break;
                    case '9':
                        output.write('8');
                        break;
                    case '0':
                        output.write('9');
                        break;
                    case '-':
                        output.write('0');
                        break;
                    case '=':
                        output.write('-');
                        break;
                    case 'W':
                        output.write('Q');
                        break;
                    case 'E':
                        output.write('W');
                        break;
                    case 'R':
                        output.write('E');
                        break;
                    case 'T':
                        output.write('R');
                        break;
                    case 'Y':
                        output.write('T');
                        break;
                    case 'U':
                        output.write('Y');
                        break;
                    case 'I':
                        output.write('U');
                        break;
                    case 'O':
                        output.write('I');
                        break;
                    case 'P':
                        output.write('O');
                        break;
                    case '[':
                        output.write('P');
                        break;
                    case ']':
                        output.write('[');
                        break;
                    case '\\':
                        output.write(']');
                        break;
                    case 'S':
                        output.write('A');
                        break;
                    case 'D':
                        output.write('S');
                        break;
                    case 'F':
                        output.write('D');
                        break;
                    case 'G':
                        output.write('F');
                        break;
                    case 'H':
                        output.write('G');
                        break;
                    case 'J':
                        output.write('H');
                        break;
                    case 'K':
                        output.write('J');
                        break;
                    case 'L':
                        output.write('K');
                        break;
                    case ';':
                        output.write('L');
                        break;
                    case '\'':
                        output.write(';');
                        break;
                    case 'X':
                        output.write('Z');
                        break;
                    case 'C':
                        output.write('X');
                        break;
                    case 'V':
                        output.write('C');
                        break;
                    case 'B':
                        output.write('V');
                        break;
                    case 'N':
                        output.write('B');
                        break;
                    case 'M':
                        output.write('N');
                        break;
                    case ',':
                        output.write('M');
                        break;
                    case '.':
                        output.write(',');
                        break;
                    case '/':
                        output.write('.');
                        break;
                    default:
                        output.write(inChar);
                        break;
                }
            }
            output.newLine();
        }
        output.close();
    }
}
