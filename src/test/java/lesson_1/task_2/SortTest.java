package lesson_1.task_2;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortTest {

    @Test
    public void evenlyMixedTest() {
        int[] actual = {5, 1, 6, 4, 2, 3};
        int[] expected = {1, 2, 3, 4, 5, 6};
        SecondTask.mergeSort(actual, actual.length);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void partiallyMixedTest() {
        int[] actual = {6, 1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5, 6};
        SecondTask.mergeSort(actual, actual.length);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void inReverseOrderTest() {
        int[] actual = {6, 5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5, 6};
        SecondTask.mergeSort(actual, actual.length);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void withDoublesTest() {
        int[] actual = {5, 6, 1, 6, 4, 1, 6, 4, 2, 3, 1};
        int[] expected = {1, 1, 1, 2, 3, 4, 4, 5, 6, 6, 6};
        SecondTask.mergeSort(actual, actual.length);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shortArrayTest() {
        int[] actual = {6, 1};
        int[] expected = {1, 6};
        SecondTask.mergeSort(actual, actual.length);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void oneElementArrayTest() {
        int[] actual = {6};
        int[] expected = {6};
        SecondTask.mergeSort(actual, actual.length);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void emptyArrayTest() {
        int[] actual = {};
        int[] expected = {};
        SecondTask.mergeSort(actual, actual.length);
        assertArrayEquals(expected, actual);
    }
}
