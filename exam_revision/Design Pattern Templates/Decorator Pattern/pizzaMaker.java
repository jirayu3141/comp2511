public class pizzaMaker {
    public static void main(String[] args) {
        Pizza basicPizza = new Mozzarella(new TomatoSauce(new PlainPizza()));
        System.out.println("ingradients: " + basicPizza.getDescription());
        System.out.println("price: : " + basicPizza.getCost());
    }
}