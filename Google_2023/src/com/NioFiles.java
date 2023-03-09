package com;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class newThread extends Thread {
    newThread() {
        super("MY THREEAD");
        start();
    }

    public void run() {
        System.out.println(this);
    }
}

public class NioFiles {
    public static void main(char[] args) {
        System.out.println("Hi");
    }

    static class Sort implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return 0;
        }
    }
    public static void main(String[] args) throws IOException {
//        new newThread();
//        new Sort();
//        List<Integer> li = new ArrayList<>();
////        li.sort();


        Path path = Path.of("kpc/snapshot/test.txt");
        if (!Files.isDirectory(path)) {
            System.out.println("Setting up snapshots directory");
            Files.createDirectories(path);
        }
        System.out.println("Hi hi");
    }
}
