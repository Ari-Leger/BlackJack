import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        buildDeck();
        shuffle();
    }

    private void buildDeck() {

        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {
                "Ace", "2", "3", "4", "5", "6", "7",
                "8", "9", "10", "Jack", "Queen", "King"
        };

        for (String suit : suits) {
            for (String rank : ranks) {

                int value;

                if (rank.equals("Ace")) {
                    value = 11;
                } else if (rank.equals("Jack") ||
                           rank.equals("Queen") ||
                           rank.equals("King")) {
                    value = 10;
                } else {
                    value = Integer.parseInt(rank);
                }

                cards.add(new Card(suit, rank, value));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card dealCard() {

        if (cards.isEmpty()) {
            buildDeck();
            shuffle();
        }

        return cards.remove(0);
    }

    public int cardsRemaining() {
        return cards.size();
    }
}
