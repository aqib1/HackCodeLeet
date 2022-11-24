import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class HashTablesAndMaps {

    // ConcurrentModificationException fail-fast for HashMap iterator.
    // Enumerator
    public static void main(String[] args) throws InterruptedException {
        Hashtable<String, String> hashTable = new Hashtable<>();
        HashMap<String, String> hashMap = new HashMap<>();

        for (int x = 0; x < 3; x++) {
            hashTable.put("key" + x, String.valueOf(x));
        }
        AtomicReference<String> oldValues = new AtomicReference<>("");
        Thread t1 = new Thread(() -> {
            Enumeration<String> entries = hashTable.elements();
            try {
                Thread.sleep(100);
                while (entries.hasMoreElements()) {
                    oldValues.set(oldValues.get() + entries.nextElement() + " ,");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            for (int x = 0; x < 5; x++) {
                hashTable.put("akey" + x, x + "hello");
            }
        });
        t2.start();


        t2.join();
        t1.join();

        System.out.println("Old values from read thread -> " + oldValues.get());
        System.out.println("New values after write thread -> " + String.join(",", hashTable.values()));

//        System.out.println(hashMap);


//        int oldCapacity = 15;
//        int newCapacity = (oldCapacity << 1) + 1;
//        System.out.println(newCapacity);
//        String []cities = new String[] {"London", "Amsterdam"};
//        String []map = new String[5];
//
//        for(String city: cities) {
//            int sumOfAscii = 0;
//            for (char c : city.toCharArray()) {
//                sumOfAscii += c;
//            }
//            System.out.println(city +" will store in index " + (sumOfAscii % map.length));
//        }

    }
}
