import java.util.*;

enum DAYS  {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, FRIDAY, SATURDAY}
public class SetDataStructure {
    public static void main(String[] args) {
        // Internally use hashmap
        // unordered unique set of numbers
        Set<Integer> set = new HashSet<>();
        // O(1)
        set.add(1);
        set.add(11);
        set.add(1234);

        System.out.println(set);

        // A type of hash set which maintain order or data
        // LinkedHashSet just like HashSet use a hash map with
        // extension of doubly-linked list to maintain or identify order
        // This also provide constant time complexity but its slightly
        // slower than hashset due to reason of maintain internal linked list.
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(1);
        linkedHashSet.add(1211);
        linkedHashSet.add(2);
        linkedHashSet.add(2);
        System.out.println(linkedHashSet);

//        Set<Integer> sortedSet = new TreeSet<>();
//        sortedSet.add(11);
//        sortedSet.add(1);
//        sortedSet.add(3);
//        sortedSet.add(1111);
//        System.out.println(sortedSet);

//        Set<DAYS> enumSet = EnumSet.of(DAYS.SUNDAY, DAYS.FRIDAY);
//        System.out.println(enumSet);

            // Implements navigable set which extends Sorted set
            Set<Integer> treeSet = new TreeSet<>();

    }
}
