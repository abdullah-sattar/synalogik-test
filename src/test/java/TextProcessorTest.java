import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TextProcessorTest {
    @Test
    void setWordCount_Four_ShouldChangeWordCount(){
        TextProcessor testInstance = new TextProcessor(0, new HashMap<>(), 0, new ArrayList<>());
        testInstance.setWordCount(4);
        assertEquals(4, testInstance.getWordCount()) ;
    }

    @Test
    void setCommonLengths_Ten_ShouldChangeCommonLengths() {
        TextProcessor testInstance = new TextProcessor(0, new HashMap<>(), 0, new ArrayList<>());
        testInstance.setCommonLengths(10);
        assertEquals(10, testInstance.getCommonLengths());
    }

    @Test
    void fillCommonWords_WordLengths_ShouldFillCommonWords() {
        TextProcessor testInstance = new TextProcessor(0, new HashMap<>(), 0, new ArrayList<>());
        testInstance.getWordLengths().put(1,1);
        testInstance.getWordLengths().put(2,2);
        testInstance.getWordLengths().put(3,3);
        testInstance.getWordLengths().put(4,4);
        testInstance.getWordLengths().put(5,5);
        testInstance.getWordLengths().put(6,5);

        ArrayList<Integer> testResult = new ArrayList<>();
        testResult.add(5);
        testResult.add(6);

        testInstance.fillCommonWordsAndCommonLength();

        assertEquals(testResult, testInstance.getCommonWords());
        assertEquals(5, testInstance.getCommonLengths());
    }

    @Test
    void getAverageWordLength_WordLengths_ShouldReturnAverage() {
        TextProcessor testInstance = new TextProcessor(0, new HashMap<>(), 0, new ArrayList<>());
        testInstance.getWordLengths().put(1,1);
        testInstance.getWordLengths().put(2,2);
        testInstance.getWordLengths().put(3,3);
        testInstance.getWordLengths().put(4,4);
        testInstance.getWordLengths().put(5,5);
        testInstance.getWordLengths().put(6,5);

        assertEquals(4.25, testInstance.getAverageWordLength());
    }
}