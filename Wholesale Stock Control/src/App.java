import java.util.ArrayList;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class App {
    public static void main(String[] args) throws Exception {

        String choice;
        
        do {
            Scanner sc = new Scanner(System.in);  
            System.out.println("------------------");
            System.out.println("The Food Store");
            System.out.println("Choose from these options");
            System.out.println("------------------");
            System.out.println("[1] List all products");
            System.out.println("[2] Search for product by ID");
            System.out.println("[3] Add a new product");
            System.out.println("[4] Update a product by ID");
            System.out.println("[5] Delete a product by ID");
            System.out.println("[6] Exit");

            choice = sc.next();
            System.out.println();
            switch(choice) {
                case "1":{
                    ArrayList<FoodProduct> items = FoodProductDAO.findAllProducts();
                    for (int i = 0; i < items.size(); i++) {
                        System.out.println(items.get(i));
                    }
                    System.out.println();
                    break;}

                case "2": {
                    System.out.println("Search for Product ID: ");
                    int id = sc.nextInt();
                    FoodProduct product = FoodProductDAO.findProduct(id);
                    /* Code to display the product */
                }
                
                case "3": {
                    System.out.println("SKU: ");
                    String SKU = sc.next();
                    System.out.println("Description: ");  
                    String desc = sc.next();
                    System.out.println("Category: ");
                    String cat = sc.next();
                    System.out.println("Price: ");
                    int price = sc.nextInt();
                    FoodProduct product = new FoodProduct(SKU, desc, cat, price);
                    FoodProductDAO.addProduct(product);
                }
                
                case "4": {
                    System.out.println("Product ID: ");
                    int id = sc.nextInt();
                    System.out.println("Enter updated details below");
                    System.out.println("SKU: ");
                    String SKU = sc.next();
                    System.out.println("Description: ");   
                    String desc = sc.next();
                    System.out.println("Category: ");
                    String cat = sc.next();
                    System.out.println("Price: ");
                    int price = sc.nextInt();
                    FoodProduct product = new FoodProduct(id, SKU, desc, cat, price);
                    FoodProductDAO.updateProduct(product);
                }

                case "5": {
                    System.out.println("Product ID:");
                    int id = sc.nextInt();
                    FoodProductDAO.deleteProduct(id);
                }
                sc.close();
            }
        } while (!choice.equals("6"));



    }

static class FoodProduct {
        int id;
        String SKU;
        String description;
        String category;
        int price;

        public FoodProduct(String SKU, String description, String category, int price) {
            this.SKU = SKU;
            this.description = description;
            this.category = category;
            this.price = price;
            /* Insert code for creating new sequential ID */
        }

        public FoodProduct(int id, String SKU, String description, String category, int price) {
            this.SKU = SKU;
            this.description = description;
            this.category = category;
            this.price = price;
            this.id = id;
        }
    }

    class FoodProductDAO {

        public static ArrayList<FoodProduct> findAllProducts() {
            ArrayList<FoodProduct> products = new ArrayList<FoodProduct>();  /* */

            /* Make the call to the database to return all records */
            /* Create a Food Product variable for them all and return them as a list of FoodProduct objects */

            String url = "jdbc:sqlite:C:/sqlite/db/hello.db";

            try (Connection conn = DriverManager.getConnection(url)){
                if (conn != null) {
                    System.out.println("Connected to database");
                }
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }

            String sqlCall = "SELECT * FROM table";

            return products;
        }

        public static FoodProduct findProduct(int id) {
            FoodProduct product = new FoodProduct(null, null, null, id); /* */

            /* Add the SELECT statement to get object of specified ID from the database */

            String sqlCall = "SELECT * FROM table WHERE id= { id }";


            return product;
        }

        public static boolean deleteProduct(int id) {
            boolean confirmation = false; /* */

             /* add the DELETE statement call to the database */
             /* if successful, return true, else: return false */

            return confirmation;
        }

        public static boolean updateProduct(FoodProduct product) {
            boolean confirmation = false; /* */

            String sqlCall = "UPDATE table WHERE id= { product.id }";

            return confirmation;
        }

        public static boolean addProduct(FoodProduct product) {
            boolean confirmation = false; /* */

            String sqlCall = "INSERT INTO table VALUES {product.id, product.name, product.category etc.}";

            return confirmation;
        }



    }

}
