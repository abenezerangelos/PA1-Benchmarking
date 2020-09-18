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
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Input your file name: ");
        String filename = keyboard.nextLine();
        File file = new File(filename);
        Scanner inputFile = new Scanner(file);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String str;
        LinkedList<Integer> list = new LinkedList<>();

        //time to insert
        long startInsert = System.nanoTime();
        int i, j, k, key, temp;
        while ((str = buffer.readLine()) != null) {
            for (i = 1; i < list.size(); i++){
                key = list.get(i);
                j = i - 1;
                while (j >= 0 && key < list.get(j)){
                    temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    j--;
                }
            }
            String[] read = str.split(" ");
            for(k = 0; k < read.length; k++) {
                list.add(Integer.parseInt(read[k]));
            }
        }
        long endInsert = System.nanoTime();
        long time_insert = endInsert - startInsert;

        //time to find min
        long startMin = System.nanoTime();
        int min = list.getFirst();
        long endMin = System.nanoTime();
        long time_min = endMin - startMin;
        System.out.println();
        System.out.println("min: " + min);

        //time to find max
        long startMax = System.nanoTime();
        int max = list.get(list.size() - 2);
        long endMax = System.nanoTime();
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