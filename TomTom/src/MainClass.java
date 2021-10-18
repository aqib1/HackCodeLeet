import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class MainClass {

	public static boolean solution(int N, int[] A, int[] B) {
     
		Map<Integer, List<Integer>> vertixLinks = new TreeMap<>();
		for(int vertix = 0; vertix < A.length; vertix++) {
			vertixLinks.putIfAbsent( A[vertix], new ArrayList<>());
			vertixLinks.get( A[vertix]).add(B[vertix]);
		}

		boolean [][] visited = new boolean[N+1][N+1];

		vertixLinks.keySet().stream().forEach(key -> {
			vertixLinks.get(key).forEach(value -> {
				visited[key][value] = true;
			});
		});
		
		List<Integer> misingIndexes = new ArrayList<Integer>();
		for(int key : vertixLinks.keySet()) {
			if(key == N) {
				if(!misingIndexes.isEmpty()) {
					for(int missing = 0; missing < misingIndexes.size(); missing++) {
						if(!visited[key][misingIndexes.get(missing)]) return false;
					}
					
				}
				if(!visited[key][1]) return false;
				
			} else
			if(key <  N -1 && !visited[key][key+1] && !visited[key+1][key] ) return false;	
			else
			if(!visited[key][key+1]) {
				misingIndexes.add(key);
				
			}
		}
		
		return true;
    }
	public static void main(String[] args) {
		System.out.println(solution(6, new int [] {2, 4, 5,3}, new int[] {3, 5, 6, 4}));
		
	}
}
