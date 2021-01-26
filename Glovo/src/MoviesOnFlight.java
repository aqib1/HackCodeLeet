import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * Movies on Flight You are on a flight and wanna watch two movies during this
 * flight. You are given int[] movie_duration which includes all the movie
 * durations. You are also given the duration of the flight which is d in
 * minutes. Now, you need to pick two movies and the total duration of the two
 * movies is less than or equal to (d - 30min). Find the pair of movies with the
 * longest total duration. If multiple found, return the pair with the longest
 * movie.
 * 
 * e.g. Input movie_duration: [90, 85, 75, 60, 120, 150, 125] d: 250
 * 
 * Output from aonecode.com [90, 125] 90min + 125min = 215 is the maximum number
 * within 220 (250min - 30min)
 * 
 * 
 */
class Movie {
	private int d;
	private int index;

	public Movie(int d, int index) {
		this.d = d;
		this.index = index;
	}

	public int getD() {
		return d;
	}

	public int getIndex() {
		return index;
	}

	public void setD(int d) {
		this.d = d;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return "[distance: " + d + ", index: " + index + "]";
	}
}

class MoviePair {
	private Movie movie1;
	private Movie movie2;
	private int sumDuration;

	public MoviePair(Movie movie1, Movie movie2) {
		this.movie1 = movie1;
		this.movie2 = movie2;
		this.sumDuration = movie1.getD() + movie2.getD();
	}

	public Movie getMovie1() {
		return movie1;
	}

	public Movie getMovie2() {
		return movie2;
	}

	public int getSumDuration() {
		return sumDuration;
	}

	@Override
	public String toString() {
		return movie1.toString() + ", " + movie2.toString() + " sum = " + sumDuration;
	}
}

public class MoviesOnFlight {

	// Try to solve that in O(NlogN) + O(n)?
	public static int[] moviesOnFlightWithSort(int[] movies, int d) {
		d -= 30;
		int result[] = new int[2];
		List<Movie> moviesList = new ArrayList<>();
		for (int x = 0; x < movies.length; x++) {
			moviesList.add(new Movie(movies[x], x));
		}

		Collections.sort(moviesList, (a, b) -> Integer.compare(a.getD(), b.getD()));
		int p = 0;
		int q = moviesList.size() - 1;
		int max_val = Integer.MIN_VALUE;
		while (p < q) {
			int sum = moviesList.get(p).getD() + moviesList.get(q).getD();
			if (sum <= d && sum > max_val) {
				result[0] = moviesList.get(p).getIndex();
				result[1] = moviesList.get(q).getIndex();
				max_val = sum;
			}
			if (sum > d) {
				--q;
			} else {
				++p;
			}
		}

		return result;
	}

	// with O(n)2 and space O(2)
	public static int[] moviesOnFlightOptimistic(int[] movies, int d) {
		d -= 30;
		int[][] indexesWithValues = new int[2][2];

		int MAX_VALUE = Integer.MIN_VALUE;

		for (int x = 0; x < movies.length; x++) {
			for (int y = x + 1; y < movies.length; y++) {
				int sum = movies[x] + movies[y];
				if (sum <= d && MAX_VALUE <= sum) {
					boolean equals = (MAX_VALUE == sum
							&& ((indexesWithValues[1][0] < movies[x] && indexesWithValues[1][1] < movies[x])
									|| (indexesWithValues[1][0] < movies[y] && indexesWithValues[1][1] < movies[y])));
					if (equals || MAX_VALUE < sum) {
						indexesWithValues[0] = new int[] { x, y };
						indexesWithValues[1] = new int[] { movies[x], movies[y] };
					}
					MAX_VALUE = sum;
				}

			}
		}
		return indexesWithValues[0];
	}

	public static int[] moviesOnFlight(int[] movies, int d) {
		List<MoviePair> pairList = new ArrayList<>();
		// O(N)2
		for (int x = 0; x < movies.length; x++) {
			for (int y = x + 1; y < movies.length; y++) {
				MoviePair pair = new MoviePair(new Movie(movies[x], x), new Movie(movies[y], y));
				pairList.add(pair);
			}
		}

		// OLog(N)
		Queue<MoviePair> max_heap = new PriorityQueue<>(pairList.size(), (a, b) -> {
			int distanceComp = -1 * Integer.compare(a.getSumDuration(), b.getSumDuration());
			int maxMovieComp = -1 * (compareMovies(a, b) ? 1 : compareMovies(b, a) ? -1 : 0);
			return distanceComp == 0 ? (maxMovieComp) : distanceComp;
		});
		max_heap.addAll(pairList);
		d -= 30;
		//O(N) in worst case
		while (!max_heap.isEmpty()) {
			MoviePair pair = max_heap.poll();
			if (pair.getSumDuration() <= d)
				return new int[] { pair.getMovie1().getIndex(), pair.getMovie2().getIndex() };
		}
		return null;
	}

	public static boolean compareMovies(MoviePair a, MoviePair b) {
		return (a.getMovie1().getD() > b.getMovie1().getD() && a.getMovie1().getD() > b.getMovie2().getD()
				|| a.getMovie2().getD() > b.getMovie1().getD() && a.getMovie2().getD() > b.getMovie2().getD());
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(moviesOnFlightWithSort(new int[] { 90, 85, 75, 60, 120, 150, 125, 15, 200 }, 250)));
	}
}
