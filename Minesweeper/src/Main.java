 import java.io.*;

class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    static char[][] board;
    static int field = 0;

    public static void main(String[] args) throws IOException {
        while (true){
            createBoard();
            System.out.println();
            findBombs();
            outputBoard();
        }
    }


    //Create a board of size m,n and fill with inputs
    static void createBoard() throws IOException {
        //Get the input and initialize the board
        String size = input.readLine().trim();
        //Start finishing when last line is given
        if (size.equals("0 0")) System.exit(0);

        board = new char[Integer.parseInt(size.substring(0, size.indexOf(" ")))]
                [Integer.parseInt(size.substring(size.indexOf(" ") + 1))];
        for (int i = 0; i < board.length; i++) {
            String line;
            do {
                line = input.readLine();
            } while (line.length() != board[i].length);
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = line.toCharArray()[j];
            }
        }
    }

    //Find all the bombs and replace safe squares with the number of bombs next to it
    static void findBombs() {
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
                    board[r][c] = Integer.toString(increment).toCharArray()[0];
                }
            }
        }
    }
    static void outputBoard(){
        System.out.println("Field #" + field++ + ":");
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}