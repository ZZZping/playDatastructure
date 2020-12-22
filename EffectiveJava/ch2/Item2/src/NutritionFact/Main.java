package NutritionFact;

public class Main {

	public static void main(String[] args) {
		NutritionFactInBuilderPattern cocaCola = 
				new NutritionFactInBuilderPattern
				.Builder(240, 8)
				.calories(100)
				.sodium(35)
				.carbohydrate(27)
				.build();
		
		System.out.println(cocaCola);

	}

}