package minishop.shop.model;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Customer {

    private int customerId;

    private String name;

    private String customerCategory;

    public Customer(int customerId, String name, String customerCategory) {
        this.customerId = customerId;
        this.name = name;
        this.customerCategory = customerCategory;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return name;
    }

    public void setCustomerName(String name) {
        this.name = name;
    }

    public String getCustomerCategory() {
        return customerCategory;
    }

    public void setCustomerCategory(String customerCategory) {
        this.customerCategory = customerCategory;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                '}';
    }
}
