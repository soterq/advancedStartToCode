package array.methods;

import java.util.Arrays;
import java.util.List;

public class StringMethods {
    public static void arrayInitializer(int size) {
        String[] data = new String[]{"caps", "ana", "beta", "zed", "color", "caps"};
        String[] array = new String[size];
        for (int i = 0; i < data.length; i++) {
            array[i] = data[i];
        }
        for (String value : array) {
            System.out.println(value);
        }
    }

    public static void sortArray(String[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].toLowerCase().compareTo(arr[j].toLowerCase()) > 0) {
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static boolean arrayContains(String[] array, String word) {
        for (String element : array) {
            if (word.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public static int getArrayIndex(String[] arr, String word) {
        if (arr == null) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(word)) {
                return i;
            }
        }
        return -1;
    }

    public static String[] removeElementFromArray(String[] arr, int index) throws Exception {
        if (index < arr.length) {
            for (int i = index; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            return arr;
        }
        throw new Exception("your data is not corresponding requirements");
    }

    public static String[] addElementIntoArray(String[] arr, int index, String element) throws Exception {
        if (index < arr.length) {
            for (int i = arr.length - 1; i > index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index] = element;
            return arr;
        }
        throw new Exception("your data is not corresponding requirements");
    }

    public static void copyArrayByIterating(String[] source, String[] destination) throws Exception {
        if (source.length == destination.length) {
            for (int i = 0; i < source.length; i++) {
                destination[i] = source[i];
            }
        } else {
            throw new Exception("size of source is not the same with destination size");
        }
    }

    public static void reverseArray(String[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            String temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }

    public static String[] getDuplicateValues(String[] arr) {
        String[] numbers = {};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].equals(arr[j])) {
                    if (!arrayContains(numbers, arr[j])) {
                        numbers = Arrays.copyOf(numbers, numbers.length + 1);
                        numbers[numbers.length - 1] = arr[j];
                    }
                }
            }
        }
        return numbers;
    }

    public static String[] getCommonElements(String[] first, String[] second) {
        String[] numbers = {};
        int k = 0;
        for (String value : first) {
            for (String i : second) {
                if (value.equals(i)) {
                    numbers = Arrays.copyOf(numbers, numbers.length + 1);
                    numbers[k++] = i;
                }
            }
        }
        return numbers;
    }

    public static String[] removeDuplicates(String[] arr) throws Exception {
        sortArray(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].equals(arr[i + 1])) {
                arr = removeElementFromArray(arr, i);
                i--;
            }
        }
        return arr;
    }

    public static Integer[] convertIntListToArray(List<Integer> list) {
        Integer[] stringArray = new Integer[list.size()];
        stringArray = list.toArray(stringArray);
        return stringArray;
    }

    public static void rotateClockwise(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            String temp = arr[i];
            arr[i] = arr[arr.length - 1];
            arr[arr.length - 1] = temp;
        }
    }

    public static String[] rotateAnticlockwise(String[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            String temp = arr[i];
            arr[i] = arr[arr.length - 1];
            arr[arr.length - 1] = temp;
        }
        return arr;
    }

    public static String[] removeSubArray(String[] arr, int startIndex, int endIndex) throws Exception {
        for (int i = startIndex; i < endIndex + 1; i++) {
            arr = removeElementFromArray(arr, startIndex);
        }
        return arr;
    }

    public static String[] addSubArrayIntoArray(String[] arr, int index, String[] elements) throws Exception {
        arr = Arrays.copyOf(arr, ((arr.length - 1) + elements.length) - 2);
        int l = 0;
        for (int i = 0; i < elements.length; i++) {
            arr = addElementIntoArray(arr, index + i, elements[l++]);
        }
        return arr;
    }
}
