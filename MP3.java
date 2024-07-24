/** MP3 class represents an MP3 player which is a subclass of Gadget **/
public class MP3 extends Gadget {
    private int availableMemory; // Available memory in the MP3 player
    /** 
     * Constructor to initialize the MP3 class
     */
    public MP3(String model, double price, int weight, String size, int availableMemory) {
        // Call the constructor of the superclass (Gadget)
        super(model, price, weight, size);
        this.availableMemory = availableMemory;
    }
    
    /** 
     * Accessor method for availalbleMemory attribute
     */
    public int getAvailableMemory() {
        return availableMemory;
    }
    
    /**
     * Method to download music to the MP3 player
     */
    public void downloadMusic(int memory) {
        // Check if there is enough available memory
        if (memory <= availableMemory) { 
            availableMemory -= memory; // Reduce the available memory
            System.out.println("Music downloaded. Available memory: " + availableMemory + "Mb\n");
        } else {
            System.out.println("Not enough memory to download music.");
        }
    }
    
    /**
     * Method to delete music and give space to the memory
     */
    public void deleteMusic(int memory) {
        availableMemory += memory; // Increase the available memory
        System.out.println("Music deleted. Available memory: " + availableMemory);
    }
    
    @Override  // Override the display method to include available memory
    public void display() {
        super.display(); // Call the display method of the superclass (Gadget)
        System.out.println("Available memory: " + availableMemory + "\n");
    }
}