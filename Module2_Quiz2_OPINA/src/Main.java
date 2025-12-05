public class Main
{
    public static void main(String[] args)
    {
        Player asuna = new Player(1, "Asuna", 100);
        Player lethalBacon = new Player(2, "LethalBacon", 205);
        Player hpDeskjet = new Player(3, "HpDeskjet", 34);

        PlayerLinkedList playerLinkedList = new PlayerLinkedList();

        playerLinkedList.addToFront(asuna);
        playerLinkedList.addToFront(lethalBacon);
        playerLinkedList.addToFront(hpDeskjet);

        System.out.println("Initial list:");
        playerLinkedList.printList();

        System.out.println("Size: " + playerLinkedList.size());

        System.out.println("\nContains Asuna? " + playerLinkedList.contains(asuna));
        System.out.println("Contains new Player(99, \"Ghost\", 1)? " +
                playerLinkedList.contains(new Player(99, "Ghost", 1)));

        System.out.println("\nIndex of HpDeskjet: " + playerLinkedList.indexOf(hpDeskjet));
        System.out.println("Index of Asuna: " + playerLinkedList.indexOf(asuna));
        System.out.println("Index of unknown player: " +
                playerLinkedList.indexOf(new Player(77, "Unknown", 0)));

        System.out.println("\nRemoving first element...");
        Player removed = playerLinkedList.removeFromFront();
        System.out.println("Removed: " + removed);

        System.out.println("\nList after removal:");
        playerLinkedList.printList();
        System.out.println("Size: " + playerLinkedList.size());

    }
}

