import java.util.HashMap;
import java.util.Map;

public class Fridge {
    private String name;
    Map<String, Integer> ingredients;

    public Fridge(String name, Ingredient... ingredients) {
        this.name = name;
        this.ingredients = new HashMap<>();
        for (Ingredient ingredient : ingredients) {
            this.ingredients.put(ingredient.getName(), ingredient.getAmount());
        }
    }

    // Заказать ингредиент, если не хватает для приготовления блюда
    public void placeOrder(String name, int amount) {
        System.out.println("В холодильнике " + name + " не хватает " + amount + " грамм " + name + ". Заказываем...");
        // В нашем примере заказываем просто удвоенное количество необходимого ингредиента
        ingredients.put(name, ingredients.getOrDefault(name, 0) + amount * 2);
        System.out.println("Заказ выполнен, " + name + " в наличии: " + ingredients.get(name));
    }

    // Проверить наличие необходимых ингредиентов
    public boolean checkIngredients(Map<String, Integer> recipe) {
        for (Map.Entry<String, Integer> entry : recipe.entrySet()) {
            if (ingredients.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    // Удалить использованные ингредиенты
    public void removeIngredients(Map<String, Integer> recipe) {
        for (Map.Entry<String, Integer> entry : recipe.entrySet()) {
            Integer amount = ingredients.get(entry.getKey());
            if (amount != null) {
                ingredients.put(entry.getKey(), amount - entry.getValue());
            }
        }
    }
}
