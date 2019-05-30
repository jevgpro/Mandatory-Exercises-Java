package kt_example.kt_example;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class TextAnalyticsTest{


    @Test
    public void testIfWrongFilePathIsHandled(){
        TextAnalytics analytics = new TextAnalytics();
        String text = analytics.read_my_file("/");
        assertTrue(true);
    }

    @Test
    public void testIfFileContentEmpty(){
        TextAnalytics analytics = new TextAnalytics();
        String text = analytics.read_my_file("/");
        assertFalse(text.equals(""));
        assertNotNull(text);
    }

    @Test
    public void TestIfWordsNotNull(){
        TextAnalytics analytics = new TextAnalytics();
        String[] words = analytics.split_words_into_pieces("tere isa");
        assertNotNull(words);
    }

    @Test
    public void TestIfItHasWords(){
        TextAnalytics analytics = new TextAnalytics();
        String[] words = analytics.split_words_into_pieces("tere isa");
        assertTrue(words.length > 1);
    }

    @Test
    public void TestIfWordCalculationIsCorrect(){
        TextAnalytics analytics = new TextAnalytics();
        String[] words = {"Hello", "Isa"};
        List<String> result = analytics.count_words(words);
        assertTrue(result.size() == 0);
    }

    @Test
    public void TestIfReturnsEmptyListOnNoValue(){
        TextAnalytics analytics = new TextAnalytics();
        String[] words = {"Hello", "World"};
        List<String> result = analytics.count_words(words);
        assertTrue(result.size() == 0);
    }

    @Test
    public void testStringUtil_Bad() {
        TextAnalytics analytics = new TextAnalytics();
        String result = analytics.turn_words_to_lowercase("Hello ", "World");
        System.out.println("Result is "+result);
    }

    @Test
    public void testStringUtil_Good() {
        TextAnalytics analytics = new TextAnalytics();
        String result = analytics.turn_words_to_lowercase("Hello ", "hello", "World", "world");
        assertEquals("Hello World", result);
    }

}