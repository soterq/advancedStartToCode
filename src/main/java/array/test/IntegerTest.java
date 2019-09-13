package array.test;

import array.methods.IntegerMethods;

import java.util.Arrays;

public class IntegerTest {

    public static void main(String[] args) throws Exception {
        int[] array = {9, 6, 3, 8, 1, 6, 8};
        int[] intCollection = new int[array.length];
        int[] anotherArray = {1, 5, 9, 7, 5, 3, 6, 3, 3};
        int[] arr = {66, 77, 88};

        IntegerMethods.intArrayInitializer(4);

        System.out.println("Sort array");
        IntegerMethods.sortArray(array);
        System.out.println(Arrays.toString(array));

        System.out.println("sum of array");
        System.out.println(IntegerMethods.getSum(array));

        System.out.println("average of array");
        System.out.println(IntegerMethods.getAverage(array));

        System.out.println("array Contains");
        System.out.println(IntegerMethods.arrayContains(array, 1));
        System.out.println(IntegerMethods.arrayContains(array, 11));

        System.out.println("index number from array");
        System.out.println(IntegerMethods.getArrayIndex(array, 6));

        System.out.println("Remove Element from array");
        array = IntegerMethods.removeElementFromArray(array, 2);
        System.out.println(Arrays.toString(array));

        System.out.println("insert  Element in array");
        array = IntegerMethods.addElementIntoArray(array, 2, 99);
        System.out.println(Arrays.toString(array));

        System.out.println("Copy array by iterating");
//        IntegerMethods.copyArrayByIterating(array, intCollection);
        System.out.println(Arrays.toString(intCollection));

        System.out.println("Min value");
        System.out.println(IntegerMethods.getMinValue(array));

        System.out.println("Max value");
        System.out.println(IntegerMethods.getMaxValue(array));

        System.out.println("Reverse array");
        IntegerMethods.reverseArray(array);
        System.out.println(Arrays.toString(array));

        System.out.println("Duplicate values");
        System.out.println(Arrays.toString(IntegerMethods.getDuplicateValues(array)));

        System.out.println("Common elements");
        System.out.println(Arrays.toString(IntegerMethods.getCommonElements(array, anotherArray)));

        System.out.println("Remove Duplicates");
        System.out.println(Arrays.toString(IntegerMethods.removeDuplicates(array)));

        System.out.println("Number of even integers");
        System.out.println(IntegerMethods.findEvenNumber(array));

        System.out.println("Number of odd integers");
        System.out.println(IntegerMethods.findOddNumber(array));

        System.out.println("Rotate clockwise");
        IntegerMethods.rotateClockwise(array,2);
        System.out.println(Arrays.toString(array));

        System.out.println("Rotate anticlockwise");
        IntegerMethods.rotateAnticlockwise(array,2);
        System.out.println(Arrays.toString(array));

        System.out.println("Remove sub array from array");
        array = IntegerMethods.removeSubArray(array, 3, 5);
        System.out.println(Arrays.toString(array));

        System.out.println("add sub array in to array");
        anotherArray = IntegerMethods.addSubArrayIntoArray(anotherArray, 3, arr);
        System.out.println(Arrays.toString(anotherArray));
    }
}
