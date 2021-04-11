import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class User {
	    private String id;
	    private String username;
	    private int submission_count;

	    public User() {

	    }

	    public User(String id, String username, int submission_count) {
	        this.id = id;
	        this.username = username;
	        this.submission_count = submission_count;
	    }

	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public int getSubmission_count() {
	        return submission_count;
	    }

	    public void setSubmission_count(int submission_count) {
	        this.submission_count = submission_count;
	    }

	    @Override
	    public String toString() {
	        return "User{" +
	                "id='" + id + '\'' +
	                ", username='" + username + '\'' +
	                ", submission_count=" + submission_count +
	                '}';
	    }
	}
public class Task2 {
	public static List<String> getUsernames(int threshold) {
        List<User> users = new ArrayList<>();
        for(int x=0; x < 2; x++) {
          try {
            URL url = new URL("https://jsonmock.hackerrank.com/api/article_users?page="+(x+1));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
              throw new RuntimeException("Failed : HTTP error code : "
                      + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            while ((output = br.readLine()) != null) {
              String[] base = output.split("\"data\":");
              base[1] = base[1].replace("[{", "").replace("}]", "");
              base[1] = base[1].replace("},{", "temp123");
              String[] data = base[1].split("temp123");
              for (String d : data) {
                User user = new User();
                String[] dVal = d.split(",");
                for (String dSubVal : dVal) {
                  String params[] = dSubVal.split(":");
                  if (params[0].equals("\"id\"")) {
                    user.setId(params[1]);
                  } else if (params[0].equals("\"username\"")) {
                    user.setUsername(params[1].replace("\"", ""));
                  } else if (params[0].equals("\"submission_count\"")) {
                    user.setSubmission_count(Integer.parseInt(params[1]));
                  }
                }
                users.add(user);
              }
            }
            conn.disconnect();

          } catch (MalformedURLException e) {
            e.printStackTrace();

          } catch (IOException e) {
            e.printStackTrace();

          }
        }
        return users.stream().filter(user -> user.getSubmission_count() > threshold).map(User::getUsername).collect(Collectors.toList());
    }
}
