package solid.understanding.service.locator;

public interface CoffeeMachine {
	
	CoffeeDrink brewCoffee(CoffeeSelection selection) throws CoffeeException;
}