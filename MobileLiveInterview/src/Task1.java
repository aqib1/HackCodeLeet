import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1 {
	public static void main(String[] args) {
		List<Person> person = new ArrayList<>(Arrays.asList(new Person("Aqib", ""), new Person("Ali", "")));
		
		person.stream().map(Person::getName).forEach(System.out::println);
	}
}
