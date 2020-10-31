package klarna;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

enum Smoothies {
	CLASSIC(Arrays.asList("strawberry", "banana", "pineapple", "mango", "peach", "honey")), //
	FREEZIE(Arrays.asList("blackberry", "blueberry", "black currant", "grape juice", "frozen yogurt")), //
	GREENIE(Arrays.asList("green apple", "lime", "avocado", "spinach", "ice", "apple juice")), //
	DESSERTS(Arrays.asList("banana", "ice cream", "chocolate", "peanut", "cherry"));

	private List<String> ingredients;

	private Smoothies(List<String> ingredients) {
		this.ingredients = ingredients;
	}

	public List<String> getIngredients() {
		return ingredients;
	}
}

public class Question1 {

	public static String ingredients(String order) {
		if (order == null || order.isEmpty()) {
			throw new IllegalArgumentException("Please define a proper order!");
		}
		String orderMenus[] = order.split(",");
		List<Smoothies> types = Arrays.asList(Smoothies.values());
		Smoothies smoothies = orderMenus[0].equals("Just Desserts") ? Smoothies.DESSERTS
				: types.stream().filter(x -> orderMenus[0].toUpperCase().equals(x.name())).findFirst()
						.orElseThrow(() -> new IllegalArgumentException("Smoothie not found!!"));
		List<String> allergies = IntStream.range(1, orderMenus.length).mapToObj(x -> orderMenus[x])
				.filter(x -> x.contains("-")).map(x -> x.replace("-", "")).collect(Collectors.toList());
		List<String> recievedIngredients = IntStream.range(1, orderMenus.length).mapToObj(x -> orderMenus[x])
				.filter(x -> !x.contains("-")).collect(Collectors.toList());
		if (!smoothies.getIngredients().containsAll(recievedIngredients)) {
			throw new IllegalArgumentException("Smoothie, Ingredient not found");
		}
		List<String> result = new ArrayList<>();
		smoothies.getIngredients().stream().forEach(x -> {
			if (!allergies.contains(x)) {
				if (!recievedIngredients.isEmpty() && recievedIngredients.contains(x)) {
					result.add(x);
				}
				if (recievedIngredients.isEmpty()) {
					result.add(x);
				}
			}
		});
		return result.stream().sorted().collect(Collectors.joining(","));
	}

	public static void main(String[] args) {
		System.out.println(ingredients("Classic"));
	}
}
