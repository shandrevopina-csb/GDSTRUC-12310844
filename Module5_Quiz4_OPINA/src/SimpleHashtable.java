public class SimpleHashtable {

    private StoredPlayer[] hashtable;
    private final StoredPlayer DELETED = new StoredPlayer(null, null);

    public SimpleHashtable() {
        hashtable = new StoredPlayer[10];
    }

    private int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    public void put(String key, Player value) {
        int hashedKey = hashKey(key);

        if (isOccupied(hashedKey)) {
            int stoppingIndex = hashedKey;

            do {
                hashedKey = (hashedKey + 1) % hashtable.length;
            } while (isOccupied(hashedKey) && hashedKey != stoppingIndex);
        }

        if (isOccupied(hashedKey)) {
            System.out.println("Sorry, there is already an element at position " + hashedKey);
        } else {
            hashtable[hashedKey] = new StoredPlayer(key, value);
        }
    }

    public Player get(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }
        return hashtable[hashedKey].value;
    }

    private int findKey(String key) {
        int hashedKey = hashKey(key);

        // Direct match
        if (hashtable[hashedKey] != null &&
                hashtable[hashedKey] != DELETED &&
                hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        }

        int stoppingIndex = hashedKey;
        hashedKey = (hashedKey + 1) % hashtable.length;

        while (hashedKey != stoppingIndex &&
                hashtable[hashedKey] != null) {

            if (hashtable[hashedKey] != DELETED &&
                    hashtable[hashedKey].key.equals(key)) {
                return hashedKey;
            }

            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        return -1;
    }

    public void remove(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return; // Not found
        }

        // Mark slot as deleted
        hashtable[hashedKey] = DELETED;
    }

    private boolean isOccupied(int index) {
        return hashtable[index] != null && hashtable[index] != DELETED;
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i] == null) {
                System.out.println("Element " + i + " null");
            } else if (hashtable[i] == DELETED) {
                System.out.println("Element " + i + " <DELETED>");
            } else {
                System.out.println("Element " + i + " " + hashtable[i].value);
            }
        }
    }
}

