package lesson_1.task_1;

import org.junit.Assert;
import org.junit.Test;

public class FirstTaskTest {

    @Test
    public void getExtremeValuesFromArrayWithLoopsTest() {
        long[][] array = {
                {0, 5, 3, 2, 4},
                {1, 6, 9, 7, 8}
        };
        String actual = FirstTask.getExtremeValuesFromArrayWithLoops(array);
        String expected = "With loops\nMin: 0\nMax: 9\nAverage: 4,500000\n";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getExtremeValuesFromArrayWithStreamAPITest() {
        long[][] array = {
                {0, 5, 3, 2, 4},
                {1, 6, 9, 7, 8}
        };
        String actual = FirstTask.getExtremeValuesFromArrayWithStreamAPI(array);
        String expected = "With streams\nMin: 0\nMax: 9\nAverage: 4,500000\n";
        Assert.assertEquals(expected, actual);
    }
}
