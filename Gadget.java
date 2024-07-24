/**
 * Gadget Shop application for adding Mobiles phones, MP3 players making calls and dowloading music.
 *
 * @author (Ilir Tzaferai)
 * @version (12/04/2024)
 */
public class Gadget {
    // Attributes
    private String model;
    private double price;
    private int weight;
    private String size;
    
    /**
     * Constructor to initialize the gadget attributes
     */
    public Gadget(String model, double price, int weight, String size) {
        this.model = model; // Model of the gadget
        this.price = price; // Price of the gadget in pounds
        this.weight = weight; // Weight of the gadget in grams
        this.size = size; // Size of the gadget (e.g., "71mm x 137mm x 9mm")
    }
        
    /**
     * Method to display the details of the gadget
     */
    
    public void display() {
        System.out.println("Model: " + model);
        System.out.println("Price: " + price + " pounds");
        System.out.println("Weight: " + weight + " grams");
        System.out.println("Size: " + size);
    }
    
    /**
     * Accessor methods
     */
    public String getModel() {
        return model;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getWeight() {
        return weight;
    }
    
    public String getSize() {
        return size;
    }
}
