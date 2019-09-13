package array.methods;

public class Exercises {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        findAllPairs(arr, 11);
    }

    public static void findAllPairs(int[] arr, int number) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j && (arr[i] + arr[j]) == number) {
                    System.out.println(arr[i] + " and " + arr[j]);
                }
            }
        }
    }

    public static int[] vectorsMultiplication(int a[], int[] b) throws Exception {
        if (a.length == b.length) {
            int[] c = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                c[i] = a[i] * b[i];
            }
            return c;
        }
        throw new Exception("your data is not corresponding requirements");
    }

    public static int[] factorialNumber(int[] arr) throws Exception {
        if (arr.length > 1) {
            int[] factorialArray = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < 0) {
                    continue;
                }
                int factorial = 1;
                for (int j = 1; j <= arr[i]; j++) {
                    factorial *= j;
                }
                factorialArray[i] = factorial;
            }
            return factorialArray;
        }
        throw new Exception("your data is not corresponding requirements");
    }

    public static int[] recursionFactorialArray(int[] arr) throws Exception {
        if (arr.length > 1) {
            int[] factorialArray = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 0) {
                    factorialArray[i] = factorialPrintRecursion(arr[i]);
                }
            }
            return factorialArray;
        }
        throw new Exception("your data is not corresponding requirements");
    }

    private static int factorialPrintRecursion(int number) {
        if (number >= 1) {
            return number * factorialPrintRecursion(number - 1);
        } else {
            return 1;
        }
    }
}