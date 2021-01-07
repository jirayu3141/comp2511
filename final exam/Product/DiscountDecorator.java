package part3Q3;

public class DiscountDecorator extends Decorator {

    private double discount;

    @Override
    public double getPrice() {
        return super.getPrice() * (100 - this.discount) / 100;
    }

    @Override
    public double getShippingCost() {
        // TODO Auto-generated method stub
        return super.getShippingCost();
    }

    @Override
    public int getWeight() {
        // TODO Auto-generated method stub
        return super.getWeight();
    }

    public DiscountDecorator(Product product, double discount) {
        super(product);
        this.discount = discount;
    }

}
