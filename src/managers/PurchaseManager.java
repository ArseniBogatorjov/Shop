package managers;

import java.util.List;
import java.util.Scanner;
import entity.Costumer;
import entity.Product;
import java.util.Collections;
import java.util.Comparator;
import tools.InputFromKeyboard;

public class PurchaseManager {
    private List<Costumer> costumerList;
    private List<Product> productList;
    private Scanner scanner;
    private double totalSales;
    private int numberOfSales;
    
    public PurchaseManager(List<Costumer> costumerList, List<Product> productList, Scanner scanner) {
        this.costumerList = costumerList;
        this.productList = productList;
        this.scanner = scanner;
        this.totalSales = 0;
        
    }

    public void makePurchase() {
        System.out.println("-------- Make a Purchase --------");

        if (costumerList.isEmpty()) {
            System.out.println("No customers available. Purchase declined.");
            return;
        }

        System.out.println("Choose a customer:");

        for (int i = 0; i < costumerList.size(); i++) {
            System.out.println((i + 1) + ". " + costumerList.get(i).getFullName());
        }

        System.out.print("Your choice: ");
        int customerChoice = InputFromKeyboard.inputNumberFromRange(1, costumerList.size());
        Costumer selectedCustomer = costumerList.get(customerChoice - 1);

        if (productList.isEmpty()) {
            System.out.println("No products available. Purchase declined.");
            return;
        }

        System.out.println("Choose a product to purchase:");

        for (int i = 0; i < productList.size(); i++) {
            System.out.println((i + 1) + ". " + productList.get(i));
        }

        System.out.print("Your choice: ");
        int productChoice = InputFromKeyboard.inputNumberFromRange(1, productList.size());
        Product selectedProduct = productList.get(productChoice - 1);

        if (selectedProduct.getQuantity() == 0) {
            System.out.println("Sorry, this product is out of stock. Purchase declined.");
            return;
        }

        System.out.print("Enter the quantity to purchase: ");
        int quantityToPurchase = InputFromKeyboard.inputNumberFromRange(1, selectedProduct.getQuantity());

        double totalCost = selectedProduct.getPrice() * quantityToPurchase;

        if (totalCost <= selectedCustomer.getBalance() && quantityToPurchase <= selectedProduct.getQuantity()) {
            selectedCustomer.subtractBalance(totalCost);
            selectedProduct.subtractQuantity(quantityToPurchase);
            selectedProduct.recordSale(quantityToPurchase);
            totalSales += totalCost;
            selectedCustomer.incrementNumberOfPurchases();
            System.out.println("Purchase successful. New balance: " + selectedCustomer.getBalance() + " EUR");
        } else {
            System.out.println("Insufficient funds or insufficient quantity. Purchase declined.");
        }
    }
    
    public void displayTotalSales() {
        System.out.println("-------- Total Sales --------");
        System.out.println("Total Sales: " + totalSales + " EUR");
    }
    
    public void displayProductRanking() {
        System.out.println("-------- Product Ranking by Sales --------");
        if (productList.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        Collections.sort(productList, Comparator.comparingInt(Product::getQuantitySold).reversed());

        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            System.out.println((i + 1) + ". " + product.getName() + " - Sold: " + product.getQuantitySold() + " units");
        }
    }
    
}
