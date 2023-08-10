package Bankk;

import java.util.Arrays;

public class DataBase {
    private Customer[]customers;

    public DataBase(Customer[] customers) {
        this.customers = customers;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }
    Product[]getAllCustomerProducts(String name){
        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getName().equalsIgnoreCase(name)){
                return customers[i].getProducts();
            }
        }
                return null;
    }
    Product[]deleteProductByName(String name, String productName){
        int index = 0;
        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getName().equalsIgnoreCase(name)) {
                Product[] oldProducts = customers[i].getProducts();
                for (int j = 0; j < oldProducts.length; j++) {
                    if (oldProducts[j].getName().equalsIgnoreCase(productName)) {
                        index = j;
                    }
                }
                if (index == 0) {
                    return oldProducts;
                }
                Product[] newProducts = new Product[oldProducts.length - 1];
                if (index > 0) {
                    System.arraycopy(oldProducts, 0, newProducts, 0, index);
                }
                if (index < oldProducts.length - 1) {
                    System.arraycopy(oldProducts, index + 1, newProducts, index, oldProducts.length - index - 1);
                    customers[i].setProducts(newProducts);
                }
                return newProducts;
            }
        }
        return null;
    }
    Product[] addProduct(String name, Product productName){
        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getName().equalsIgnoreCase(name)) {
                Product[] oldProducts = customers[i].getProducts();
                for (int j = 0; j < oldProducts.length; j++) {
                    if (oldProducts[j].getName().equalsIgnoreCase(productName.getName())) {
                        return oldProducts;
                    }
                }
                Product[] newProducts = new Product[oldProducts.length + 1];
                for (int j = 0; j < oldProducts.length; j++) {
                    newProducts[j] = oldProducts[j];
                }
                newProducts[oldProducts.length] = productName;
                customers[i].setProducts(newProducts);
                return newProducts;
            }
        }
                return null;
    }
    String updateCustomerName(String name, String newName){
        for (int i = 0; i < customers.length ; i++) {
            if (customers[i].getName().equalsIgnoreCase(name)) {
                customers[i].setName(newName);
                return customers[i].getName();
            }
        }
        return null;
    }
    String payment(String name, int password, int sum) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getBank().getUserName().equalsIgnoreCase(name)) {
                if (customers[i].getBank().getPassword() == password) {
                        if (sum <= customers[i].getBank().getTotalMoney()) {
                            return "Остаток вашего баланса " + (customers[i].getBank().getTotalMoney() - sum);
                        } else {
                            return "У вас недостаточно средств";
                        }
                    }
                }
            }
            return "Неправильное имя пользователья или счет";
    }

    @Override
    public String toString() {
        return "DataBase " +
                "customers=" + Arrays.toString(customers);
    }
}
