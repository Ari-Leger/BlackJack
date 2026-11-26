import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = input.nextLine();

        BlackjackGame game = new BlackjackGame(name);

        boolean playing = true;

        while (playing) {

            game.playRound(input);

            System.out.print("\nPlay again? (y/n): ");
            String choice = input.nextLine();

            if (!choice.equalsIgnoreCase("y")) {
                playing = false;
            }
        }

        System.out.println("Thanks for playing!");
        input.close();
    }
}
