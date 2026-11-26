import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void clearHand() {
        cards.clear();
    }

    public int getValue() {

        int total = 0;
        int aceCount = 0;

        for (Card card : cards) {

            total += card.getValue();

            if (card.getRank().equals("Ace")) {
                aceCount++;
            }
        }

        while (total > 21 && aceCount > 0) {
            total -= 10;
            aceCount--;
        }

        return total;
    }

    public String showCards() {

        StringBuilder result = new StringBuilder();

        for (Card card : cards) {
            result.append(card).append("\n");
        }

        return result.toString();
    }
}
