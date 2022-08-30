package lesson_1.task_2;

import java.util.Arrays;

public class SecondTask {

    public static void main(String[] args) {
        int[] array = {5, 6, 3, 2, 5, 1, 4, 9};
        printArray(array);
        mergeSort(array, array.length);
        printArray(array);
    }

    public static void mergeSort(int[] arr, int length) {
        if (length < 2) {
            return;
        }

        int separator = length / 2;
        int[] left = new int[separator];
        int[] right = new int[length - separator];

        System.arraycopy(arr, 0, left, 0, separator);
        if (length - separator >= 0) {
            System.arraycopy(arr, separator, right, 0, length - separator);
        }

        mergeSort(left, separator);
        mergeSort(right, length - separator);

        int i = 0, j = 0, k = 0;
        while (i < separator && j < (length - separator)) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < separator) {
            arr[k++] = left[i++];
        }
        while (j < (length - separator)) {
            arr[k++] = right[j++];
        }
    }

    private static void printArray(int[] arr) {
        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
        System.out.println();
        System.out.println("------------------");
    }
}
