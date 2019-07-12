package solid.understanding.service.locator;

public class BrewingUnit {

	public CoffeeDrink brew(CoffeeSelection selection, GroundCoffee groundCoffee,
			double quantity) {
		return new CoffeeDrink(selection, quantity);
	}

}
