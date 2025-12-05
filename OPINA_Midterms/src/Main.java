import java.util.Random;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        LinkedStack deck = new LinkedStack();
        Stack<Card> discardPile = new Stack<>();
        Stack<Card> playerHand = new Stack<>();

        // --- Create 30 cards ---
        deck.push(new Card(1, "Zinger"));
        deck.push(new Card(2, "McChicken"));
        deck.push(new Card(3, "McNuggets"));
        deck.push(new Card(4, "Whopper"));
        deck.push(new Card(5, "Bacon King"));
        deck.push(new Card(6, "McFlurry"));
        deck.push(new Card(7, "Chao Fan"));
        deck.push(new Card(8, "TripleCheeseburger"));
        deck.push(new Card(9, "WhopperJr."));
        deck.push(new Card(10, "Lauriat"));
        deck.push(new Card(11, "Siomai"));
        deck.push(new Card(12, "Siopao"));
        deck.push(new Card(13, "LumpiangShanghai"));
        deck.push(new Card(14, "Buchi"));
        deck.push(new Card(15, "PancitCanton"));
        deck.push(new Card(16, "X-traLongChicken"));
        deck.push(new Card(17, "Baconator"));
        deck.push(new Card(18, "BLT"));
        deck.push(new Card(19, "Halo-Halo"));
        deck.push(new Card(20, "Sundae"));
        deck.push(new Card(21, "StrawberryCheesecake"));
        deck.push(new Card(22, "BlueberryCheesecake"));
        deck.push(new Card(23, "MaisConYelo"));
        deck.push(new Card(24, "Vanilla"));
        deck.push(new Card(25, "Chocolate"));
        deck.push(new Card(26, "Ube"));
        deck.push(new Card(27, "HotShots"));
        deck.push(new Card(28, "Pepperoni"));
        deck.push(new Card(29, "Hawaiian"));
        deck.push(new Card(30, "CreamCheese&Spinach"));


        System.out.println("\n--- GAME START ---\n");

        // Game loop: ends when deck is empty
        while (!deck.isEmpty()) {
            executeRandomCommand(deck, playerHand, discardPile);
            displayPlayerInfo(deck, playerHand, discardPile);

            try { Thread.sleep(1000); } catch (InterruptedException _) {}
        }

        System.out.println("\n--- GAME OVER: DECK EMPTY ---");
    }

    public static void executeRandomCommand(LinkedStack deck, Stack<Card> playerHand, Stack<Card> discardPile) {
        Random random = new Random();
        int command = random.nextInt(3);  // 0 = draw, 1 = discard, 2 = retrieve

        if (command == 0) {
            int drawCount = random.nextInt(5) + 1;
            drawCards(deck, playerHand, drawCount);

        } else if (command == 1) {
            int discardCount = random.nextInt(playerHand.size() + 1);
            discardCards(playerHand, discardPile, discardCount);

        } else {
            int retrieveCount = random.nextInt(discardPile.size() + 1);
            retrieveCards(discardPile, playerHand, retrieveCount);
        }
    }

    public static void drawCards(LinkedStack deck, Stack<Card> playerHand, int count) {
        System.out.println("Drawing " + count + " card(s)...");
        for (int i = 0; i < count; i++) {
            if (!deck.isEmpty()) {
                playerHand.push(deck.pop());
            } else {
                System.out.println("Deck empty! Cannot draw more.");
                break;
            }
        }
    }

    public static void discardCards(Stack<Card> playerHand, Stack<Card> discardPile, int count) {
        System.out.println("Discarding " + count + " card(s)...");
        for (int i = 0; i < count; i++) {
            if (!playerHand.isEmpty()) {
                discardPile.push(playerHand.pop());
            } else {
                System.out.println("Nothing to discard.");
                break;
            }
        }
    }

    public static void retrieveCards(Stack<Card> discardPile, Stack<Card> playerHand, int count) {
        System.out.println("Retrieving " + count + " card(s)...");
        for (int i = 0; i < count; i++) {
            if (!discardPile.isEmpty()) {
                playerHand.push(discardPile.pop());
            } else {
                System.out.println("No cards in discard pile.");
                break;
            }
        }
    }

    public static void displayPlayerInfo(LinkedStack deck, Stack<Card> playerHand, Stack<Card> discardPile) {
        System.out.println("\n--- PLAYER INFO ---");
        System.out.println("Player hand: " + playerHand);
        System.out.println("Deck remaining: " + deck.size());
        System.out.println("Discard pile: " + discardPile);
        System.out.println("-------------------\n");
    }
}
