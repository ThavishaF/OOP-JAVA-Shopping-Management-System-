import java.io.Serializable;

// Electronic class(Sub class of a Product class)
public class Electronics extends Product implements Serializable {
    // Initializing the instance variables
    protected String brand;
    protected double warrantyPeriod;

    // Constructors for the Electronics class
    public Electronics(){}

    public Electronics(String brand, double warrantyPeriod){
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }

    public Electronics(String productID, String productName, double price, String brand, double warrantyPeriod){
        super(productID, productName, price);
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;

    }

    // Setter and Getter methods for the Electronics class
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(double warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public String toString() {
        return "Electronics {" + "productID = '" + productID + '\'' + ", productName = '" + productName + '\'' + ", numberOfAvailableItems = " + numberOfAvailableItems + ", price = " + price + ", brand = '" + brand + '\'' + ", warrantyPeriod = " + warrantyPeriod + '}' + "\n";
    }
}
