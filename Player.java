public class Player {

    private String name;
    protected Hand hand;

    public Player(String name) {
        this.name = name;
        hand = new Hand();
    }

    public void receiveCard(Card card) {
        hand.addCard(card);
    }

    public int getScore() {
        return hand.getValue();
    }

    public String getName() {
        return name;
    }

    public void clearHand() {
        hand.clearHand();
    }

    public void showHand() {
        System.out.println(name + "'s Hand:");
        System.out.println(hand.showCards());
        System.out.println("Score: " + getScore());
    }
}
