package part3Q3;

public class FreeShippingDecorator extends Decorator {

    private int freeWeight;
    private double freeCost;

    @Override
    public double getPrice() {
        return super.getPrice();
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

    public FreeShippingDecorator(Product product, double cost, int weight) {
        super(product);
        this.freeCost = cost;
        this.freeWeight = weight;
    }

}
