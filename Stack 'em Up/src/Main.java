import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    static final String[] SUITS = {"Clubs","Diamonds","Hearts","Spades"};
    static final String[] VALUES = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    static HashMap<Integer, String> deck = new HashMap<>();

    public static void main(String[] args) throws IOException {
        //Create a deck.
        //Takes >1 millisecond so I'll keep it like this instead of some insane manual way.
        int key = 1;
        for(int suit = 0; suit < SUITS.length; suit++){
            for(int value = 0; value < VALUES.length; value++){
                deck.put(key, (VALUES[value] + " of " + SUITS[suit]));
                key++;
            }
        }

        int cases = Integer.parseInt(input.readLine().trim());
        for(int case_ = 0; case_ < cases; case_++) {
            input.readLine();

        }
    }
}
