import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Fridge fridge1 = new Fridge("Холодильник 1",
                new Ingredient("яйца", 12),
                new Ingredient("молоко", 1000),
                new Ingredient("сыр", 300),
                new Ingredient("томаты", 500),
                new Ingredient("мясо", 700),
                new Ingredient("картофель", 1000)
        );
        Fridge fridge2 = new Fridge("Холодильник 2",
                new Ingredient("яйца", 6),
                new Ingredient("молоко", 500),
                new Ingredient("сыр", 150),
                new Ingredient("томаты", 250),
                new Ingredient("мясо", 350),
                new Ingredient("картофель", 500)
        );

        Kitchen kitchen = new Kitchen();
        kitchen.prepareBreakfast(2, fridge1);
        kitchen.prepareLunch(2, fridge1);
        kitchen.prepareDinner(2, fridge1);
        kitchen.preparePartyDish(10, fridge1, fridge2);
        
    }
}