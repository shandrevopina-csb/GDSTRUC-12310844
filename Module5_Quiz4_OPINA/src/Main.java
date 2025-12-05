public class Main
{

    public static void main(String[] args)
    {

        Player ploo = new Player(134, "Plooful", 135);
        Player wardell = new Player(536, "TSM Wardell", 640);
        Player deadlyJimmy = new Player(32, "DeadlyJimmy", 34);
        Player subroza = new Player(4931, "Subroza", 604);
        Player annieDro = new Player(6919, "C9 Annie", 593);

        SimpleHashtable hashtable = new SimpleHashtable();
        hashtable.put(ploo.getUserName(), ploo);
        hashtable.put(wardell.getUserName(), wardell);
        hashtable.put(deadlyJimmy.getUserName(), deadlyJimmy);
        hashtable.put(subroza.getUserName(), subroza);
        hashtable.put(annieDro.getUserName(), annieDro);


        // System.out.println(hashtable.get("C9 Annie"));
        System.out.println("\n");
        hashtable.printHashtable();
        hashtable.remove("C9 Annie");
        System.out.println("\n");
        hashtable.printHashtable();

        Player faker = new Player(6196, "T1 Faker", 521);
        hashtable.put(faker.getUserName(), faker);
        System.out.println("\n");
        hashtable.printHashtable();
    }
}