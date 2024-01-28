import java.io.Serializable;

// Clothing class(Sub class of a Product class)
public class Clothing extends Product implements Serializable {
    // Initializing the instance variables
    protected String size;
    protected String colour;

    // Constructors for the Clothing class
    public Clothing(){}

    public Clothing(String size, String colour){
        this.size = size;
        this.colour = colour;
    }

    public Clothing(String productID, String productName, double price, String size, String colour){
        super(productID, productName, price);
        this.size = size;
        this.colour = colour;
    }

    // Setter and Getter methods for the Clothing class
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Clothing {" + "productID = '" + productID + '\'' + ", productName = '" + productName + '\'' + ", numberOfAvailableItems = " + numberOfAvailableItems + ", price = " + price + ", size = '" + size + '\'' + ", colour = '" + colour + '}' + "\n" ;
    }
}
