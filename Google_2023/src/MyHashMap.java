import java.util.Arrays;

public class MyHashMap {

    // Time complexity is O(1)
    // Space complexity is 10^6 + 1

    private static final int KEY_SPACE = (int)Math.pow(10, 6) + 1;
    private final int[] map;
    public MyHashMap() {
        map = new int[KEY_SPACE];
        Arrays.fill(map, -1);
    }

    public void put(int key, int value) {
        this.map[key] = value;
    }

    public int get(int key) {
        return this.map[key];
    }

    public void remove(int key) {
        this.map[key] = -1;
    }

}
