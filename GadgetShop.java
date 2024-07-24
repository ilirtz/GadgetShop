import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.*;

public class GadgetShop extends JFrame implements ActionListener {
    private ArrayList<Gadget> gadgets; // Arraylist to store gadgets
    private JTextField modelField, priceField, weightField, sizeField, creditField, memoryField, phoneNumberField, durationField, downloadField, displayNumberField;
    private JButton addMobileButton, addMP3Button, clearButton, displayAllButton, makeCallButton, downloadMusicButton;
    private JTextArea displayArea; // TextArea for displaying gadgets
    public GadgetShop() {
        gadgets = new ArrayList<>(); // Initialize ArrayList
        
        setTitle("Gadget Shop");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Using null layout for manual positioning
        /**
         * Labels and TextFields for inputs
         */
        JLabel modelLabel = new JLabel("Model:");
        modelLabel.setBounds(20, 20, 100, 20);
        add(modelLabel);
        
        modelField = new JTextField();
        modelField.setBounds(20, 40, 100, 20);
        add(modelField);
        
        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setBounds(120, 20, 100, 20);
        add(priceLabel);
        
        priceField = new JTextField();
        priceField.setBounds(120, 40, 100, 20);
        add(priceField);
        
        JLabel weightLabel = new JLabel("Weight:");
        weightLabel.setBounds(220, 20, 100, 20);
        add(weightLabel);
        
        weightField = new JTextField();
        weightField.setBounds(220, 40, 100, 20);
        add(weightField);
        
        JLabel sizeLabel = new JLabel("Size:");
        sizeLabel.setBounds(320, 20, 100, 20);
        add(sizeLabel);
        
        sizeField = new JTextField();
        sizeField.setBounds(320, 40, 100, 20);
        add(sizeField);
        
        JLabel creditLabel = new JLabel("Credit:");
        creditLabel.setBounds(20, 60, 100, 20);
        add(creditLabel);
        
        creditField = new JTextField();
        creditField.setBounds(20, 80, 100, 20);
        add(creditField);
        
        JLabel memoryLabel = new JLabel("Memory:");
        memoryLabel.setBounds(120, 60, 100, 20);
        add(memoryLabel);
        
        memoryField = new JTextField();
        memoryField.setBounds(120, 80, 100, 20);
        add(memoryField);
        
        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        phoneNumberLabel.setBounds(20, 100, 100, 20);
        add(phoneNumberLabel);
        
        phoneNumberField = new JTextField();
        phoneNumberField.setBounds(20, 120, 100, 20);
        add(phoneNumberField);
        
        JLabel durationLabel = new JLabel("Duration:");
        durationLabel.setBounds(120, 100, 100, 20);
        add(durationLabel);
        
        durationField = new JTextField();
        durationField.setBounds(120, 120, 100, 20);
        add(durationField);
        
        JLabel downloadLabel = new JLabel("Download:");
        downloadLabel.setBounds(220, 100, 100, 20);
        add(downloadLabel);
        
        downloadField = new JTextField();
        downloadField.setBounds(220,120,100, 20);
        add(downloadField);
        
        JLabel displayNumberLabel = new JLabel("Display Number:");
        displayNumberLabel.setBounds(320,100, 100, 20);
        add(displayNumberLabel);
        
        displayNumberField = new JTextField();
        displayNumberField.setBounds(320,120, 100, 20);
        add(displayNumberField);
        
        /**
         * Buttons for actions
         */
        addMobileButton = new JButton("Add Mobile");
        addMobileButton.setBounds(220, 60, 100, 20);
        addMobileButton.addActionListener(this); // Register ActionListener
        add(addMobileButton);
        
        addMP3Button = new JButton("Add MP3");
        addMP3Button.setBounds(320, 60, 100, 20);
        addMP3Button.addActionListener(this);
        add(addMP3Button);
        
        clearButton = new JButton("Clear");
        clearButton.setBounds(220, 80, 100, 20);
        clearButton.addActionListener(this);
        add(clearButton);
        
        displayAllButton = new JButton("Display All");
        displayAllButton.setBounds(320, 80, 100, 20);
        displayAllButton.addActionListener(this);
        add(displayAllButton);
        
        makeCallButton = new JButton("Make a Call");
        makeCallButton.setBounds(20, 140, 100, 20);
        makeCallButton.addActionListener(this);
        add(makeCallButton);
        
        downloadMusicButton = new JButton("Download Music");
        downloadMusicButton.setBounds(120, 140, 150, 20);
        downloadMusicButton.addActionListener(this); 
        add(downloadMusicButton);
        
        /** Display area for showing gadgets **/
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBounds(20, 200, 400, 200);
        add(scrollPane);
        
        setVisible(true); // Make the GUI visible
    }

    
    /**
     * ActionListener implementation for button actions
     */
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Add Mobile button action
        try {
            if (e.getSource() == addMobileButton) {
            // Read values from text fields
            String model = modelField.getText();
            double price = Double.parseDouble(priceField.getText());
            int weight = Integer.parseInt(weightField.getText());
            String size = sizeField.getText();
            int credit = Integer.parseInt(creditField.getText());
            // Check for negative numbers
            if (price < 0 || weight < 0 || credit < 0) {
                JOptionPane.showMessageDialog(null, "Invalid input, Please use a positive Number.");
                return; // Stop further execution
            }
            // Add a new Mobile
            gadgets.add(new Mobile(model, price, weight, size, credit));
            clearFields();
            displayArea.append("Added Mobile: " + model + "\n");
        } else if (e.getSource() == addMP3Button) {
            // Get input values and add MP3
            String model = modelField.getText();
            double price = Double.parseDouble(priceField.getText());
            int weight = Integer.parseInt(weightField.getText());
            String size = sizeField.getText();
            int memory = Integer.parseInt(memoryField.getText());
            gadgets.add(new MP3(model, price, weight, size, memory));
            clearFields();
            displayArea.append("Added MP3: " + model + "\n");
        } else if (e.getSource() == clearButton) {
            clearFields();
            displayArea.setText("");
        } else if (e.getSource() == displayAllButton) {
            displayAll();
            displayArea.append("");
        } else if (e.getSource() == makeCallButton) {
            // Get input values and make Call
            int displayNumber = getDisplayNumber(displayNumberField.getText());
            if (displayNumber != -1) {
                String phoneNumber = phoneNumberField.getText();
                int duration = Integer.parseInt(durationField.getText());
                Mobile mobile = (Mobile) gadgets.get(displayNumber);
                mobile.makeCall(phoneNumber, duration);
                displayArea.append("Calling from number: " +  
                phoneNumber + " for " 
                + duration + " mins \nand you have " 
                + mobile.getCallingCredit()+ " mins left \n");
                clearFields();
                if (mobile.getCallingCredit() < duration) {
                    JOptionPane.showMessageDialog(null,
                    "Insufficient credit to make the call. Please add more credit");
                    return; // Stop further execution
                }
            }
        } else if (e.getSource() == downloadMusicButton) {
            // Get input values and download Music
            int displayNumber = getDisplayNumber(displayNumberField.getText());
            if (displayNumber != -1) {
                int memory = Integer.parseInt(downloadField.getText());
                MP3 mp3 = (MP3) gadgets.get(displayNumber);
                mp3.downloadMusic(memory);
                displayArea.append("Dowloaded music to MP3: " 
                + mp3.getModel() + ", " 
                + mp3.getAvailableMemory() + " Mb left \n");
                clearFields();
            }
        }
       }catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numbers.");
       }
    
    }
    
     
    /**
     * Method to clear input fields
     */
    private void clearFields() {
        modelField.setText("");
        priceField.setText("");
        weightField.setText("");
        sizeField.setText("");
        creditField.setText("");
        memoryField.setText("");
        phoneNumberField.setText("");
        durationField.setText("");
        downloadField.setText("");
        displayNumberField.setText("");
    }
    
    /**
     * Method to display all gadgets
     */
    public void displayAll() {
        displayArea.setText(""); //Clear previous contentn
        for (int i = 0; i < gadgets.size(); i++) {
            clearFields();
            gadgets.get(i).display();
            displayArea.append("Gadget number: " + i + "\n"); // Add new line between gadgets
        }
    }

    /**
     * Method to validate and get display number from input 
     */
    private int getDisplayNumber(String input) {
        try {
            int displayNumber = Integer.parseInt(input);
            if (displayNumber >= 0 && displayNumber < gadgets.size()) {
                return displayNumber;
            } else {
                JOptionPane.showMessageDialog(null, "Display number is out of range.");
                return -1; // Return -1 for invalid input
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid display number format.");
            return -1;  // Return -1 for invalid input
        }
    }

    /**
     * Main method to start the program 
     */
    public static void main(String[] args) {
                new GadgetShop();// Create an instance of GadgetShop
    }
} 
   