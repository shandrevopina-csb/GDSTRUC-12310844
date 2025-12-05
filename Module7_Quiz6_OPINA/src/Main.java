public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.insert(25);
        tree.insert(17);
        tree.insert(29);
        tree.insert(10);
        tree.insert(16);
        tree.insert(-5);
        tree.insert(60);
        tree.insert(55);

        System.out.println("In-order traversal:");
        tree.traverseInOrder();

        System.out.println("\nIn-order descending traversal:");
        tree.traverseInOrderDescending();

        System.out.println("\nMinimum value: " + tree.getMin());
        System.out.println("Maximum value: " + tree.getMax());

    }
}



