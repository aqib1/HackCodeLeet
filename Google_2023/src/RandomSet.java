import java.util.*;

public class RandomSet {
    // Space O(N)
    // Time complexity, smartly O(1) with a very interesting trick
    private final Map<Integer, Integer> map;
    private final List<Integer> list;
    private int currentIndex;
    private static final Random RAND = new Random();
    public RandomSet() {
        this.map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean add(int val) {
        if(map.containsKey(val)) return false;
        map.put(val, currentIndex);
        list.add(currentIndex, val);
        currentIndex++;
     return true;
    }

    public boolean delete(int val) {
        if(!map.containsKey(val)) return false;
        int valueIndex = map.get(val);
        list.set(valueIndex, list.get(list.size() - 1));
        map.put(list.get(list.size() - 1), valueIndex);
        list.remove(list.size() - 1);
        map.remove(val);
        currentIndex--;
        return true;
    }

    public int getRandom() {
        return this.list.get(RAND.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomSet randomSet = new RandomSet();
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.delete(0));
        System.out.println(randomSet.delete(0));
        System.out.println(randomSet.add(0));
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.delete(0));
        System.out.println(randomSet.add(0));

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
