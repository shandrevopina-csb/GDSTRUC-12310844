import java.util.*;

public class Main
{

    public static void main(String[] args)
    {

        ArrayQueue queue = new ArrayQueue(10); // larger initial capacity
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        queue.add(new Player(1, "aceu", 100));
        queue.add(new Player(2, "Sinatraa", 100));
        queue.add(new Player(3, "Subroza", 95));
        queue.add(new Player(4, "ploo", 90));
        queue.add(new Player(5, "TenZ", 85));

        ArrayList<Player> extraPlayers = new ArrayList<>(Arrays.asList(
                new Player(6, "Munchkin", 80), new Player(7, "Jinggg", 75),
                new Player(8, "DerbO", 88), new Player(9, "ScreaM", 92),
                new Player(10, "Lakia", 94), new Player(11, "Boaster", 100),
                new Player(12, "Kyedae", 100), new Player(13, "Zekken", 95),
                new Player(14, "MiniBoo", 90), new Player(15, "Noia", 85),
                new Player(16, "Primmie", 80), new Player(17, "Yay", 75),
                new Player(18, "Aspas", 88), new Player(19, "Som", 92),
                new Player(20, "Skuba", 94), new Player(21, "Leaf", 89),
                new Player(22, "Demon1", 96), new Player(23, "Chronicle", 93),
                new Player(24, "Leo", 95), new Player(25, "Less", 97),
                new Player(26, "Heat", 91), new Player(27, "Kellogg", 87),
                new Player(28, "Sayf", 92), new Player(29, "Nivera", 90),
                new Player(30, "Jamppi", 94), new Player(31, "Stax", 88),
                new Player(32, "Buzz", 86), new Player(33, "Rb", 84),
                new Player(34, "Zest", 83), new Player(35, "MaKo", 95),
                new Player(36, "Mindfreak", 90), new Player(37, "Forsaken", 92),
                new Player(38, "BenKai", 85), new Player(39, "JoxJo", 80),
                new Player(40, "Keznit", 95), new Player(41, "Shroud", 90),
                new Player(42, "Wardell", 96), new Player(43, "Steel", 85),
                new Player(44, "Hiko", 89), new Player(45, "Nitr0", 88),
                new Player(46, "Crashies", 92), new Player(47, "Victor", 91),
                new Player(48, "Marved", 95), new Player(49, "FNS", 90),
                new Player(50, "Sacy", 94), new Player(51, "Pancada", 93),
                new Player(52, "Dephh", 84), new Player(53, "Xeppa", 88),
                new Player(54, "Leafy", 86), new Player(55, "Bang", 92)
        ));

        int gameCount = 0;

        System.out.println("\nInitial players:");
        queue.printQueue();

        System.out.println("\nPress ENTER to start matchmaking...");
        sc.nextLine();

        while (gameCount < 10)
        {

            System.out.println("\nPress ENTER for next turn...");
            sc.nextLine();

            int playersJoining = rand.nextInt(7) + 1;
            System.out.println(playersJoining + " new players joining!");

            for (int i = 0; i < playersJoining && !extraPlayers.isEmpty(); i++)
            {
                int randIndex = rand.nextInt(extraPlayers.size());
                Player p = extraPlayers.remove(randIndex);
                queue.add(p);
                System.out.println("Joined: " + p);
            }

            System.out.println("Queue size: " + queue.size());

            while (queue.size() >= 5 && gameCount < 10)
            {
                gameCount++;

                System.out.println("\n=== Game " + gameCount + " STARTED ===");
                System.out.println("Matched players:");

                for (int i = 0; i < 5; i++) {
                    System.out.println(queue.remove());
                }

                System.out.println("Remaining in queue: " + queue.size());
            }
        }

        System.out.println("\n=== The Game is Finished!!! ===");
    }
}










