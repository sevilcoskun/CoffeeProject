package tddTest;

import org.junit.Test;
import tdd.LeapYear;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class LeapYearTest {

    @Test
    public void leapYearsAreDivisibleByFour(){
        assertTrue(LeapYear.isLeapYear(2016));
    }

    @Test
    public void normalYearsAreNotDivisibleByFour(){
        assertFalse(LeapYear.isLeapYear(2017));
    }

    @Test
    public void leapYearsAreNotDivisibleByOneHundred(){
        assertFalse(LeapYear.isLeapYear(1900));
    }

    @Test
    public void leapYearsAreDivisibleByFourHundred(){
        assertTrue(LeapYear.isLeapYear(2000));
    }
}
