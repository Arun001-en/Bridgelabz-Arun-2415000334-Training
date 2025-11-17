interface MealPlan {}
class VegetarianMeal implements MealPlan {}
class VeganMeal implements MealPlan {}
class KetoMeal implements MealPlan {}

class Meal<T extends MealPlan> {
    T plan;
    Meal(T m){ plan=m; }
}

class MealUtil {
    static <T extends MealPlan> Meal<T> generate(T p){
        return new Meal<>(p);
    }
}
