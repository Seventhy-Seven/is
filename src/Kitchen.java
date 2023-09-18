import java.util.Map;

public class Kitchen {
    private int platesCount = 50; // количество тарелок
    private int spoonsCount = 40; // количество ложек
    private int forksCount = 40; // количество вилок

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

    // Приготовить завтрак
    public void prepareBreakfast(int portions, Fridge fridge) {
        if (fridge != null) {
            // Проверяем наличие продуктов в холодильнике
            if (fridge.checkIngredients(Map.of(
                    "яйца", portions * 2,
                    "сыр", portions * 50,
                    "томаты", portions * 50
            ))) {
                System.out.println("Готовим завтрак...");
                fridge.removeIngredients(Map.of(
                        "яйца", portions * 2,
                        "сыр", portions * 50,
                        "томаты", portions * 50
                ));
                System.out.println("Завтрак готов!");
            } else {
                System.out.println("Недостаточно ингредиентов для приготовления завтрака. Ищем в другом холодильнике...");
                seekIngredientsInOtherFridge("яйца", portions, fridge);
                seekIngredientsInOtherFridge("сыр", portions * 50, fridge);
                seekIngredientsInOtherFridge("томаты", portions * 50, fridge);
            }
        } else {
            System.out.println("Холодильник не найден.");
        }
    }

    // Приготовить обед
    public void prepareLunch(int portions, Fridge fridge) {
        if (fridge != null) {
            // Проверяем наличие продуктов в холодильнике
            if (fridge.checkIngredients(Map.of(
                    "мясо", portions * 100,
                    "картофель", portions * 200,
                    "масло", portions * 10,
                    "лук", portions * 20
            ))) {
                System.out.println("Готовим обед...");
                fridge.removeIngredients(Map.of(
                        "мясо", portions * 100,
                        "картофель", portions * 200,
                        "масло", portions * 10,
                        "лук", portions * 20
                ));
                System.out.println("Обед готов!");
            } else {
                System.out.println("Недостаточно ингредиентов для приготовления обеда. Ищем в другом холодильнике...");
                seekIngredientsInOtherFridge("мясо", portions * 100, fridge);
                seekIngredientsInOtherFridge("картофель", portions * 200, fridge);
                seekIngredientsInOtherFridge("масло", portions * 10, fridge);
                seekIngredientsInOtherFridge("лук", portions * 20, fridge);
            }
        } else {
            System.out.println("Холодильник не найден.");
        }
    }

    // Приготовить ужин
    public void prepareDinner(int portions, Fridge fridge) {
        if (fridge != null) {
            // Проверяем наличие продуктов в холодильнике
            if (fridge.checkIngredients(Map.of(
                    "рыба", portions * 50,
                    "картофель", portions * 200,
                    "масло", portions * 10,
                    "лук", portions * 20
            ))) {
                System.out.println("Готовим ужин...");
                fridge.removeIngredients(Map.of(
                        "рыба", portions * 50,
                        "картофель", portions * 200,
                        "масло", portions * 10,
                        "лук", portions * 20
                ));
                System.out.println("Ужин готов!");
            } else {
                System.out.println("Недостаточно ингредиентов для приготовления ужина. Ищем в другом холодильнике...");
                seekIngredientsInOtherFridge("рыба", portions * 50, fridge);
                seekIngredientsInOtherFridge("картофель", portions * 200, fridge);
                seekIngredientsInOtherFridge("масло", portions * 10, fridge);
                seekIngredientsInOtherFridge("лук", portions * 20, fridge);
            }
        } else {
            System.out.println("Холодильник не найден.");
        }
    }

    // Приготовить блюдо для вечеринки
    public void preparePartyDish(int portions, Fridge fridge1, Fridge fridge2) {
        if (fridge1 != null && fridge2 != null) {
            int meat = portions * 300;
            int cheese = portions * 100;
            if (fridge1.checkIngredients(Map.of("мясо", meat, "сыр", cheese))) {
                System.out.println("Приготовляем блюдо для вечеринки...");
                fridge1.removeIngredients(Map.of("мясо", meat, "сыр", cheese));
                System.out.println("Блюдо для вечеринки готово!");
            } else if (fridge2.checkIngredients(Map.of("мясо", meat, "сыр", cheese))) {
                System.out.println("Недостаточно ингредиентов в холодильнике 1. Ищем в холодильнике 2...");
                fridge2.removeIngredients(Map.of("мясо", meat, "сыр", cheese));
                System.out.println("Блюдо для вечеринки готово!");
            } else {
                System.out.println("Недостаточно ингредиентов для приготовления блюда для вечеринки.");
                seekIngredientsInOtherFridge("мясо", meat, fridge1, fridge2);
                seekIngredientsInOtherFridge("сыр", cheese, fridge1, fridge2);
            }
        } else {
            System.out.println("Холодильник не найден.");
        }
    }

    // Искать нужный ингредиент в другом холодильнике
    private void seekIngredientsInOtherFridge(String name, int amount, Fridge fridge) {
        if (fridge != null) {
            Fridge otherFridge = fridge == fridge1 ? fridge2 : fridge1;
            if (otherFridge.checkIngredients(Map.of(name, amount))) {
                System.out.println("Ингредиент был найден в другом холодильнике. Забираем...");
                fridge.placeOrder(name, amount);
                fridge.removeIngredients(Map.of(name, amount));
            } else {
                System.out.println("Ингредиент не найден в другом холодильнике.");
            }
        } else {
            System.out.println("Холодильник не найден.");
        }
    }

    // Искать нужные ингредиенты в других холодильниках
    private void seekIngredientsInOtherFridge(String name, int amount, Fridge fridge1, Fridge fridge2) {
        if (fridge1 != null && fridge2 != null) {
            if (fridge1.checkIngredients(Map.of(name, amount))) {
                System.out.println("Ингредиент найден в холодильнике 1. Забираем...");
                fridge2.placeOrder(name, amount - fridge1.ingredients.get(name));
                fridge1.removeIngredients(Map.of(name, amount));
            } else if (fridge2.checkIngredients(Map.of(name, amount))) {
                System.out.println("Ингредиент найден в холодильнике 1. Забираем...");
                fridge1.placeOrder(name, amount - fridge2.ingredients.get(name));
                fridge2.removeIngredients(Map.of(name, amount));
            } else {
                System.out.println("Ингредиент не найден ни в одном из холодильников.");
            }
        } else {
            System.out.println("Холодильник не найден.");
        }
    }
}