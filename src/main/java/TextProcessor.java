import java.util.HashMap;
import java.util.Map;

public class TextProcessor {
    private int wordCount = 0;
    private Map<Integer, Integer> lengthOccurrence = new HashMap<>();

    public TextProcessor(int wordCount, Map<Integer, Integer> lengthOccurrence) {
        this.wordCount = wordCount;
        this.lengthOccurrence = lengthOccurrence;
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

    public void setLengthOccurrence(Map<Integer, Integer> lengthOccurrence) {
        this.lengthOccurrence = lengthOccurrence;
    }
}
