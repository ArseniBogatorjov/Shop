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

        System.out.println("Enter product name: ");
        String nameN = scanner.nextLine();

        System.out.println("Enter product type: ");
        String typeT = scanner.nextLine();

        double priceP;
        while (true) {
            System.out.println("Enter price of product (x.xx): ");
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

        System.out.println("Enter quantity of product: ");
        int quantityQ = InputFromKeyboard.inputNumberFromRange(1, 100);
        Product newProduct = new Product(nameN, priceP, typeT, quantityQ);
        productList.add(newProduct);
        System.out.println("The product was successfully added!");
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void displayAllProducts() {
        if (productList.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        System.out.println("List of all products:");
        for (Product product : productList) {
            System.out.println(product);
        }
    }
    
    public void replenishProductQuantity() {
    System.out.println("-------- Replenish Product Quantity --------");
    if (productList.isEmpty()) {
        System.out.println("No products available.");
        return;
    }
    System.out.println("Choose a product:");

    for (int i = 0; i < productList.size(); i++) {
        System.out.println((i + 1) + ". " + productList.get(i));
    }
        System.out.print("Your choice: ");
    int productChoice = InputFromKeyboard.inputNumberFromRange(1, productList.size());
    Product selectedProduct = productList.get(productChoice - 1);

    System.out.print("Enter the quantity to replenish: ");
    int quantityToReplenish = InputFromKeyboard.inputNumberFromRange(0, Integer.MAX_VALUE);

    selectedProduct.setQuantity(selectedProduct.getQuantity() + quantityToReplenish);

    System.out.println("Product quantity replenished. New quantity: " + selectedProduct.getQuantity());
    }
    
    
    public void editProduct() {
        System.out.println("-------- Edit Product Data --------");
        if (productList.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        System.out.println("Choose a product to edit:");

        for (int i = 0; i < productList.size(); i++) {
            System.out.println((i + 1) + ". " + productList.get(i));
        }

        int productChoice = InputFromKeyboard.inputNumberFromRange(1, productList.size());
        Product selectedProduct = productList.get(productChoice - 1);

        System.out.println("Choose what to edit:");
        System.out.println("1. Edit name");
        System.out.println("2. Edit type");
        System.out.println("3. Edit price");
        System.out.println("4. Edit quantity");
        System.out.println("5. Cancel");

        System.out.print("Your choice: ");
        int editChoice = InputFromKeyboard.inputNumberFromRange(1, 5);

        switch (editChoice) {
            case 1:
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                selectedProduct.setName(newName);
                System.out.println("Name updated successfully.");
                break;
            case 2:
                System.out.print("Enter new type: ");
                String newType = scanner.nextLine();
                selectedProduct.setType(newType);
                System.out.println("Type updated successfully.");
                break;
            case 3:
                System.out.print("Enter new price (in x.xx format): ");
                String newPriceString = scanner.nextLine();
                try {
                    double newPrice = Double.parseDouble(newPriceString);
                    if (newPrice > 0 && newPriceString.matches("^\\d+\\.\\d{2}$")) {
                        selectedProduct.setPrice(newPrice);
                        System.out.println("Price updated successfully.");
                    } else {
                        System.out.println("Price must be in format x.xx and greater than zero");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid price entry format.");
                }
                break;
            case 4:
                System.out.print("Enter new quantity: ");
                int newQuantity = InputFromKeyboard.inputNumberFromRange(0, Integer.MAX_VALUE);
                selectedProduct.setQuantity(newQuantity);
                System.out.println("Quantity updated successfully.");
                break;
            case 5:
                System.out.println("Editing canceled.");
                break;
            default:
                System.out.println("Invalid choice. Editing canceled.");
                break;
        }
    }
    

}
