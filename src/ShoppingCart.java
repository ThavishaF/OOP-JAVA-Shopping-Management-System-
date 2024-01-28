import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ShoppingCart extends JFrame {


    ShoppingCart(){
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
         JLabel productIdLabel;
         JLabel productNameLabel;
         JLabel categoryLabel;
         JLabel priceLabel;
         JLabel infoLabel;

        productIdLabel = new JLabel("Product ID: ");
        productIdLabel.setBounds(20, 700, 200, 20);
        add(productIdLabel);

        productNameLabel = new JLabel("Product Name: ");
        productNameLabel.setBounds(20, 720, 200, 20);
        add(productNameLabel);

        categoryLabel = new JLabel("Category: ");
        categoryLabel.setBounds(20, 740, 200, 20);
        add(categoryLabel);

        priceLabel = new JLabel("Price: ");
        priceLabel.setBounds(20, 760, 200, 20);
        add(priceLabel);

        infoLabel = new JLabel("Info: ");
        infoLabel.setBounds(20, 780, 400, 20);
        add(infoLabel);


        String[] columnNames = {"Product ID","Name","Category","Price","Info"};



        DefaultTableModel tableModel = new DefaultTableModel(columnNames,0);
        JTable table = new JTable(tableModel);

        for (Product product : WestminsterShoppingManager.productList) {
            if (product instanceof Electronics){
                Electronics electronics = (Electronics) product;
                tableModel.addRow(new Object[]{electronics.getProductID(), electronics.getProductName(), "Electronics", electronics.getPrice(), electronics.getBrand(),electronics.getWarrantyPeriod()});
                System.out.println(product.getProductName());
            } else if (product instanceof Clothing) {
                Clothing clothing = (Clothing) product;
                tableModel.addRow(new Object[]{clothing.getProductID(), clothing.getProductName(), "Clothing", clothing.getPrice(), clothing.getSize(), clothing.getColour()});
                System.out.println(product.getProductName());
            }

            String info = "";

            if (product instanceof Electronics){
                Electronics electronics = (Electronics) product;
                info = " " + electronics.getBrand() +", "+electronics.getWarrantyPeriod();
             } else if (product instanceof  Clothing){
                Clothing clothing = (Clothing) product;
                info = "" + clothing.getSize() + ", " + clothing.getColour();
            }

            tableModel.addRow(new Object[]{
                product.getProductID(),
                product.getProductName(),
                determineProductCategory(product),
                product.getPrice(),
                info
            });

        }
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        // Row is selected, get the data for the selected row
                        String productID = table.getValueAt(selectedRow, 0).toString();
                        String productName = table.getValueAt(selectedRow, 1).toString();
                        String category = table.getValueAt(selectedRow, 2).toString();
                        String price = table.getValueAt(selectedRow, 3).toString();
                        String info = table.getValueAt(selectedRow, 4).toString();

                        // Update labels with the selected product information
                        productIdLabel.setText("Product ID: " + productID);
                        productNameLabel.setText("Product Name: " + productName);
                        categoryLabel.setText("Category: " + category);
                        priceLabel.setText("Price: " + price);
                        infoLabel.setText("Info: " + info);
                    }
                }
            }
        });





        table.setBounds(0,30,1000,900);
        table.setRowHeight(20);
        table.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 12));
        table.setForeground(new Color(50, 10, 17));
        table.setVisible(true);


        setTitle("View Doctor List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        add(table);





    }

    private String determineProductCategory(Product product){
        if (product instanceof Electronics){
            return "Electronics";
        } else if (product instanceof Clothing) {
            return "Clothing";
        }else{
            return "Unknow";
        }
    }


}
