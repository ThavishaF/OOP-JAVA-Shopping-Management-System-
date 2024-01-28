import java.io.Serializable;

// Product class(the supper class of the Electronics and Clothing class)
public abstract class Product implements Serializable {
    // Initializing the instance variables
    protected String productID;
    protected String productName;
    protected int numberOfAvailableItems;
    protected double price;

    // Constructors for the Product class
    public Product(){}

    public Product(String productID, String productName, double price){
        this.productID = productID;
        this.productName = productName;
        this.price = price;
    }

    public Product(String productID, String productName, int numberOfAvailableItems, double price){
        this.productID = productID;
        this.productName = productName;
        this.numberOfAvailableItems = numberOfAvailableItems;
        this.price = price;
    }

    // Setter and Getter methods for the Product class
    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getNumberOfAvailableItems() {
        return numberOfAvailableItems;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String displayNumberOfProducts(){
        numberOfAvailableItems = WestminsterShoppingManager.totalNumberOfProducts;
        return null;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", numberOfAvailableItems=" + numberOfAvailableItems +
                ", price=" + price +
                '}' ;
    }
}

