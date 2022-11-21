package minishop.shop.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {

    private int orderId;

    private int customerId;

    private int productId;

    private String dateTime;

    private String paymentMethod;

    private String customerName;

    private String productName;

    private double totalPrice;

    public Order(int orderId, int customerId, int productId, String paymentMethod) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.productId = productId;
        this.paymentMethod = paymentMethod;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        dateTime = now.format(format);

    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setOrderTotal(double amount) {
        this.totalPrice = amount;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", productId=" + productId +
                '}';
    }
}
