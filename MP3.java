public class MP3 extends Gadget
{
    private int memory;

    public MP3(String model, double price, int weight, String size, int memory)
    {
        super(model, price, weight, size);
        this.memory = memory;
    }

    public int getMemory()
    {
        return memory;
    }

    public void downloadMusic(int amount)
    {
        if (amount <= 0)
        {
            System.out.println("Please enter a positive download size.");
        }
        else if (memory >= amount)
        {
            memory = memory - amount;
            System.out.println("Music downloaded successfully.");
            System.out.println("Available memory: " + memory);
        }
        else
        {
            System.out.println("Insufficient memory available for this download.");
        }
    }

    public void deleteMusic(int amount)
    {
        if (amount > 0)
        {
            memory = memory + amount;
            System.out.println("Music deleted successfully.");
            System.out.println("Available memory: " + memory);
        }
        else
        {
            System.out.println("Please enter a positive amount of memory to delete.");
        }
    }

    public void display()
    {
        super.display();
        System.out.println("Available Memory: " + memory);
    }
}