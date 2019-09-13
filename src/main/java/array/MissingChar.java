package array;


import java.util.Arrays;

public class MissingChar {

    public static void main(String[] args) {
        char[] array = {'a', 'b', 'c', 'd', 'f'};
        System.out.println(missingChar(array));

    }

    public static char missingChar(char[] arr) {
        int[] intArray = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            intArray[i] = arr[i];
        }
        int min = Arrays.stream(intArray).min().getAsInt();
        int max = Arrays.stream(intArray).max().getAsInt();

        int sum = sumBetween(min, max);
        int sumArray = Arrays.stream(intArray).sum();
//
//        for (int element: intArray) {
//            sumArray +=element;
//        }
        int wantedElement = sum - sumArray;

        return (char) wantedElement;
    }

    private static int sumBetween(int min, int max) {
        return ((max - min + 1) * ((max + min))) / 2;
    }
}
