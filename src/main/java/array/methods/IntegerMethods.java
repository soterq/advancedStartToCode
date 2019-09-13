package array.methods;

import java.util.Arrays;
import java.util.List;

public class IntegerMethods {
    public static void main(String[] args) {
        cloneMethodValidation();
    }

    public static void intArrayInitializer(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        for (int value : array) {
            System.out.println(value);
        }
    }

    public static void sortArray(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static int getSum(int[] arr) {
        int sum = 0;
        for (int element : arr) {
            sum += element;
        }
        return sum;
    }

    public static double getAverage(int[] arr) {
        int sum = getSum(arr);
        return (double) (sum / arr.length);
    }

    public static boolean arrayContains(int[] array, int number) {
        for (int element : array) {
            if (number == element) {
                return true;
            }
        }
        return false;
    }

    public static int getArrayIndex(int[] arr, int number) {
        if (arr == null) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                return i;
            }
        }
        return -1;
    }

    public static int[] removeElementFromArray(int[] arr, int index) throws Exception {
        if (index >= 0 && index < arr.length) {
            for (int i = index; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            return arr;
        }
        throw new Exception("your data is not corresponding requirements");
    }

    public static int[] addElementIntoArray(int[] arr, int index, int element) {
        for (int i = arr.length - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = element;
        return arr;
    }

    public static void copyArrayByIterating(int[] source, int[] destination) throws Exception {
        if (source.length == destination.length) {
            for (int i = 0; i < source.length; i++) {
                destination[i] = source[i];
            }
        } else {
            throw new Exception("size of source is not the same with destination size");
        }
    }

    public static int getMinValue(int[] arr) {
        int min = arr[0];
        for (int value : arr) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    public static int getMaxValue(int[] arr) {
        int max = arr[0];
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static void reverseArray(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }

    public static int[] getDuplicateValues(int[] arr) {
        int[] numbers = {};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    if (!arrayContains(numbers, arr[j])) {
                        numbers = Arrays.copyOf(numbers, numbers.length + 1);
                        numbers[numbers.length - 1] = arr[j];
                    }
                }
            }
        }
        return numbers;
    }

    public static int[] getCommonElements(int[] first, int[] second) throws Exception {
        if (first.length == second.length) {
            int[] numbers = {};
            int k = 0;
            for (int value : first) {
                for (int secondValue : second) {
                    if (value == secondValue) {
                        numbers = Arrays.copyOf(numbers, numbers.length + 1);
                        numbers[k++] = secondValue;
                    }
                }
            }
            return numbers;
        }
        throw new Exception("size of array is not the same");
    }

    public static int[] removeDuplicates(int[] arr) throws Exception {
        sortArray(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                arr = removeElementFromArray(arr, i);
                i--;
            }
        }
        return arr;
    }

    public static int findEvenNumber(int[] arr) {
        int count = 0;
        for (int value : arr) {
            if (value % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static int findOddNumber(int[] arr) {
        int count = 0;
        for (int value : arr) {
            if (value % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    public static Integer[] convertListToArray(List<Integer> list) {
        Integer[] intArray = list.toArray(new Integer[0]);
        return intArray;
    }

    public static void rotateClockwise(int[] arr, int number) throws Exception {
        if (number > 1) {
            for (int j = 0; j < number; j++) {
                int a = arr[arr.length - 1];
                for (int i = arr.length - 1; i > 0; i--) {
                    arr[i] = arr[i - 1];
                }
                arr[0] = a;
            }
        } else {
            throw new Exception("size should be > 0");
        }
    }

    public static void rotateAnticlockwise(int[] arr, int number) throws Exception {
        if (number > 1) {
            for (int j = 0; j < number; j++) {
                int a = arr[arr.length - 1];
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = arr[i + 1];
                }
                arr[0] = a;

            }
        } else {
            throw new Exception("size should be > 0");
        }
    }

    public static int[] removeSubArray(int[] arr, int startIndex, int endIndex) throws Exception {
        if (endIndex > startIndex && endIndex <= arr.length) {
            for (int i = startIndex; i < endIndex + 1; i++) {
                arr = removeElementFromArray(arr, startIndex);
            }
        }
        return arr;
    }

    public static int[] addSubArrayIntoArray(int[] arr, int index, int[] elements) {
        if (elements.length <= arr.length - index) {
            for (int i = 0; i < elements.length; i++) {
                arr = addElementIntoArray(arr, index + i, elements[i]);
            }
        }
        return arr;
    }

    public static void cloneMethodValidation() {
        int[] a = {1, 2, 3};
        int[] b = a.clone();
        System.out.println("first array : " + Arrays.toString(a) + "Second array : " + Arrays.toString(b));
        a[0] = 100;
        System.out.println("first array  : " + Arrays.toString(a));
        System.out.println("Second array : " + Arrays.toString(b));
    }
}