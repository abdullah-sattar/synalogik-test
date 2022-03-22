import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        TextProcessor text = new TextProcessor(0, new HashMap<>(), 0, 0, new ArrayList<>());
        File path = new File("C:\\Users\\Abdul\\Documents\\test.txt");
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;

        while((line = reader.readLine()) != null) {
            String[] stringArr = line.split("[ .]+");

            Map<Integer, Integer> map = text.getLengthOccurrence();
            for (String word : stringArr) {
                int length = word.length();

                text.setWordCount(text.getWordCount()+1);

                if(map.containsKey(length)) {
                    map.put(length, map.get(length) + 1);
                } else {
                    map.put(length, 1);
                }
            }

        }

        Integer highestOccurrence = Collections.max(text.getLengthOccurrence().values());
        for (Map.Entry<Integer, Integer> entry : text.getLengthOccurrence().entrySet()) {
            if(entry.getValue() == highestOccurrence) {
                text.getMostCommonWords().add(entry.getKey());
                text.setMostCommonLength(entry.getValue());
            }
        }

        String lengths = "";

        for (int i=0; i<text.getMostCommonWords().size(); i++) {
            if(lengths == "") {
                lengths += Integer.toString(text.getMostCommonWords().get(i));
            } else {
                lengths += " & " + text.getMostCommonWords().get(i);
            }
        }

        DecimalFormat df = new DecimalFormat("0.000");

        System.out.println("Word count = " + text.getWordCount());
        System.out.println("Average word length = " + df.format(text.getAverage()));
        for (Map.Entry<Integer, Integer> length : text.getLengthOccurrence().entrySet()) {
            System.out.println("Number of words of length " + length.getKey() + " is " + length.getValue());
        }
        System.out.println("The most frequently occurring word length is " + text.getMostCommonLength() + ", for word lengths of " + lengths);
    }
}
