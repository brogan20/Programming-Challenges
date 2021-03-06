import java.util.*;

public class Main {
    static Scanner input = new Scanner(System.in);

    static final int DECK_SIZE = 52;
    static final String[] SUITS = {"Clubs","Diamonds","Hearts","Spades"};
    static final String[] VALUES = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    static HashMap<Integer, String> deckStrings = new HashMap<>();


    public static void main(String[] args) {
        //Create a deck.
        //Takes >1 millisecond so I'll keep it like this instead of some insane manual way.
        int key = 1;
        for(int suit = 0; suit < SUITS.length; suit++){
            for(int value = 0; value < VALUES.length; value++){
                deckStrings.put(key, (VALUES[value] + " of " + SUITS[suit]));
                key++;
            }
        }

        Integer[] deckRef = deckStrings.keySet().toArray(new Integer[DECK_SIZE]);

        Integer cases = input.nextInt();
        Integer casesDecrement = cases-1;
        for(int case_ = 0; case_ < cases; case_++) {

            input.nextLine();
            //Get shuffles
            Integer shuffleCases = input.nextInt();
            Integer[][] shuffles = new Integer[shuffleCases][52];
            for(int i = 0; i < shuffleCases; i++){
                for (int j = 0; j < DECK_SIZE; j++){
                    shuffles[i][j] = input.nextInt();
                }
            }

            //Shuffle
            Integer[] deck = new Integer[52];
            Integer[] previousDeck = Arrays.copyOf(deckRef, DECK_SIZE);

            input.useDelimiter("\n");
            while(input.hasNextInt()){
                Integer[] shuffle = shuffles[input.nextInt()-1];
                for (int i = 0; i < shuffle.length; i++){
                    deck[i] = previousDeck[shuffle[i]-1];
                }
                previousDeck = Arrays.copyOf(deck, DECK_SIZE);
            }
            input.useDelimiter("\\p{javaWhitespace}+");
            for (Integer card: deck) {
                System.out.println(deckStrings.get(card));
            }
            if(case_ < casesDecrement) System.out.println();
        }
    }
}
