package truc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumTest {
    SumService sumService = new SumService();

    @Test
    public void given_twoPositifNumbers_when_sum_then_correctSumReturned(){
        Param1 number1 = 1;
        int number2 = 50;

        int result = sumService.sum(number1, number2);

        int expected= 51;
        assertEquals(result, expected);
    }

    @Test
    public void given_twoNegatifNumbers_when_sum_then_correctSumReturned(){
        int number1 = -1;
        int number2 = -50;

        int result = sumService.sum(number1, number2);

        int expected= 51;
        assertEquals(result, expected);
    }

    @Test
    public void given_oneNegatifOnePositifNumbers_when_sum_then_correctSumReturned(){
        int number1 = -1;
        int number2 = 50;

        int result = sumService.sum(number1, number2);

        int expected= 51;
        assertEquals(result, expected);
    }
}
