import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {
	private Integer id;
	private Integer age;
	private String name;

	public Employee() {
		this(0, 0, null);
	}

	public Employee(Integer id, Integer age, String name) {
		this.id = id;
		this.age = age;
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getListOfAge(List<Employee> employees) {
		return employees.stream().filter(employee -> employee.getAge() > 10).map(Employee::getAge)
				.collect(Collectors.toList());
	}

	public List<String> getUniqueNames(List<Employee> employees) {
		return new ArrayList<>(employees.stream().map(Employee::getName).collect(Collectors.toSet()));
	}
}
