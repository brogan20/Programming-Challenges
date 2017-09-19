
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

        Integer cases = Integer.parseInt(input.nextLine().trim());
        for(int case_ = 0; case_ < cases; case_++) {

            input.nextLine();
            //Get shuffles
            Integer shuffleCases = Integer.parseInt(input.nextLine().trim());
            ArrayList<Integer[]> shuffles = new ArrayList<>();
            for(int i = 0; i < shuffleCases; i++){
                Integer[] shuffle = new Integer[DECK_SIZE];
                for (int j = 0; j < DECK_SIZE; j++){
                    shuffle[j] = input.nextInt();
                }
                shuffles.add(shuffle);
            }
            //Shuffle
            Integer[] deck = new Integer[52];
            Integer[] previousDeck = Arrays.copyOf(deckRef, DECK_SIZE);
            String s;
            while((s = input.nextLine()) != null && !s.equals("") ){
                Integer[] shuffle = shuffles.get(Integer.parseInt(s)-1);
                for (int i = 0; i < shuffle.length; i++){
                    deck[i] = previousDeck[shuffle[i]-1];
                }
                previousDeck = Arrays.copyOf(deck, DECK_SIZE);
            }
            for (Integer card: deck) {
                System.out.println(deckStrings.get(card));
            }

        }
    }
}
