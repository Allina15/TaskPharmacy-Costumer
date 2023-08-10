package Bankk;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.Arrays;

public class BankMain {
    public static void main(String[] args) {
        LocalDate madeIn = LocalDate.of(2023, 8, 10);

        Product product1 = new Product("Chocolates", "Tasty", 100, 50, madeIn, false);
        Product product2 = new Product("Wine", "Elegant", 200, 30, madeIn, true);
        Product product3 = new Product("Toothbrush", "Soft", 150, 20, madeIn, false);
        Product product4 = new Product("Coffee", "Aromatic", 120, 40, madeIn, false);
        Product product5 = new Product("Whiskey", "Aged", 180, 15, madeIn, true);
        Product product6 = new Product("Shampoo", "Cleansing", 90, 60, madeIn, false);
        Product product7 = new Product("Juice", "Fresh", 250, 10, madeIn, false);
        Product product8 = new Product("Laptop", "Powerful", 300, 5, madeIn, false);
        Product product9 = new Product("Socks", "Comfortable", 70, 25, madeIn, false);
        Product[]products1 = {product1,product2,product3};
        Product[]products2 = {product4,product5,product6};
        Product[]products3 = {product7,product8};

        Passport passport1 = new Passport(LocalDate.of(1990, 5, 15), "USA", "Male");
        Passport passport2 = new Passport(LocalDate.of(1985, 11, 20), "Canada", "Female");
        Passport passport3 = new Passport(LocalDate.of(2000, 3, 8), "UK", "Male");

        Bank user1 = new Bank("JohnDoe", 123456, 5000);
        Bank user2 = new Bank("AliceSmith", 987654, 7500);
        Bank user3 = new Bank("BobJohnson", 567890, 3000);

        Customer customer1 = new Customer("JohnDoe",passport1,products1,user1);
        Customer customer2 = new Customer("AliceSmith",passport2,products2,user2);
        Customer customer3 = new Customer("BobJohnson",passport3,products3,user3);

        Customer[]customers = {customer1,customer2,customer3};
        DataBase dataBase = new DataBase(customers);

        System.out.println(Arrays.toString(dataBase.getAllCustomerProducts("JohnDoe")));
        System.out.println(Arrays.toString(dataBase.deleteProductByName("AliceSmith","coffee")));
        System.out.println(Arrays.toString(dataBase.addProduct("BobJohnson",product9)));
        System.out.println(dataBase.updateCustomerName("JohnDoe","John Dooe"));
        System.out.println(dataBase.payment("AliceSmith",987654,750));
        customer3.credit(567890,60000);
        System.out.println(customer3.checkProduct(products3));
    }
}
