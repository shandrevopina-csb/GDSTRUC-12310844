import java.util.NoSuchElementException;

public class ArrayQueue
{
    private Player[] queue;
    private int front;
    private int back;

    public ArrayQueue(int capacity)
    {
        queue = new Player[capacity];
    }

    public void add(Player player)
    {
        if (back == queue.length)
        {
            Player[] newArray = new Player[queue.length * 2];
            System.arraycopy(queue, 0, newArray, 0,queue.length);
            queue = newArray;
        }

        queue[back] = player;
        back++;

    }

    public Player remove()
    {
        if (size() == 0)
        {
            throw new NoSuchElementException();
        }

        Player removedPlayer = queue[front];
        queue[front] = null;
        front++;

        if (front >= queue.length / 2)
        {
            compactQueue();
        }

        return removedPlayer;
    }

    public Player peek()
    {
        if (size() == 0)
        {
            throw new NoSuchElementException();
        }

        return queue[front];
    }

    public int size()
    {
        return back - front;
    }

    public void printQueue()
    {
        for (int i = front; i < back; i++)
        {
            System.out.println(queue[i]);
        }
    }

    private void compactQueue()
    {
        int newSize = size();
        for (int i = 0; i < newSize; i++) {
            queue[i] = queue[i + front];
        }
        for (int i = newSize; i < queue.length; i++) {
            queue[i] = null;
        }
        back = newSize;
        front = 0;
    }
}
