package array.test;

import array.methods.StringMethods;

import java.util.Arrays;

public class StringTest {

    public static void main(String[] args) throws Exception {

        String[] array = {"but", "arr", "xerox", "zed", "xerox", "bulls"};
        String[] stringCollections = new String[array.length];
        String[] anotherArray = {"xerox", "else", "bulls", "something"};
        String[] arr = {"uno", "duo"};

        StringMethods.arrayInitializer(6);

        System.out.println("Sort array");
        StringMethods.sortArray(array);
        System.out.println(Arrays.toString(array));

        System.out.println("Array contains");
        System.out.println(StringMethods.arrayContains(array, "but"));
        System.out.println(StringMethods.arrayContains(array, "true"));

        System.out.println("Index word from array");
        System.out.println(StringMethods.getArrayIndex(array, "xerox"));

        System.out.println("Remove Element from array");
        StringMethods.removeElementFromArray(array, 2);
        System.out.println(Arrays.toString(array));

        System.out.println("Insert  Element in to array");
        StringMethods.addElementIntoArray(array, 2, "Element");
        System.out.println(Arrays.toString(array));

        System.out.println("Copy array by iterating");
        StringMethods.copyArrayByIterating(array, stringCollections);
        System.out.println(Arrays.toString(stringCollections));

        System.out.println("Reverse array");
        StringMethods.reverseArray(array);
        System.out.println(Arrays.toString(array));

        System.out.println("Duplicate values");
        System.out.println(Arrays.toString(StringMethods.getDuplicateValues(array)));

        System.out.println("Common elements");
        System.out.println(Arrays.toString(StringMethods.getCommonElements(array, anotherArray)));

        System.out.println("Remove Duplicates");
        System.out.println(Arrays.toString(StringMethods.removeDuplicates(array)));

        System.out.println("Rotate clockwise");
        StringMethods.rotateClockwise(array);
        System.out.println(Arrays.toString(array));

        System.out.println("Rotate anticlockwise");
        StringMethods.rotateAnticlockwise(array);
        System.out.println(Arrays.toString(array));

        System.out.println("Remove sub array from array");
        array = StringMethods.removeSubArray(array, 3, 5);
        System.out.println(Arrays.toString(array));

        System.out.println("add sub array in to array");
        anotherArray = StringMethods.addSubArrayIntoArray(anotherArray, 3, arr);
        System.out.println(Arrays.toString(anotherArray));

    }
}
