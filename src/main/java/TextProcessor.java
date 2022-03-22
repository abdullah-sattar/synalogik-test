import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TextProcessor {
    private int wordCount;
    private Map<Integer, Integer> lengthOccurrence = new HashMap<>();
    private Integer mostCommonLength;
    private ArrayList<Integer> mostCommonWords = new ArrayList<>();

    public TextProcessor(int wordCount, Map<Integer, Integer> lengthOccurrence, float average, Integer mostCommonLength, ArrayList<Integer> mostCommonWords) {
        this.wordCount = wordCount;
        this.lengthOccurrence = lengthOccurrence;
        this.mostCommonLength = mostCommonLength;
        this.mostCommonWords = mostCommonWords;
    }

    public TextProcessor() {

    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public Map<Integer, Integer> getLengthOccurrence() {
        return lengthOccurrence;
    }

    public float getAverage() {
        float totalWordLength = 0;
        float keyXValue = 0;

        for (Integer key : getLengthOccurrence().keySet()) {
            totalWordLength += getLengthOccurrence().get(key);
            keyXValue += key * getLengthOccurrence().get(key);
        }

        float average = (keyXValue/totalWordLength);
        return average;
    }

    public Integer getMostCommonLength() {
        return mostCommonLength;
    }

    public void setMostCommonLength(Integer mostCommonLength) {
        this.mostCommonLength = mostCommonLength;
    }

    public ArrayList<Integer> getMostCommonWords() {
        return mostCommonWords;
    }
}
