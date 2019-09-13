package undemy9_10.test;

import java.util.*;

public class Experiments {

    public static void main(String[] args) {
        HashMap<String, Double> map = new HashMap<>();
        ValueComparator bvc = new ValueComparator(map);
        TreeMap<String, Double> sorted_map = new TreeMap<>(bvc);

        map.put("A", 9.0);
        map.put("B", 6.0);
        map.put("C", 7.0);
        map.put("D", 10.0);

        System.out.println("unsorted map: " + map);

        sorted_map.putAll(map);

        System.out.println("results: " + sorted_map);

//        System.out.println();
//        Queue<Integer> integers = new PriorityQueue<>();
//        integers.add(5);
//        integers.add(1);
//        integers.add(3);
//        integers.add(2);
//        integers.add(4);
//
//        for (Integer integer: integers) {
//            System.out.println(integer);
//        }
//
//        Map<Integer, String> myMap = new TreeMap<>(Comparator.reverseOrder());
//        myMap.put(3, "three");
//        myMap.put(4, "four");
//        myMap.put(1, "one");
//        myMap.put(2, "two");
//
//        System.out.println(myMap);
    }
}
