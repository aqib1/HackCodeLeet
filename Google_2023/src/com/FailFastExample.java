package com;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class FailFastExample {
    public static void main(String[] args) throws InterruptedException {

        String i = new String("Hi"), j = new String("Bye");

        WeakHashMap<String , String> weakHashMap = new WeakHashMap<>();
        weakHashMap.put(i, "Hi");
        weakHashMap.put(j, "Bye");
        i = null;
        System.gc();
        TimeUnit.MINUTES.sleep(1);
        System.out.println(weakHashMap);

//        Integer i = 1;
//        WeakReference<Integer> weak = new WeakReference<>(i);
//        i = null;

//        Integer i = 1;
//        SoftReference<Integer> sf = new SoftReference<>(i);
//        i = null;

//        List<Integer> al = new ArrayList<>();
//        al = Collections.synchronizedList(al);
//
//        Stack<Integer> stack = new Stack<>();
//        stack.push(1);
//        stack.push(12);
//
//        Iterator<Integer> iterator = stack.iterator();
//        boolean add = true;
//        while(iterator.hasNext()) {
//            System.out.print(iterator.next() + " ");
//            if(add) {
//                stack.push(113); // this will throw ConcurrentModificationException as
//                // iterator is not thread-safe and it will fail-fast
//                add = false;
//            }
//        }


//        Enumeration<Integer> enStack = stack.elements(); // Enumeration is a thread-safe interface
//        boolean add = true;
//        while(enStack.hasMoreElements()) {
//            System.out.print(enStack.nextElement() + " ");
//            if(add) {
//                stack.push(113);
//                add = false;
//            }
//        }






//        Vector<Integer> vector = new Vector<>();
//        for(int x = 0; x < 10; x++) {
//            vector.add(x);
//        }
//
//        Iterator<Integer> data = vector.iterator();
//        boolean add = true;
//
//        while(data.hasNext()) {
//            System.out.print(data.next() + " ");
//            if(add) {
//                vector.add(11); // this will throw ConcurrentModificationException as
//                // iterator is not thread-safe and it will fail-fast
//                add = false;
//            }
//        }
    }
}
