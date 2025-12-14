package vda.perso.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculetteTest {

    CalculetteService calculetteService = new CalculetteService();
    @Test
    public void given_twoNumbers_when_add_result(){
         int a = 0;
         int b = 10;

        int result = calculetteService.addition(a, b);
        assertEquals(result, 10);

    }
}
