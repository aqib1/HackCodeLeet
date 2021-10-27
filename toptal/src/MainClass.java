import java.util.*;
import java.util.stream.IntStream;

public class MainClass {

    private int sum;

    public static int solution2(String S, String C) {
        if(Objects.isNull(S) || Objects.isNull(C) || S.isEmpty() || C.isEmpty())
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
            return data.getOrDefault(C, new ArrayList<>())
                    .stream()
                    .map(Integer::parseInt)
                    .max(Integer::compareTo)
                    .orElseGet(() -> -1);
        } catch (NumberFormatException e) {return  -1;}
    }

    // 10, -10, -1, -1, 1, 1
    public static int solution3(int [] A) {
        if(Objects.isNull(A) || A.length == 0)
            return 0;
        Queue<Integer> minPriority = new PriorityQueue<>();
        int sum = 0;
        int iteration = 0;
        for (int j : A) {
            if (j < 0) minPriority.offer(j);
            if (sum + j < 0 && !minPriority.isEmpty()) {
                sum += -1 * minPriority.poll();
                ++iteration;
            }
            if(sum + j >= 0) sum += j;
        }
        return iteration;
    }

    public static void main(String[] args) {
        //System.out.println(solution3(new int[] {5,5,-10,-1,2}));
        System.out.println(solution2("id,name,age,act.,room,dep.\n1,Jack,68,T,13,8\n17,Betty,28,F,15,7" , "abc"));
    }



}

