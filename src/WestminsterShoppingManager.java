// This WestminsterShoppingManager class implement form ShoppingManager class.
// And specify the behavior of the managing system.
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WestminsterShoppingManager implements ShoppingManager, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    public static Scanner input = new Scanner(System.in); // Create a scanner object

    public static ArrayList<Product> productList = new ArrayList<>(); // Create an ArrayList object to save all the products
    ArrayList<Product> electronicList = new ArrayList<>(); // Create an ArrayList object to save all the electronics
    ArrayList<Product> clothingList = new ArrayList<>(); // Create an ArrayList object to save all the clothing

    public static int totalNumberOfProducts = 0;
    public static int maxNumberOfProducts = 50;

    // Selection menu implement
    public void displayMenu(){ // Implementing the display menu
        boolean go = true; // iterate the while loop
        while (go) {
            // Printing the main menu
            System.out.println("""
                    \n          *** Shopping Management System ***
                                        
                    -----------------------------------------------------
                    Number | Options                                    |
                    -----------------------------------------------------
                    1      | Add a new product (Electronics / Clothing).|
                    2      | Delete a product.                          |
                    3      | Print a list of products.                  |
                    4      | Save system information in to a file.      |
                    5      | Load system information from a file.       |
                    6      | Open graphical user interface.             |
                    7      | Exit from the program.                     |
                    -----------------------------------------------------
                    """);
            System.out.print("Select an option to Continue : "); // Getting user inputs from the user
            String option = input.next();
            System.out.println(" ");

            // Switch case to direct to corresponding method.
            switch (option) {
                case "1" -> {
                    addNewProduct();
                    go = false;
                }
                case "2" -> {
                    deleteProduct();
                    go = false;
                }
                case "3" -> {
                    printProductsList();
                    go = false;
                }
                case "4" -> {
                    saveAsFile();
                    go = false;
                }case "5" ->{
                    loadFromFile();
                    go = false;
                }case "6" ->{
                    new GraphicalUserInterface();
                    go = false;
                }case "7" ->{
                    System.exit(0);
                }
                default -> System.out.println("Please select an option from below table."); // Handling user input errors.
            }
        }
    }

    // Add a product to the system
    @Override
    public void addNewProduct() {
        if (totalNumberOfProducts < maxNumberOfProducts) { // Checking the total number of products is grater than tbe 50
            totalNumberOfProducts ++;

            while (true) { // While loop to get the correct user inputs
                // Printing the list of option to choose.
                System.out.print("""
                    \n** Product types **
                        
                    Number| Options
                    --------------------
                    1     | Electronics
                    2     | Clothing
                    """);
                System.out.print("Please select the product type: ");

                // Try and Catch to handle invalid user inputs.
                try {
                    int productOption = input.nextInt();

                    //Adding electronics to the system
                    if (productOption == 1) {

                        // Getting product ID
                        System.out.print("\nEnter the product ID: ");
                        String productID = input.next();

                        // Getting product name
                        System.out.print("Enter the product name: ");
                        String productName = input.next();

                        // Getting price
                        System.out.print("Enter price of the product: ");
                        // Validating user input
                        double price;
                        while (true){
                            try {
                                price = input.nextInt();
                                break;
                            }catch (Exception e){
                                System.out.print("Please enter numbers as input: ");
                                input.next();
                            }
                        }

                        // Getting the brand
                        System.out.print("Enter the brand: ");
                        String brand = input.next();

                        // Getting warranty period
                        double warrantyPeriod;
                        System.out.print("Enter the warranty period: ");
                        while (true) {
                            try {
                                warrantyPeriod = input.nextInt();
                                break;
                            } catch (Exception e){
                                System.out.println("Please enter numbers as input: ");
                                input.next();
                            }

                        }

                        // Creating an objet for the electric products.
                        Product electronics = new Electronics(productID, productName, price, brand, warrantyPeriod);
                        electronicList.add(electronics);
                        productList.add(electronics);

                        System.out.println("New product has been added. The total number of in the system is :" + totalNumberOfProducts);
                        break;

                    // Adding cloths to the system
                    } else if (productOption == 2) {
                        // Getting product ID
                        System.out.print("\nEnter the product ID: ");
                        String productID = input.next();

                        // Getting product name
                        System.out.print("Enter the product name: ");
                        String productName = input.next();

                        // Getting price
                        System.out.print("Enter price of the product: ");
                        // Validating user input
                        double price;
                        while (true){
                            try {
                                price = input.nextInt();
                                break;
                            }catch (Exception e){
                                System.out.print("Please enter numbers as input: ");
                                input.next();
                            }
                        }

                        // Getting the size
                        System.out.print("Enter the size: ");
                        String size = input.next();

                        // Getting the colour
                        System.out.print("Enter the colour: ");
                        String colour = input.next();

                        // Creating an objet for the clothing products.
                        Product clothing = new Clothing(productID, productName, price, size,colour);
                        clothingList.add(clothing);
                        productList.add(clothing);

                        System.out.println("New product has been added. The total number of in the system is :" + totalNumberOfProducts);
                        break;

                    // Handle invalid user inputs.
                    } else {
                        System.out.println("\nPlease select a option from below list");
                    }

                // Exception handling
                } catch (Exception e) {
                    System.out.println("\nPlease select a option from below list");
                    input.next();
                }
            }
        }else {
            // Display a message to indicate the product list is full
            System.out.println("**Maximum number of products that can be store in the system is 50.**");
        }
    }

    // Delete a product form the system
    @Override
    public void deleteProduct() {
        //
        boolean go = true;
        while (go){
            if (productList.size() != 0){
                System.out.println(productList);
                System.out.print("Please enter the ID of the product that need to be removed: ");
                String removeProductID = input.next();

                for (int i = 0; i < productList.size(); i++) {
                    if (productList.get(i).getProductID().equals(removeProductID)){
                        productList.remove(productList.get(i));
                        System.out.println();
                        totalNumberOfProducts -- ;
                        System.out.println("The " + removeProductID + " product has been removed, The number of available products: " + totalNumberOfProducts);
                        displayMenu();
                        go = false;
                    }else{
                        System.out.println("Please enter an valid product id!\n");
                    }
                }
            } else {
                System.out.println("Please add products before remove.");
                break;
            }
        }
    }

    public void sort(){
        ProductComparator productComparator = new ProductComparator();
        Collections.sort(productList, productComparator);
        Collections.sort(electronicList, productComparator);
        Collections.sort(clothingList, productComparator);
    }

    // Print the list of products in the system
    @Override
    public void printProductsList() {
        int options;
        sort();

        if (productList.size() != 0) {
            while (true) {
                System.out.println("""
                        \nNumber| Options
                        -----------------------------------------
                        1     | Print the entire product list
                        2     | Print the electronic product list
                        3     | Print the clothing product list
                        """);
                System.out.print("Select an option form above: ");
                while (true) {
                    try {
                        options = input.nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.print("Please select the correct option: ");
                        input.next();
                    }
                }

                switch (options) {
                    case 1 -> {
                        System.out.println(productList);
                        displayMenu();
                    }
                    case 2 -> {
                        System.out.println(electronicList);
                        displayMenu();
                    }
                    case 3 -> {
                        System.out.println(clothingList);
                        displayMenu();
                    }
                    default -> System.out.println("Please select the correct option form below list!");
                }
            }
        }else {
            System.out.println("Please add products before sort.");
        }
    }

    // Save the current state of the system as a file
    @Override
    public void saveAsFile() {
        sort();// Sorting the lists before saving.
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Product.dat"))) {
            objectOutputStream.writeObject(productList);
            objectOutputStream.writeObject(electronicList);
            objectOutputStream.writeObject(clothingList);
            System.out.println("The current state of the system has written to a file successfully");
            displayMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(){
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Product.dat"))){
            productList = (ArrayList<Product>) objectInputStream.readObject();
            for (Product product : productList) {
                if(product instanceof Clothing){
                    clothingList.add((Clothing) product);
                }else if (product instanceof Electronics){
                    electronicList.add((Electronics) product);
                }
            }
            System.out.println("The system sussesfully ritrive data from a file.");
            displayMenu();
        }catch (IOException |ClassNotFoundException e){
//            e.printStackTrace();
            System.out.println("The save file hels ");
        }

    }
}
