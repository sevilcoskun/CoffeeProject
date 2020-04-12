package tddTest;

import org.junit.Test;
import tdd.WordWrap;

import static junit.framework.TestCase.assertEquals;

public class WordWrapTest {

    public static final int LINE_LENGTH = 5;

    @Test
    public void lineShouldWrapOverLineLength(){
        String result = WordWrap.wrap("The Sleepy", LINE_LENGTH);
        assertEquals("The S\nleepy", result);
    }

    @Test
    public void shortLineShouldNotWrap(){
        String result = WordWrap.wrap("The", LINE_LENGTH);
        assertEquals("The", result);
    }

    @Test
    public void longerLineShouldWrapTwice(){
        String result = WordWrap.wrap("The Sleepy Girl", LINE_LENGTH);
        assertEquals("The S\nleepy\n Girl", result);
    }

    @Test
    public void longerLineShouldWrapMultiple(){
        String result = WordWrap.wrap("The Sleepy People", LINE_LENGTH);
        assertEquals("The S\nleepy\n Peop\nle", result);
    }



}
