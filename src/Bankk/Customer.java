package Bankk;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Locale;

public class Customer {
    private String name;
    private Passport passport;
    private Product [] products;
    private Bank bank;

    public Customer(String name, Passport passport, Product[] products, Bank bank) {
        this.name = name;
        this.passport = passport;
        this.products = products;
        this.bank = bank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
    public void credit(int password, int sum){
     if (password== bank.getPassword()){
         System.out.println("Вам выдан кредит в размере "+sum);
     }
    }
    String checkProduct(Product[]products) {
        for (int i = 0; i < products.length; i++) {
                Period prosrochka = Period.between(products[i].getMadeInDate(), LocalDate.of(2023, 9, 11));
                if (prosrochka.getMonths() >= 3) {
                    return " Товар просроченный";
                } else {
                    if (products[i].getIsAlcoholic()) {
                        Period age = Period.between(passport.getDateOfBirth(), LocalDate.now());
                        if (age.getYears() >= 18) {
                            return "Вам больше 18, можете купить этот товар" + products[i];
                        } else {
                            return "Вам нет 18, не можете купить этот товар" + products[i];
                        }
                    }
                }
        }
            return "Тут нет алькоголя, можете купить любой товар";
    }


    @Override
    public String toString() {
        return "Customer " +
                "name='" + name +
                ", passports=" + passport +
                ", products=" + Arrays.toString(products) +
                ", banks=" + bank;
    }
}
