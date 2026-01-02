import java.util.*;

public class Distribute {
    static Random rand = new Random();
    static String[] card_suits = { "♥", "♠", "♣", "♦" };
    static String[] card_numbers = { " 2", " 3", " 4", " 5", " 6", " 7", " 8", " 9", " 10", " J", " Q", " K", " A" };

    static String giveCard() {
        return card_suits[rand.nextInt(card_suits.length)] + card_numbers[rand.nextInt(card_numbers.length)];
    }

    String[] computer_cards = new String[8];
    String[] player_cards = new String[8];
    String[] distributed_cards = new String[52];
    Stack<String> stack_cards = new Stack<>();
    // String[] stack_cards = new String[36];
    String trump_card;
    int q = 0;

    void distributeCards() {
        // ---- COMPUTER CARDS ----
        for (int i = 0; i < 8; i++) {
            boolean duplicate;
            do {
                duplicate = false;
                computer_cards[i] = giveCard();

                for (int j = 0; j < i; j++) {
                    if (computer_cards[i].equals(computer_cards[j])) {
                        duplicate = true;
                        break;
                    }
                }
            } while (duplicate);

            distributed_cards[q++] = computer_cards[i];
        }

        // ---- PLAYER CARDS ----
        for (int i = 0; i < 8; i++) {
            boolean duplicate;
            do {
                duplicate = false;
                player_cards[i] = giveCard();

                // check player duplicates
                for (int j = 0; j < i; j++) {
                    if (player_cards[i].equals(player_cards[j])) {
                        duplicate = true;
                        break;
                    }
                }

                // check against ALL computer cards
                for (int j = 0; j < computer_cards.length && !duplicate; j++) {
                    if (player_cards[i].equals(computer_cards[j])) {
                        duplicate = true;
                        break;
                    }
                }

            } while (duplicate);

            distributed_cards[q++] = player_cards[i];
        }

        // ---- STACK CARDS ----
        

        for (int i = 0; i < 36; i++) {

            boolean duplicate;
            String card;

            do {
                duplicate = false;
                card = giveCard();
                for (int j = 0; j < q; j++) {
                    if (card.equals(distributed_cards[j])) {
                        duplicate = true;
                        break;
                    }
                }
                for (String s : stack_cards) {
                    if (card.equals(s)) {
                        duplicate = true;
                        break;
                    }
                }

            } while (duplicate);

            stack_cards.push(card);
            distributed_cards[q++] = card;
        }
        trump_card = stack_cards.pop();
    }

    void print() {
        // System.out.println("Computer Cards:");
        // for (String c : computer_cards)
        //     System.out.println(c);

        System.out.println("\nPlayer Cards:");
        for (String p : player_cards)
            System.out.print(p+", ");

        System.out.println("\nTrump card:" + trump_card);
    }
}
