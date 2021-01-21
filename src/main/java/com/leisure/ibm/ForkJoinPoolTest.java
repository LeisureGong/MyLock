package com.leisure.ibm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolTest {

    private static final ForkJoinPool pool = new ForkJoinPool(3);


    public static void main(String[] args) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 100; ++i) {
            arrayList.add(i + "");
        }
        pool.submit(() -> arrayList.parallelStream().forEach(e -> {
            System.out.println(Thread.currentThread().getName() + " " + e);
        })).join();
        System.out.println("Main is over");
    }
}
