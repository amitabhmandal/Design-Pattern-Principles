package design.pattern.behavorial.observer;

public class QuantityObserver implements OrderObserver {

    public void updated(Order order) {
        int count = order.getCount();
        if(count <= 5) {
            order.setShippingCost(10);
        } else {
            order.setShippingCost(10 + (count - 5) * 1.5);
        }


    }

}
