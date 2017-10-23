import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException{
        String[] arrInput;
        int[] stack;
        int[] sortedStack;

        String input;
        while ((input = in.readLine()) != null){
            //Getting input.
            arrInput = input.split(" ");
            stack = new int[arrInput.length];
            for (int i = 0; i < arrInput.length; i++) {
                stack[i] = Integer.parseInt(arrInput[i]);
            }
            //Making a stack to compare to for reference
            sortedStack = stack.clone();
            Arrays.sort(sortedStack);

            for (int i = 0; i < sortedStack.length/2; i++) {
                int temp = sortedStack[i];
                sortedStack[i] = sortedStack[sortedStack.length-i-1];
                sortedStack[sortedStack.length-1-i] = temp;
            }



            int sortedPos = 0;
            while (!Arrays.toString(stack).equals(Arrays.toString(sortedStack))){
                //find largest unsorted pancake
                int pos = 0 , size = 0;
                for (int i = sortedPos; i < stack.length ; i++) {
                    if (stack[i] > size){
                        size = stack[i];
                        pos = i;
                    }
                }
                //Bring the largest to the top
                System.out.print(pos + " ");
                for (int i = pos, j = stack.length-1; i < j ; i++, j--) {
                    int temp = stack[i];
                    stack[i] = stack[j];
                    stack[j] = temp;
                }
                if (Arrays.toString(stack).equals(Arrays.toString(sortedStack))) break;
                //Reverse to the bottom
                System.out.print(sortedPos + " ");
                for (int i = sortedPos, j = stack.length-1; i < j; i++, j--) {
                    int temp = stack[i];
                    stack[i] = stack[j];
                    stack[j] = temp;
                }
                sortedPos++;
                if (Arrays.toString(stack).equals(Arrays.toString(sortedStack))) break;
            }

            System.out.println("0");
            //System.out.println(Arrays.toString(stack));
        }
    }
}
