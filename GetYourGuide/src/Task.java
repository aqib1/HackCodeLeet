import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PhotoStats {
	private String name;
	private String city;
	private LocalDateTime dateTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "PhotoStats [name=" + name + ", city=" + city + ", dateTime=" + dateTime + "]";
	}

}

public class Task {

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public String solution(String S) {
		List<String> cityKeys = new ArrayList<>();
		List<String> orderKeys = new ArrayList<>();
 		Map<String, List<PhotoStats>> photoByCity = new HashMap<>();
		String[] dataList = S.split("\n");
		for (String data : dataList) {
			String[] stats = data.split(", ");
			PhotoStats photoStats = new PhotoStats();
			photoStats.setName(stats[0]);
			photoStats.setCity(stats[1]);
			photoStats.setDateTime(LocalDateTime.parse(stats[2], formatter));
			cityKeys.add(photoStats.getCity());
			orderKeys.add(photoStats.toString());
			if (!photoByCity.containsKey(photoStats.getCity())) {
				photoByCity.put(photoStats.getCity(), new ArrayList<>(Arrays.asList(photoStats)));
			} else {
				photoByCity.get(photoStats.getCity()).add(photoStats);
			}
		}

		for (String key : photoByCity.keySet()) {
			Collections.sort(photoByCity.get(key), (a, b) -> a.getDateTime().compareTo(b.getDateTime()));
		}

		Map<String, Integer> nameByCount = new HashMap<>();
		Map<String, Integer> nameByLen = new HashMap<>();
		Map<String, String> orderedKeyByResult = new HashMap<>();
		for (String orderedKey : cityKeys) {
			if(!nameByLen.containsKey(orderedKey)) {
				nameByLen.put(orderedKey, photoByCity.get(orderedKey).size());
			}
			if (nameByCount.containsKey(orderedKey)) {
				nameByCount.put(orderedKey, nameByCount.get(orderedKey) + 1);
			} else {
				nameByCount.put(orderedKey, 1);
			}

			int count = nameByCount.get(orderedKey);
			List<PhotoStats> photoStats = photoByCity.get(orderedKey);
			PhotoStats stat = photoStats.get(0);
			String result = stat.getCity()
					+ generateZeros(Integer.toString(nameByLen.get(orderedKey)).length() - Integer.toString(count).length())
					+ count + "." + stat.getName().split("\\.")[1] + "\n";
			photoStats.remove(0);
			
			orderedKeyByResult.put(stat.toString(), result);
		}

		String result = "";
		for(String orderKey : orderKeys) {
			result+= orderedKeyByResult.get(orderKey);
		}
		return result;
	}

	public String generateZeros(int n) {
		String zeros = "";
		for (int x = 0; x < n; x++) {
			zeros += "0";
		}
		return zeros;
	}

	public static void main(String[] args) {
		Task task = new Task();
		String data = "photo.jpg, Warsaw, 2013-09-05 14:08:15\n" + "john.png, London, 2015-06-20 15:13:22\n"
				+ "myFriends.png, Warsaw, 2013-09-05 14:07:13\n" + "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n"
				+ "pisatower.jpg, Paris, 2015-07-22 23:59:59\n" + "BOB.jpg, London, 2015-08-05 00:02:03\n"
				+ "notredame.png, Paris, 2015-09-01 12:00:00\n" + "me.jpg, Warsaw, 2013-09-06 15:40:22\n"
				+ "a.png, Warsaw, 2016-02-13 13:33:50\n" + "b.jpg, Warsaw, 2016-01-02 15:12:22\n"
				+ "c.jpg, Warsaw, 2016-01-02 14:34:30\n" + "d.jpg, Warsaw, 2016-01-02 15:15:01\n"
				+ "e.png, Warsaw, 2016-01-02 09:49:09\n" + "f.png, Warsaw, 2016-01-02 10:55:32\n"
				+ "g.jpg, Warsaw, 2016-02-29 22:13:11";
		System.out.println(task.solution(data));
	}
}
