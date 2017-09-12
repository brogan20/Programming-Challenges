import java.io.*;

class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    static char[][] board;
    static int field = 0;

    public static void main(String[] args) throws IOException {
        while (true){
           //Get the input and initialize the board
           String size = input.readLine().trim();
           //Start finishing when last line is given
           if (size.equals("0 0")) System.exit(0);

           board = new char[Integer.parseInt(size.substring(0, size.indexOf(" ")))]
                   [Integer.parseInt(size.substring(size.indexOf(" ") + 1))];
           for (int i = 0; i < board.length; i++) {
               board[i] = input.readLine().toCharArray();
            }
           if(field > 0) System.out.println();
            for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                //Make sure no bombs are replaced
                if (board[r][c] != '*') {
                    board[r][c] = '0';

                    //Check all adjacent squares for bombs and then replace the current square with that number
                    int increment = 0;
                    for (int adjr = -1; adjr <= 1; adjr++) {
                        for (int adjc = -1; adjc <= 1; adjc++) {
                            try {
                                if (board[r + adjr][c + adjc] == '*') increment++;
                            } catch (IndexOutOfBoundsException e) {
                            }
                        }
                    }
                    board[r][c] = (char)(increment + '0');
                }
            }
        }
        field++;
        System.out.println("Field #" + field + ":");
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                System.out.print(board[i][j]);
            }
               System.out.println();
           }
        }
    }
}
