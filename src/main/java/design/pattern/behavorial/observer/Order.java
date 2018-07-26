package design.pattern.behavorial.observer;

import java.util.ArrayList;
import java.util.List;

public class Order {


    private String id;
    private int count;
    private double itemCost;
    private double shippingCost;
    private double discount;
    private List<OrderObserver> observers = new ArrayList();

    public Order(String id) {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getItemCost() {
        return itemCost - discount + shippingCost;
    }

    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippCost) {
        this.shippingCost = shippCost;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void addItem(double price) {
        itemCost = itemCost + price;
        count++;

        for (OrderObserver orderObserver : observers) {
            orderObserver.updated(this);
            System.out.println("Notification send : " + orderObserver.getClass()
                .getSimpleName());

        }
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", count=" + count + ", itemCost=" + itemCost + ", shippCost=" + shippingCost + ", discount=" + discount + "]";
    }

    public void attach(OrderObserver orderObserver) {
        observers.add(orderObserver);
        System.out.println("Observer added : " + orderObserver.getClass()
            .getSimpleName());

    }

    public void detach(OrderObserver orderObserver) {
        observers.remove(orderObserver);
        System.out.println("Observer removed : " + orderObserver.getClass()
            .getSimpleName());

    }
}
