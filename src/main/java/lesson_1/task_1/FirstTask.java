package lesson_1.task_1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FirstTask {
    public static final int SIZE = 10;
    public static final long MAX = 10;
    public static final long MIN = -10;
    private static final String RED = "\u001B[31m";
    private static final String BLUE = "\u001B[34m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
        long[][] array = new long[SIZE][SIZE];

        fillArrayWithPseudoRandomNumbers(array, MIN, MAX);
        printArray(array);
        System.out.println(getExtremeValuesFromArrayWithLoops(array));
        System.out.println("------------------------------------------------");
        System.out.println(getExtremeValuesFromArrayWithStreamAPI(array));
    }

    public static void fillArrayWithPseudoRandomNumbers(long[][] arr, long min, long max) {
        if (min >= max) {
            System.out.println("Invalid range in method fillArrayWithPseudoRandomNumbers()");
            return;
        }

        IntStream.range(0, arr.length).forEach(x -> Arrays.setAll(
                arr[x], y -> {
                    long base = System.currentTimeMillis();
                    long factor = base % ((max - min) / (y + 1) + x);
                    long result = base % (max - min);
                    result = (result + y + 1) * (factor + x + 1) + y + x;
                    while (result > max || result < min) {
                        if (result >= max) {
                            result = max - result;
                        }
                        if (result <= min) {
                            result = min - result;
                        }
                    }
                    return result;
                }));
    }

    private static void printArray(long[][] arr) {
        System.out.println("------------------------------------------------");
        for (long[] longs : arr) {
            for (int j = 0; j < arr.length; j++) {
                if (Long.signum(longs[j]) >= 0) {
                    System.out.print(" ");
                }
                int length = Long.toString(longs[j]).length();
                if (Long.signum(longs[j]) == 1) {
                    System.out.print(RED + longs[j] + RESET);
                }
                if (Long.signum(longs[j]) == -1) {
                    System.out.print(BLUE + longs[j] + RESET);
                }
                if (Long.signum(longs[j]) == 0) {
                    System.out.print(YELLOW + longs[j] + RESET);
                }
                for (int k = 0; k < 4 - length; k++) {
                    System.out.print(" ");
                }
                if (Long.signum(longs[j]) == -1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println("------------------------------------------------");
    }

    public static String getExtremeValuesFromArrayWithLoops(long[][] arr) {
        if (arr.length == 0) {
            return "Zero size of the given array in method getExtremeValuesFromArrayWithLoops()";
        }
        long max = arr[0][0];
        long min = arr[0][0];
        double sum = 0;
        int count = 0;

        for (long[] longs : arr) {
            for (long item : longs) {
                sum += item;
                count++;
                if (max < item) {
                    max = item;
                }
                if (min > item) {
                    min = item;
                }
            }
        }
        double average = sum / count;
        return String.format("With loops\nMin: %d\nMax: %d\nAverage: %f\n", min, max, average);
    }

    public static String getExtremeValuesFromArrayWithStreamAPI(long[][] arr) {
        if (arr.length == 0) {
            return "Zero size of the given array in method getExtremeValuesFromArrayWithStreamAPI()";
        }
        long max = Arrays.stream(arr).flatMapToLong(Arrays::stream).max().orElse(0);
        long min = Arrays.stream(arr).flatMapToLong(Arrays::stream).min().orElse(0);
        double average = Arrays.stream(arr).flatMapToLong(Arrays::stream).average().orElse(0);
        return String.format("With streams\nMin: %d\nMax: %d\nAverage: %f\n", min, max, average);
    }
}
