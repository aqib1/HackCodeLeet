import java.util.*;
import java.util.stream.IntStream;

public class MainClass {

    public static int solution2(String S, String C) {
        if(Objects.isNull(S) || Objects.isNull(C) || S.isBlank() || C.isBlank())
            return -1;

        Map<String, List<String>> data = new HashMap<>();
        String[] rawData = S.split("\n");
        if(rawData.length == 0) {
            return -1;
        }
        String[] columns = rawData[0].split(",");
        if(columns.length == 0) {
            return -1;
        }
        // init columns
        for (String column : columns) {
            data.put(column, new ArrayList<>());
        }

        IntStream.range(1, rawData.length).forEach(index -> {
            int valueIndex = 0;
            String[] values = rawData[index].split(",");
            for (String column : columns) {
                data.get(column).add(values[valueIndex]);
                valueIndex++;
            }
        });

        try {
            return data.get(C)
                    .stream()
                    .map(Integer::parseInt)
                    .max(Integer::compareTo)
                    .orElseGet(() -> -1);
        } catch (NumberFormatException e) {return  -1;}
    }
    public static int solution(int [] A) {
        if(Objects.isNull(A) || A.length == 0)
            return 0;
        int iteration = 0;
        Queue<Integer> minHeap = new PriorityQueue<>();
        int sum = 0;
        for(int x=0; x< A.length; x++) {
                if(A[x] < 0)  minHeap.offer(A[x]);
                if(x < 1 && sum + A[x] < 0 && !minHeap.isEmpty()) {
                    iteration++; minHeap.poll();
                }
                if(x > 0 && sum + A[x] < 0 && !minHeap.isEmpty()) {
                   sum =+ -1 *  minHeap.poll();
                    iteration++;
                }
                sum += A[x];
        }

        return iteration;
    }
    public static void main(String[] args) {
        System.out.println(solution2("id,name,age,act.,room,dep.\n1,Jack,68,T,13,8\n17,Betty,28,F,15,7" , "age"));
    }
}
