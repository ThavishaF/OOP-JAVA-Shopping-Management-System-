import java.util.ArrayList;

// This interface outline the basic functionality to manage the shopping system
public interface ShoppingManager {
    // Add a product to the system
    void addNewProduct();

    // Delete a product form the system
    void deleteProduct();

    // Print the list of products in the system
    void printProductsList();

    // Save the current state of the system as a file
    void saveAsFile();
}
