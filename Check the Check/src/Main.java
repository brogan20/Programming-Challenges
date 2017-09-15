import java.io.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    static int gameNum = 0;

    static char[][] board = new char[8][];

    public static void main(String[] args) throws IOException{
        while (true) {
            getInput();
            findKing();
        }
    }

    static void getInput() throws IOException{
        gameNum++;
        for (int i = 0; i < 8; i++){
            board[i] = input.readLine().toCharArray();
        }
        input.readLine();
    }
    static void findKing() throws IOException{
        boolean foundKing = false;
        boolean checked = false;
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                char loc = board[i][j];
                if(loc == 'K' || loc == 'k'){
                    if(!checked) {
                        checked = kingCheck(i, j, loc);
                    }
                    foundKing = true;
                }
            }
        }

        if (!foundKing){
            output.close();
            System.exit(0);
        }
        if(!checked){
            output.write("Game #" + gameNum + ": no king is in check.\n");
        }
    }
    static boolean kingCheck(int row, int col, char piece) throws IOException{
        found:

        //WHITE KING CHECK
        if (piece == 'K'){
            int track = -1;
            char current;
            //vertical up
            verticald:while (track+row >= 0){
                current = board[track+row][col];
                if(current != 'r' && current != 'q' && current != '.'){
                    break verticald;
                }
                if(current == 'r' || current == 'q'){
                    output.write("Game #" + gameNum + ": white king is in check.\n");
                    return true;
                }
                track--;
            }
            //vertical down
            track = 1;
            verticalu:while (track + row < 8) {
                current = board[track + row][col];
                if (current != 'r' && current != 'q' && current != '.') {
                    break verticalu;
                }
                if (current == 'r' || current == 'q') {
                    output.write("Game #" + gameNum + ": white king is in check.\n");
                    return true;
                }
                track++;
            }
            //horizontal to right
            track = 1;
            horizontalr:while (col + track < 8){
                current = board[row][col + track];
                if (current != 'r' && current != 'q' && current != '.') {
                    break horizontalr;
                }
                if (current == 'r' || current == 'q') {
                    output.write("Game #" + gameNum + ": white king is in check.\n");
                    return true;
                }
                track++;
            }
            //horizontal to left
            track = -1;
            horizontall:while (col + track >= 0){
                current = board[row][col + track];
                if (current != 'r' && current != 'q' && current != '.') {
                    break horizontall;
                }
                if (current == 'r' || current == 'q') {
                    output.write("Game #" + gameNum + ": white king is in check.\n");
                    return true;
                }
                track--;
            }
            //Pawns
            if(row - 1 >= 0 && col + 1 < 8){
                if(board[row-1][col+1] == 'p'){
                    output.write("Game #" + gameNum + ": white king is in check.\n");
                    return true;
                }
            }
            if(row - 1 >= 0 && col - 1 >= 0){
                if(board[row-1][col-1] == 'p'){
                    output.write("Game #" + gameNum + ": white king is in check.\n");
                    return true;
                }
            }
            //Knights down
            if(col + 2 < 8 && row -1 >= 0){
                if(board[row-1][col+2] == 'n'){
                    output.write("Game #" + gameNum + ": white king is in check.\n");
                    return true;
                }
            }
            if(col + 2 < 8 && row +1 < 8){
                if(board[row+1][col+2] == 'n'){
                    output.write("Game #" + gameNum + ": white king is in check.\n");
                    return true;
                }
            }
            //Knights up
            if(col - 2 >= 0 && row - 1 >= 0){
                if(board[row-1][col-2] == 'n'){
                    output.write("Game #" + gameNum + ": white king is in check.\n");
                    return true;
                }
            }
            if(col - 2 >= 0 && row + 1 < 8){
                if(board[row+1][col-2] == 'n'){
                    output.write("Game #" + gameNum + ": white king is in check.\n");
                    return true;
                }
            }
            //Knights left
            if(col + 1 < 8 && row - 2 >= 0){
                if(board[row-2][col+1] == 'n'){
                    output.write("Game #" + gameNum + ": white king is in check.\n");
                    return true;
                }
            }
            if(col - 1 >= 0 && row - 2 >= 0){
                if(board[row-2][col-1] == 'n'){
                    output.write("Game #" + gameNum + ": white king is in check.\n");
                    return true;
                }
            }
            //Knights right
            if(col + 1 < 8 && row + 2 < 8){
                if(board[row+2][col+1] == 'n'){
                    output.write("Game #" + gameNum + ": white king is in check.\n");
                    return true;
                }
            }
            if(col -1 >= 0 && row + 2 < 8){
                if(board[row+2][col-1] == 'n'){
                    output.write("Game #" + gameNum + ": white king is in check.\n");
                    return true;
                }
            }
            //Diagonal bottom right
            track = 1;
            diagbr:while (row + track < 8 && col + track < 8){
                current = board[row+track][col+track];
                if(current != 'b' && current != 'q' && current != '.'){
                    break diagbr;
                }
                if (current == 'b' || current == 'q') {
                    output.write("Game #" + gameNum + ": white king is in check.\n");
                    return true;
                }
                track++;
            }
            //Diagonal upper left
            track = -1;
            diagul:while (row + track >= 0 && col + track >= 0){
                current = board[row+track][col+track];
                if(current != 'b' && current != 'q' && current != '.'){
                    break diagul;
                }
                if (current == 'b' || current == 'q') {
                    output.write("Game #" + gameNum + ": white king is in check.\n");
                    return true;
                }
                track--;
            }
            //Diagonal upper right
            track = -1;
            int track2 = 1;
            diagur:while (row + track >= 0 && col + track2 < 8){
                current = board[row+track][col+track2];
                if(current != 'b' && current != 'q' && current != '.'){
                    break diagur;
                }
                if (current == 'b' || current == 'q') {
                    output.write("Game #" + gameNum + ": white king is in check.\n");
                    return true;
                }
                track--;
                track2++;
            }
            //Diagonal bottom left
            track = 1;
            track2 = -1;
            diagbl:while (row + track < 8 && col + track2 >= 0){
                current = board[row+track][col+track2];
                if(current != 'b' && current != 'q' && current != '.'){
                    break diagbl;
                }
                if (current == 'b' || current == 'q') {
                    output.write("Game #" + gameNum + ": white king is in check.\n");
                    return true;
                }
                track++;
                track2--;
            }



            //BLACK KING CHECK
        } else if(piece == 'k'){
            int track = -1;
            char current;
            //vertical up
            verticald:while (track+row >= 0){
                current = board[track+row][col];
                if(current != 'R' && current != 'Q' && current != '.'){
                    break verticald;
                }
                if(current == 'R' || current == 'Q'){
                    output.write("Game #" + gameNum + ": black king is in check.\n");
                    return true;
                }
                track--;
            }
            //vertical down
            track = 1;
            verticalu:while (track + row <= 7) {
                current = board[track + row][col];
                if (current != 'R' && current != 'Q' && current != '.') {
                    break verticalu;
                }
                if (current == 'R' || current == 'Q') {
                    output.write("Game #" + gameNum + ": black king is in check.\n");
                    return true;
                }
                track++;
            }
            //horizontal to right
            track = 1;
            horizontalr:while (col + track < 8){
                current = board[row][col + track];
                if (current != 'R' && current != 'Q' && current != '.') {
                    break horizontalr;
                }
                if (current == 'R' || current == 'Q') {
                    output.write("Game #" + gameNum + ": black king is in check.\n");
                    return true;
                }
                track++;
            }
            //horizontal to left
            track = -1;
            horizontall:while (col + track >= 0){
                current = board[row][col + track];
                if (current != 'R' && current != 'Q' && current != '.') {
                    break horizontall;
                }
                if (current == 'R' || current == 'Q') {
                    output.write("Game #" + gameNum + ": black king is in check.\n");
                    return true;
                }
                track--;
            }
            //Pawns
            if(row + 1 < 8 && col + 1 < 8){
                if(board[row+1][col+1] == 'P'){
                    output.write("Game #" + gameNum + ": black king is in check.\n");
                    return true;
                }
            }
            if(row + 1 < 8 && col - 1 >= 0 ){
                if(board[row+1][col-1] == 'P'){
                    output.write("Game #" + gameNum + ": black king is in check.\n");
                    return true;
                }
            }
            //Knights down
            if(col + 2 < 8 && row -1 >= 0){
                if(board[row-1][col+2] == 'N'){
                    output.write("Game #" + gameNum + ": black king is in check.\n");
                    return true;
                }
            }
            if(col + 2 < 8 && row +1 < 8){
                if(board[row+1][col+2] == 'N'){
                    output.write("Game #" + gameNum + ": black king is in check.\n");
                    return true;
                }
            }
            //Knights up
            if(col - 2 >= 0 && row - 1 >= 0){
                if(board[row-1][col-2] == 'N'){
                    output.write("Game #" + gameNum + ": black king is in check.\n");
                    return true;
                }
            }
            if(col - 2 >= 0 && row + 1 < 8){
                if(board[row+1][col-2] == 'N'){
                    output.write("Game #" + gameNum + ": black king is in check.\n");
                    return true;
                }
            }
            //Knights left
            if(col + 1 < 8 && row - 2 >= 0){
                if(board[row-2][col+1] == 'N'){
                    output.write("Game #" + gameNum + ": black king is in check.\n");
                    return true;
                }
            }
            if(col - 1 >= 0 && row - 2 >= 0){
                if(board[row-2][col-1] == 'N'){
                    output.write("Game #" + gameNum + ": black king is in check.\n");
                    return true;
                }
            }
            //Knights right
            if(col + 1 < 8 && row + 2 < 8){
                if(board[row+2][col+1] == 'N'){
                    output.write("Game #" + gameNum + ": black king is in check.\n");
                    return true;
                }
            }
            if(col - 1 >= 0 && row + 2 < 8){
                if(board[row+2][col-1] == 'N'){
                    output.write("Game #" + gameNum + ": black king is in check.\n");
                    return true;
                }
            }
            //Diagonal bottom right
            track = 1;
            diagbr:while (row + track != 8 && col + track != 8){
                current = board[row+track][col+track];
                if(current != 'B' && current != 'Q' && current != '.'){
                    break diagbr;
                }
                if (current == 'B' || current == 'Q') {
                    output.write("Game #" + gameNum + ": black king is in check.\n");
                    return true;
                }
                track++;
            }
            //Diagonal upper left
            track = -1;
            diagul:while (row + track >= 0 && col + track >= 0){
                current = board[row+track][col+track];
                if(current != 'B' && current != 'Q' && current != '.'){
                    break diagul;
                }
                if (current == 'B' || current == 'Q') {
                    output.write("Game #" + gameNum + ": black king is in check.\n");
                    return true;
                }
                track--;
            }
            //Diagonal upper right
            track = -1;
            int track2 = 1;
            diagur:while (row + track > -1 && col + track2 < 8){
                current = board[row+track][col+track2];
                if(current != 'B' && current != 'Q' && current != '.'){
                    break diagur;
                }
                if (current == 'B' || current == 'Q') {
                    output.write("Game #" + gameNum + ": black king is in check.\n");
                    return true;
                }
                track--;
                track2++;
            }
            //Diagonal bottom left
            track = 1;
            track2 = -1;
            diagbl:while (row + track < 8 && col + track2 >= 0){
                current = board[row+track][col+track2];
                if(current != 'B' && current != 'Q' && current != '.'){
                    break diagbl;
                }
                if (current == 'B' || current == 'Q') {
                    output.write("Game #" + gameNum + ": black king is in check.\n");
                    return true;
                }
                track++;
                track2--;
            }

        }
        return false;
    }
}
