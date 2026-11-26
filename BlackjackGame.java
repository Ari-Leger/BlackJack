import java.util.Scanner;

public class BlackjackGame {

    private Deck deck;
    private Player player;
    private Dealer dealer;

    public BlackjackGame(String playerName) {
        deck = new Deck();
        player = new Player(playerName);
        dealer = new Dealer();
    }

    public void playRound(Scanner input) {

        player.clearHand();
        dealer.clearHand();

        player.receiveCard(deck.dealCard());
        dealer.receiveCard(deck.dealCard());

        player.receiveCard(deck.dealCard());
        dealer.receiveCard(deck.dealCard());

        boolean playerTurn = true;

        while (playerTurn) {

            player.showHand();

            System.out.println("\nDealer shows one card.");
            System.out.println("Score Hidden");

            if (player.getScore() > 21) {
                break;
            }

            System.out.print("\nHit or Stand (h/s): ");
            String choice = input.nextLine();

            if (choice.equalsIgnoreCase("h")) {
                player.receiveCard(deck.dealCard());
            } else {
                playerTurn = false;
            }
        }

        if (player.getScore() <= 21) {
            dealer.takeTurn(deck);
        }

        determineWinner();
    }

    private void determineWinner() {

        System.out.println("\n===== FINAL HANDS =====");

        player.showHand();
        dealer.showHand();

        int playerScore = player.getScore();
        int dealerScore = dealer.getScore();

        if (playerScore > 21) {
            System.out.println("Bust! Dealer wins.");
        }
        else if (dealerScore > 21) {
            System.out.println("Dealer busts! You win.");
        }
        else if (playerScore > dealerScore) {
            System.out.println("You win!");
        }
        else if (dealerScore > playerScore) {
            System.out.println("Dealer wins.");
        }
        else {
            System.out.println("Push (Tie).");
        }
    }
}
