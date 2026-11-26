public class Dealer extends Player {

    public Dealer() {
        super("Dealer");
    }

    public void takeTurn(Deck deck) {

        while (getScore() < 17) {
            receiveCard(deck.dealCard());
        }
    }
}
