/*
Name: Liyuan Wang
CptS 233: PA1 -- Benchmarking
Date: 9/18/2020
gitRepo url:
**/

import java.io.*;
import java.util.*;

public class Benchmarking{
    public static void main(String[] args)throws Exception {
        File file = new File("C:\\Users\\CutieBoo\\Desktop\\input1.txt");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String str;
        LinkedList<Integer> list = new LinkedList<>();

        //time to insert
        long startInsert = System.nanoTime();
        while ((str = buffer.readLine()) != null) {
            String read[] = str.split(" ");
            for(int i = 0; i < read.length; i++) {
                list.add(Integer.parseInt(read[i]));
            }
        }
        long endInsert = System.nanoTime();
        long time_insert = endInsert - startInsert;
        Collections.sort(list);

        //time to find min
        long startMin = System.nanoTime();
        int min = list.getFirst();
        long endMin = System.nanoTime();
        long time_min = endMin - startMin;
        System.out.println("min: " + min);

        //time to find max
        Long startMax = System.nanoTime();
        int max = list.getLast();
        Long endMax = System.nanoTime();
        long time_max = endMax - startMax;
        System.out.println("max: " + max);

        //time to find median
        long startMed = System.nanoTime();
        int median = list.get(list.size()/2);
        long endMed = System.nanoTime();
        long time_med = endMed - startMed;
        System.out.println("med: " + median);

        System.out.println("time insert: " + time_insert + " nanoTime");
        System.out.println("time min: " + time_min + " nanoTime");
        System.out.println("time max: " + time_max + " nanoTime");
        System.out.println("time med: " + time_med + " nanoTime");
    }
}