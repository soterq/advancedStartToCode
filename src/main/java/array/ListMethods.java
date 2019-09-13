package array;

import java.util.*;
import java.util.List;

public class ListMethods {
    public static void main(String[] args) throws Exception {

        List<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);
        myList.add(7);
        myList.add(8);
        myList.add(9);

        List<Integer> secondList = new ArrayList<>();
        secondList.add(150);
        secondList.add(160);
        secondList.add(170);

        myList.subList(3, secondList.size()).addAll(secondList);

        for (int value : myList) {
            System.out.println(value);
        }
    }

    private static void stringListInitializer(int size) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(i + " ");
        }
        for (String value : list) {
            System.out.println(value);
        }
    }

    private static void ListInitializer(int size) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(i + 1);
        }
        for (int number : list) {
            System.out.println(list.get(number));
        }
    }

    private static void sortIntList(List<Integer> sortList) {
        for (int i = 0; i < sortList.size(); i++) {
            for (int j = sortList.size() - 1; j > i; j--) {
                if (sortList.get(i) > sortList.get(j)) {
                    int tmp = sortList.get(i);
                    sortList.set(i, sortList.get(j));
                    sortList.set(j, tmp);

                }
            }
        }
    }

    private static String sortStringListInt(List<String> sortList) {
        for (int i = 0; i < sortList.size() - 1; i++) {
            for (int j = i + 1; j < sortList.size(); j++) {
                if (sortList.get(i).toLowerCase().compareTo(sortList.get(j).toLowerCase()) > 0) {
                    String tmp = sortList.get(i);
                    sortList.set(i, sortList.get(j));
                    sortList.set(j, tmp);
                }
            }
        }

        return sortList.toString();
    }

    private static boolean listContains(List<Integer> list, int number) {
        return list.contains(number);
    }

    private static boolean listContains(List<String> list, String word) {
        return list.contains(word);
    }

    private static int findIndex(List<Integer> list, int number) {
        return list.indexOf(number);
    }

    private static int findIndex(List<String> list, String word) {
        return list.indexOf(word);
    }

    private static void addElementIntoList(List<Integer> list, int index, int number) {
        list.add(index, number);
    }

    private static void addElementIntoList(int index, List<String> list, String word) {
        list.add(index, word);
    }

    private static void removeElementFromList(List<Integer> list, int index) throws Exception {
    int position = findIndex(list, index);
    if(position >=0){
        list.remove(index);
    }
//        if (index < list.size()) {
//            list.remove(index);
//        }
        else {
            throw new Exception("index is is not corresponding with requirements");
        }

    }

    private static void coppyListByInterating(List<Integer> list, List<Integer> newList) {

        for (int number : list) {
            newList.add(number);
        }
    }

    private static int getMax(List<Integer> list) {
        int max = list.get(0);
        for (int number : list) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    private static int getMin(List<Integer> list) {
        int min = list.get(0);
        for (int number : list) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }

    private static List<Integer> reverseList(List<Integer> list) {
        for (int i = 0; i < list.size() / 2; i++) {
            int temp = list.get(i);
            list.set(i, list.get(list.size() - i - 1));
            list.set(list.size() - i - 1, temp);
            list.set(list.size() - i - 1, temp);
        }

        return list;
    }

    private static List<String> reverseStringList(List<String> list) {
//        Collections.reverse(list);
        for (int i = 0; i < list.size() / 2; i++) {
            String temp = list.get(i);
            list.set(i, list.get(list.size() - i - 1));
            list.set(list.size() - i - 1, temp);
            list.set(list.size() - i - 1, temp);
        }

        return list;
    }

    private static List<Integer> getDuplicateElementsFromInt(List<Integer> list) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    if (!numbers.contains(list.get(j)))
                        numbers.add(list.get(j));
                }
            }

        }
        return numbers;
    }

    private static List<String> getDuplicateElementsFromString(List<String> list) {
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    if (!numbers.contains(list.get(j)))
                        numbers.add(list.get(j));
                }
            }

        }
        return numbers;
    }

    private static List<Integer> removeDuplicate(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        list.removeAll(list);
        list.addAll(set);
        return list;
    }

    private static List<String> removeDuplicateFromString(List<String> list) {
        Set<String> set = new HashSet<>(list);
        list.removeAll(list);
        list.addAll(set);
        return list;
    }

    private static int findOdd(List<Integer> list) {
        int odd = 0;
        for (int number : list) {
            if (number % 2 != 0) {
                odd++;
            }
        }
        return odd;
    }

    private static int findEven(List<Integer> list) {
        int even = 0;
        for (int number : list) {
            if (number % 2 == 0) {
                even++;
            }
        }
        return even;
    }

    private static List<Integer> arrayToList(Integer[] arr) {
        return Arrays.asList(arr);
    }

    private static List<String> arrayToList(String[] arr) {
        return Arrays.asList(arr);
    }

    private static void addSubList(List<Integer> list, List<Integer> secondList, int index) throws Exception {
        if (index < list.size()) {
            list.subList(index, secondList.size()).addAll(secondList);
        } else {
            throw new Exception("Index is not corresponding with requirements");
        }
    }

    private static List<Integer> removeSubList(List<Integer> list, int startIndex, int endIndex) throws Exception {
        if (list != null && startIndex < endIndex && endIndex < list.size()) {
            list.subList(startIndex, endIndex).clear();
            return list;
        } else {
            throw new Exception("Data is not corresponding with requirements");
        }
    }
}