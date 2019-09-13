package array;

import array.methods.IntegerMethods;
import array.methods.StringMethods;

import java.util.Arrays;

public class Matrix {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] secondArray = {6, 7, 8, 9};
        reverseIntArray(array);
        print(array);
    }

    private static void print(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static void matrixInitializer(int rowSize, int columnSize) {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] arr = new int[rowSize][columnSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                arr[i][j] = array[i][j];
            }
        }
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static void stringMatrixInitializer(int rowSize, int columnSize) {
        String[][] array = {{"a", "z", "o"}, {"a", "z", "o"}, {"a", "z", "o"}};
        String[][] arr = new String[rowSize][columnSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                arr[i][j] = array[i][j];
            }
        }
        for (String[] ints : arr) {
            for (String anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static int[][] sortAllMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                for (int k = 0; k < matrix[i].length; k++) {
                    if (matrix[i][j] < matrix[i][k]) {
                        int temp = matrix[i][j];
                        matrix[i][k] = matrix[i][k];
                        matrix[i][k] = temp;
                    }
                }
            }
        }
        return matrix;
    }

    private static boolean matrixContains(String[][] matrix, String name) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix.length - 1; j++) {
                if (matrix[i][j].contains(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean matrixContains(int[][] matrix, int number) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix.length - 1; j++) {
                if (matrix[i][j] == (number)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int[] matrixGetIndex(int[][] matrix, int number) {
        int[] numbers = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; i < matrix[i].length; j++) {
                if (matrix[i][j] == number) {
                    numbers[numbers.length - 2] = i;
                    numbers[numbers.length - 1] = j;
                }
            }
        }
        return numbers;
    }

    private static int[] matrixGetIndex(String[][] matrix, String value) {
        int[] numbers = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals(value)) {
                    numbers[numbers.length - 2] = i;
                    numbers[numbers.length - 1] = j;
                }
            }
        }
        return numbers;
    }

    private static void addElementIntoMatrix(int[][] matrix, int row, int column, int value) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (row == i && column == j) {
                    matrix[row][column] = value;
                }
            }
        }
    }

    private static void addElementIntoMatrix(String[][] matrix, int row, int column, String value) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (row == i && column == j) {
                    matrix[row][column] = value;
                }
            }
        }
    }

    private static void removeElementFromMatrix(int[][] matrix, int row, int column) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (row == i && column == j) {
                    matrix[row][column] = 0;
                }
            }
        }
    }

    private static void removeElementFromMatrix(String[][] matrix, int row, int column) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (row == i && column == j) {
                    matrix[row][column] = " ";
                }
            }
        }
    }

    private static int[][] copyByIteratingMatrix(int[][] array, int[][] newArray) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; i++) {
                newArray[i][j] = array[i][j];
            }
        }
        return newArray;
    }

    private static String[][] copyByIteratingMatrix(String[][] array, String[][] newArray) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; i++) {
                newArray[i][j] = array[i][j];
            }
        }
        return newArray;
    }

    private static int getMin(int[][] array) {
        int min = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; i++) {
                if (array[i][j] < min) {
                    min = array[i][j];
                }
            }
        }
        return min;
    }

    private static int getMinMax(int[][] array) {
        int max = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; i++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        return max;
    }

    private static int[][] reverseIntArray(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - i - 1];
                matrix[i][matrix.length - i - 1] = temp;
            }
        }
        return matrix;
    }

    public static int[] matrixDuplicates(int[][] matrix) {
        int[] duplicates = {};
        int length = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                for (int k = 0; k < matrix[j].length; k++) {
                    if (IntegerMethods.arrayContains(matrix[i], matrix[i][j]) && (i != j)) {
                        duplicates = Arrays.copyOf(duplicates, duplicates.length + 1);
                        duplicates[length++] = matrix[k][j + 1];
                    }
                }
            }
        }
        return duplicates;
    }

    public static String[] matrixDuplicates(String[][] matrix) {
        String[] duplicates = {};
        int length = 0;
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                for (int k = 0; k < matrix.length; k++) {
                    for (int l = 0; l < matrix[i].length; l++) {
                        if (matrix[i][j] == matrix[k][l] && !(StringMethods.arrayContains(duplicates, matrix[i][j])) && i != k) {
                            duplicates = Arrays.copyOf(duplicates, duplicates.length + 1);
                            duplicates[length++] = matrix[k][l];
                        }
                    }
                }
            }
        }
        return duplicates;
    }

    private static int findOdd(int[][] array) {
        int oddNumber = 0;
        for (int[] number : array) {
            for (int element : number) {
                if (element % 2 != 0) {
                    oddNumber++;
                }
            }
        }
        return oddNumber;
    }

    private static int findOddAndEven(int[][] array) {
        int evenNumber = 0;
        for (int[] number : array) {
            for (int element : number) {
                if (element % 2 == 0) {
                    evenNumber++;
                }
            }
        }
        return evenNumber;
    }

    private static int[][] clockwiseMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int a = matrix[i][matrix.length - 1];
                for (int k = matrix.length - 1; k > 0; k--) {
                    matrix[i][k] = matrix[i][k - 1];
                }
                matrix[i][0] = a;
            }
        }
        return matrix;
    }

    private static int[][] anticlockwiseMatrix(int[][] matrix, int number) {
        for (int o = 0; o < number; o++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    int a = matrix[i][0];
                    for (int k = 0; k < matrix.length; k++) {
                        matrix[i][k] = matrix[i][k + 1];
                    }
                    matrix[i][matrix.length - 1] = a;
                }
            }
        }
        return matrix;
    }

    private static int[][] removeArrayByIndex(int[][] matrix, int startIndexRow, int startIndexColumn, int endIndexRow, int endIndexColumn) throws Exception {
        if (endIndexRow <= matrix.length) {
            for (int i = startIndexColumn; i < endIndexColumn; i++) {
                removeElementFromMatrix(matrix, startIndexRow, i);
            }
        } else {
            throw new Exception("your data is not corresponding with requirements");
        }
        return matrix;
    }

    private static int[][] addSubArray(int[][] matrix, int rowIndex, int startIndexColumn, int[] section) throws Exception {
        if (section.length <= matrix.length && startIndexColumn < matrix.length) {
            for (int i = startIndexColumn; i < section.length; i++) {
                addElementIntoMatrix(matrix, rowIndex, i, section[i]);
            }
        } else {
            throw new Exception("length is not corresponding with requirements");
        }
        return matrix;
    }
}