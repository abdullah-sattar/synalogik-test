import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TextProcessor {
    private int wordCount;
    private Map<Integer, Integer> wordLengths = new HashMap<>();
    private Integer commonLengths;
    private ArrayList<Integer> commonWords = new ArrayList<>();

    public TextProcessor(int wordCount, Map<Integer, Integer> wordLengths, Integer commonLengths, ArrayList<Integer> commonWords) {
        this.wordCount = wordCount;
        this.wordLengths = wordLengths;
        this.commonLengths = commonLengths;
        this.commonWords = commonWords;
    }

    public TextProcessor() {

    }

    public void fillCommonWordsAndCommonLength() {
        Integer mostCommonLengthOccurrence = Collections.max(getWordLengths().values());
        for (Map.Entry<Integer, Integer> entry : getWordLengths().entrySet()) {
            if(entry.getValue() == mostCommonLengthOccurrence) {
                getCommonWords().add(entry.getKey());
                setCommonLengths(entry.getValue());
            }
        }
    }

    public float getAverageWordLength() {
        float totalWordLength = 0;
        float keyXValue = 0;

        for (Integer key : getWordLengths().keySet()) {
            totalWordLength += getWordLengths().get(key);
            keyXValue += key * getWordLengths().get(key);
        }

        return (keyXValue/totalWordLength);
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public Map<Integer, Integer> getWordLengths() {
        return wordLengths;
    }

    public Integer getCommonLengths() {
        return commonLengths;
    }

    public void setCommonLengths(Integer commonLengths) {
        this.commonLengths = commonLengths;
    }

    public ArrayList<Integer> getCommonWords() {
        return commonWords;
    }


}
