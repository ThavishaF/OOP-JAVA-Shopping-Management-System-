import java.util.Comparator;

public class ProductComparator implements Comparator<Product>{

    public int compare(Product product1, Product product2){
        return product1.getProductID().compareTo(product2.getProductID());
    }
}
