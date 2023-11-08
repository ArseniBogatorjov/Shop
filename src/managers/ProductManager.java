package managers;

import java.util.List;
import java.util.Scanner;
import entity.Product;
import java.util.ArrayList;
import tools.InputFromKeyboard;

public class ProductManager {
    private List<Product> productList;
    private Scanner scanner;

    public ProductManager(List<Product> productList, Scanner scanner) {
        this.productList = productList;
        this.scanner = scanner;
    }

    public void addProduct() {
        System.out.println();
        System.out.println("-------- Add new product --------");
        System.out.println();

        System.out.print("Enter product name: ");
        String nameN = scanner.nextLine();

        System.out.print("Enter product type: ");
        String typeT = scanner.nextLine();

        double priceP;
        while (true) {
            System.out.print("Enter price of product (x.xx): ");
            String priceString = scanner.nextLine();
            try {
                priceP = Double.parseDouble(priceString);
                if (priceP > 0 && priceString.matches("^\\d+\\.\\d{2}$")) {
                    break;
                } else {
                    System.out.println("Price must be in format x.xx and greater than zero");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid price entry format.");
            }
        }

        System.out.print("Enter quantity of product: ");
        int quantityQ = InputFromKeyboard.inputNumberFromRange(1, 100);
        Product newProduct = new Product(nameN, priceP, typeT, quantityQ);
        productList.add(newProduct);
        System.out.println("The product was successfully added!");
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void displayAllProducts() {
        System.out.println("List of all products:");
        for (Product product : productList) {
            System.out.println(product);
        }
    }
}
