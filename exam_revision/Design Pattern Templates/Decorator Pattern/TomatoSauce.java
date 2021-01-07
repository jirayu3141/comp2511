public class TomatoSauce extends AbstractTopingDecorator {

    public TomatoSauce(Pizza newPizza) {
        super(newPizza);
        System.out.println("adding Tomato Sauce");

        
    }
    
    public String getDescription() {
        return tempPizza.getDescription() + ", Tomato Sauce";
    }

    public double getCost() {
        return tempPizza.getCost() + 0.35;
    }

}