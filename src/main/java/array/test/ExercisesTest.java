package array.test;

import array.methods.Exercises;

import java.util.Arrays;

public class ExercisesTest {

    public static void main(String[] args) throws Exception {
        int[] elements = {4, 5, 6, 7, 8, 9};
        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] result;

        System.out.println("All pairs of number");
        Exercises.findAllPairs(elements, 9);

        System.out.println("multiplication of vectors");
        result = Exercises.vectorsMultiplication(elements, arr);
        System.out.println(Arrays.toString(result));

        System.out.println("Factorial method without recursion");
        int[] factorial = Exercises.factorialNumber(elements);
        System.out.println(Arrays.toString(factorial));

        System.out.println("Factorial method wit recursion");
        int[] numbers = Exercises.recursionFactorialArray(elements);
        System.out.println(Arrays.toString(numbers));

    }
}
