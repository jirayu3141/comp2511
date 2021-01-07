public class Mozzarella extends AbstractTopingDecorator {

    public Mozzarella(Pizza newPizza) {
        super(newPizza);
        System.out.println("adding dough");
        System.out.println("adding moz");

        
    }
    
    public String getDescription() {
        return tempPizza.getDescription() + ",moz";
    }

    public double getCost() {
        return tempPizza.getCost() + 0.5;
    }

}