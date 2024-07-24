/**
 * Mobile class represents a mobile phone which is a subclass of Gadget
 */
public class Mobile extends Gadget {
    private int callingCredit;
    public Mobile(String model, double price, int weight, String size, int callingCredit) {
        // Call the constructor of the superclass (Gadget)
        super(model, price, weight, size);
        this.callingCredit = callingCredit;
    }
    // Accessor method for callingCredit attribute
    public int getCallingCredit() {
        return callingCredit; 
    }
    
    /**
     * Method to add calling credit to the mobile
     */ 
    public void addCallingCredit(int credit) {
        if (credit > 0) {
            callingCredit += credit;
        } else {
            System.out.println("Please enter a positive amount for credit.");
        }
    }
    
    /**
     * Method to make a phone call
     */
    public void makeCall(String phoneNumber, int duration) {
        if (callingCredit >= duration) {
            System.out.println("Calling " + phoneNumber + " for " + duration + " minutes.\n");
            callingCredit -= duration;
        } else {
            System.out.println("Insufficient credit to make the call.");
        }
    }
    
    /**
     * Override the display method to include calling credit
     */
    @Override 
    public void display() {
        super.display(); // Call the display method of the superclass (Gadget)
        System.out.println("Minutes remaining: " + callingCredit + "\n");
    }
}

