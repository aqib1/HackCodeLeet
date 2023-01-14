import java.util.*;
import java.util.stream.Collectors;

public class RandomSet {
    // O(N)
    private final Map<Integer, Integer> map;
    private final List<Integer> list;
    private int currentIndex;
    private int randomIndex = 0;
    public RandomSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    // O(1)
    // map = [[0, 1], [1, 2], [2, 3]]
    // reverseValueIndex = [[1, 0], [2, 1], [3, 2]]
    public boolean add(int val) {
        if(map.containsKey(val)) return false;
        map.put(val, currentIndex);
        list.add(currentIndex, val);
        currentIndex++;
     return true;
    }

    public boolean delete(int val) {
        if(!map.containsKey(val)) return false;
        int valueIndex = map.remove(val);
        list.set(valueIndex, list.get(list.size() - 1));
        map.put(list.get(list.size() - 1), valueIndex);
        list.remove(list.size() - 1);
        currentIndex--;
        return true;
    }

    // 1, 2, 3, 4
    // map = [[0, 1],  ,[2, 3]]
    // reverseValueIndex = [[1, 0], [2, 1], [3, 2]]
    public int getRandom() {
        int res = this.list.get(randomIndex);
        randomIndex++;
        if(randomIndex >= this.list.size()) randomIndex = 0;
        return res;
    }

    public static void main(String[] args) {
        RandomSet randomSet = new RandomSet();
        randomSet.add(0);
        randomSet.add(1);
        randomSet.delete(0);
        randomSet.add(2);
        randomSet.delete(1);
        System.out.println(randomSet.getRandom());

//        randomSet.add(5);
//        randomSet.add(6);
//        randomSet.delete(2);
//        System.out.println("-----------------");
//
//        for(int x=0; x<10; x++) {
//            System.out.println(randomSet.getRandom());
//        }

    }
}
