package javacoursework;

/**
 * Used to create class LaptopInfo which is used by MenuInfo class for adding laptop information in ArrayList.
 * It provides the information of bikes and customers.
 * This class has 6 attributes, a constructor and 6 getter methods. 
 * @author (Prajan Acharya, Mohit Paudel, Khiman Thapa, Sanchay Chapagain) 
 * Created on November 20,2017
 */
public class LaptopInfo {
    private int laptopId;
    private String brand;
    private String model;
    private String processor;
    private String color;
    private double price;
    
    /**
     * Constructor of class LaptopInfo
     * Initializes attributes laptopId, brand, model, processor, color, price through parameters
     */
    public LaptopInfo(int laptopId, String brand, String model, String processor, String color, double price){
        this.laptopId=laptopId;
        this.brand=brand;
        this.model=model;
        this.processor=processor;
        this.color=color;
        this.price=price;
    }
    
    /**
     * Getter method. 
     * returns the id of the laptop.
     */
    public int getLaptopId(){
        return laptopId;
    }
    
    /**
     * Getter method. 
     * returns the brand of the laptop.
     */
    public String getBrand(){
        return brand;
    }
    
    /**
     * Getter method. 
     * returns the model of the laptop.
     */
    public String getModel(){
        return model;
    }
    
    /**
     * Getter method. 
     * returns the processor of the laptop.
     */
    public String getProcessor(){
        return processor;
    }
    
    /**
     * Getter method. 
     * returns the color of the laptop.
     */
    public String getColor(){
        return color;
    }
    
    /**
     * Getter method. 
     * returns the price of the laptop.
     */
    public double getPrice(){
        return price;
    }
}
